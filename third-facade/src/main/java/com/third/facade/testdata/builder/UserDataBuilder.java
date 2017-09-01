package com.third.facade.testdata.builder;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

import com.third.model.MenuModel;
import com.third.model.RoleModel;
import com.third.model.UserGroupModel;
import com.third.model.UserModel;
import com.third.service.user.MenuService;
import com.third.service.user.RoleService;
import com.third.service.user.UserService;


/**
 * build test data for user module,this can be run via /data url,implement {@link DataBuilder}
 */
public class UserDataBuilder implements DataBuilder
{
	private UserService userService;
	private MenuService menuService;
	private RoleService roleService;

	public void buildData()
	{

      /*
       * 创建符合easy-ui的菜单,如果需要启用easyui需要将这段注释掉
		MenuModel lv2_user = this.buildMenu("1", 2, "系统管理", "#", "menu-icon-sys");
		menuService.createMenu(lv2_user);

		MenuModel lv3_usergroup = this.buildMenu("11", 3, "用户组列表", "/getUserGroupListPage", "menu-icon-role");
		MenuModel lv3_userlist = this.buildMenu("12", 3, "用户列表", "/getUserListPage", "menu-icon-users");
		lv3_usergroup.setParentMenu(lv2_user);
		lv3_userlist.setParentMenu(lv2_user);
		menuService.createMenu(lv3_usergroup);
		menuService.createMenu(lv3_userlist);

		MenuModel lv2_sales = this.buildMenu("2", 2, "销售管理", "#", "menu-icon-users");
		menuService.createMenu(lv2_sales);

		MenuModel lv3_customer = this.buildMenu("21", 3, "顾客管理", "/getCustomerListPage", "menu-icon-role");
		lv3_customer.setParentMenu(lv2_sales);
		menuService.createMenu(lv3_userlist);

		MenuModel lv3_orders = this.buildMenu("22", 3, "订单管理", "/getOrderListPage", "menu-icon-file");
		lv3_orders.setParentMenu(lv2_sales);
		menuService.createMenu(lv3_orders);

		MenuModel lv3_reservation = this.buildMenu("23", 3, "预约管理", "/getReservationListPage", "menu-icon-file");
		lv3_reservation.setParentMenu(lv2_sales);
		menuService.createMenu(lv3_reservation);

		MenuModel lv3_orderprocess = this.buildMenu("24", 3, "条码管理", "/getOrderProcessPage", "menu-icon-file");
		lv3_orderprocess.setParentMenu(lv2_sales);
		menuService.createMenu(lv3_orderprocess);

		MenuModel lv3_orderprocesslist = this.buildMenu("25", 3, "扫码记录查询管理", "/getOrderProcessListPage", "menu-icon-file");
		lv3_orderprocesslist.setParentMenu(lv2_sales);
		menuService.createMenu(lv3_orderprocesslist);
		*/
      
		MenuModel lv2_user = this.buildMenu("1", 2, "系统管理", "#", "fa-opera");
		menuService.createMenu(lv2_user);

		MenuModel lv3_usergroup = this.buildMenu("11", 3, "用户组列表", "/user/usergrouplistpage", "fa-users");
		MenuModel lv3_userlist = this.buildMenu("12", 3, "用户列表", "/user/userlistpage", "fa-user");
		lv3_usergroup.setParentMenu(lv2_user);
		lv3_userlist.setParentMenu(lv2_user);
		menuService.createMenu(lv3_usergroup);
		menuService.createMenu(lv3_userlist);

		MenuModel lv2_sales = this.buildMenu("2", 2, "销售管理", "#", "fa-book");
		menuService.createMenu(lv2_sales);

		MenuModel lv3_customer = this.buildMenu("21", 3, "顾客管理", "/customer/customerlistpage", "fa-users");
		lv3_customer.setParentMenu(lv2_sales);
		menuService.createMenu(lv3_userlist);

		MenuModel lv3_orders = this.buildMenu("22", 3, "订单管理", "/order/orderlistpage", "fa-book");
		lv3_orders.setParentMenu(lv2_sales);
		menuService.createMenu(lv3_orders);

		MenuModel lv3_reservation = this.buildMenu("23", 3, "创建订单", "/order/createorderpage", "fa-edit");
		lv3_reservation.setParentMenu(lv2_sales);
		menuService.createMenu(lv3_reservation);

		MenuModel lv3_orderprocess = this.buildMenu("24", 3, "条码管理", "/orderprocess/orderprocesspage", "fa-barcode");
		lv3_orderprocess.setParentMenu(lv2_sales);
		menuService.createMenu(lv3_orderprocess);

		MenuModel lv3_orderprocesslist = this.buildMenu("25", 3, "扫码记录查询管理", "/orderprocess/searchprocessrecordspage", "fa-search");
		lv3_orderprocesslist.setParentMenu(lv2_sales);
		menuService.createMenu(lv3_orderprocesslist);
		
		MenuModel lv3_reservationlist = this.buildMenu("26", 3, "预约管理", "/reservation/reservationlistpage", "fa-search");
		lv3_reservationlist.setParentMenu(lv2_sales);
		menuService.createMenu(lv3_reservationlist);
		
		List<MenuModel> menus = Arrays.asList(lv3_usergroup, lv3_userlist, lv3_customer, lv3_orders, lv3_reservation, lv3_orderprocess,
				lv3_orderprocesslist,lv3_reservationlist);
		//create role

      RoleModel role_admin = buildRole("admin", "管理员", "管理员", menus);
      RoleModel role_sales = buildRole("sales", "销售员", "销售员", menus);
      RoleModel role_factory = buildRole("factory", "工厂", "工厂", menus);
      RoleModel role_finicial = buildRole("finicial", "财务", "财务", menus);
      
		UserModel admin = new UserModel();
		admin.setUserId("test");
		admin.setName("test user");
		admin.setPassword("test");
		UserGroupModel userGroup = this.buildUserGroupModel("admin", "管理员",role_admin);
		List<UserGroupModel> userGroups =
				Arrays.asList(
						this.buildUserGroupModel("sales", "销售员",role_sales),
						this.buildUserGroupModel("factory", "工厂",role_factory),
						this.buildUserGroupModel("finicial", "财务",role_finicial)
						);

		admin.setUserGroup(userGroup);
		userService.createUserGroup(userGroup);
		userService.createUser(admin);
		
		for(int i = 0;i < 50;i++)
		{
			UserModel u = new UserModel();
			u.setUserId("test"+i);
			final int j = RandomUtils.nextInt(0,3);
			u.setName("test user"+i+"-"+j);
			u.setPassword("test");
			u.setUserGroup(userGroups.get(j));
			userService.createUser(u);
		}
	}

	protected MenuModel buildMenu(final String menuId, final Integer level, final String menuName, final String url,
			final String icon)
	{
		MenuModel menu = new MenuModel();
		menu.setMenuId(menuId);
		menu.setLevel(level);
		menu.setMenuName(menuName);
		menu.setUrl(url);
		menu.setIcon(icon);
		menuService.createMenu(menu);
		return menu;
	}
	
	public UserGroupModel buildUserGroupModel(final String id,final String name,final RoleModel role)
	{
		UserGroupModel userGroup = new UserGroupModel();
		userGroup.setGroupId(id);
		userGroup.setName(name);
		userGroup.setRoles(Arrays.asList(role));
		userService.createUserGroup(userGroup);
		return userGroup;
	}
	
	public RoleModel buildRole(final String id,final String name,final String desc,final List<MenuModel> menus)
	{
		RoleModel role = new RoleModel();
		role.setRoleId(id);
		role.setRoleName(name);
		role.setDescription(desc);
		role.setMenus(menus);
		
		return role;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public void setMenuService(MenuService menuService)
	{
		this.menuService = menuService;
	}

	public void setRoleService(RoleService roleService)
	{
		this.roleService = roleService;
	}


}
