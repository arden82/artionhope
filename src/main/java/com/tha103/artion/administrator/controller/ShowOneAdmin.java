package com.tha103.artion.administrator.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.administrator.service.AdministratorService;

@WebServlet("/showOneAdmin")
public class ShowOneAdmin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		res.setHeader("Access-Control-Allow-Origin", "*");		

		PrintWriter out = res.getWriter();

		String str = req.getParameter("admId");

		System.out.println(str);

		if (str != null && !str.isEmpty()) {
			Integer admId = Integer.valueOf(str);
			AdministratorService adminService = new AdministratorService();
			AdministratorVO admin = adminService.getAdminByAdmId(admId);

			Gson gson = new Gson();

			if (admin != null) {

				Map<String, Object> adminMap = convertAdministratorToMap(admin);
				String adminJson = gson.toJson(adminMap);

				System.out.println(adminJson);

				out.print(adminJson); // 將JSON字串寫入響應
				out.flush();

			} else {
				String errorJson = gson.toJson("Admin not found");
				out.println(errorJson);
			}
		} else {
			// 处理空字符串的情况，例如返回错误消息
		}

	}

	public Map<String, Object> convertAdministratorToMap(AdministratorVO admin) {
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
		// 将其他管理员信息字段也添加到 adminMap 中

		return adminMap;
	}

}
