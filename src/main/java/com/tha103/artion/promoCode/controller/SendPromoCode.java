package com.tha103.artion.promoCode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
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
		// 獲取前端傳遞的参数，例如 promoCodeId
		String promoCodeId = req.getParameter("promoCodeId");
		System.out.println(promoCodeId);
		JsonObject jObj = new JsonObject();
		// 創建PromoCodeEmailDAO實例
		PromoCodeEmailDAO promoCodeEmailDAO = new PromoCodeEmailDAO();

		// 獲取所有會員的電子郵件地址
		List<String> memberEmails = promoCodeEmailDAO.selectAllMemberEmail();

		// 創建PromocoEmailutil實例
		PromocoEmailutil emailUtil = new PromocoEmailutil();
		List<String> failedEmails = new ArrayList<>();
		for (String userEmail : memberEmails) {
			try {
				new Thread(() -> emailUtil.sendPromoCodeEmail(userEmail, promoCodeId, getBaseUrl(req))).start();
			} catch (Exception e) {
				// 如果發送失敗，記錄失敗的郵件
				failedEmails.add(userEmail);
			}
		}

		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		if (failedEmails.isEmpty()) {
			// 發送成功
			jObj.addProperty("status", "Email sent successfully}");
		} else {
			// 發送失败，可以包含失敗的郵件列表或其他信息
			jObj.addProperty("status", "Failed to send email to the following emails:" + failedEmails);
		}
		out.println(jObj.toString());
		out.close();
	}

	private String getBaseUrl(HttpServletRequest request) {
		String scheme = request.getScheme(); // (http, https)
		String serverName = request.getServerName(); // 獲取主機名或IP地址
		int serverPort = request.getServerPort(); // 獲取端口號
		String contextPath = request.getContextPath(); // 獲取上下文路徑

		// 創建基本URL
		return scheme + "://" + serverName + ":" + serverPort + contextPath;
	}

}
