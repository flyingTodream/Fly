package com.fly.cotroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fly.model.Article;
import com.fly.model.UserInfo;

/**
 * �����������
 * @author A-T
 *
 */
@Controller
public class ArticleController {

	/**
	 *  ��������
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value="addArticle" , method=RequestMethod.POST)
	@ResponseBody
	public Object addArticle(Article article ,HttpServletRequest req , HttpServletResponse res) {
		JSONObject json = new JSONObject();
		
		//�õ���ǰ��¼ʵ��
		UserInfo entity = (UserInfo)req.getSession().getAttribute("userInfo");
		if(entity == null) {
			json.put("code", "200");
			return json;
		}else {
			
		}
		return json;
	}
}
