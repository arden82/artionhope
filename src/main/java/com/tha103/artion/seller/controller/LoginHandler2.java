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
	import com.tha103.artion.seller.service.*;
	import javax.sql.DataSource;
	
	@WebServlet("/seller/LoginHandler2.do")
	public class LoginHandler2 extends HttpServlet {
		private SellerDAO sellerDAO;
	
		@Override
		public void init() throws ServletException {
			super.init();
			sellerDAO = new SellerDAO();
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");
	
			String account = req.getParameter("selAccount");
			System.out.println(account);
			String password = req.getParameter("selPassword");
			System.out.println(password);
			
			if (allowUser(account, password)) {
				successfulLogin(req, res, account);
			} else {
				failedLogin(req, res);
			}
		}
		
		protected boolean allowUser(String account, String password) {
		    SellerVO sellerVO = sellerDAO.getSellerByAccount(account); // 根据帳號从数据库中获取賣家信息
	
		    if (sellerVO != null && sellerVO.getSelPassword().equals(password)) {
		        return true; // 帳號和密碼匹配
		    } else {
		        return false; // 帳號或密碼不匹配
		    }
		}
	
		protected void successfulLogin(HttpServletRequest req, HttpServletResponse res, String account) throws IOException {
		    // 登录成功后，获取卖家的所有数据并存储在 sellerVO 对象中
		    SellerService sellerSvc = new SellerService();
		    SellerVO sellerVO = sellerSvc.getSellerByAccount(account);
	
		    // 将 sellerVO 对象存储在 session 属性中
		    HttpSession session = req.getSession();
		    session.setAttribute("sel_id", sellerVO.getSelId());
		    session.setAttribute("sellerVO", sellerVO);
	
		    String contextPath = req.getContextPath();
		    res.sendRedirect(contextPath + "/activity/sel_index.jsp");
		}
	
		protected void failedLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.setAttribute("error", "Incorrect account or password. Please try again.");
			req.getRequestDispatcher("/seller/sel_login.jsp").forward(req, res);
		}
	
	}
