package com.tha103.artion.ticketOrderDetail.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tha103.artion.activityComment.JSONObject;

import redis.clients.jedis.Jedis;

@WebServlet("/removeTicketDetail")
public class RemoveTicketDetailServlet extends HttpServlet {
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String memId = request.getParameter("memId");
        session.setAttribute("memId", 7011);
            try {
                
                String actId = request.getParameter("actId");

                try (Jedis jedis = new Jedis("localhost", 6379)) {
                    jedis.select(3); 

                    String jsonData = jedis.get(memId.toString()); 
                    System.out.println("jsonData = " + jsonData);
                   

                    if (jsonData != null) {
                        JSONObject json = new JSONObject(jsonData);

                        // 获取JSON数据中的所有键（actId）
                        for (String key : json.keySet()) {
                            if (key.equals(actId)) {
                                json.remove(key);
                            }
                        }

                        jedis.set(memId.toString(), json.toString());

                        response.setStatus(HttpServletResponse.SC_OK);
                        response.getWriter().write("删除成功");
                    } else {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        response.getWriter().write("JSON");
                    }
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("找不到memId");
            }
        
    }
}