package com.tha103.artion.ticketCart.servlet;

import java.io.IOException;
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
import com.tha103.artion.seller.model.SellerVO;

import redis.clients.jedis.Jedis;

@WebServlet("/getFromRedis")
public class GetFromRedisServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String memId = request.getParameter("memId");

        Jedis jedis = new Jedis("localhost", 6379);

        // 选择 db03 数据库
        jedis.select(3);

        Set<String> cartItems = jedis.smembers(memId);

        // 关闭 Redis 连接
//        jedis.close();

        JsonArray jsonData = new JsonArray();

        ActivityService activityService = new ActivityService();

        for (String cartItem : cartItems) {
            // 解析JSON字符串以获取活动ID
            JsonObject cartItemJson = new JsonParser().parse(cartItem).getAsJsonObject();
            String actId = cartItemJson.get("活動編號").getAsString();
            String selIdStr = cartItemJson.get("廠商編號").getAsString();
//            String selName = cartItemJson.get("廠商名稱").getAsString();
          
            ActivityVO activityVO = activityService.getOneActivity(Integer.parseInt(actId));
            int selId = Integer.parseInt(selIdStr);
            
            SellerVO sellerVO = activityVO.getSeller();
            
            if (activityVO != null) {
                JsonObject cartItemData = new JsonObject();
                cartItemData.addProperty("selName", sellerVO.getSelName());
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












