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

@WebServlet("/addAdmin")
@MultipartConfig
public class AddAdmin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	@Override
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
			//============接受請求參數==============================
			
			String strAdmId = req.getParameter("admId");
			Integer admId = null;
			try {
				admId = Integer.valueOf(strAdmId);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String admName = req.getParameter("admName");
			
			String strAdmIdentity = req.getParameter("admIdentity");
			
			Integer admIdentity = null;
			try {
				admIdentity = Integer.valueOf(strAdmIdentity);
			} catch (NumberFormatException e) {
				errorMsgs.add("請選擇身分!");
			}
			
			String strAdmStatus = req.getParameter("admStatus");
			Integer admStatus = null;
			try {
				admStatus = Integer.valueOf(strAdmStatus);
			} catch (NumberFormatException e) {
				errorMsgs.add("請選擇身分!");
			}
			
			String admMail = req.getParameter("admMail");

			String admPassword = req.getParameter("admPassword");
			
			String strAdmBirthday = req.getParameter("admBirthday");
			java.sql.Date admBirthday = null;
			try {
				admBirthday = java.sql.Date.valueOf(strAdmBirthday);
			} catch (IllegalArgumentException e) {
				admBirthday = new java.sql.Date(System.currentTimeMillis());
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
			
			String strAdmRight = req.getParameter("admRight");
			Integer admRight = null;
			try {
				admRight = Integer.valueOf(strAdmRight);
			} catch (NumberFormatException e) {
				errorMsgs.add("請選擇身分!");
			}
			
			//============接受請求參數==============================
			
			
			
			//============開始新增==============================
			try {
				
				AdministratorService_Interface admSvc = new AdministratorService();
				AdministratorVO adminVO = new AdministratorVO();

				
				
				adminVO.setAdmProfilePhoto(admProfilePhoto);
				adminVO.setAdmName(admName);
				adminVO.setAdmIdentity(admIdentity);
				adminVO.setAdmStatus(admStatus);
				adminVO.setAdmMail(admMail);
				adminVO.setAdmPassword(admPassword);
				adminVO.setAdmBirthday(admBirthday);
				adminVO.setAdmMobile(admMobile);
				adminVO.setAdmRight(admRight);
				

				// 調用新增方法

				System.out.println(adminVO);
				int addResult = admSvc.addAdmin(adminVO);
				
				System.out.println(addResult);
				if (addResult > 0) {
					// 返回成功信息
					Map<String, Object> response = new HashMap<>();
					response.put("status", "success");
					response.put("message", "管理员信息已成功更新。");
					
					Gson gson = new Gson();
					String json = gson.toJson(response);
					out.print(json);
					out.flush();
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
