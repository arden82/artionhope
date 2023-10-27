package com.tha103.artion.memberCollection.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addToCollectionServlet")
public class AddToCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
    	
        String memId = request.getParameter("memId");
        String actId = request.getParameter("actId");
        String status = request.getParameter("status");
        
        
        
        // 根据实际结果发送 JSON 响应
//        if () {
//            out.print("{\"message\": \"收藏成功\"}");
//        } else {
//            out.print("{\"message\": \"收藏失败\"}");
//        }
//        out.flush();
    }
}
