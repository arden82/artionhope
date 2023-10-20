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

@WebServlet("/seller/LoginHandler.do")
public class LoginHandler extends HttpServlet {
	private SellerDAO sellerDAO;

	@Override
	public void init() throws ServletException {
		super.init();
		sellerDAO = new SellerDAO();
	}

	protected boolean allowUser(String account, String password) {
		return sellerDAO.checkUser(account, password);
	}

	protected void successfulLogin(HttpServletRequest req, HttpServletResponse res, String account) throws IOException {
	    HttpSession session = req.getSession();
	    session.setAttribute("userAccount", account);

	    String selName = sellerDAO.getSelName(account);
	    session.setAttribute("userSelName", selName);

	    // 將密碼存入Session，或者存入其他需要的資訊
	    String password = req.getParameter("selPassword");
	    session.setAttribute("userPassword", password);

	    String contextPath = req.getContextPath();
	    res.sendRedirect(contextPath + "/seller/sel_profile.jsp");
	}
	protected void failedLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("error", "Incorrect account or password. Please try again.");
		req.getRequestDispatcher("/seller/sel_login.jsp").forward(req, res);
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
}
