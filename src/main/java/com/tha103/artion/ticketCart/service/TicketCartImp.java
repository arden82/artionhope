package com.tha103.artion.ticketCart.service;

import java.util.List;

import com.tha103.artion.util.JedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TicketCartImp {

	private static JedisPool pool = JedisUtil.getJedisPool();

	public static List<String> getCart(String memId) {
		String key = new StringBuilder(memId).append(":").toString();
		Jedis jedis = null;
		jedis = pool.getResource();
		List<String> historyData = jedis.lrange(key, 0, -1);
		jedis.close();
		return historyData;
	}

}
