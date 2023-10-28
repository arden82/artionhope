package com.tha103.artion.ticketCart.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.mapping.List;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

@WebServlet("/getFromRedis")
public class GetFromRedisServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 连接到 Redis 数据库
        Jedis jedis = new Jedis("localhost", 6379);

        // 选择 db02 数据库
        jedis.select(2);

        // 获取所有的购物车记录
        Set<String> cartItems = jedis.keys("*"); // 获取所有的 key，每个 key 对应一个购物车记录
        System.out.println(cartItems);
        List<CartItem> cartData = new ArrayList<>();

        // 遍历购物车记录
        for (String cartItemKey : cartItems) {
            // 获取购物车记录的 JSON 数据
            String cartItemData = jedis.get(cartItemKey);

            // 解析 JSON 数据为 Java 对象
            Gson gson = new Gson();
            CartItem cartItem = gson.fromJson(cartItemData, CartItem.class);

            cartData.add(cartItem);
        }

        // 将购物车数据转换为 JSON 格式
        Gson gson = new Gson();
        String jsonData = gson.toJson(cartData);

        response.getWriter().write(jsonData);

        // 关闭 Redis 连接
        jedis.close();
    }
}
