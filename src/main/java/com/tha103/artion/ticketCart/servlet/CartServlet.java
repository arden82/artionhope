package com.tha103.artion.ticketCart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import redis.clients.jedis.Jedis;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();

        String redisHost = "localhost";
        int redisPort = 6379;
        Jedis jedis = new Jedis(redisHost, redisPort);

        try {
            jedis.select(0);

            // 取得"user_cart"集合中所有資料
            Set<String> jsonStrings = jedis.smembers("user_cart");

            JsonObject jsonArray = new JsonObject();
            for (String jsonString : jsonStrings) {
                JsonObject jsonObject = (JsonObject) new JsonParser().parse(jsonString);
                long actId = jsonObject.get("actId").getAsLong();
                String actName = jsonObject.get("actName").getAsString();
                double actTicPrice = jsonObject.get("actTicPrice").getAsDouble();

//                System.out.println(actId);
//                System.out.println(actName);
//                System.out.println(actTicPrice);
                
                // 創建一個JSON將資料添加進去
                JsonObject item = new JsonObject();
                item.addProperty("actId", actId);
                item.addProperty("actName", actName);
                item.addProperty("actTicPrice", actTicPrice);
                jsonArray.add(jsonString, item);
//              jsonArray.add(actId.toString(), item);
                System.out.println(item);
            }

            out.print(jsonArray.toString());
        } finally {
            jedis.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}


