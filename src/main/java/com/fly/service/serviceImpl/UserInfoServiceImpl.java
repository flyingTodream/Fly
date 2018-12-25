package com.fly.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fly.mapper.UserInfoMapper;
import com.fly.model.UserInfo;
import com.fly.service.UserInfoService;
import com.github.pagehelper.PageHelper;

@Service

public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper mapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserInfo record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(UserInfo record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public UserInfo selectByPrimaryKey(UserInfo record) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(UserInfo record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserInfo record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<UserInfo> selectListByUserInfo(UserInfo userInfo,int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		return mapper.selectListByUserInfo(userInfo);
	}

	@Override
	public Integer selectCount(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return mapper.selectCount(userInfo);
	}

}
