package com.tha103.artion.administrator.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet("/getalladmins")
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setHeader("Access-Control-Allow-Origin", "*");

		// 创建AdministratorService实例
		AdministratorService adminService = new AdministratorService();

		// 获取管理员数据
		List<AdministratorVO> adminList = adminService.getAllAdmins();

		// 将AdministratorVO列表转换为Map列表
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
			adminMap.put("admRight", admin.getAdmRight());
			// 添加其他属性...

			adminMapList.add(adminMap);
		}

		// 使用Gson库将Map列表转换为JSON字符串
		Gson gson = new Gson();
		String json = gson.toJson(adminMapList);

		// 发送JSON数据到前端
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
