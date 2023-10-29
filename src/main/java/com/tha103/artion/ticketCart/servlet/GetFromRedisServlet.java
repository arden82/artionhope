package com.tha103.artion.ticketCart.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activity.service.ActivityService;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.administrator.service.AdministratorService;
import com.tha103.artion.ticketOrder.model.TicketOrderService;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailService;

import redis.clients.jedis.Jedis;

@WebServlet("/getFromRedis")
public class GetFromRedisServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 从URL中获取memId
        String memId = request.getParameter("memId");

        // 连接到 Redis 数据库
        Jedis jedis = new Jedis("localhost", 6379);

        // 选择 db03 数据库
        jedis.select(3);

        // 使用SMEMBERS命令获取购物车集合中的所有JSON字符串
        Set<String> cartItems = jedis.smembers(memId);

        // 关闭 Redis 连接
//        jedis.close();

        // 用于存储购物车内容的 JSON 数组
        JsonArray jsonData = new JsonArray();

        // 连接到 MySQL 数据库并检索活动信息
        ActivityService activityService = new ActivityService();

        for (String cartItem : cartItems) {
            // 解析JSON字符串以获取活动ID
            JsonObject cartItemJson = new JsonParser().parse(cartItem).getAsJsonObject();
            String actId = cartItemJson.get("活動編號").getAsString();
            String selIdStr = cartItemJson.get("廠商編號").getAsString();
            
            // 使用活动ID查询数据库以获取活动名称和价格
            ActivityVO activityVO = activityService.getOneActivity(Integer.parseInt(actId));
            int selId = Integer.parseInt(selIdStr);
            
            if (activityVO != null) {
                // 创建一个 JSON 对象以存储活动信息
                JsonObject cartItemData = new JsonObject();
                cartItemData.addProperty("actId", actId);
                cartItemData.addProperty("actName", activityVO.getActName());
                cartItemData.addProperty("actTicPrice", activityVO.getActTicketPrice());
                cartItemData.addProperty("selId", selId);
                
                jsonData.add(cartItemData);
            }
        }
        
        // 將購物車資料轉成 JSON 送回前端
        response.getWriter().write(jsonData.toString());
    }
}












