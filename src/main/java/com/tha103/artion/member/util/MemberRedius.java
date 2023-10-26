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

			if (email != null && resetToken != null) {
				jedis.select(1);
				jedis.hset("email", email, resetToken);
				jedis.hset("email_expiration", email, String.valueOf(System.currentTimeMillis() + 1800 * 1000));
				jedis.close();
//				JedisUtil.shutdownJedisPool();

			} else {
				System.out.println("email" + email);
				System.out.println("resetToken" + resetToken);
			}
	}

	public String checkRedis(String email, String resetToken) {
		pool = JedisUtil.getJedisPool();
		Jedis jedis = pool.getResource();
			String msg = "";
			jedis.select(1);
			String Token = jedis.hget("email", email);
			String checkToken = jedis.hget("email_expiration", email);
			if (checkToken != null && Token.equals(resetToken)
					&& Long.parseLong(checkToken) > System.currentTimeMillis()) {
				msg = "驗證成功!";
			} else {
				msg = "連結信已失效，請重新申請";
				delRedis(email);
			}
			jedis.close();
//			JedisUtil.shutdownJedisPool();
			return msg;

	}

	public void delRedis(String email) {
		pool = JedisUtil.getJedisPool();
		Jedis jedis = pool.getResource();
			jedis.select(1);
			jedis.hdel("email", email);
			jedis.hdel("email_expiration", email);
			jedis.close();
//			JedisUtil.shutdownJedisPool();
	}
}
