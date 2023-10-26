package com.tha103.artion.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;

import com.tha103.artion.member.service.MemberService;
import com.tha103.artion.member.service.MemberServiceImp;
import com.tha103.artion.member.util.MemberEmailutil;
import com.tha103.artion.member.util.MemberRedius;
import com.tha103.artion.util.JedisUtil;

@WebServlet("/memberRestPassword")
@MultipartConfig
public class MemberRestPassword extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, UnsupportedEncodingException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		String userEmail = req.getParameter("email");
		String token = req.getParameter("token"); // 不是null，代表是從驗證信過來
		System.out.println("userEmail: " + userEmail);

		try {
			if (token != null) {
				MemberRedius redius = new MemberRedius();
				String checkResult = redius.checkRedis(userEmail, token);
				switch (checkResult) {
				case "連結信已失效，請重新申請":
					res.sendRedirect(req.getContextPath() + "/html/member/memberforgetPassword.html");
					break;
				case "驗證成功!":
					res.sendRedirect(req.getContextPath() + "/html/member/memberRemakePassword.html?account="+userEmail);
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
				StringBuffer requrl = req.getRequestURL();
				int startIndex = requrl.indexOf("/artion");
				String url = requrl.substring(0,startIndex);
				emailUtil.sendRestMail(userEmail, resetToken, url);
			System.out.println(req.getContextPath() + "/html/member/memberLogin.html");
				res.sendRedirect(req.getContextPath() + "/html/member/memberLogin.html");

			}
		} catch (Exception e) {
			System.out.println("MeberRestpassword Exception: " + e);
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