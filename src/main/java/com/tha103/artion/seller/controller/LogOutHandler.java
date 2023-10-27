package com.tha103.artion.seller.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/seller/LogOutHandler.do")
public class LogOutHandler extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
		// 清除使用者的登入資訊（session 或 cookie）
		HttpSession session = request.getSession();
		session.setAttribute("logoutMessage", "帳號已登出"); // 设置自定义的登出消息

		session.invalidate();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.

		System.out.println("帳號已登出消息已设置");
		response.sendRedirect(request.getContextPath() + "/seller/sel_login2.jsp");

    }
}

