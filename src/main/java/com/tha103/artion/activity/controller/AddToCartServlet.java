package com.tha103.artion.activity.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activity.service.ActivityService;

import redis.clients.jedis.Jedis;

@WebServlet("/addToCartServlet")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 取得請求參數
        BufferedReader reader = request.getReader();
        StringBuilder jsonInput = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonInput.append(line);
        }

        // 拆解json
        JsonObject data = new JsonParser().parse(jsonInput.toString()).getAsJsonObject();
        String actIdStr = data.get("actId").getAsString();
        int actId = Integer.parseInt(actIdStr); // 字串轉換數字
        String memId = data.get("memId").getAsString();

        // 因前端傳actName是亂碼，因此用actId取得活動名稱和票價
        ActivityService activityService = new ActivityService();
        ActivityVO activityVO = activityService.getOneActivity(actId);
        String actName = activityVO.getActName();
        double actTicPrice = activityVO.getActTicketPrice();

        // 存入 Redis Set
        String redisHost = "localhost";
        int redisPort = 6379;
        Jedis jedis = new Jedis(redisHost, redisPort);

        try {
            jedis.select(2); 

            // 創建購物車資料json
            JsonObject cartItem = new JsonObject();
            cartItem.addProperty("actName", actName); // 直接存储 actName 字符串
            cartItem.addProperty("actTicPrice", actTicPrice);

            // 將 memId 對應 Set，以 actId 作為 key，cartItem.toString() 設為 value
            jedis.hset(memId, Integer.toString(actId), cartItem.toString());
        } finally {
            jedis.close();
        }

        // 成功
        response.getWriter().print("{\"message\":\"Activity added to cart.\"}");
    }
}



