package com.tha103.artion.member.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashMap;

import java.util.Map;

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
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.member.service.MemberService;
import com.tha103.artion.member.service.MemberServiceImp;
import com.tha103.artion.member.service.Membermsg;

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
		Integer memId = null;
		HttpSession session = null;
		Gson gson = null;
		Membermsg msg = null;
		toObject memIdobj = null;
		String memIdjson = null;
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
			// 使用ajax不選圖使用profilePhoto.getSize()也不會小於0
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
			memId = memSvc.insert(memberVO);
//			if (memId == -1) {
//				session = req.getSession();
//				gson = null;
//				msg = null;
//				session.setAttribute("errmsg", "此帳號已註冊");
//				String sessionStr = (String) session.getAttribute("errmsg");
//				msg = new Membermsg(sessionStr);
//				System.out.println("msg:" + msg);
//				gson = new Gson();
//				String sessionJson = gson.toJson(msg);
//				System.out.println("sessionJson," + sessionJson);
//				res.setContentType("application/json");
//				res.setCharacterEncoding("UTF-8");
//				res.getWriter().write(sessionJson);
//				break;
//			};
			session = req.getSession();
			session.setAttribute("account", account);
			session.setAttribute("memId", memId);
			memIdobj = new toObject();
			memIdobj.getData().put("mem_id", memId);
			gson = new Gson();
			memIdjson = gson.toJson(memIdobj);
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(memIdjson);
			return;
		case "update":
			memId=(Integer)session.getAttribute("memId");
			if (memId == null) {
				res.sendRedirect(req.getContextPath() + "/html/member/memberLogin.html");
				return;
			}
			String passwordType = req.getParameter("passwordType");
			if (passwordType != null && "remake".equals(passwordType)) {
				account = req.getParameter("mem_account");
				password = req.getParameter("mem_password");
				memSvc = new MemberServiceImp();
				memberVO = memSvc.getMember(account);
				memberVO.setMemPassword(password);
				int result = memSvc.update(memberVO);
				if (result == 1) {
					System.out.println("remake轉向:" + req.getContextPath() + "/html/member/memberLogin.html");
					res.sendRedirect(req.getContextPath() + "/html/member/memberLogin.html");
					return;
				}

			} else {
				account = req.getParameter("mem_account");
				password = req.getParameter("mem_password");
				name = req.getParameter("mem_name");
				String nickname=req.getParameter("mem_nickname");
				gender = req.getParameter("mem_gender");
				birthdaystr = req.getParameter("mem_birthday");
				mobile = req.getParameter("mem_mobile");
				billAddress = req.getParameter("mem_billAddress");
				profilePhoto = req.getPart("mem_profilePhoto"); // 沒有選圖片也不會null而是空物件
				profilePhotoByte = null;
				// 使用ajax不選圖使用profilePhoto.getSize()也不會小於0
				if (profilePhoto.getSubmittedFileName() != null) {
//					System.out.println("profilePhoto1," + profilePhoto);
					InputStream is = profilePhoto.getInputStream();
					ByteArrayOutputStream byteArros = new ByteArrayOutputStream();
					byte[] buf = new byte[4 * 1024];
					int len;
					while ((len = is.read(buf)) != -1) {
						byteArros.write(buf, 0, len);
					}
					profilePhotoByte = byteArros.toByteArray();
					byteArros.close();
				}
			
		
			
				memSvc = new MemberServiceImp();
				MemberVO UpdateMember=new MemberVO();
				UpdateMember = memSvc.getMember(account);
				UpdateMember.setMemName(name);
				UpdateMember.setMemNickname(nickname);
				UpdateMember.setMemAccount(account);
				UpdateMember.setMemPassword(password);
				UpdateMember.setMemGender(gender);
				UpdateMember.setMemBirthday(java.sql.Date.valueOf(birthdaystr));
				UpdateMember.setMemMobile(mobile);
				UpdateMember.setMemAddress(billAddress);
				UpdateMember.setMemRegisterdTime(new java.sql.Timestamp(new java.util.Date().getTime()));
				if (profilePhoto.getSubmittedFileName() != null) {
				UpdateMember.setMemProfilePhoto(profilePhotoByte);
				}
				int result =memSvc.update(UpdateMember);
				System.out.println("result:"+result);
				if (result == 1) {
					System.out.println("update轉向:" + req.getContextPath() + "/html/member/memberProfile.html");
					res.sendRedirect(req.getContextPath() + "/html/member/memberProfile.html");
					return;
				}
			}

			break;
		case "login":
			account = req.getParameter("mem_account");
			password = req.getParameter("mem_password");
			memSvc = new MemberServiceImp();
			memberVO = memSvc.login(account, password);
			String streql = null;
			if (memberVO != null) {
				streql = memberVO.getMemPassword();
				memId = memberVO.getMemId();
			}
			session = req.getSession();
			System.out.println("login case");
			System.out.println("memberVO != null:" + (memberVO != null));
			try {
				System.out.println("streql:" + streql);
				if (memberVO != null && !(("密碼錯誤".equals(streql)))) {
					session.setAttribute("account", account);
					session.setAttribute("memId", memId);
					String location = (String) session.getAttribute("location");
					if (location != null) {
						session.removeAttribute(location);// 移出session裡的location
						System.out.println("location , 成功" + location);
						res.sendRedirect(location);
						return;
					}

					memIdobj = new toObject();
					memIdobj.getData().put("mem_id", memId);
					gson = new Gson();
					memIdjson = gson.toJson(memIdobj);
					res.setContentType("application/json");
					res.setCharacterEncoding("UTF-8");
					res.getWriter().write(memIdjson);
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
					return;

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
			}
			break;
		case "profile":
			session = req.getSession();
			memId=(Integer)session.getAttribute("memId");
			if (memId == null) {
				res.sendRedirect(req.getContextPath() + "/html/member/memberLogin.html");
				return;
			}
			account = req.getParameter("mem_account");
			memSvc = new MemberServiceImp();
			memberVO = memSvc.getMember(account);
			MemberVO tojson = memSvc.getMember(memberVO.getMemId());
			toObject obj = new toObject();
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = tojson.getMemBirthday();
			java.util.Date utilDate = new Date(date.getTime());
			String birdthday = dateformat.format(utilDate);
			obj.getData().put("mem_id", tojson.getMemId());
			obj.getData().put("mem_account", tojson.getMemAccount());
			obj.getData().put("mem_name", tojson.getMemName());
			obj.getData().put("mem_nickname", tojson.getMemNickname());
			obj.getData().put("mem_password", tojson.getMemPassword());
			obj.getData().put("mem_gender", tojson.getMemGender());
			obj.getData().put("mem_birthday", birdthday);
			obj.getData().put("mem_mobile", tojson.getMemMobile());
			obj.getData().put("mem_address", tojson.getMemAddress());
			obj.getData().put("memLev_level", String.valueOf(tojson.getMemLevLevel().getMemLevLevel()));
			obj.getData().put("memLev_levelName", String.valueOf(tojson.getMemLevLevel().getMemLevLevelName()));
			obj.getData().put("memLev_minimunOrder", Integer.valueOf(tojson.getMemLevLevel().getMemLevMinimunOrder()));
			obj.getData().put("mem_totalCost", tojson.getMemTotalCost());
			gson = new Gson();
			String json = gson.toJson(obj);
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(json);
			break;
		}
	}

	class toObject {
		private Map<String, Object> obj = new HashMap<>();

		public Map<String, Object> getData() {
			return obj;
		}
	}
}
