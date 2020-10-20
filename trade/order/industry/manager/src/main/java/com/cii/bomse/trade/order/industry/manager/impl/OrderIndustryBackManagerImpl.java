package com.cii.bomse.trade.order.industry.manager.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryBackDao;
import com.cii.bomse.trade.order.industry.dao.IOrderIndustryDao;
import com.cii.bomse.trade.order.industry.dao.IOrderIndustryInvoiceDao;
import com.cii.bomse.trade.order.industry.dao.IOrderIndustryInvoiceRelationDao;
import com.cii.bomse.trade.order.industry.dictionary.OrderBackStatus;
import com.cii.bomse.trade.order.industry.dictionary.OrderBackType;
import com.cii.bomse.trade.order.industry.dictionary.OrderStatus;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryBackEntity;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryEntity;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryInvoiceRelationEntity;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryInvoiceEntity;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryBackManager;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryInvoiceManager;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryInvoiceRelationManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;


@Component
public class OrderIndustryBackManagerImpl extends AbstractManager<OrderIndustryBackEntity> implements IOrderIndustryBackManager {

    @Autowired
    private IOrderIndustryBackDao orderBackRecordDao;
    @Autowired
    private IOrderIndustryDao orderDao;
    @Autowired
    private IOrderIndustryInvoiceManager orderIndustryInvoiceManager;
    @Autowired
    private IOrderIndustryInvoiceDao orderIndustryInvoiceDao;
    @Autowired
    private IOrderIndustryInvoiceRelationManager orderIndustryInvoiceRelationManager;

    @Override
    protected IMyBatisBaseDao<OrderIndustryBackEntity, Long> getMyBatisDao() {
        return orderBackRecordDao;
    }

    @Override
    protected void beforeBatchCreate(List<OrderIndustryBackEntity> list) {
        for (OrderIndustryBackEntity orderBackRecord : list) {

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑

            if (ObjectUtils.isNotEmpty(orderBackRecord.getOrderId())) {
                orderBackRecord.setBackStatus(OrderBackStatus.HasConfirm);
                orderBackRecord.setConfirmId(CurrentContext.getUserId());
                orderBackRecord.setConfirmName(CurrentContext.getUserInfo().getUserName());
            } else {
                orderBackRecord.setBackStatus(OrderBackStatus.WaitConfirm);
            }

            if (ObjectUtils.isEmpty(orderBackRecord.getHasInvoice())) {
                orderBackRecord.setHasInvoice(Boolean.FALSE);
            }
        }

        //处理关联先开票情况的订单,同时设置是否需要设置回款hasInvoice字段为true
        beforeCreateOrConfirmProcessRelationInvoice(list);
    }

    @Override
    protected void beforeBatchUpdate(List<OrderIndustryBackEntity> list) {
        for (OrderIndustryBackEntity orderBackRecord : list) {
            //在插入数据之前的动作，比如更新其他信息或者通知等
            ValidationResult vr = ValidationUtils.validateInclude(orderBackRecord, "brCode");
            if (!vr.getSuccess()) {
                throw new BusinessException(vr.getMessage());
            }

            OrderIndustryBackEntity bc = findById(orderBackRecord.getId(), "id", "has_invoice");

            if (Boolean.TRUE.equals(bc.getHasInvoice())) {
                throw new BusinessException("已经申请开票，不能对回款进行修改");
            }

            if (ObjectUtils.isNotEmpty(orderBackRecord.getOrderId())) {
                orderBackRecord.setBackStatus(OrderBackStatus.HasConfirm);
            } else {
                orderBackRecord.setBackStatus(OrderBackStatus.WaitConfirm);
            }
        }
    }

    @Override
    protected void afterBatchCreate(List<OrderIndustryBackEntity> list) {
        for (OrderIndustryBackEntity back : list) {
            if (ObjectUtils.isNotEmpty(back.getOrderId())) {
                afterCreateUpdateProcessOrderStatus(back.getOrderId());
            }
        }
    }

    @Override
    protected void afterBatchUpdate(List<OrderIndustryBackEntity> list) {
        for (OrderIndustryBackEntity back : list) {
            if (ObjectUtils.isNotEmpty(back.getOrderId())) {
                afterCreateUpdateProcessOrderStatus(back.getOrderId());
            }
        }
    }

    /**
     * @description 回款更新之后从回款数据中统计订单的回款信息并且更新到订单表中
     * @auth david·cun
     * @date 2019-08-12 22:17
     * @since 1.0
     */
    private void afterCreateUpdateProcessOrderStatus(Long orderId) {


        Map<String, Object> param = new HashMap<>();
        param.put("orderId", orderId);
        param.put("is_deleted", Boolean.FALSE);

        List<OrderIndustryBackEntity> backs = orderBackRecordDao.selectByMapSimple(param);

        BigDecimal amount = BigDecimal.ZERO;
        BigDecimal badAmount = BigDecimal.ZERO;

        if (ObjectUtils.isNotEmpty(backs)) {

            for (OrderIndustryBackEntity back : backs) {

                amount = amount.add(back.getBackAmount());

                if (OrderBackType.BadMoney.equals(back.getBackType())) {
                    badAmount = badAmount.add(back.getBackAmount());
                }
            }
        }

        OrderIndustryEntity order = orderDao.selectById(orderId, "id", "landlord_contract_amount", "customer_contract_amount", "contract_amount");

        OrderIndustryEntity oe = new OrderIndustryEntity();
        oe.setId(order.getId());
        oe.setBadBackAmount(badAmount);
        oe.setBackedAmount(amount.subtract(badAmount));

        if (order.getContractAmount().compareTo(amount) > 0) {
            oe.setOrderStatus(OrderStatus.PartBack);
        } else {
            if (badAmount.compareTo(BigDecimal.ZERO) > 0) {
                oe.setOrderStatus(OrderStatus.BadBack);
            } else {
                oe.setOrderStatus(OrderStatus.HasBack);
            }
        }

        orderDao.update(oe);
    }

    /**
     * @description
     * 需要在回款创建之前调用是因为，可能需要设置回款的hasInvoice字段
     * @author david·cun
     * @date 2020-03-10 09:31
     * @since 1.0
     */
    private void beforeCreateOrConfirmProcessRelationInvoice(List<OrderIndustryBackEntity> list) {

        List<OrderIndustryInvoiceRelationEntity> createRelation = new ArrayList<>();
        List<OrderIndustryInvoiceRelationEntity> updateRelation = new ArrayList<>();

        List<OrderIndustryInvoiceEntity> updateInvoiceList = new ArrayList<>();

        for (OrderIndustryBackEntity back : list) {

            boolean backHasSet = false;

            //已经确认了订单关系的回款才会去做与发票关联
            if (ObjectUtils.isNotEmpty(back.getOrderId())) {

                Map<String, Object> param = new HashMap<>();
                param.put("orderId", back.getOrderId());
                List<OrderIndustryInvoiceEntity> invoiceList = orderIndustryInvoiceManager.findByMap(param);

                if (ObjectUtils.isNotEmpty(invoiceList)) {
                    for (OrderIndustryInvoiceEntity invoice : invoiceList) {

                        BigDecimal backAmount = invoice.getBackAmount();
                        if (backAmount == null) {
                            backAmount = BigDecimal.ZERO;
                        }

                        //只是关联未回完款的发票
                        if (invoice.getInvoiceAmount().compareTo(backAmount.add(back.getBackAmount())) >= 0) {

                            if (!backHasSet && ObjectUtils.isNotEmpty(invoice.getOrderBackRelations())) {

                                for (OrderIndustryInvoiceRelationEntity relation : invoice.getOrderBackRelations()) {

                                    //1、先找开票金额和回款金额相同的发票
                                    if (ObjectUtils.isEmpty(relation.getBackId())) {
                                        relation.setBackId(back.getId());
                                        updateRelation.add(relation);
                                        backHasSet = true;

                                        invoice.setBackAmount(backAmount.add(back.getBackAmount()));
                                        //只是跟新有必要的字段
                                        addNeedUpdateInvoice(updateInvoiceList,invoice);

                                        break;
                                    }
                                }
                            }

                            if (!backHasSet) {
                                OrderIndustryInvoiceRelationEntity relation = new OrderIndustryInvoiceRelationEntity();
                                relation.setInvoiceId(invoice.getId());
                                relation.setOrderId(back.getOrderId());
                                relation.setBackId(back.getId());
                                createRelation.add(relation);
                                backHasSet = true;

                                invoice.setBackAmount(backAmount.add(back.getBackAmount()));
                                //只是跟新有必要的字段
                                addNeedUpdateInvoice(updateInvoiceList,invoice);

                                break;
                            }
                        }
                    }
                }

                if (backHasSet){
                    back.setHasInvoice(true);
                }
            }
        }

        if (ObjectUtils.isNotEmpty(updateRelation)){
            orderIndustryInvoiceRelationManager.batchUpdate(updateRelation);
        }

        if (ObjectUtils.isNotEmpty(createRelation)){
            orderIndustryInvoiceRelationManager.batchCreate(createRelation);
        }

        if (ObjectUtils.isNotEmpty(updateInvoiceList)){
            orderIndustryInvoiceDao.batchUpdate(updateInvoiceList);
        }

    }

    private void addNeedUpdateInvoice(List<OrderIndustryInvoiceEntity> list,OrderIndustryInvoiceEntity source){
        OrderIndustryInvoiceEntity needUpdate = new OrderIndustryInvoiceEntity();
        needUpdate.setBackAmount(source.getBackAmount());
        needUpdate.setId(source.getId());
        list.add(needUpdate);
    }


    /**
     * @param
     * @return
     * @description 认领回款
     * @author david·cun
     * @date 2019-08-12 22:18
     * @since 1.0
     */
    @Transactional
    public void confirm(Long orderId, Long backId) {

        OrderIndustryBackEntity back = findById(backId,"id","back_amount","order_id");

        back.setId(backId);
        back.setOrderId(orderId);
        back.setBackStatus(OrderBackStatus.HasConfirm);
        back.setHasInvoice(Boolean.TRUE);
        back.setLastUpdateId(CurrentContext.getUserId());
        back.setLastUpdateName(CurrentContext.getUserInfo().getUserName());
        back.setLastUpdateTime(new Date());
        back.setConfirmId(CurrentContext.getUserId());
        back.setConfirmName(CurrentContext.getUserInfo().getUserName());
        orderBackRecordDao.update(back);

        afterCreateUpdateProcessOrderStatus(orderId);

        List<OrderIndustryBackEntity> backList = new ArrayList<>();
        backList.add(back);
        beforeCreateOrConfirmProcessRelationInvoice(backList);
    }


}
