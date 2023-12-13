package com.tha103.artion.activity.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.tha103.artion.activity.model.ActivityDAO_interface;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activity.service.ActivityService;
import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.seller.service.SellerService;

import redis.clients.jedis.Jedis;

@WebServlet("/AddToCart2")
public class AddToCartServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 從前端獲得數據
        String actId = request.getParameter("actId");
        String memId = request.getParameter("memId");

        // redis 連線
        Jedis jedis = new Jedis("localhost", 6379);

        // 選擇資料庫
        jedis.select(3);

        int actIdInt = Integer.parseInt(actId); //活動編號
        
        ActivityService activityService = new ActivityService();
        ActivityVO activityVO = activityService.getOneActivity(actIdInt);
        
        String actName = activityVO.getActName(); //活動名稱
        int actTicketPrice = activityVO.getActTicketPrice(); //活動票價
        int selId = activityVO.getSeller().getSelId(); //廠商編號
        
        SellerService sellerService = new SellerService();
        SellerVO sellerVO = sellerService.getOneSeller(selId);
        String selName = sellerVO.getSelName();  //廠商名稱
        
        
        // 創建JSON對象
        JsonObject cartItem = new JsonObject();
        cartItem.addProperty("活動編號", actId);
        cartItem.addProperty("活動名稱", actName);
        cartItem.addProperty("活動票價", actTicketPrice);
        cartItem.addProperty("廠商編號", selId);
        cartItem.addProperty("廠商名稱", selName);

        // 將Json轉成字串
        String jsonItem = cartItem.toString();

        // 使用sadd()將json字串加入memid對應的集合
        jedis.sadd(memId, jsonItem);

        // 關閉連線
        jedis.close();

        // 發送成功回應
        response.getWriter().write("{\"message\":\"Activity added to cart.\"}");
    }
}





