package com.fly.cotroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fly.model.Article;
import com.fly.model.UserInfo;
import com.fly.service.UserInfoService;

@Controller
public class AdminController {

	@Autowired
	private UserInfoService userInfoServiceImpl;
	
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
}
