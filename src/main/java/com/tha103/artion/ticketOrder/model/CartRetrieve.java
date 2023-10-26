package com.tha103.artion.ticketOrder.model;

import java.util.Set;

import com.tha103.artion.ticketOrder.util.JedisPoolUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class CartRetrieve {

	public static void main(String[] args) {
		JedisPool pool = JedisPoolUtil.getJedisPool();

		// 購物車的鍵名
		String cartId = "user_cart";

		Jedis jedis = pool.getResource();
		try {
			// 使用 SMEMBERS 命令來取得購物車中所有的元素
			Set<String> cartItems = jedis.smembers(cartId);

			for (String item : cartItems) {
				System.out.println("購物車項目: " + item);
			}
		} finally {
			jedis.close();
		}
	}
}