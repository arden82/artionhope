package com.tha103.artion.seller.controller;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.tha103.artion.seller.model.*;
import com.tha103.artion.seller.model.SellerDAO;

import javax.sql.DataSource;

@WebServlet("/seller/loginhandler.do")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SellerDAO sellerDAO;

	@Override
	public void init() throws ServletException {
		super.init();
		sellerDAO = new SellerDAO();
	}

	protected boolean allowUser(String account, String password) {
		// 使用SellerDAO中的方法来验证用户
		return sellerDAO.checkUser(account, password);
	}

	protected void successfulLogin(HttpServletResponse res) throws IOException {
		// 密码匹配，可以执行登录成功后的操作
		// 例如，可以设置用户会话或重定向到其他页面
		// 以下是一个重定向的示例：
		res.sendRedirect("/Artionhope/activity/sel_index.jsp");
		System.out.println("登入成功");
	}

	protected void failedLogin(HttpServletResponse res) throws IOException {
		// 密码不匹配，可以返回错误消息
		System.out.println("登入失敗");
		res.sendRedirect("login.jsp");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();

		// 从请求参数中获取帐户和密码
		String account = req.getParameter("sel_account");
		System.out.println(account);
		String password = req.getParameter("sel_password");
		System.out.println(password);

		if (allowUser(account, password)) {
			successfulLogin(res);
		} else {
			failedLogin(res);
		}
	}
}
