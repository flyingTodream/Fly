package com.common.utils;

import java.io.UnsupportedEncodingException;
import org.springframework.util.DigestUtils;

public class CryptoUtils {
	private static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * md5 salt 加密
	 * 
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String encodeMD5WithSalt(final String str, String salt) {
		String encodeStr = str + salt;
		try {
			return DigestUtils.md5DigestAsHex(encodeStr.getBytes(DEFAULT_CHARSET));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 默认md5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encodeMD5(final String str) {
		try {
			return DigestUtils.md5DigestAsHex(str.getBytes(DEFAULT_CHARSET));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
