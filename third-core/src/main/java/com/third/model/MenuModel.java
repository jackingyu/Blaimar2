package com.third.model;
// Generated Dec 2, 2016 4:39:39 PM by Hibernate Tools 4.3.1



/**
 * MenuModel generated by hbm2java
 */
public class MenuModel  implements java.io.Serializable {


     private String pk;
     private String menuId;
     private String menuName;
     private String icon;
     private String url;
     private Integer level;
     private MenuModel parentMenu;

    public MenuModel() {
    }

    public MenuModel(String menuId, String menuName, String icon, String url, Integer level, MenuModel parentMenu) {
       this.menuId = menuId;
       this.menuName = menuName;
       this.icon = icon;
       this.url = url;
       this.level = level;
       this.parentMenu = parentMenu;
    }
   
    public String getPk() {
        return this.pk;
    }
    
    public void setPk(String pk) {
        this.pk = pk;
    }
    public String getMenuId() {
        return this.menuId;
    }
    
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    public String getMenuName() {
        return this.menuName;
    }
    
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getIcon() {
        return this.icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getLevel() {
        return this.level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }
    public MenuModel getParentMenu() {
        return this.parentMenu;
    }
    
    public void setParentMenu(MenuModel parentMenu) {
        this.parentMenu = parentMenu;
    }




}


