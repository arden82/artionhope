package com.tha103.artion.administrator.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.administrator.service.AdministratorService;

@WebServlet("/showAllAdmins")
public class ShowAllAdmins extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");

		res.setHeader("Access-Control-Allow-Origin", "*");
		
		AdministratorService adminService = new AdministratorService();
		List<AdministratorVO> adminList = adminService.getAllAdmins();


		// 將AdministratorVO列表轉換為Map列表
		List<Map<String, Object>> adminMapList = new ArrayList<>();
		for (AdministratorVO admin : adminList) {
			Map<String, Object> adminMap = new HashMap<>();
			adminMap.put("admId", admin.getAdmId());
			adminMap.put("admName", admin.getAdmName());
			adminMap.put("admIdentity", admin.getAdmIdentity());
			adminMap.put("admStatus", admin.getAdmStatus());
			adminMap.put("admMail", admin.getAdmMail());
			adminMap.put("admPassword", admin.getAdmPassword());
			adminMap.put("admBirthday", admin.getAdmBirthday());
			adminMap.put("admMobile", admin.getAdmMobile());
			adminMap.put("admAddTime", admin.getAdmAddTime());
			adminMap.put("admLastModifiedTime", admin.getAdmLastModifiedTime());
			adminMap.put("admProfilePhoto", admin.getAdmProfilePhoto());
			adminMap.put("admRight", admin.getAdmRight());
			
			// 將圖片轉換為Base64字符串
//			String base64Image = Base64.getEncoder().encodeToString(admin.getAdmProfilePhoto());
//            adminMap.put("admProfilePhoto", base64Image);

			
			adminMapList.add(adminMap);
		}

		Gson gson = new Gson();
		String json = gson.toJson(adminMapList);

		PrintWriter out = res.getWriter();
		out.print(json); // 將JSON字串寫入響應
		out.flush();
	}
	
}
