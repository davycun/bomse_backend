package com.cii.bomse.crm.customer.industry.manager.impl;

import com.cii.bomse.crm.customer.base.dictionary.CustomerOwnerType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerStatus;
import com.cii.bomse.crm.customer.base.entity.CustomerAreaEntity;
import com.cii.bomse.crm.customer.base.manager.IBaseCustomerValidator;
import com.cii.bomse.crm.customer.base.manager.ICustomerAreaManager;
import com.cii.bomse.crm.customer.base.manager.impl.BaseCustomerManager;
import com.cii.bomse.crm.customer.industry.dao.ICustomerIndustryDao;
import com.cii.bomse.crm.customer.industry.dto.CustomerStatisticDto;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryEntity;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryManager;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryValidator;
import com.cii.bomse.hrm.dept.entity.DeptEntity;
import com.cii.bomse.ums.user.entity.UserEntity;
import com.cii.bomse.ums.user.manager.IUserManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.*;


@Component
public class CustomerIndustryManagerImpl extends BaseCustomerManager<CustomerIndustryEntity> implements ICustomerIndustryManager {

    @Autowired
    private ICustomerIndustryDao customerIndustryDao;
    @Autowired
    private ICustomerIndustryValidator customerIndustryValidator;
    @Autowired
    private IUserManager userManager;
    @Autowired
    private ICustomerAreaManager customerAreaManager;

    @Override
    protected IMyBatisBaseDao<CustomerIndustryEntity, Long> getMyBatisDao() {
        return customerIndustryDao;
    }

    @Override
    public IBaseCustomerValidator<CustomerIndustryEntity> getCustomerValidator() {
        return customerIndustryValidator;
    }

    @Override
    protected void beforeBatchCreate(List<CustomerIndustryEntity> list) {
        for (CustomerIndustryEntity customerIndustry : list) {

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑
            ValidationResult vr = ValidationUtils.validateInclude(customerIndustry, "cusPhone", "cusName", "cusOwnerType", "cusSource");
            if (!vr.getSuccess()) {
                throw new BusinessException(vr.getMessage());
            }
            //校验是否可以新增客户的
            validateCreateCustomer(customerIndustry.getCusPhone());

            //TODO 新增房源的时候，需要校验，客户不需要
//            validatePrice(customerIndustry);

            fillOwnerInfo(customerIndustry);

            fillUpUserInfo(customerIndustry);

            processAreaString(customerIndustry);
        }
        //保存需求区域
        processAreas(list);
    }

    @Override
    protected void beforeBatchUpdate(List<CustomerIndustryEntity> list) {
        for (CustomerIndustryEntity customerIndustry : list) {
            //不能更新客户号码
            customerIndustry.setCusPhone(null);
            processAreaString(customerIndustry);
        }
        processAreas(list);
    }

    @Override
    protected void afterBatchCreate(List<CustomerIndustryEntity> list) {
        processPartTimer(list);
    }

    @Override
    protected void afterBatchUpdate(List<CustomerIndustryEntity> list) {
        processPartTimer(list);
    }

    /**
     * @description
     * 创建客户的时候填充不同的客户类型的客户的所属信息
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-29 21:34
     * @since 1.0
     */
    private void fillOwnerInfo(CustomerIndustryEntity customerIndustry) {
        //公盘客户
        if (CustomerOwnerType.Company.equals(customerIndustry.getCusOwnerType())) {
            if (ObjectUtils.isEmpty(customerIndustry.getOwnerDeptId())) {
                throw new BusinessException("公盘客户部门ID必填");
            } else {
                DeptEntity dept = deptManager.findById(customerIndustry.getOwnerDeptId(), "id", "dept_name");
                customerIndustry.setOwnerDeptName(dept.getDeptName());
                customerIndustry.setOwnerId(null);
                customerIndustry.setOwnerName(null);
            }
            customerIndustry.setCusStatus(CustomerStatus.WaitProcess);
        } else if (CustomerOwnerType.Hide.equals(customerIndustry.getCusOwnerType())) {
            if (ObjectUtils.isEmpty(customerIndustry.getOwnerId())) {
                throw new BusinessException("公盘拉私客户，必须先分配人员");
            } else {
                UserEntity user = userManager.findById(customerIndustry.getOwnerId(), "id", "user_name", "owner_dept_id", "owner_dept_name");
                customerIndustry.setOwnerName(user.getOwnerName());
                customerIndustry.setOwnerDeptId(user.getOwnerDeptId());
                customerIndustry.setOwnerDeptName(user.getOwnerDeptName());
            }
            customerIndustry.setCusStatus(CustomerStatus.WaitProcess);
        } else {
            if (ObjectUtils.isEmpty(customerIndustry.getCusStatus())) {
                customerIndustry.setCusStatus(CustomerStatus.Followup);
            }
        }
    }

    /**
     * @description
     * 填充客户上架的上架人信息
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-29 21:34
     * @since 1.0
     */
    private void fillUpUserInfo(CustomerIndustryEntity customerIndustry) {
        if (ObjectUtils.isEmpty(customerIndustry.getLastUpUserId())) {
            customerIndustry.setLastUpUserId(CurrentContext.getUserId());
            customerIndustry.setLastUpUserName(CurrentContext.getUserName());
            customerIndustry.setLastUpUserDeptId(CurrentContext.getOwnerDeptId());
            customerIndustry.setLastUpUserDeptName(CurrentContext.getOwnerDeptName());
            customerIndustry.setLastUpTime(new Date());
        }
    }

    /**
     * @description
     * 处理省市区，合并字段到一个areaString字段，便于检索，不用关联
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-29 21:34
     * @since 1.0
     */
    private void processAreaString(CustomerIndustryEntity customer){
        if (ObjectUtils.isNotEmpty(customer.getAreas())){
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<customer.getAreas().size();i++){
                CustomerAreaEntity area = customer.getAreas().get(i);
                if (i>0){
                    sb.append("|");
                }
                sb.append(area.getNameString());
                sb.append("(").append(area.getIdString()).append(")");

            }
            customer.setAreaString(sb.toString());
        }
    }

    /**
     * @description
     * 保存客户的需求区域信息，一对多关系
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-29 21:35
     * @since 1.0
     */
    private void processAreas(List<CustomerIndustryEntity> list){
        List<CustomerAreaEntity> areas = new ArrayList<>();

        for (CustomerIndustryEntity customer : list){

            if (ObjectUtils.isNotEmpty(customer.getAreas())){
                for (CustomerAreaEntity area : customer.getAreas()){
                    area.setCusId(customer.getId());
                }
                areas.addAll(customer.getAreas());

                Map<String,Object> param = new HashMap<>();
                param.put("cusId",customer.getId());
                customerAreaManager.deleteByMap(param);
            }else{
                throw new BusinessException("需求区域必填");
            }
        }

        if (ObjectUtils.isNotEmpty(areas)){
            customerAreaManager.batchCreate(areas);
        }
    }


    @Override
    public CustomerStatisticDto waitWorkStatistic() {

        CustomerStatisticDto statisticDto = new CustomerStatisticDto();

        Map<String,Object> param = new HashMap<>();

        param.put("cusStatus",CustomerStatus.WaitProcess);
        statisticDto.setWaitProcessCount(countByMap(param));

        Date now = Calendar.getInstance().getTime();

        param.clear();
        //最后跟进小于下一次联系时间的数据
        param.put("cusStatus",CustomerStatus.Followup);
        param.put("waitContact",Boolean.TRUE);
        param.put("nextContactTimeEnd",now);
        statisticDto.setWaitContactCount(countByMap(param));

        //2个月内到期，并且5天内没有跟进过的
        //TODO 此处可以做成统一配置
        param.clear();
        param.put("cusStatus",CustomerStatus.HasDown);
        param.put("nextContactTimeEnd",DateUtils.addMonths(now,2));
        param.put("lastFollowupTimeEnd",DateUtils.addDays(now,-5));
        statisticDto.setWaitUpCount(countByMap(param));

        return statisticDto;

    }
}
