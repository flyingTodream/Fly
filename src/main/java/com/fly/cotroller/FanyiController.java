package com.fly.cotroller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.winter.utils.TransApi;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
public class FanyiController {
	// 在平台申请的APP_ID 详见
	// http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
	private static final String APP_ID = "20181225000251914";
	private static final String SECURITY_KEY = "rI9FWxU_z4HVxBk7kpAx";


	@ResponseBody
	@RequestMapping(value = "fanyi", method = RequestMethod.GET)
	public Object fanyi(HttpServletRequest req, HttpServletResponse res, String query)
			throws UnsupportedEncodingException {
		JSONObject json = new JSONObject();
		json.put("code", "200");
		try {

			if (query != null && query != "") {

				TransApi api = new TransApi(APP_ID, SECURITY_KEY);
				JSONObject result = JSONObject.parseObject(api.getTransResult(query, "auto", "zh"));
				System.out.println(res);
				JSONArray trans_result = JSONArray.parseArray(result.get("trans_result").toString());
				JSONObject jsonobj = JSONObject.parseObject(trans_result.getString(0));
				System.out.println(jsonobj.get("dst"));
				json.put("res", jsonobj.get("dst"));

			} else {
				json.put("res", "");
			}
		} catch (Exception e) {
			// TODO: handle exception
			json.put("code", "500");
		}
		return json;
	}
}
