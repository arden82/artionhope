package com.tha103.artion.member.controller;

import java.security.SecureRandom;
import java.util.Base64;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.member.util.MemberEmailutil;
import com.tha103.artion.member.util.MemberRedius;

@WebServlet("/memberRestPassword")
public class MemberRestPassword extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		String userEmail = req.getParameter("email");
		String token = req.getParameter("token"); // 不是null，代表是從驗證信過來
		try {
			if (token != null) {
				MemberRedius redius = new MemberRedius();
				String checkResult = redius.checkRedis(userEmail, token);
				switch (checkResult) {
				case ("連結信已失效"):
					res.sendRedirect(req.getContextPath() + "/html/member/memberforgetPassword.html");
					break;
				case ("驗證成功!"):
					res.sendRedirect(req.getContextPath() + "/html/member/memberRemakePassword.html");
					break;
				case ("驗證有誤，請重新申請"):
					res.sendRedirect(req.getContextPath() + "/html/member/memberforgetPassword.html");
					break;
				default:
					res.sendRedirect(req.getContextPath() + "/html/member/memberLogin.html");
					break;
				}
			} else {
				String resetToken = resetToken();
				MemberEmailutil emailUtil = new MemberEmailutil();
				MemberRedius redius = new MemberRedius();
				redius.emailRedis(userEmail, resetToken);
				String url = req.getContextPath();
				emailUtil.sendRestMail(userEmail, resetToken, url);
			}
		} catch (Exception e) {
			System.out.println("login Exception:" + e);
		}
	}

	private String resetToken() {
		String token = "";
		SecureRandom random = new SecureRandom();
		byte[] tokenBytes = new byte[18];
		random.nextBytes(tokenBytes);
		token = Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
		return token;
	}
}