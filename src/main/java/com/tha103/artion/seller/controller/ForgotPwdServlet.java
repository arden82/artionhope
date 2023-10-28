package com.tha103.artion.seller.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.seller.model.SellerDAO;
import com.tha103.artion.seller.model.SellerDAO_interface;

@WebServlet("/seller/forgotPwdServlet")
public class ForgotPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String selAccount = request.getParameter("selAccount");

		 // 首先检查是否存在该帐号
	    SellerDAO sellerDAO = new SellerDAO(); // 假设你有一个SellerDAO用于数据库交互
	    boolean accountExists = sellerDAO.doesSellerAccountExist(selAccount);

	    if (!accountExists) {
	        // 如果帐号不存在，返回错误消息
	        request.setAttribute("errorMsg", "該帳號不存在。");
	        request.getRequestDispatcher("/seller/sel_forgotPassword.jsp").forward(request, response);
	        return;
	    }

		// 创建SellerEmailUtil实例
		SellerEmailUtil emailUtil = new SellerEmailUtil();
		// 发送重新设置密码的链接
		emailUtil.sendResetPasswordEmail(selAccount, getBaseUrl(request));
		System.out.println(222);
		request.getRequestDispatcher("/seller/sel_blankPage.jsp").forward(request, response);
	}

	private String getBaseUrl(HttpServletRequest request) {
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String contextPath = request.getContextPath();
		return scheme + "://" + serverName + ":" + serverPort + contextPath;
	}

}