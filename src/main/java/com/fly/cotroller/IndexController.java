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
import com.common.utils.DateUtils;
import com.common.utils.StringEncode;
import com.common.utils.StringUtils;
import com.fly.model.Article;
import com.fly.model.Menu;
import com.fly.model.UserInfo;
import com.fly.service.ArticleService;
import com.fly.service.MenuService;

@Controller
public class IndexController {

	@Autowired
	private MenuService menuServiceIml;

	@Autowired
	private ArticleService ArticleServiceImpl;

	@RequestMapping("table")
	@ResponseBody
	public Object data(UserInfo userInfo) {
		for (int i = 0; i < 50; i++) {
			Article a = new Article();
			a.setId(StringUtils.UUID());
			a.setTitle(i + "�����˵��ȹ��ܣ���Ҫ����elementģ��");
			a.setInsertTime(DateUtils.getCurrDate());
			a.setAuther("admin");
			a.setContent("��������һ�����Ϊ 1140px ��ˮƽ���п飨����Ӧʽ��");
			// a.setMuenId("62e8e3d7bb09458a8d6d7cec37792b18");
			a.setMuenId("70d0e22d55cd4572918608ad5c7bbb97");
			// a.setMuenId("7da30279407c4fa7a5034895933b85ab");

			// a.setMuenId("843eb39813924331ba6ba1a06460a4cd");
			// a.setMuenId("936033bf2cdc4e78a82cdd8fb64bedf1");
			// a.setMuenId("a91c146b068249a2afd828f7fe79e316");

			ArticleServiceImpl.insertSelective(a);
		}

		return null;
	}

	/**
	 * ��ò˵�����
	 * 
	 * @param mid
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "GetMenuName", method = RequestMethod.GET)
	@ResponseBody
	public Object GetName(String mid, HttpServletRequest req) {
		Menu m = menuServiceIml.selectByPrimaryKey(mid);
		return m;
	}

	/**
	 * ��ȡ�����б�
	 * 
	 * @param searchEntity
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "GetArticleList", method = RequestMethod.GET)
	@ResponseBody
	public Object GetArticleList(Article searchEntity, HttpServletRequest req) {
		return ArticleServiceImpl.selectList(searchEntity);
	}

	/**
	 * 获取文章明细
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "GetArticleDetail", method = RequestMethod.POST)
	@ResponseBody
	public Object getArticleDetail(String id, HttpServletRequest req, HttpServletResponse res) {

		return ArticleServiceImpl.selectByPrimaryKey(id);

	}

	/**
	 * 密码加密与解密
	 * @param op
	 * @param value
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "encode", method = RequestMethod.POST)
	@ResponseBody
	public Object encode(String op, String value, HttpServletRequest req, HttpServletResponse res) {
		JSONObject json = new JSONObject();
		json.put("code", CommonContext.HTTP_SUCCESS);
		try {

			// 加密
			if ("1".equals(op)) {
				json.put("value", StringEncode.encodeString(value));
			} else {
				// 解密
				json.put("value", StringEncode.deencodeString(value));
			}
		} catch (Exception e) {
			// TODO: handle exception
			json.put("code", CommonContext.HTTP_ERROR);
		}
		return json;
	}
}
