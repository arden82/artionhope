package com.tha103.artion.util;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	// Singleton單例模式
	private static JedisPool pool = null;

	private JedisUtil() {
	}

	public static JedisPool getJedisPool() {
		// double lock
		if (pool == null) {
			synchronized(JedisUtil.class) {
				if (pool == null) {
					JedisPoolConfig config = new JedisPoolConfig();
					config.setMaxTotal(8);//設置連接池中允許的最大活動（active）連接數
					config.setMaxIdle(8);//設置連接池中允許的最大閒置（idle）連接數
					config.setMaxWaitMillis(10000);//設置當連接池中的所有連接都被占用，且沒有可用的連接時，客戶端需要等待的最長時間
					pool = new JedisPool(config, "localhost", 6379);
				}
			}
		}
		return pool;
	}

	public static void shutdownJedisPool() {
		if (pool != null)
			pool.destroy();
	}

}
