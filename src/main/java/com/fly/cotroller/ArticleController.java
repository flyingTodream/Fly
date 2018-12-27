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
import com.common.utils.StringUtils;
import com.fly.model.Article;
import com.fly.model.UserInfo;
import com.fly.service.ArticleService;

/**
 * 
 * 
 * @author A-T
 *
 */
@Controller
public class ArticleController {

	@Autowired
	private ArticleService ArticleServiceImpl;

	/**
	 * 添加文章
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "addArticle", method = RequestMethod.POST)
	@ResponseBody
	public Object addArticle(Article article, HttpServletRequest req, HttpServletResponse res) {
		JSONObject json = new JSONObject();
		json.put("code", CommonContext.HTTP_SUCCESS);
		try {

			// 获取当前登陆实体
			UserInfo entity = (UserInfo) req.getSession().getAttribute("userInfo");
			if (entity == null) {
				json.put("code", "400");
				return json;
			} else {
				// 为空新增的场合
				if (StringUtils.isEmpty(article.getId())) {
					article.setId(StringUtils.UUID());
					article.setAuther(entity.getUsername());
					article.setInsertTime(DateUtils.getCurrDate());
					ArticleServiceImpl.insertSelective(article);

				} else {
					// 更新
					article.setUpdateTime(DateUtils.getCurrDate());
					ArticleServiceImpl.updateByPrimaryKeySelective(article);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			json.put("code", CommonContext.HTTP_ERROR);
		}

		return json;
	}

	/**
	 * 查询文章
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "Search")
	@ResponseBody
	public Object Search(String keyWord, int page, HttpServletRequest req, HttpServletResponse res) {
		System.out.println();
		return ArticleServiceImpl.search(keyWord, page);
	}

}
