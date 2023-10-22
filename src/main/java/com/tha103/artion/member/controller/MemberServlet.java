package com.tha103.artion.member.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.tha103.artion.member.controller.*;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.member.service.MemberService;
import com.tha103.artion.member.service.MemberServiceImp;
import com.tha103.artion.member.service.Membermsg;
import com.tha103.artion.memberLevel.model.MemberLevelVO;

@WebServlet("/member/member.do")
@MultipartConfig
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		action = (action != null) ? action : "";
		System.out.println("action " + action);
		MemberService memSvc = null;
		memSvc = new MemberServiceImp();
		MemberVO memberVO = new MemberVO();
		HttpSession session = null;
		Gson gson = null;
		Membermsg msg = null;
		switch (action) {
		case "insert":
			String account = req.getParameter("mem_account");
			String password = req.getParameter("mem_password");
			String name = req.getParameter("mem_name");
			String gender = req.getParameter("mem_gender");
			String birthdaystr = req.getParameter("mem_birthday");
			String mobile = req.getParameter("mem_mobile");
			String billAddress = req.getParameter("mem_billAddress");
			Part profilePhoto = req.getPart("mem_profilePhoto"); // 沒有選圖片也不會null而是空物件
			System.out.println(profilePhoto);
			byte[] profilePhotoByte = null;
			// 使用ajax不選圖使用profilePhoto.getSize()也部會小於0
			if (profilePhoto.getSubmittedFileName() != null) {
//				System.out.println("profilePhoto1," + profilePhoto);
				InputStream is = profilePhoto.getInputStream();
				ByteArrayOutputStream byteArros = new ByteArrayOutputStream();
				byte[] buf = new byte[4 * 1024];
				int len;
				while ((len = is.read(buf)) != -1) {
					byteArros.write(buf, 0, len);
				}
				profilePhotoByte = byteArros.toByteArray();
				byteArros.close();
			} else {
				try {
//					System.out.println("未選圖片");
					ServletContext context = getServletContext();// 開發與上線路徑會不一樣
					// randomInteger = min + (int)(Math.random() * ((max - min) + 1))
					int random = 1 + (int) (Math.random() * (3) + 1);
					String imgPath = context.getRealPath("/images/member/" + random + ".jpg");
					System.out.println("a2imgPath ," + imgPath);
					FileInputStream fis = new FileInputStream(imgPath);
					byte[] buffer = fis.readAllBytes();
					fis.close();
					byte[] is = buffer;
					profilePhotoByte = is;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			memberVO.setMemName(name);
			memberVO.setMemNickname(name);
			memberVO.setMemAccount(account);
			memberVO.setMemPassword(password);
			memberVO.setMemGender(gender);
			memberVO.setMemBirthday(java.sql.Date.valueOf(birthdaystr));
			memberVO.setMemMobile(mobile);
			memberVO.setMemAddress(billAddress);
			memberVO.setMemRegisterdTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			memberVO.setMemProfilePhoto(profilePhotoByte);
			memberVO.setMemTotalCost(0);
			if (memSvc.insert(memberVO) == -1) {
				session = req.getSession();
				gson = null;
				msg = null;
				session.setAttribute("errmsg", "此帳號已註冊");
				String sessionStr = (String) session.getAttribute("errmsg");
				msg = new Membermsg(sessionStr);
				System.out.println("msg:" + msg);
				gson = new Gson();
				String sessionJson = gson.toJson(msg);
				System.out.println("sessionJson," + sessionJson);
				res.setContentType("application/json");
				res.setCharacterEncoding("UTF-8");
				res.getWriter().write(sessionJson);
				break;
			}
			;
			break;
		case "login":
			account = req.getParameter("mem_account");
			password = req.getParameter("password");
			memSvc = new MemberServiceImp();
			memberVO = memSvc.login(account, password);
			session = req.getSession();
			System.out.println("login case");
			System.out.println("memberVO != null:" + (memberVO != null));
			String streql = null;
			if (memberVO != null) {
				streql = memberVO.getMemPassword();
			} else {
				streql = "";
			}
			try {
				System.out.println("streql:"+streql);
				if (memberVO != null && !(("密碼錯誤".equals(streql)))) {
					session.setAttribute("account", account);
					String location = (String) session.getAttribute("location");
					if (location != null) {
						session.removeAttribute(location);// 移出session裡的location
						System.out.println("location , 成功" + location);
						res.sendRedirect(location);
						return;
					}
					System.out.println("login 成功要轉換");
					System.out.println(req.getContextPath() + "/html/member/memberforgetPassword.html");
					res.sendRedirect(req.getContextPath() + "/html/member/memberforgetPassword.html");
					return;

				} else {
					if ("密碼錯誤".equals(streql)) {
						session.setAttribute("errmsg", "密碼錯誤");
						String sessionStr = (String) session.getAttribute("errmsg");
						msg = new Membermsg(sessionStr);
						System.out.println("msg:" + msg);

					} else {
						session.setAttribute("errmsg", "此帳號沒有註冊過");
						String sessionStr = (String) session.getAttribute("errmsg");
						msg = new Membermsg(sessionStr);
						System.out.println("msg:" + msg);

					}
					gson = new Gson();
					String sessionJson = gson.toJson(msg);
					System.out.println("sessionJson," + sessionJson);
					res.setContentType("application/json");
					res.setCharacterEncoding("UTF-8");
					res.getWriter().write(sessionJson);
					break;
				}

			} catch (Exception e) {
				System.out.println("login Exception:" + e);
			}
		case "examine":
			account = req.getParameter("mem_account");
			memSvc = new MemberServiceImp();
			if (1 == memSvc.examine(account)) {
				session = req.getSession();
				session.setAttribute("errmsg", "此帳號已註冊");
				String sessionStr = (String) session.getAttribute("errmsg");
				msg = new Membermsg(sessionStr);
				System.out.println("msg:" + msg);
				gson = new Gson();
				String sessionJson = gson.toJson(msg);
				res.setContentType("application/json");
				res.setCharacterEncoding("UTF-8");
				res.getWriter().write(sessionJson);
				break;
			}
		}
	}
}
