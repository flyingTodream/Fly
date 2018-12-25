package com.fly.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fly.mapper.MenuMapper;
import com.fly.model.Menu;
import com.fly.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper mapper;
	
	@Override
	public int deleteByPrimaryKey(String menuId) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(menuId);
	}

	@Override
	public int insert(Menu record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Menu record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public Menu selectByPrimaryKey(String menuId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(menuId);
	}

	@Override
	public int updateByPrimaryKeySelective(Menu record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Menu record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

}
