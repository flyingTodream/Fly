package com.fly.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.fly.mapper.ArticleMapper;
import com.fly.model.Article;
import com.fly.service.ArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper mapper;
	
	@Override
	public JSONObject selectList(Article record) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		Page<Object> page = null;
		if(record.getLimit()==null) {
			page = PageHelper.startPage(record.getPage(), 10);
			
		}else {
			page = PageHelper.startPage(record.getPage(), record.getLimit());
			
		}
		json.put("data", mapper.selectList(record));
		PageInfo<Object> info = new PageInfo<>(page.getResult());
		json.put("pages", info.getPages());
		json.put("code", 0);
		return json;
	}

	@Override
	public int insertSelective(Article record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public Article selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Article> getarticle(Article record) {
		// TODO Auto-generated method stub
		PageHelper.startPage(record.getPage(), record.getLimit());
		return mapper.selectList(record);
	}

}
