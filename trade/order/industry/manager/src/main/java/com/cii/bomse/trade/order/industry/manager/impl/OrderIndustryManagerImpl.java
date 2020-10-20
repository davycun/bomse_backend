package com.cii.bomse.trade.order.industry.manager.impl;

import com.cii.bomse.crm.customer.base.dictionary.CustomerDownReasonType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerUpDownType;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryUpDownEntity;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryUpDownManager;
import com.cii.bomse.common.dictionary.IndustryPriceUnitType;
import com.cii.bomse.house.industry.entity.FloorIndustryEntity;
import com.cii.bomse.house.industry.manager.IFloorIndustryManager;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.cii.bomse.trade.order.industry.dao.IOrderIndustryDao;
import com.cii.bomse.trade.order.industry.dictionary.OrderStatus;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryDivideEntity;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryExpensesEntity;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryHouseEntity;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryDivideManager;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryExpensesManager;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryHouseManager;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryManager;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class OrderIndustryManagerImpl extends AbstractManager<OrderIndustryEntity> implements IOrderIndustryManager {

    @Autowired
    private IOrderIndustryDao orderIndustryDao;
    @Autowired
    private IOrderIndustryDivideManager orderIndustryDivideManager;
    @Autowired
    private IOrderIndustryExpensesManager orderIndustryExpensesManager;
    @Autowired
    private IOrderIndustryHouseManager orderIndustryHouseManager;
    @Autowired
    private ICustomerIndustryUpDownManager customerIndustryUpDownManager;
    @Autowired
    private IFloorIndustryManager floorIndustryManager;
    @Autowired
    private IDeptManager deptManager;

    @Override
    protected IMyBatisBaseDao<OrderIndustryEntity, Long> getMyBatisDao() {
        return orderIndustryDao;
    }

    @Override
    protected void beforeBatchCreate(List<OrderIndustryEntity> list) {
        for (OrderIndustryEntity orderIndustry : list) {
            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑

            if (ObjectUtils.isEmpty(orderIndustry.getOrderStatus())) {
                orderIndustry.setOrderStatus(OrderStatus.WaitBack);
            }

            if (ObjectUtils.isEmpty(orderIndustry.getContractAmount())) {
                if (ObjectUtils.isEmpty(orderIndustry.getLandlordContractAmount())) {
                    orderIndustry.setLandlordContractAmount(BigDecimal.ZERO);
                }
                if (ObjectUtils.isEmpty(orderIndustry.getCustomerContractAmount())) {
                    orderIndustry.setCustomerContractAmount(BigDecimal.ZERO);
                }
                orderIndustry.setContractAmount(orderIndustry.getLandlordContractAmount().add(orderIndustry.getCustomerContractAmount()));
            }
        }
        //设置订单成交的总面积及平均价格
        processOrderLeasePrice(list);
        //设置订单房源成交地址
        processOrderAddress(list);
    }

    @Override
    protected void beforeBatchUpdate(List<OrderIndustryEntity> list) {
        for (OrderIndustryEntity orderIndustry : list) {
            //在更新数据之前的动作，比如校验数据唯一键必填
        }

        //设置订单成交的总面积及平均价格
        processOrderLeasePrice(list);
        //设置订单房源成交地址
        processOrderAddress(list);
    }

    @Override
    protected void afterBatchCreate(List<OrderIndustryEntity> list) {
        createOrUpdateDivide(list, false);
        createOrUpdateExpenses(list, false);
        createOrUpdateOrderHouse(list, false);

        //订单录入成交后，下架房源
        downCustomer(list);
        //订单成交，修改房源可出租面积
        reduceHouseLeaseAcreage(list);

    }

    @Override
    protected void afterBatchUpdate(List<OrderIndustryEntity> list) {
        createOrUpdateDivide(list, true);
        createOrUpdateExpenses(list, true);
        createOrUpdateOrderHouse(list, true);
    }

    /**
     * @param
     * @return
     * @description 处理订单成交房源的平均价格和总面积
     * @author david·cun
     * @date 2020-02-18 21:46
     * @since 1.0
     */
    private void processOrderLeasePrice(List<OrderIndustryEntity> orderList) {

        for (OrderIndustryEntity order : orderList) {
            if (ObjectUtils.isNotEmpty(order.getOrderHouses())) {

                Float price = 0f;
                Float acreage = 0f;
                for (OrderIndustryHouseEntity orderHouse : order.getOrderHouses()) {

                    processHouseLeasePrice(orderHouse);

                    price += orderHouse.getLeasePrice();
                    acreage += orderHouse.getLeaseAcreage();
                }

                order.setLeasePrice(price / order.getOrderHouses().size());
                order.setLeaseAcreage(acreage);
                order.setLeasePriceUnit(IndustryPriceUnitType.Day);
            }
        }
    }

    /**
     * @param
     * @return
     * @description 固定修改成交房源的单价单位为元/平米/天
     * @author david·cun
     * @date 2020-02-18 21:46
     * @since 1.0
     */
    private void processHouseLeasePrice(OrderIndustryHouseEntity orderHouse) {

        if (IndustryPriceUnitType.Month.equals(orderHouse.getLeasePriceUnit())) {

            orderHouse.setLeasePrice(orderHouse.getLeasePrice() * 12 / 365);
            orderHouse.setLeasePriceUnit(IndustryPriceUnitType.Day);

        } else if (IndustryPriceUnitType.Year.equals(orderHouse.getLeasePriceUnit())) {

            orderHouse.setLeasePrice(orderHouse.getLeasePrice() / 365);
            orderHouse.setLeasePriceUnit(IndustryPriceUnitType.Day);
        }
    }

    /**
     * @param
     * @return
     * @description 设置成交房源位置到订单的冗余字段
     * @author david·cun
     * @date 2020-02-19 19:18
     * @since 1.0
     */
    private void processOrderAddress(List<OrderIndustryEntity> orderList) {

        for (OrderIndustryEntity order : orderList) {

            if (ObjectUtils.isNotEmpty(order.getOrderHouses())) {

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < order.getOrderHouses().size(); i++) {
                    OrderIndustryHouseEntity orderHouse = order.getOrderHouses().get(i);

                    if (i>0){
                        sb.append(";");
                    }

                    sb.append(orderHouse.getCityName());
                    sb.append(orderHouse.getRegionName());
                    sb.append(orderHouse.getStreetName());
                    if (ObjectUtils.isNotEmpty(orderHouse.getCommunityName())){
                        sb.append(orderHouse.getRegionName());
                    }
                    sb.append(orderHouse.getAddress());
                    sb.append(orderHouse.getBdName()).append("栋");
                    sb.append("第").append(orderHouse.getFloorNumber()).append("层");
                }

                order.setHouseAddress(sb.toString());
            }
        }

    }


    /**
     * @param
     * @return
     * @description 在after之后调用
     * @author david·cun
     * @date 2020-02-15 19:18
     * @since 1.0
     */
    private void createOrUpdateDivide(List<OrderIndustryEntity> list, boolean update) {

        List<OrderIndustryDivideEntity> divideList = new ArrayList<>();

        List<Long> orderIdList = new ArrayList<>();

        for (OrderIndustryEntity order : list) {
            if (ObjectUtils.isNotEmpty(order.getOrderDivides())) {
                for (OrderIndustryDivideEntity divide : order.getOrderDivides()) {
                    divide.setOrderId(order.getId());
                    divide.setOrderTime(order.getOrderTime());

                    divideList.add(divide);
                }

                //如果是更新记录ID，之后更新的逻辑是先删除关联的ID数据再新增
                if (update) {
                    orderIdList.add(order.getId());
                }
            }
        }

        if (ObjectUtils.isNotEmpty(divideList)) {
            if (ObjectUtils.isNotEmpty(orderIdList)) {
                Map<String, Object> param = new HashMap<>();
                param.put("orderIdList", orderIdList);
                orderIndustryDivideManager.deleteByMap(param);
            }
            orderIndustryDivideManager.batchCreate(divideList);
        }


    }

    /**
     * @param
     * @return
     * @description 在after之后调用
     * @author david·cun
     * @date 2020-02-15 19:18
     * @since 1.0
     */
    private void createOrUpdateExpenses(List<OrderIndustryEntity> list, boolean update) {

        List<OrderIndustryExpensesEntity> expensesList = new ArrayList<>();
        List<Long> orderIdList = new ArrayList<>();

        if (ObjectUtils.isNotEmpty(list)) {
            for (OrderIndustryEntity order : list) {
                if (ObjectUtils.isNotEmpty(order.getOrderExpenses())) {
                    for (OrderIndustryExpensesEntity expense : order.getOrderExpenses()) {
                        expense.setOrderId(order.getId());

                        expensesList.add(expense);
                    }
                }

                if (update) {
                    orderIdList.add(order.getId());
                }
            }
        }

        if (ObjectUtils.isNotEmpty(expensesList)) {
            if (ObjectUtils.isNotEmpty(orderIdList) && update) {
                Map<String, Object> param = new HashMap<>();
                param.put("orderIdList", orderIdList);
                orderIndustryExpensesManager.deleteByMap(param);
            }

            orderIndustryExpensesManager.batchCreate(expensesList);
        }
    }

    /**
     * @param
     * @return
     * @description 在after之后调用
     * @author david·cun
     * @date 2020-02-15 19:18
     * @since 1.0
     */
    private void createOrUpdateOrderHouse(List<OrderIndustryEntity> list, boolean update) {

        List<OrderIndustryHouseEntity> orderHouseList = new ArrayList<>();
        List<Long> orderIdList = new ArrayList<>();

        if (ObjectUtils.isNotEmpty(list)) {
            for (OrderIndustryEntity order : list) {
                if (ObjectUtils.isNotEmpty(order.getOrderHouses())) {
                    for (OrderIndustryHouseEntity orderHouse : order.getOrderHouses()) {
                        orderHouse.setOrderId(order.getId());

                        orderHouseList.add(orderHouse);
                    }
                }
                if (update) {
                    orderIdList.add(order.getId());
                }
            }
        }

        if (ObjectUtils.isNotEmpty(orderHouseList)) {
            if (ObjectUtils.isNotEmpty(orderIdList)) {
                Map<String, Object> param = new HashMap<>();
                param.put("orderIdList", orderIdList);
                orderIndustryHouseManager.deleteByMap(param);
            }
            orderIndustryHouseManager.batchCreate(orderHouseList);
        }

    }


    /**
     * @param
     * @return
     * @description 房源成交后，状态变更，只有新增的订单的时候调用
     * @author david·cun
     * @date 2020-02-18 21:47
     * @since 1.0
     */
    private void reduceHouseLeaseAcreage(List<OrderIndustryEntity> orderList) {
        List<FloorIndustryEntity> floorList = new ArrayList<>();

        for (OrderIndustryEntity order : orderList) {
            if (ObjectUtils.isNotEmpty(order.getOrderHouses())) {
                for (OrderIndustryHouseEntity orderHouse : order.getOrderHouses()) {
                    FloorIndustryEntity floor = floorIndustryManager.findById(orderHouse.getFloorId(), "id", "park_id", "building_id", "total_acreage", "lease_acreage");

                    if (floor.getLeaseAcreage() > orderHouse.getLeaseAcreage()) {
                        //减去已经出租掉的面积
                        floor.setLeaseAcreage(floor.getLeaseAcreage() - orderHouse.getLeaseAcreage());
                    } else {
                        floor.setLeaseAcreage(0f);
                    }

                    floorList.add(floor);
                }
            }
        }

        if (ObjectUtils.isNotEmpty(floorList)) {
            floorIndustryManager.batchUpdate(floorList);
        }
    }

    /**
     * @param
     * @return
     * @description 客户成交后，修改客户状态
     * @author david·cun
     * @date 2020-02-18 21:48
     * @since 1.0
     */
    private void downCustomer(List<OrderIndustryEntity> orderList) {

        List<CustomerIndustryUpDownEntity> upDownList = new ArrayList<>();

        for (OrderIndustryEntity order : orderList) {

            CustomerIndustryUpDownEntity upDown = new CustomerIndustryUpDownEntity();
            upDown.setCusId(order.getCusId());
            upDown.setUpDownType(CustomerUpDownType.Down);
            upDown.setDownReason(CustomerDownReasonType.neiBuChengJiao);
            upDown.setNextContactTime(order.getContractTimeEnd());
            upDown.setRemark("录入订单系统自动下架此客户，所以下架人为当前录入订单的人");
            upDownList.add(upDown);
        }

        if (ObjectUtils.isNotEmpty(upDownList)) {
            customerIndustryUpDownManager.batchCreate(upDownList);
        }
    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        //TODO 只能查询有权限的订单，此处要考虑分成里面的人是否有权限

        List<Long> ownerUserDeptIdList = deptManager.findUserAuthDeptId(CurrentContext.getUserId());

        //查询自己有权限部门和自己的数据
        if (ObjectUtils.isNotEmpty(ownerUserDeptIdList)) {
            param.put("authOwnerDeptIdList", ownerUserDeptIdList);
            param.put("authOwnerId", CurrentContext.getUserId());
        } else {
            //查询自己的订单
            param.put("ownerId", CurrentContext.getUserId());
//            param.put("authOwnerDeptId", CurrentContext.getOwnerDeptId());
        }


    }
}
