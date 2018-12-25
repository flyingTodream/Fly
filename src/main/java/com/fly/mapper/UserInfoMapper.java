package com.fly.mapper;

import java.util.List;

import com.fly.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(UserInfo record);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    List<UserInfo> selectListByUserInfo(UserInfo userInfo);
    
    Integer selectCount(UserInfo userInfo);
}