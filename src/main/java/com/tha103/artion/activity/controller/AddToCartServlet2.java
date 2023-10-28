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

import redis.clients.jedis.Jedis;

@WebServlet("/AddToCart2")
public class AddToCartServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 获取传递的数据
        String actId = request.getParameter("actId");
        String memId = request.getParameter("memId");

        // 连接到 Redis 数据库
        Jedis jedis = new Jedis("localhost", 6379);

        // 选择 db03 数据库
        jedis.select(3);

        // 创建 JSON 对象
        JsonObject cartItem = new JsonObject();
        cartItem.addProperty("活動編號", actId);

        // 将 JSON 对象转换为字符串
        String jsonItem = cartItem.toString();

        // 使用 SADD 命令将 JSON 字符串添加到 memId 对应的集合
        jedis.sadd(memId, jsonItem);

        // 关闭 Redis 连接
        jedis.close();

        // 发送成功响应
        response.getWriter().write("{\"message\":\"Activity added to cart.\"}");
    }
}





