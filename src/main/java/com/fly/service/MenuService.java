package com.fly.service;

import com.fly.model.Menu;

public interface MenuService {
	 int deleteByPrimaryKey(String menuId);

	    int insert(Menu record);

	    int insertSelective(Menu record);

	    Menu selectByPrimaryKey(String menuId);

	    int updateByPrimaryKeySelective(Menu record);

	    int updateByPrimaryKey(Menu record);
}
