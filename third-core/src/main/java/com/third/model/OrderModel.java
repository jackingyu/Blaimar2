package com.third.model;
// Generated Dec 2, 2016 4:39:39 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * OrderModel generated by hbm2java
 */
public class OrderModel  implements java.io.Serializable {


     private String pk;
     private String code;
     private String customerName;
     private String cellphone;
     private Date weddingDate;
     private Date tryDate;
     private Date photoDate;
     private Date deliveryDate;
     private Date orderDate;
     private String coSalesperson;
     private String comment;
     private BigDecimal receiveable;
     private BigDecimal openamount;
     private Integer status;
     private Date modificationTime;
     private Date createTime;
     private CustomerModel customer;
     private UserModel salesperson;
     private SourceModel source;
     private StoreModel store;
     private List payments = new ArrayList(0);
     private List orderEntries = new ArrayList(0);

    public OrderModel() {
    }

    public OrderModel(String code, String customerName, String cellphone, Date weddingDate, Date tryDate, Date photoDate, Date deliveryDate, Date orderDate, String coSalesperson, String comment, BigDecimal receiveable, BigDecimal openamount, Integer status, Date modificationTime, Date createTime, CustomerModel customer, UserModel salesperson, SourceModel source, StoreModel store, List payments, List orderEntries) {
       this.code = code;
       this.customerName = customerName;
       this.cellphone = cellphone;
       this.weddingDate = weddingDate;
       this.tryDate = tryDate;
       this.photoDate = photoDate;
       this.deliveryDate = deliveryDate;
       this.orderDate = orderDate;
       this.coSalesperson = coSalesperson;
       this.comment = comment;
       this.receiveable = receiveable;
       this.openamount = openamount;
       this.status = status;
       this.modificationTime = modificationTime;
       this.createTime = createTime;
       this.customer = customer;
       this.salesperson = salesperson;
       this.source = source;
       this.store = store;
       this.payments = payments;
       this.orderEntries = orderEntries;
    }
   
    public String getPk() {
        return this.pk;
    }
    
    public void setPk(String pk) {
        this.pk = pk;
    }
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCellphone() {
        return this.cellphone;
    }
    
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    public Date getWeddingDate() {
        return this.weddingDate;
    }
    
    public void setWeddingDate(Date weddingDate) {
        this.weddingDate = weddingDate;
    }
    public Date getTryDate() {
        return this.tryDate;
    }
    
    public void setTryDate(Date tryDate) {
        this.tryDate = tryDate;
    }
    public Date getPhotoDate() {
        return this.photoDate;
    }
    
    public void setPhotoDate(Date photoDate) {
        this.photoDate = photoDate;
    }
    public Date getDeliveryDate() {
        return this.deliveryDate;
    }
    
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public Date getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getCoSalesperson() {
        return this.coSalesperson;
    }
    
    public void setCoSalesperson(String coSalesperson) {
        this.coSalesperson = coSalesperson;
    }
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    public BigDecimal getReceiveable() {
        return this.receiveable;
    }
    
    public void setReceiveable(BigDecimal receiveable) {
        this.receiveable = receiveable;
    }
    public BigDecimal getOpenamount() {
        return this.openamount;
    }
    
    public void setOpenamount(BigDecimal openamount) {
        this.openamount = openamount;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
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
    public CustomerModel getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }
    public UserModel getSalesperson() {
        return this.salesperson;
    }
    
    public void setSalesperson(UserModel salesperson) {
        this.salesperson = salesperson;
    }
    public SourceModel getSource() {
        return this.source;
    }
    
    public void setSource(SourceModel source) {
        this.source = source;
    }
    public StoreModel getStore() {
        return this.store;
    }
    
    public void setStore(StoreModel store) {
        this.store = store;
    }
    public List getPayments() {
        return this.payments;
    }
    
    public void setPayments(List payments) {
        this.payments = payments;
    }
    public List getOrderEntries() {
        return this.orderEntries;
    }
    
    public void setOrderEntries(List orderEntries) {
        this.orderEntries = orderEntries;
    }




}


