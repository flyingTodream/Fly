package com.fly.cotroller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fly.model.UserInfo;
import com.fly.service.UserInfoService;


@Controller
public class IndexController {

	@Autowired
	private UserInfoService userInfoServiceImpl;
	
	@RequestMapping("/demo/table")
	@ResponseBody
	public String data(@RequestParam Map<String, Object> map) {
		com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
		System.out.println(map);
		List<UserInfo> li = userInfoServiceImpl.selectListByUserInfo(null,Integer.valueOf(map.get("page").toString()),Integer.valueOf(map.get("limit").toString()));
		
		json.put("data", li);
		json.put("code", 0);
		json.put("count", userInfoServiceImpl.selectCount(null));
		return json.toString();
	}
	
	@RequestMapping(value="/home" , method=RequestMethod.DELETE)
	@ResponseBody
	public String home(@RequestParam Map<String,Object> map, HttpServletRequest req) {
		System.err.println(req.getAttribute("id"));
		System.out.println(map);
		System.out.println("111");
		return "views/app";
	}
}
