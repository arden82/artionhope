package com.tha103.artion.activityComment;
import java.util.Set;

import redis.clients.jedis.Jedis;
public class GetRedisTest {

	public static void main(String[] args) {
// =============================== 設定Redis連接 ===============================
        String redisHost = "localhost"; 
        int redisPort = 6379;
        Jedis jedis = new Jedis(redisHost, redisPort);

        try {
            jedis.select(0);

// =============================== 取得名稱為"user_cart"的集合所以資料 ===============================
            Set<String> jsonStrings = jedis.smembers("user_cart");

            System.out.println(jsonStrings);
            for (String jsonString : jsonStrings) {
                JSONObject jsonObject = new JSONObject(jsonString);
                long actId = jsonObject.getLong("actId");
                String actName = jsonObject.getString("actName");
                double actTicPrice = jsonObject.getDouble("actTicPrice");
// ===============================印出取得資料 ===============================
                System.out.println("actId: " + actId);
                System.out.println("actName: " + actName);
                System.out.println("actTicPrice: " + actTicPrice);
            }
        } finally {
            jedis.close();
        }
    }
}
