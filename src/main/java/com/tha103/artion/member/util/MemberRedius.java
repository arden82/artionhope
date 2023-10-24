package com.tha103.artion.member.util;

import com.tha103.artion.util.JedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class MemberRedius {
	public MemberRedius() {
		super();
	}

	private static JedisPool pool = null;

	public void emailRedis(String email, String resetToken) {
		pool = JedisUtil.getJedisPool();
		Jedis jedis = pool.getResource();
		jedis.select(1);
		jedis.set(email, resetToken);
		jedis.expire(email, 18000);
		jedis.close();
		JedisUtil.shutdownJedisPool();

	}

	public String checkRedis(String email, String resetToken) {
		pool = JedisUtil.getJedisPool();
		Jedis jedis = pool.getResource();
		jedis.select(1);
		String checkToken = jedis.get(email);
		jedis.close();
		JedisUtil.shutdownJedisPool();
		if (checkToken == null) {
			return "連結信已失效";   
		}
		if (checkToken.equals(resetToken)) {
			return "驗證成功!";
		} else {
			return "驗證有誤，請重新申請";
		}
	}
}
