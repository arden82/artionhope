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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import  com.tha103.artion.member.controller.*;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.member.service.MemberService;
import com.tha103.artion.member.service.MemberServiceImp;
import com.tha103.artion.memberLevel.model.MemberLevelVO;


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
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date utilD = null;
			java.sql.Date birthday = null;
			try {
				utilD = format.parse(birthdaystr);
				birthday = new java.sql.Date(utilD.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			byte[] profilePhotoByte = null;
			// 沒有選圖片也不會null而是空物件
			if (profilePhoto != null && profilePhoto.getSize() > 0) {
				System.out.println("profilePhoto1," + profilePhoto);
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
				profilePhotoByte=null;
				try {
					ServletContext context = getServletContext();// 開發與上線路徑會不一樣
					// randomInteger = min + (int)(Math.random() * ((max - min) + 1))
					int random = 1 + (int) (Math.random() * (3) + 1);
					String imgPath = context.getRealPath("/images/member" + random + ".jpg");
					System.out.println("imgPath ," + imgPath);
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
		}
		
	}
}
