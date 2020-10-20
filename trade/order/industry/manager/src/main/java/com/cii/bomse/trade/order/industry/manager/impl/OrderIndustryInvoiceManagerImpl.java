package com.cii.bomse.trade.order.industry.manager.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryBackDao;
import com.cii.bomse.trade.order.industry.dao.IOrderIndustryDao;
import com.cii.bomse.trade.order.industry.dao.IOrderIndustryInvoiceDao;
import com.cii.bomse.trade.order.industry.dictionary.InvoiceProperty;
import com.cii.bomse.trade.order.industry.dictionary.InvoiceStatus;
import com.cii.bomse.trade.order.industry.dictionary.InvoiceType;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryBackEntity;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryEntity;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryInvoiceRelationEntity;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryInvoiceManager;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryInvoiceEntity;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryInvoiceRelationManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class OrderIndustryInvoiceManagerImpl extends AbstractManager<OrderIndustryInvoiceEntity> implements IOrderIndustryInvoiceManager {

    @Autowired
    private IOrderIndustryInvoiceDao orderInvoiceDao;
    @Autowired
    private IOrderIndustryInvoiceRelationManager orderIndustryInvoiceRelationManager;
    @Autowired
    private IOrderIndustryBackDao orderIndustryBackDao;
    @Autowired
    private IOrderIndustryDao orderIndustryDao;

    @Override
    protected IMyBatisBaseDao<OrderIndustryInvoiceEntity, Long> getMyBatisDao() {
        return orderInvoiceDao;
    }

    @Override
    protected void beforeBatchCreate(List<OrderIndustryInvoiceEntity> list) {
        for (OrderIndustryInvoiceEntity orderInvoice : list) {

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑

            ValidationResult vr = ValidationUtils.validateInclude(orderInvoice, "orderBackRelations");
            if (!vr.getSuccess()) {
                throw new BusinessException(vr.getMessage());
            }

            orderInvoice.setInvoiceStatus(InvoiceStatus.Applying);
            //处理关联的订单或者回款记录

            //如果是个人发票，去掉这些信息
            if (InvoiceType.Person.equals(orderInvoice.getInvoiceType())) {
                orderInvoice.setInvoiceTitle("个人");
                orderInvoice.setTaxNumber(null);
                orderInvoice.setAccountBankName(null);
                orderInvoice.setAccountBankNumber(null);
                orderInvoice.setRegisterAddress(null);
                orderInvoice.setRegisterTelephone(null);
            }
        }

        //如果关联回款，会涉及到backAmount字段的更新
        beforeCreateProcessOrderInvoiceBackRelation(list);
    }

    @Override
    protected void afterBatchCreate(List<OrderIndustryInvoiceEntity> list) {

        //设置回款状态为已开票
        afterCreateProcessOrderBack(list);
        //设置订单已开票金额总和
        afterCreateProcessOrderInvoiceAmount(list);
    }

    /**
     * @param
     * @return
     * @description 新增后处理发票与订单和回款的关系
     * @author david·cun
     * @date 2020-03-08 22:37
     * @since 1.0
     */
    private void beforeCreateProcessOrderInvoiceBackRelation(List<OrderIndustryInvoiceEntity> list) {

        List<OrderIndustryInvoiceRelationEntity> brs = new ArrayList<>();
        List<OrderIndustryBackEntity> updateBackList = new ArrayList<>();

        for (OrderIndustryInvoiceEntity orderInvoice : list) {
            if (ObjectUtils.isNotEmpty(orderInvoice.getOrderBackRelations())) {

                for (OrderIndustryInvoiceRelationEntity rl : orderInvoice.getOrderBackRelations()) {

                    //处理关联的关系
                    rl.setInvoiceId(orderInvoice.getId());
                    if (ObjectUtils.isNotEmpty(rl.getBackId()) || ObjectUtils.isNotEmpty(rl.getOrderId())) {
                        brs.add(rl);
                    }

                    //表示从订单开票，并非是回款开票，处理关联关系中，已经有回款，但是未关联发票的情况
                    if (ObjectUtils.isEmpty(rl.getBackId()) && ObjectUtils.isNotEmpty(rl.getOrderId())) {
                        Map<String, Object> param = new HashMap<>();
                        param.put("orderId", rl.getOrderId());
                        param.put("hasInvoice", Boolean.FALSE);
                        List<OrderIndustryBackEntity> backList = orderIndustryBackDao.selectByMapSimple(param);

                        if (ObjectUtils.isNotEmpty(backList)) {
                            boolean hasSetBack = false;
                            for (OrderIndustryBackEntity back : backList) {

                                BigDecimal backAmount = orderInvoice.getBackAmount();
                                if (backAmount == null) {
                                    backAmount = BigDecimal.ZERO;
                                }

                                if (orderInvoice.getInvoiceAmount().compareTo(backAmount.add(back.getBackAmount())) >= 0) {

                                    if (hasSetBack){
                                        //如果是找到过空的，那么这个时候可以新增
                                        OrderIndustryInvoiceRelationEntity tmpRl = new OrderIndustryInvoiceRelationEntity();
                                        tmpRl.setBackId(back.getId());
                                        tmpRl.setInvoiceId(orderInvoice.getId());
                                        tmpRl.setOrderId(back.getOrderId());
                                        brs.add(tmpRl);

                                        back.setHasInvoice(Boolean.TRUE);
                                        updateBackList.add(back);
                                    }else{
                                        rl.setBackId(back.getId());

                                        back.setHasInvoice(Boolean.TRUE);
                                        updateBackList.add(back);
                                        hasSetBack = true;
                                    }

                                    //再次更新发票信息，收集已回款的总额
                                    orderInvoice.setBackAmount(backAmount.add(back.getBackAmount()));
                                }
                            }
                        }
                    }
                }
            }
        }
        if (brs.size() > 0) {
            orderIndustryInvoiceRelationManager.batchCreate(brs);
        }
        if (updateBackList.size() > 0) {
            orderIndustryBackDao.batchUpdate(updateBackList);
        }
    }

    /**
     * @param
     * @return
     * @description 更新回款已开票状态
     * @author david·cun
     * @date 2020-03-08 22:33
     * @since 1.0
     */
    private void afterCreateProcessOrderBack(List<OrderIndustryInvoiceEntity> list) {

        List<OrderIndustryBackEntity> orderBacks = new ArrayList<>();
        for (OrderIndustryInvoiceEntity orderInvoice : list) {

            if (ObjectUtils.isNotEmpty(orderInvoice.getOrderBackRelations())) {
                for (OrderIndustryInvoiceRelationEntity rl : orderInvoice.getOrderBackRelations()) {

                    if (ObjectUtils.isNotEmpty(rl.getBackId())) {
                        OrderIndustryBackEntity back = new OrderIndustryBackEntity();
                        back.setId(rl.getBackId());
                        back.setHasInvoice(Boolean.TRUE);
                        orderBacks.add(back);
                    }
                }
            }
        }

        if (orderBacks.size() > 0) {
            orderIndustryBackDao.batchUpdate(orderBacks);
        }

    }

    /**
     * @param
     * @return
     * @description 更新订单已开票金额
     * @author david·cun
     * @date 2020-03-08 22:15
     * @since 1.0
     */
    private void afterCreateProcessOrderInvoiceAmount(List<OrderIndustryInvoiceEntity> list) {

        Map<Long, OrderIndustryEntity> tmp = new HashMap<>();

        for (OrderIndustryInvoiceEntity invoice : list) {
            if (ObjectUtils.isNotEmpty(invoice.getOrderBackRelations())) {
                for (OrderIndustryInvoiceRelationEntity rl : invoice.getOrderBackRelations()) {

                    OrderIndustryEntity order = tmp.get(rl.getOrderId());
                    if (order == null && ObjectUtils.isNotEmpty(rl.getOrderId())) {
                        order = new OrderIndustryEntity();
                        order.setId(rl.getOrderId());
                        tmp.put(rl.getOrderId(), order);

                    } else if (order == null && ObjectUtils.isNotEmpty(rl.getBackId())) {
                        order = new OrderIndustryEntity();
                        OrderIndustryBackEntity back = orderIndustryBackDao.selectById(rl.getBackId(), "id", "order_id");
                        order.setId(back.getOrderId());
                        tmp.put(rl.getOrderId(), order);
                    }

                    //为了减少数据库操作，此判断表示order已经从数据库取过数据
                    if (ObjectUtils.isEmpty(order.getInvoiceAmount())) {
                        OrderIndustryEntity orderTmp = orderIndustryDao.selectById(order.getId(), "id", "invoice_amount");
                        if (ObjectUtils.isNotEmpty(orderTmp.getInvoiceAmount())) {
                            order.setInvoiceAmount(invoice.getInvoiceAmount().add(orderTmp.getInvoiceAmount()));
                        } else {
                            order.setInvoiceAmount(invoice.getInvoiceAmount());
                        }
                    } else {
                        order.setInvoiceAmount(invoice.getInvoiceAmount());
                    }
                }
            }
        }

        if (tmp.size() > 0) {
            List<OrderIndustryEntity> orderList = new ArrayList<>();
            for (Map.Entry<Long, OrderIndustryEntity> entry : tmp.entrySet()) {
                orderList.add(entry.getValue());
            }
            orderIndustryDao.batchUpdate(orderList);
        }
    }

    /**
     * @param
     * @return
     * @description 邮寄发票之后的操作，填写快递公司及快递单号
     * @author david·cun
     * @date 2019-08-10 21:17
     * @since 1.0
     */
    @Transactional
    public void mail(OrderIndustryInvoiceEntity invoice) {

        OrderIndustryInvoiceEntity oi = findById(invoice.getId(), "id", "invoice_prop");

        if (oi != null) {

            ValidationResult vr = null;

            if (InvoiceProperty.Paper.equals(oi.getInvoiceProp())) {
                vr = ValidationUtils.validateInclude(invoice, "id", "expressCompany", "expressCode");
                invoice.setInvoiceStatus(InvoiceStatus.HasMail);
            } else {
                vr = ValidationUtils.validateInclude(invoice, "id", "invoiceUrl");
                invoice.setInvoiceStatus(InvoiceStatus.HasSend);
            }
            if (!vr.getSuccess()) {
                throw new BusinessException(vr.getMessage());
            }
            orderInvoiceDao.update(invoice);
        } else {
            throw new BusinessException("邮寄/发送发票，发票编码错误");
        }
    }

}
