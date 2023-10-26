package com.tha103.artion.ticketOrder.util;

import java.util.List;

import redis.clients.jedis.Jedis;

public class ticketOrderutil {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost", 6379);

		if (jedis.exists("ticketCartDetail"))
			jedis.del("ticketCartDetail");

		jedis.rpush("ticketCartDetail", "mem_id", "ticket_id", "ticketCartDetail_total");

		System.out.println("=====================================");

		List<String> range1 = jedis.lrange("ticketCartDetail", 0, -1);
		for (String ticketCartDetail : range1)
			System.out.println(ticketCartDetail);

	}
}
