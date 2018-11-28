package com.third.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.third.core.constants.CoreConstants;
import com.third.core.constants.UserGroupConstants;
import com.third.dao.user.UserDao;
import com.third.dao.user.UserGroupDao;
import com.third.dao.util.PaginationSupport;
import com.third.model.UserGroupModel;
import com.third.model.UserModel;
import com.third.service.user.SessionService;
import com.third.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserGroupDao userGroupDao;

	@Autowired
	private SessionService sessionService;

	public UserModel getUserById(String userId)
	{
		UserModel user = userDao.findUserById(userId);
		return user;
	}

	public UserModel getCurrentUser()
	{
		String userId = (String) sessionService
				.get(CoreConstants.Session.CURRENT_USER_ID);
		return userDao.findUserById(userId);
	}

	public void createUser(UserModel user)
	{
		userDao.save(user);
	}

	public void createUserGroup(UserGroupModel userGroup)
	{
		userGroupDao.save(userGroup);
	}

	public UserGroupModel getUserGroupById(String userGroupId)
	{
		return userGroupDao.findUserGroupById(userGroupId);
	}

	public boolean isExist(String userId)
	{
		UserModel userModel = new UserModel();
		return userDao.contains(userModel);
	}

	@Override
	public void updateUser(UserModel user)
	{
		userDao.update(user);
	}

	@Override
	public PaginationSupport getUserList(final String userId,
			final String userName,final String storeCode, final Integer startIndex,
			final Integer pageSize)
	{
		return userDao.findUser(userId, userName, storeCode,startIndex, pageSize);
	}

	@Override
	public void updateUserGroup(UserGroupModel userGroup)
	{
		userGroupDao.update(userGroup);
	}

	@Override
	public PaginationSupport getUserGroupList(final String userGroupId,
			final String userGroupName, final Integer startIndex,
			final Integer pageSize)
	{
		return userGroupDao.findUserGroupByName(userGroupId, userGroupName,
				startIndex, pageSize);
	}

	@Override
	public UserGroupModel getUserGroup(final String pk)
	{
		return userGroupDao.get(pk);
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	public void setUserGroupDao(UserGroupDao userGroupDao)
	{
		this.userGroupDao = userGroupDao;
	}

	@Override
	public List<UserModel> getSalesPerson(String storeCode)
	{
		return userDao.findUserByUserGroup(storeCode, UserGroupConstants.SALES);
	}
	
	@Override
	public List<UserModel> getDesignerForStore(String storeCode)
	{
		return userDao.findUserByUserGroup(storeCode, UserGroupConstants.DESIGNER);
	}
	
	public boolean checkUserGroup(final String userGroup)
	{
		UserModel user = getCurrentUser();
		return user.getUserGroup().getGroupId().equals(userGroup);
	}
	
	public String generateUserId()
	{
		Integer i =  userDao.countByQuery("select pk from UserModel")+1;
		return i.toString();
	}

}
