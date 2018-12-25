/**
 * 
 */
package com.common.utils;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

/**
 * 通用文件工具类
 * 
 * @author A-T
 *
 */
public class FileUtils {

	/**
	 * 上传文件
	 * @param file
	 * @param path
	 * @param systemName
	 * @return
	 */
	public static boolean saveFile(MultipartFile file, String path, String systemName) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				File filepath = new File(path);
				if (!filepath.exists())
					filepath.mkdirs();
				// 文件保存路径
				String savePath = path + systemName;
				System.out.println("原始文件名：" + file.getOriginalFilename());
				System.out.println("系统保存文件名：" + savePath);
				File filePath = new File(path);

				if (!filePath.exists()) {

					filePath.mkdirs();

				}
				// 转存文件
				file.transferTo(new File(savePath));
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	


	
	
}
