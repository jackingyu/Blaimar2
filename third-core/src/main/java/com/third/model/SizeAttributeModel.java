package com.third.model;
// Generated Aug 29, 2017 9:21:27 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * SizeAttributeModel generated by hbm2java
 */
public class SizeAttributeModel  implements java.io.Serializable {


     private String pk;
     private Integer itemCategory;
     private Integer group;
     private String name;
     private String code;
     private Date modificationTime;
     private Date createTime;

    public SizeAttributeModel() {
    }

    public SizeAttributeModel(Integer itemCategory, Integer group, String name, String code, Date modificationTime, Date createTime) {
       this.itemCategory = itemCategory;
       this.group = group;
       this.name = name;
       this.code = code;
       this.modificationTime = modificationTime;
       this.createTime = createTime;
    }
   
    public String getPk() {
        return this.pk;
    }
    
    public void setPk(String pk) {
        this.pk = pk;
    }
    public Integer getItemCategory() {
        return this.itemCategory;
    }
    
    public void setItemCategory(Integer itemCategory) {
        this.itemCategory = itemCategory;
    }
    public Integer getGroup() {
        return this.group;
    }
    
    public void setGroup(Integer group) {
        this.group = group;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
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




}


