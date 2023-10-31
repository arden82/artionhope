package com.tha103.artion.ticketOrder.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.member.service.MemberService;
import com.tha103.artion.member.service.MemberServiceImp;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailService;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailService_Interface;

@WebServlet("/getOneTicketOrder")
public class TicketOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json; charset=UTF-8"); // 设置响应内容类型为JSON
        res.setCharacterEncoding("UTF-8");
        res.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session = req.getSession();
        String sessioMemId = session.getAttribute("memId").toString();

        if (sessioMemId != null) {
            // 拿取会员id
            Integer memId = Integer.valueOf(sessioMemId);
            

        }
    }
}
