package com.third.model;
// Generated Dec 2, 2016 4:39:39 PM by Hibernate Tools 4.3.1


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * UserModel generated by hbm2java
 */
public class UserModel  implements java.io.Serializable {


     private String pk;
     private String userId;
     private String password;
     private Boolean blocked;
     private String name;
     private Date modificationTime;
     private Date createTime;
     private UserGroupModel userGroup;
     private Collection stores = new ArrayList(0);

    public UserModel() {
    }

    public UserModel(String userId, String password, Boolean blocked, String name, Date modificationTime, Date createTime, UserGroupModel userGroup, Collection stores) {
       this.userId = userId;
       this.password = password;
       this.blocked = blocked;
       this.name = name;
       this.modificationTime = modificationTime;
       this.createTime = createTime;
       this.userGroup = userGroup;
       this.stores = stores;
    }
   
    public String getPk() {
        return this.pk;
    }
    
    public void setPk(String pk) {
        this.pk = pk;
    }
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getBlocked() {
        return this.blocked;
    }
    
    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    public UserGroupModel getUserGroup() {
        return this.userGroup;
    }
    
    public void setUserGroup(UserGroupModel userGroup) {
        this.userGroup = userGroup;
    }
    public Collection getStores() {
        return this.stores;
    }
    
    public void setStores(Collection stores) {
        this.stores = stores;
    }




}


