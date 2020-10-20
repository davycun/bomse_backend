package com.cii.bomse.crm.customer.base.manager.impl;

import com.cii.bomse.common.utils.Constants;
import com.cii.bomse.crm.customer.base.dictionary.CustomerOperationType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerOwnerType;
import com.cii.bomse.crm.customer.base.entity.BaseCustomerEntity;
import com.cii.bomse.crm.customer.base.manager.IBaseCustomerManager;
import com.cii.bomse.crm.customer.base.manager.IBaseCustomerValidator;
import com.cii.bomse.crm.parttimer.dao.IPartTimerDao;
import com.cii.bomse.crm.parttimer.entity.PartTimerEntity;
import com.cii.bomse.hrm.dept.entity.DeptConfigEntity;
import com.cii.bomse.hrm.dept.manager.IDeptConfigManager;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.cii.bomse.hrm.dept.manager.IDeptShareManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.log.entity.OperationLogEntity;
import com.ciiframework.log.manager.IOperationLogManager;
import com.ciiframework.utils.GenericsUtils;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 14:32
 * @since 1.0
 */
public abstract class BaseCustomerManager<T extends BaseCustomerEntity> extends AbstractManager<T> implements IBaseCustomerManager<T> {
    @Autowired
    protected IOperationLogManager operationLogManager;
    @Autowired
    protected IDeptManager deptManager;
    @Autowired
    protected IPartTimerDao partTimerDao;
    @Autowired
    protected IDeptConfigManager deptConfigManager;
    @Autowired
    protected IDeptShareManager deptShareManager;

    public abstract IBaseCustomerValidator<T> getCustomerValidator();

    @Transactional
    @Override
    public String callPhone(Long cusId) {

        String cusPhone = null;
        T customer = findById(cusId, "id", "cus_phone", "cus_owner_type", "owner_id", "owner_name", "owner_dept_id", "owner_dept_name");
        ValidationResult vr;

        if ((vr = getCustomerValidator().validateCustomerInUserPersonal(customer, CurrentContext.getUserInfo())).getSuccess()) {
            cusPhone = customer.getCusPhone();
        } else if ((vr = getCustomerValidator().validateSharePersonalCustomerInDept(customer, CurrentContext.getUserInfo())).getSuccess()) {
            cusPhone = customer.getCusPhone();
        } else if ((vr = getCustomerValidator().validateCustomerInUserAuthDeptPersonal(customer, CurrentContext.getUserInfo())).getSuccess()) {
            cusPhone = customer.getCusPhone();
        } else if ((vr = getCustomerValidator().validateCustomerInUserAuthDeptPublic(customer, CurrentContext.getUserInfo())).getSuccess()) {
            cusPhone = customer.getCusPhone();
        } else if ((vr = getCustomerValidator().validateCustomerInShareDeptPublic(customer, CurrentContext.getUserInfo())).getSuccess()) {
            cusPhone = customer.getCusPhone();
        } else if ((vr = getCustomerValidator().validateCustomerInUserPrivate(customer, CurrentContext.getUserInfo())).getSuccess()) {
            cusPhone = customer.getCusPhone();
        } else if ((vr = getCustomerValidator().validateCustomerInUserAuthDeptPrivate(customer, CurrentContext.getUserInfo())).getSuccess()) {
            cusPhone = customer.getCusPhone();
        } else if ((vr = getCustomerValidator().validateCustomerInUserPush(customer, CurrentContext.getUserInfo())).getSuccess()) {
            cusPhone = customer.getCusPhone();
        } else if ((vr = getCustomerValidator().validateCustomerInUserAuthDeptPush(customer, CurrentContext.getUserInfo())).getSuccess()) {
            cusPhone = customer.getCusPhone();
        }

        if (ObjectUtils.isEmpty(cusPhone)) {
            throw new BusinessException("没有权限查看此客户号码");
        }

        //新增客户操作日志
        OperationLogEntity optLog = new OperationLogEntity();
        optLog.setBizId(cusId);
        optLog.setOptType(CustomerOperationType.cusSeePhone);
        optLog.setContent(String.format("%s查看了客户[%d]号码", CurrentContext.getUserName(), cusId));
        operationLogManager.create(optLog);

        return cusPhone;
    }

    @Override
    public void validateCreateCustomer(String cusPhone) {

        ValidationResult vr;

        Map<String, Object> param = new HashMap<>();
        param.put("cusPhone", cusPhone);
        ObjectUtils.isNotEmpty(CurrentContext.getCpyId(), param, (p) -> p.put("cpyId", CurrentContext.getCpyId()));
        //此处只能用DAO查询，查询全局是否有客户，否则会被filterParam过滤
        List<T> customerList = getMyBatisDao().selectByMapSimple(param,
                "id", "cus_phone", "cus_owner_type", "cus_status", "owner_id", "owner_name", "owner_dept_id", "owner_dept_name");

        if (ObjectUtils.isNotEmpty(customerList)) {
            for (T customer : customerList) {
                if ((vr = getCustomerValidator().validateCustomerInUserPersonal(customer, CurrentContext.getUserInfo())).getSuccess()) {
                    throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不可重复创建");
                } else if ((vr = getCustomerValidator().validateSharePersonalCustomerInDept(customer, CurrentContext.getUserInfo())).getSuccess()) {

                    throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不可重复创建");
                } else if ((vr = getCustomerValidator().validateCustomerInUserAuthDeptPersonal(customer, CurrentContext.getUserInfo())).getSuccess()) {

                    throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不可重复创建");
                } else if ((vr = getCustomerValidator().validateCustomerInUserAuthDeptPublic(customer, CurrentContext.getUserInfo())).getSuccess()) {

                    throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不可重复创建");
                } else if ((vr = getCustomerValidator().validateCustomerInShareDeptPublic(customer, CurrentContext.getUserInfo())).getSuccess()) {

                    throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不可重复创建");
                } else if ((vr = getCustomerValidator().validateCustomerInUserPrivate(customer, CurrentContext.getUserInfo())).getSuccess()) {

                    throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不可重复创建");
                } else if ((vr = getCustomerValidator().validateCustomerInUserAuthDeptPrivate(customer, CurrentContext.getUserInfo())).getSuccess()) {

                    throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不可重复创建");
                } else if ((vr = getCustomerValidator().validateCustomerInUserPush(customer, CurrentContext.getUserInfo())).getSuccess()) {

                    throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不可重复创建");
                } else if ((vr = getCustomerValidator().validateCustomerInUserAuthDeptPush(customer, CurrentContext.getUserInfo())).getSuccess()) {
                    throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不可重复创建");
                }

            }
        }
    }

    @Transactional
    @Override
    public void hide(Long cusId) {

        T customer = findById(cusId,
                "id", "cus_phone", "cus_owner_type", "cus_status", "owner_id", "owner_name", "owner_dept_id", "owner_dept_name");

        if (ObjectUtils.isNotEmpty(customer)) {

            ValidationResult vr = getCustomerValidator().validateCustomerInUserAuthDeptPublic(customer, CurrentContext.getUserInfo());
            if (vr.getSuccess()) {

                //更新客户信息
                T cus = (T) ObjectUtils.createInstance(GenericsUtils.getSuperClassGenricType(getClass()));
                cus.setId(cusId);
                cus.setOwnerId(CurrentContext.getUserId());
                cus.setOwnerName(CurrentContext.getUserName());
                cus.setHideTime(new Date());
                cus.setCusOwnerType(CustomerOwnerType.Hide);
                getMyBatisDao().update(cus);

                //添加日志
                OperationLogEntity opt = new OperationLogEntity();
                opt.setBizId(cusId);
                opt.setOptType(CustomerOperationType.cusHide);
                opt.setContent(String.format("%s拉私了客户[%d]", CurrentContext.getUserName(), cusId));
                operationLogManager.create(opt);

            } else {
                throw new BusinessException(String.format(
                        "只能拉私自己部门的公盘客户，此客户的类型为%s，所属部门为%s",
                        customer.getCusOwnerTypeName(), customer.getOwnerDeptName()));
            }
        } else {
            throw new BusinessException("客户不存在");
        }

    }

    @Transactional
    @Override
    public void open(Long cusId) {

        T customer = findById(cusId,
                "id", "cus_phone", "cus_owner_type", "cus_status", "owner_id", "owner_name", "owner_dept_id", "owner_dept_name");

        if (ObjectUtils.isNotEmpty(customer)) {

            ValidationResult vr;

            if ((vr = getCustomerValidator().validateCustomerInUserPrivate(customer, CurrentContext.getUserInfo())).getSuccess()
                    || (vr = getCustomerValidator().validateCustomerInUserAuthDeptPrivate(customer, CurrentContext.getUserInfo())).getSuccess()) {

                //更新客户信息
                T cus = (T) ObjectUtils.createInstance(GenericsUtils.getSuperClassGenricType(getClass()));
                cus.setId(cusId);
                cus.setOpenTime(new Date());
                cus.setCusOwnerType(CustomerOwnerType.Company);
                cus.setOpenUserId(CurrentContext.getUserId());
                cus.setOpenUserName(CurrentContext.getUserName());

                getMyBatisDao().update(cus);

                //添加日志
                OperationLogEntity opt = new OperationLogEntity();
                opt.setBizId(cusId);
                opt.setOptType(CustomerOperationType.cusOpen);
                opt.setContent(String.format("%s公开了客户[%d]", CurrentContext.getUserName(), cusId));
                operationLogManager.create(opt);

            } else {
                throw new BusinessException(String.format(
                        "只能公开自己私盘或者自己部门私盘的客户，此客户的类型为%s，所属部门为%s",
                        customer.getCusOwnerTypeName(), customer.getOwnerDeptName()));
            }
        } else {
            throw new BusinessException("客户不存在");
        }
    }

    @Transactional
    @Override
    public void updateCustomerPhone(Long cusId, String oldPhone, String newPhone) {
        if (ObjectUtils.isNotEmpty(cusId)
                && ObjectUtils.isNotEmpty(oldPhone)
                && ObjectUtils.isNotEmpty(newPhone)) {

            T customer = findById(cusId, "id", "cus_phone");

            if (ObjectUtils.isNotEmpty(customer)) {

                if (customer.getCusPhone().equals(oldPhone)
                        && Pattern.matches(Constants.phoneRegexp, newPhone)) {

                    //更新客户号码
                    customer.setCusPhone(newPhone);
                    getMyBatisDao().update(customer);

                    //添加日志
                    OperationLogEntity opt = new OperationLogEntity();
                    opt.setBizId(cusId);
                    opt.setOptType(CustomerOperationType.cusPhoneUpdate);
                    opt.setContent(String.format("%s更新了客户[%d]号码，老号码为%s", CurrentContext.getUserName(), cusId, oldPhone));
                    opt.setRemark(oldPhone);
                    operationLogManager.create(opt);

                } else {
                    throw new BusinessException("手机号码格式不对，或者原号码不匹配");
                }

            } else {
                throw new BusinessException(String.format("客户[%d]不存在", cusId));
            }
        }
    }

    /**
     * @param
     * @return
     * @description 兼职推荐计算兼职的推荐量及最后推荐时间
     * @author david·cun
     * @date 2019-11-29 21:32
     * @since 1.0
     */
    protected void processPartTimer(List<T> list) {

        List<PartTimerEntity> pts = new ArrayList<>();
        for (T cus : list) {

            if (ObjectUtils.isNotEmpty(cus.getPtId())) {

                PartTimerEntity pt = new PartTimerEntity();

                pt.setId(cus.getPtId());
                pt.setRecommendCount(recommendCount(cus.getPtId()));
                pt.setLastRecommendTime(new Date());

                pts.add(pt);
            }
        }

        if (pts.size() > 0) {
            partTimerDao.batchUpdate(pts);
        }
    }

    protected int recommendCount(Long id) {
        Map<String, Object> param = new HashMap<>();
        param.put("ptId", id);
        return getMyBatisDao().countByMap(param);
    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        //添加只能查询本区域相关的客户
        if (ObjectUtils.isNotEmpty(CurrentContext.getOwnerDeptId())) {

            if (param.containsKey("cusOwnerType")) {

                String cusOwnerType = param.get("cusOwnerType").toString();

                if (CustomerOwnerType.Hide.equals(cusOwnerType)) {

                    List<Long> ownerUserDeptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());

                    if (ObjectUtils.isNotEmpty(ownerUserDeptIds)) {
                        param.put("authOwnerDeptIds", ownerUserDeptIds);
                        param.put("authOwnerId", CurrentContext.getUserId());
                    } else {
                        param.put("ownerId", CurrentContext.getUserId());
                    }

                } else if (CustomerOwnerType.Personal.equals(cusOwnerType)) {

                    List<Long> ownerUserDeptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());
                    if (ownerUserDeptIds==null){
                        ownerUserDeptIds = new ArrayList<>();
                    }
                    //如果是部门内部共享，把本部门编码也传入
                    addDeptInnerShareConfig(ownerUserDeptIds);

                    if (ObjectUtils.isNotEmpty(ownerUserDeptIds)) {
                        param.put("authOwnerDeptIds", ownerUserDeptIds);
                        param.put("authOwnerId", CurrentContext.getUserId());
                    } else {
                        param.put("ownerId", CurrentContext.getUserId());
                    }

                } else if (CustomerOwnerType.Company.equals(cusOwnerType)) {

                    List<Long> ownerDeptIds = new ArrayList<>();
                    List<Long> deptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());

                    if (ObjectUtils.isNotEmpty(deptIds)) {
                        ownerDeptIds.addAll(deptIds);
                    }

                    List<Long> result = deptShareManager.findAllShareDeptByDeptId(CurrentContext.getOwnerDeptId());
                    ownerDeptIds.addAll(result);

                    if (!ownerDeptIds.contains(CurrentContext.getOwnerDeptId())) {
                        ownerDeptIds.add(CurrentContext.getOwnerDeptId());
                    }

                    if (ObjectUtils.isNotEmpty(ownerDeptIds)) {
                        param.put("authOwnerDeptIds", ownerDeptIds);
//                        param.put("authOwnerId", CurrentContext.getUserId());
                    }
                }
            } else {


                //如果有权限部门，那么就是查询自己的客户或者有权限的部门客户
                List<Long> ownerUserDeptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());
                addDeptInnerShareConfig(ownerUserDeptIds);

                if (ObjectUtils.isNotEmpty(ownerUserDeptIds)) {
                    param.put("authOwnerDeptIds", ownerUserDeptIds);
                    param.put("authOwnerId", CurrentContext.getUserId());
                } else {
                    //没有传入客户类型的时候，只能查询所属是自己的客户（包含了个人客户和拉私客户），或者本部门的公盘客户
                    param.put("authOwnerId", CurrentContext.getUserId());
                    param.put("authCusOwnerDeptId", CurrentContext.getOwnerDeptId());
                    param.put("authCusOwnerType", CustomerOwnerType.Company);
                }
            }
        }

    }

    protected void addDeptInnerShareConfig(List<Long> ownerUserDeptIds){
        DeptConfigEntity config = deptConfigManager.findByDeptId(CurrentContext.getOwnerDeptId());

        if (ObjectUtils.isNotEmpty(config.getSharePersonalCustomer()) && config.getSharePersonalCustomer()) {
            //如果部门内部共享，查询个人客户的时候也添加可以查看自己部门内部的客户
            ownerUserDeptIds.add(CurrentContext.getOwnerDeptId());
        }
    }

}
