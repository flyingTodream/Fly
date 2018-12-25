package com.fly.service;


import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.fly.model.Article;

public interface ArticleService {
	
	JSONObject selectList(Article record);
	
	int insertSelective(Article record);
	
	Article selectByPrimaryKey(String id);
	
	List<Article> getarticle(Article record);
}
