package com.tha103.artion.ticketCart.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession();
//        String memId = "7002";
//        Integer memId = (Integer) session.getAttribute("memId");
        String memId = request.getParameter("memId");
        if (memId != null) {
            Jedis jedis = new Jedis("localhost", 6379);

            // 選擇適當的 Redis 資料庫
            jedis.select(3);

            Set<String> cartItems = jedis.smembers(memId);

            JsonArray jsonData = new JsonArray();
            ActivityService activityService = new ActivityService();

            for (String cartItem : cartItems) {
                JsonObject cartItemData = new JsonObject();
                JsonObject cartItemJson = new JsonParser().parse(cartItem).getAsJsonObject();

                if (cartItemJson.has("活動編號") && cartItemJson.has("廠商編號")) {
                    String actId = cartItemJson.get("活動編號").getAsString();
                    String selIdStr = cartItemJson.get("廠商編號").getAsString();
                    int selId = Integer.parseInt(selIdStr);

                    ActivityVO activityVO = activityService.getOneActivity(Integer.parseInt(actId));
                    SellerVO sellerVO = activityVO.getSeller();

                    if (activityVO != null) {
                        cartItemData.addProperty("selName", sellerVO.getSelName());
                        cartItemData.addProperty("actId", actId);
                        cartItemData.addProperty("actName", activityVO.getActName());
                        cartItemData.addProperty("actTicPrice", activityVO.getActTicketPrice());
                        cartItemData.addProperty("selId", selId);
                        cartItemData.addProperty("memId", memId);
                        cartItemData.addProperty("quantity", 1);
//                        cartItemData.addProperty("totalPrice", 100);

                        jsonData.add(cartItemData);
                    }
                }
            }

            // 關閉 Redis 連線
            jedis.close();

            // 將購物車資料轉成 JSON 並送給前端
            response.getWriter().write(jsonData.toString());
        } else {
            // 處理 memId 遺失的情況
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("遺失 memId 參數");
        }
    }
}













