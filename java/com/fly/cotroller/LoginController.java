package com.fly.cotroller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.common.utils.StringUtils;
import com.fly.model.UserInfo;

@RestController
public class LoginController {

	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(UserInfo UserInfo,HttpRequest req) {
		//
		JSONObject json = new JSONObject();
		json.put("status", 200);
		System.out.println(UserInfo);
		return json.toString();
	}
	public static void main(String[] args) {

	}
}
