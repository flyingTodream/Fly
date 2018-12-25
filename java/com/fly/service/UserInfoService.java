package com.fly.service;

import java.util.List;

import com.fly.model.UserInfo;

public interface UserInfoService {
	int deleteByPrimaryKey(String id);

	int insert(UserInfo record);

	int insertSelective(UserInfo record);

	UserInfo selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(UserInfo record);

	int updateByPrimaryKey(UserInfo record);

	List<UserInfo> selectListByUserInfo(UserInfo userInfo,int pageNum, int pageSize);
	
	 Integer selectCount(UserInfo userInfo);
}
