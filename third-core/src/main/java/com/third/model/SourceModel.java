package com.third.model;
// Generated Nov 28, 2016 4:34:25 PM by Hibernate Tools 4.3.1



/**
 * SourceModel generated by hbm2java
 */
public class SourceModel  implements java.io.Serializable {


     private String pk;
     private String name;
     private String type;

    public SourceModel() {
    }

    public SourceModel(String name, String type) {
       this.name = name;
       this.type = type;
    }
   
    public String getPk() {
        return this.pk;
    }
    
    public void setPk(String pk) {
        this.pk = pk;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }




}


