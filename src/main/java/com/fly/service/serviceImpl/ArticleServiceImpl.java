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
		String order = "t.insert_time desc";
		Page<Object> page = null;
		if(record.getLimit()==null) {
			page = PageHelper.startPage(record.getPage(), 10 ,order);
			
		}else {
			page = PageHelper.startPage(record.getPage(), record.getLimit() , order);
			
		}
		json.put("data", mapper.selectList(record));
		PageInfo<Object> info = new PageInfo<>(page.getResult());
		json.put("pages", info.getPages());
		json.put("code", 0);
		json.put("count", info.getTotal());
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

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Article record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public JSONObject search(String kw,int page) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		String order = "t.insert_time desc";
		Page<Object> pages = PageHelper.startPage(page, 10 ,order);
		json.put("data", mapper.search(kw));
		PageInfo<Object> info = new PageInfo<>(pages.getResult());
		json.put("pages", info.getPages());
		json.put("code", 0);
		json.put("count", info.getTotal());
		return json;
	}

}
