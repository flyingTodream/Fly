package com.fly.cotroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.common.CommonContext;
import com.fly.model.Article;
import com.fly.model.UserInfo;
import com.fly.service.ArticleService;
import com.fly.service.UserInfoService;

@Controller
public class AdminController {

	@Autowired
	private UserInfoService userInfoServiceImpl;
	
	@Autowired
	private ArticleService ArticleServiceImpl;
	
	
	@RequestMapping(value="getArticle" , method=RequestMethod.GET)
	@ResponseBody
	public Object getarticle(Article searchEntity) {
		JSONObject json = new JSONObject();
		List<UserInfo> data = userInfoServiceImpl.selectListByUserInfo(null,1,10);
		json.put("pages", 10);
		json.put("data", data);
		json.put("code", 0);
		return json.toString();
	}
	
	
	/**
	 * 删除文章
	 */
	@RequestMapping(value="delArticle" , method=RequestMethod.POST)
	@ResponseBody
	public Object delArticle(String id ,HttpServletRequest req , HttpServletResponse res) {
		JSONObject json = new JSONObject();
		
		try {
			if(ArticleServiceImpl.deleteByPrimaryKey(id) == 1) {
				json.put("code", CommonContext.HTTP_SUCCESS);
			}else {
				json.put("code", CommonContext.HTTP_ERROR);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			json.put("code", CommonContext.HTTP_ERROR);
		}
		System.out.println(json);
		return json;
	}
	
}
