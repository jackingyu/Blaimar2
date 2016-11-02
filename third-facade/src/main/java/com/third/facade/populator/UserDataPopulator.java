package com.third.facade.populator;

import com.third.facade.data.UserData;
import com.third.facade.data.UserGroupData;
import com.third.model.UserModel;


public class UserDataPopulator implements Populator<UserModel, UserData>
{

	@Override
	public void populate(UserModel source, UserData target)
	{
		target.setPk(source.getPk());
		target.setUserId(source.getUserId());
		target.setName(source.getName());
		target.setBlocked(false);
		//不将真实的密码传递出去
		target.setPassword("xxxxxxx");
	}

}
