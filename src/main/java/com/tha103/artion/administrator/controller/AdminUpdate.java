package com.tha103.artion.administrator.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.administrator.service.AdministratorService;
import com.tha103.artion.administrator.service.AdministratorService_Interface;

@WebServlet("/updateadmin")
@MultipartConfig
public class AdminUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setHeader("Access-Control-Allow-Origin", "*");

		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		List<String> errorMsgs = new LinkedList<>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		session.setAttribute("errorMsgs", errorMsgs);

		String sessionAdmId = session.getAttribute("admId").toString();
		
		if(sessionAdmId != null) {
			String strAdminId = req.getParameter("admId");

			System.out.println(strAdminId);

			String admName = req.getParameter("admName");
			System.out.println(admName);

			String strAdminIdentity = req.getParameter("admIdentity");

			Integer adminIdentity = null;
			try {
				adminIdentity = Integer.valueOf(strAdminIdentity);
			} catch (NumberFormatException e) {
				errorMsgs.add("請選擇身分!");
			}

			String strAdminStatus = req.getParameter("admStatus");
			Integer adminStatus = null;
			try {
				adminStatus = Integer.valueOf(strAdminStatus);
			} catch (NumberFormatException e) {
				errorMsgs.add("請選擇身分!");
			}

			String adminEmail = req.getParameter("admMail");

			String adminPassword = req.getParameter("admPassword");

			String strAdminBirthday = req.getParameter("admBirthday");
			java.sql.Date adminBirthday = null;
			try {
				adminBirthday = java.sql.Date.valueOf(strAdminBirthday);
			} catch (IllegalArgumentException e) {
				adminBirthday = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入有效日期!");
			}

			String admMobile = req.getParameter("admMobile");

			Part part = req.getPart("admProfilePhoto"); // 获取上传的文件部分
			byte[] admProfilePhoto = null;
			if (part != null && part.getSize() > 0) {
				System.out.println(part);

				InputStream in = part.getInputStream();

				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;
				while ((len = in.read(buf)) != -1) {
					byteArrayOutputStream.write(buf, 0, len);
				}

				admProfilePhoto = byteArrayOutputStream.toByteArray();
				
				System.out.println(admProfilePhoto);
			} else {
				System.out.println("沒有照片");
			}
			
			
			String strAdminRight = req.getParameter("admRight");
			Integer admRight = null;
			try {
				admRight = Integer.valueOf(strAdminRight);
			} catch (NumberFormatException e) {
				errorMsgs.add("請選擇身分!");
			}
			
			System.out.println(admProfilePhoto);
			System.out.println(admName);
			try {
				Integer admId = Integer.valueOf(strAdminId);

				AdministratorService_Interface admSvc = new AdministratorService();
				AdministratorVO adminVO = new AdministratorVO();

				
				//要修改區域	
				adminVO.setAdmProfilePhoto(admProfilePhoto);
				adminVO.setAdmName(admName);
				adminVO.setAdmIdentity(adminIdentity);
				adminVO.setAdmStatus(adminStatus);
				adminVO.setAdmMail(adminEmail);
				adminVO.setAdmPassword(adminPassword);
				adminVO.setAdmBirthday(adminBirthday);
				adminVO.setAdmMobile(admMobile);
				adminVO.setAdmRight(admRight);
				
				//不修改區域
				adminVO.setAdmId(admSvc.getAdminByAdmId(admId).getAdmId());
//				adminVO.setAdmAddTime(admSvc.getAdminByAdmId(adminId).getAdmAddTime());
				

				// 调用更新方法

				System.out.println(adminVO);
				int updateResult = admSvc.updateAdmin(adminVO);
				
				System.out.println(updateResult);
				if (updateResult > 0) {
					// 返回成功信息
					Map<String, Object> response = new HashMap<>();
					response.put("admId",admId);
					response.put("status", "success");
					response.put("message", "管理员信息已成功更新。");
					out.write(new Gson().toJson(response));
				} else {
					// 返回错误信息
					Map<String, Object> response = new HashMap<>();
					response.put("status", "error");
					response.put("message", "管理员信息更新失败。");
					out.write(new Gson().toJson(response));
				}

			} catch (NumberFormatException e) {
				// 处理无效的 adminId 参数
				Map<String, Object> response = new HashMap<>();
				response.put("status", "error");
				response.put("message", "无效的管理员 ID 参数.");
				out.write(new Gson().toJson(response));
			}
		}else {
			res.sendRedirect(req.getContextPath() + "/admin/signin.html");
			return;
		}
			
		
	}
}
