package com.fly.cotroller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.utils.DateUtils;
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
	
	//@Autowired
	//private UserInfoService userInfoServiceImpl;
	
	@Autowired
	private ArticleService ArticleServiceImpl;
	
	
	
	@RequestMapping("table")
	@ResponseBody
	public Object data(UserInfo userInfo) {
		for(int i = 0 ; i < 50 ; i++) {
			Article a = new Article();
			a.setId(StringUtils.UUID());
			a.setTitle(i+"二级菜单等功能，需要依赖element模块");
			a.setInsertTime(DateUtils.getCurrDate());
			a.setAuther("admin");
			a.setContent("用于设置一个宽度为 1140px 的水平居中块（无响应式）");
			//a.setMuenId("62e8e3d7bb09458a8d6d7cec37792b18");
			a.setMuenId("70d0e22d55cd4572918608ad5c7bbb97");
			//a.setMuenId("7da30279407c4fa7a5034895933b85ab");
			
			//a.setMuenId("843eb39813924331ba6ba1a06460a4cd");
			//a.setMuenId("936033bf2cdc4e78a82cdd8fb64bedf1");
			//a.setMuenId("a91c146b068249a2afd828f7fe79e316");
			
			ArticleServiceImpl.insertSelective(a);
		}
		
		return null;
	}
	
	/**
	 * 获得菜单名称
	 * @param mid
	 * @param req
	 * @return
	 */
	@RequestMapping(value="GetMenuName" , method=RequestMethod.GET)
	@ResponseBody
	public Object GetName(String mid, HttpServletRequest req) {
		Menu m = menuServiceIml.selectByPrimaryKey(mid);
		return m;
	}
	
	/**
	 * 获取文章列表
	 * @param searchEntity
	 * @param req
	 * @return
	 */
	@RequestMapping(value="GetArticleList" , method=RequestMethod.GET)
	@ResponseBody
	public Object GetArticleList(Article searchEntity, HttpServletRequest req) {
		return ArticleServiceImpl.selectList(searchEntity);
	}
		
	/**
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping(value="GetArticleDetail" , method=RequestMethod.POST)
	@ResponseBody
	public Object getArticleDetail(String id, HttpServletRequest req , HttpServletResponse res) {
		
		return ArticleServiceImpl.selectByPrimaryKey(id);
			
	}
		
	
}
