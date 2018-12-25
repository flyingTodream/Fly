package com.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created By Donghua.Chen on  2018/1/9
 */
public class StringUtils {

    public static String UUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static boolean isEmpty(String str){
        return org.springframework.util.StringUtils.isEmpty(str);
    }
    
	/**
	 * 根据时间生成唯一id
	 * @return
	 */
	public static String getId(){  
        String id=""; 
        //获取当前时间戳		
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmm");  
        String temp = sf.format(new Date());  
	       //获取6位随机数
        int random=(int) ((Math.random()+1)*100000);  
        id=temp+random;  
        return id; 
	}
    
	 public static void main(String[] args) {
		System.out.println(UUID());
	}
	 
	 
	 
}
