package com.cii.bomse.ums.user.controller;

import com.cii.bomse.ums.user.dictionary.UserOperationType;
import com.cii.bomse.ums.user.dto.UserControllerRequest;
import com.cii.bomse.ums.user.dto.UserControllerResponse;
import com.cii.bomse.ums.user.entity.UserEntity;
import com.cii.bomse.ums.user.manager.IUserManager;
import com.ciiframework.common.auth.Token;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.configure.CiiProperty;
import com.ciiframework.data.PageResult;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.log.entity.OperationLogEntity;
import com.ciiframework.log.manager.IOperationLogManager;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import com.ciiframework.user.utiles.UserTokenUtils;
import com.ciiframework.utils.BeanMapConvertUtils;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/11/19 21:18
 */
@RestController
@RequestMapping(path = "/user",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController extends AbstractRestController {

    @Autowired
    private CiiProperty ciiProperty;
    @Autowired
    private IUserManager userManager;
    @Autowired
    private IOperationLogManager operationLogManager;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> login(@RequestBody UserControllerRequest request,
                                                  HttpServletRequest req, HttpServletResponse resp) {

        UserControllerResponse response = new UserControllerResponse();

        UserEntity user = userManager.login(request.getEntity());

        if (ObjectUtils.isEmpty(user)) {
            return this.error(response, "用户不存在");
        }
        //设置token

        String auth = UUID.randomUUID().toString().replaceAll("-", "");
//        Token token = new Token(user.getId(), auth,3600l);
        Date now = Calendar.getInstance().getTime();
        now = DateUtils.addDays(now,1);
        now = DateUtils.setHours(now,1);

        String tokenType = request.getTokenType();

        if (ObjectUtils.isEmpty(tokenType)){
            tokenType = ciiProperty.getUserTokenType();
        }

        Token token = new Token(user.getId(), auth,tokenType, now);

        userManager.saveUserToken(token);
        UserTokenUtils.addTokenToCookie(req, resp, token, ciiProperty.getUserTokenName());

        user.setPassword(null);
        user.setSecure(null);
        response.setResult(user);
        response.setToken(token.toBase64String());

        //记录日志
        OperationLogEntity optLog = new OperationLogEntity();
        optLog.setBizId(user.getId());
        optLog.setOptType(UserOperationType.Login);
        optLog.setContent(String.format("%s登录了系统",user.getUserName()));
        optLog.setCreateId(user.getId());
        optLog.setCreateName(user.getUserName());
        optLog.setCreateDeptId(user.getOwnerDeptId());
        optLog.setCreateDeptName(user.getOwnerDeptName());
        optLog.setCpyId(user.getCpyId());
        operationLogManager.create(optLog);


        return this.success(response);
    }

    @RequestMapping(path = "/logout",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> logout(@RequestBody UserControllerRequest request,
                                                   HttpServletRequest req,HttpServletResponse resp){
        UserControllerResponse response = new UserControllerResponse();

        UserTokenUtils.invalidateToken(req,resp,ciiProperty.getUserTokenName());
        userManager.deleteUserToken(CurrentContext.getToken());

        return this.success(response);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody UserControllerRequest request) {
        UserControllerResponse response = new UserControllerResponse();
        userManager.create(request.getEntity());
        return this.success(response);
    }

    /**
     * 为某个用户分配角色的时候，需要选择用户，就调用此接口
     * @param request
     * @return
     */
    @RequestMapping(path = "/selector", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> selector(@RequestBody UserControllerRequest request) {

        UserControllerResponse response = new UserControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        //此处对平台平台管理员进行权限开发，为了是可以分配角色给新创建的公司的管理账号角色

        PageResult<UserEntity> users = userManager.selectUserSelector(param,
                request.getStartOrDefault(0),request.getPageSizeOrDefault(20));

        response.setResult(users);

        return this.success(response);
    }

    /**
     * 通过角色编码查询，看哪些用户被分配到了指定角色
     * @param request
     * @return
     */
    @RequestMapping(path = "/queryRoleUser",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryRoleUser(@RequestBody UserControllerRequest request){
        UserControllerResponse response = new UserControllerResponse();

        Map<String, Object> param = processRoleUserParam(request);

        PageResult<UserEntity> list = userManager.findRoleUser(param,
                request.getStartOrDefault(0),request.getPageSizeOrDefault(20));

        response.setResult(list);

        return this.success(response);
    }

    /**
     * 通过数据角色编码查询，看哪些用户被分配到了指定角色
     * @param request
     * @return
     */
    @RequestMapping(path = "/queryDataRoleUser",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryDataRoleUser(@RequestBody UserControllerRequest request){
        UserControllerResponse response = new UserControllerResponse();

        Map<String, Object> param = processRoleUserParam(request);

        PageResult<UserEntity> list = userManager.findDataRoleUser(param,
                request.getStartOrDefault(0),request.getPageSizeOrDefault(20));
        response.setResult(list);
        return this.success(response);
    }

    /**
     * @description 修改登录密码
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-16 14:39
     * @since 1.0
     */
    @RequestMapping(path = "/changePassword",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> changePassword(@RequestBody UserControllerRequest request){
        UserControllerResponse response = new UserControllerResponse();

        userManager.changePassword(CurrentContext.getUserId(),request.getEntity().getOldPassword(),request.getEntity().getNewPassword());

        OperationLogEntity optLog = new OperationLogEntity();
        optLog.setBizId(CurrentContext.getUserId());
        optLog.setOptType(UserOperationType.UpdatePassword);
        optLog.setContent(String.format("%s更新了登录密码",CurrentContext.getUserName()));
        operationLogManager.create(optLog);

        return this.success(response);
    }

    /**
     * @description 查询当前登录用户的基本信息
     * @auth david·cun
     * @date 2019-04-18 10:08
     * @since 1.0
     */
    @RequestMapping(path = "/current",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> current(@RequestBody UserControllerRequest request){
        UserControllerResponse response = new UserControllerResponse();

        UserEntity u = new UserEntity();
        UserEntity cur = (UserEntity) CurrentContext.getUserInfo();

        u.setId(cur.getId());
        u.setId(cur.getId());
        u.setUserName(cur.getUserName());
        u.setUserPhone(cur.getUserPhone());
        u.setOwnerDeptId(cur.getOwnerDeptId());
        u.setOwnerDeptName(cur.getOwnerDeptName());
        u.setWorkNumber(cur.getWorkNumber());
        u.setAvatar(cur.getAvatar());

        response.setResult(u);

        return this.success(response);
    }

    private Map<String,Object> processRoleUserParam(UserControllerRequest request){
        ValidationResult vr = ValidationUtils.validateInclude(request.getEntity(),"roleId");
        if (!vr.getSuccess()){
            throw new BusinessException(vr.getMessage());
        }
        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request.getEntity(),"roleId");
        if (StringUtils.isNotEmpty(request.getKeyword())){
            param.put("keyword",request.getKeyword());
        }
        return param;
    }

}
