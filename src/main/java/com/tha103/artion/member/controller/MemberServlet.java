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
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.tha103.artion.member.controller.*;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.member.service.MemberService;
import com.tha103.artion.member.service.MemberServiceImp;
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
		System.out.println(action);
		MemberService memSvc = new MemberServiceImp();
		MemberVO memberVO = new MemberVO();
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
					int random = 1 + (int) (Math.random() * (4) + 1);
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
			memSvc.insert(memberVO);
			break;
		case "login":
			account = req.getParameter("mem_account");
			password = req.getParameter("mem_password");
			memSvc 
		}

	}
}
