package com.third.model;
// Generated Aug 23, 2017 5:05:46 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * PaymentModel generated by hbm2java
 */
public class PaymentModel  implements java.io.Serializable {


     private String pk;
     private Integer paymentEntryNo;
     private OrderModel order;
     private String paymentMethod;
     private String paymentType;
     private BigDecimal amount;
     private Date paidTime;
     private Date modificationTime;
     private Date createTime;
     private StoreModel store;
     private UserModel createdBy;

    public PaymentModel() {
    }

    public PaymentModel(Integer paymentEntryNo, OrderModel order, String paymentMethod, String paymentType, BigDecimal amount, Date paidTime, Date modificationTime, Date createTime, StoreModel store, UserModel createdBy) {
       this.paymentEntryNo = paymentEntryNo;
       this.order = order;
       this.paymentMethod = paymentMethod;
       this.paymentType = paymentType;
       this.amount = amount;
       this.paidTime = paidTime;
       this.modificationTime = modificationTime;
       this.createTime = createTime;
       this.store = store;
       this.createdBy = createdBy;
    }
   
    public String getPk() {
        return this.pk;
    }
    
    public void setPk(String pk) {
        this.pk = pk;
    }
    public Integer getPaymentEntryNo() {
        return this.paymentEntryNo;
    }
    
    public void setPaymentEntryNo(Integer paymentEntryNo) {
        this.paymentEntryNo = paymentEntryNo;
    }
    public OrderModel getOrder() {
        return this.order;
    }
    
    public void setOrder(OrderModel order) {
        this.order = order;
    }
    public String getPaymentMethod() {
        return this.paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public String getPaymentType() {
        return this.paymentType;
    }
    
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Date getPaidTime() {
        return this.paidTime;
    }
    
    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }
    public Date getModificationTime() {
        return this.modificationTime;
    }
    
    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public StoreModel getStore() {
        return this.store;
    }
    
    public void setStore(StoreModel store) {
        this.store = store;
    }
    public UserModel getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(UserModel createdBy) {
        this.createdBy = createdBy;
    }




}


