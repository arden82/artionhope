package com.tha103.artion.promoCode.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.promoCode.model.PromoCodeEmailDAO;
import com.tha103.artion.promoCode.util.PromocoEmailutil;

@WebServlet("/SendPromoCode")
public class SendPromoCode extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取前端传递的参数，例如 promoCodeId
		String proCodeCode = req.getParameter("proCodeCode");
		System.out.println(proCodeCode);

		// 创建PromoCodeEmailDAO实例
		PromoCodeEmailDAO promoCodeEmailDAO = new PromoCodeEmailDAO();

		// 获取所有会员的电子邮件地址
		List<String> memberEmails = promoCodeEmailDAO.selectAllMemberEmail();

		// 创建PromocoEmailutil实例
		PromocoEmailutil emailUtil = new PromocoEmailutil();

		// 发送邮件给所有会员
		for (String userEmail : memberEmails) {
			emailUtil.sendPromoCodeEmail(userEmail, proCodeCode, getBaseUrl(req));
		}

		// 处理成功或失败的情况，可以向前端发送响应
		// 例如：
		// if (发送邮件成功) {
		// // 发送成功的响应
		// res.getWriter().write("Email sent successfully");
		// } else {
		// // 发送失败的响应
		// res.getWriter().write("Failed to send email");
		// }
	}

	private String getBaseUrl(HttpServletRequest request) {
		String scheme = request.getScheme(); // 获取协议 (http, https)
		String serverName = request.getServerName(); // 获取主机名或IP地址
		int serverPort = request.getServerPort(); // 获取端口号
		String contextPath = request.getContextPath(); // 获取上下文路径

		// 构建基本URL
		return scheme + "://" + serverName + ":" + serverPort + contextPath;
	}

}
