package com.fly.cotroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;
import com.common.utils.FileUtils;
import com.common.utils.StringUtils;

/**
   * �ļ��ϴ�����
 * @author A-T
 *
 */
@Controller
public class FileCotroller {
	private final ResourceLoader resourceLoader;

	@Autowired
	public FileCotroller(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	/**
	 * �ϴ��ӿ�
	 * @param file
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "uploadImg", method = RequestMethod.POST)
	@ResponseBody
	public Object file(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest req,
			HttpServletResponse res) {
		JSONObject json = new JSONObject();
		ApplicationHome home = new ApplicationHome(getClass());
		String shellPath = home.getSource().getParent();

		// 上传路径
		String path = shellPath + "/imgages/";

		// �ļ�ϵͳ�ļ���
		String systemName = StringUtils.getId() + "-" + file.getOriginalFilename().trim();
		// �ϴ��ɹ�
		if (FileUtils.saveFile(file, path, systemName)) {
			json.put("code", "0");
			JSONObject data = new JSONObject();
			data.put("src", "/show?name=" +systemName);
			data.put("title", file.getOriginalFilename());
			json.put("data", data);
		} else {
			json.put("code", "-1");
		}

		return json;
	}

	/*
	 * �鿴ͼƬ�ӿ�
	 */
	@RequestMapping("show")
	@ResponseBody
	public Object show(String name ,HttpServletRequest req, HttpServletResponse res) {
		try {
			ApplicationHome home = new ApplicationHome(getClass());
			String shellPath = home.getSource().getParent();
			// �ļ��ϴ�·��
			String path = shellPath + "/imgages/";
			// �����Ƕ�ȡ�������ļ���file��һ��Ҫ���ϵģ� path����application�����ļ��е�·��
			return ResponseEntity.ok(resourceLoader.getResource("file:"+path +name));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
