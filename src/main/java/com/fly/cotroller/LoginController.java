package com.fly.cotroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.common.CommonContext;
import com.common.utils.CryptoUtils;
import com.fly.model.UserInfo;
import com.fly.service.UserInfoService;

/**
 * 登录相关类
 * 
 * @author A-T
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UserInfoService userInfoServiceImpl;

	/**
	 * 登录主方法
	 * 
	 * @param loginName
	 * @param password
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(String loginName, String password, HttpServletRequest req, HttpServletResponse res) {
		//
		JSONObject json = new JSONObject();
		json.put("code", CommonContext.HTTP_SUCCESS);
		try {

			UserInfo searchEntity = new UserInfo();
			searchEntity.setUsername(loginName);
			searchEntity = userInfoServiceImpl.selectByPrimaryKey(searchEntity);
			// 有用户信息时
			if (searchEntity != null) {
				// 登录成功
				if (CryptoUtils.encodeMD5(password).equals(searchEntity.getPassword())) {
					json.put("msg", 1);
					req.getSession().setAttribute("userInfo", searchEntity);
				} else {
					json.put("msg", 0);
				}
			} else {
				json.put("msg", 0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			json.put("code", CommonContext.HTTP_ERROR);
		}
		return json;
	}

	/**
	 * 注销方法
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "loginOut", method = RequestMethod.POST)
	@ResponseBody
	public Object login(HttpServletRequest req, HttpServletResponse res) {
		JSONObject json = new JSONObject();
		json.put("code", 200);
		try {
			req.getSession().setAttribute("userInfo", null);
		} catch (Exception e) {
			// TODO: handle exception
			json.put("code", CommonContext.HTTP_ERROR);
		}
		return json;
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	public Object test(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(req.getSession().getAttribute("userInfo"));
		return req.getSession().getAttribute("userInfo");
	}
	
	@RequestMapping(value = "checkLogin", method = RequestMethod.GET)
	@ResponseBody
	public Object checkLogin(HttpServletRequest req, HttpServletResponse res) {
		JSONObject json = new JSONObject();
		UserInfo entity = (UserInfo)req.getSession().getAttribute("userInfo");
		if(entity==null) {
			json.put("code", 400);
		}else {
			json.put("code", CommonContext.HTTP_SUCCESS);
		}
		return json;
	}
	
	
}
