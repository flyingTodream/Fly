/**
 * 
 */
package com.common;

import redis.clients.jedis.*;

/**
 * @author A-T
 *
 */
public class JedisUtils {

	private static JedisPool jedisPool = null;
	// 把redis连接对象放到本地线程中
	private static ThreadLocal<Jedis> local = new ThreadLocal<Jedis>();

	// 不允许通过new创建该类的实例
	private JedisUtils() {
	}

	/**
	 * 初始化Redis连接池
	 */
	public static void initialPool() {
		try {
			// 创建jedis池配置实例
			JedisPoolConfig config = new JedisPoolConfig();
			// 设置池配置项值
			config.setMaxTotal(20);
			config.setMaxIdle(50);
			config.setMaxWaitMillis(1500);
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);
			// 根据配置实例化jedis池
			jedisPool = new JedisPool(config, "127.0.0.1", 6379, 2000, "123456");
			System.out.println("线程池被成功初始化");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得连接
	 * 
	 * @return Jedis
	 */
	public static Jedis getConn() {
		// Redis对象
		Jedis jedis = local.get();
		if (jedis == null) {
			if (jedisPool == null) {
				initialPool();
			}
			jedis = jedisPool.getResource();
			local.set(jedis);
		}
		return jedis;
	}

	// 新版本用close归还连接
	public static void closeConn() {
		// 从本地线程中获取
		Jedis jedis = local.get();
		if (jedis != null) {
			jedis.close();
		}
		local.set(null);
	}

	// 关闭池
	public static void closePool() {
		if (jedisPool != null) {
			jedisPool.close();
		}
	}

	/**
	 * 设置值
	 * @param key
	 * @param obj
	 * @param time
	 */
	public static void setValue(String key,Object obj,long time) {
		try {
			Jedis Jedis = getConn();
			Jedis.set(key, obj.toString());
			Jedis.expireAt(key, time);
		} finally {
			// TODO: handle finally clause
			closeConn();
			closePool();
			
		}
		
		
	}
	
	/**
	 * 获取值
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		try {
			Jedis Jedis = getConn();
			return Jedis.get("key");
		} finally {
			// TODO: handle finally clause
			closeConn();
			closePool();
		}
	}
	
	
	/**
	 * 获取剩余时间
	 * @param args
	 */
	
	public static Long getLastTime(String key) {
		try {
			Jedis Jedis = getConn();
			return Jedis.ttl(key);
		} finally {
			// TODO: handle finally clause
			closeConn();
			closePool();
		}
	}
	
	public static void main(String[] args) {
		//Jedis Jedis = getConn();
		//Jedis.set("name", "123");
		setValue("name" ,"123",10*1000);
		System.out.println(getValue("name"));
	}

}
