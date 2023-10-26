package com.tha103.artion.merch.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.administrator.service.AdministratorService;
import com.tha103.artion.merch.model.MerchVO;
import com.tha103.artion.merch.service.MerchService;
import com.tha103.artion.merch.service.MerchService_Interface;

@WebServlet("/showOneMerch")
public class ShowOneMerch extends HttpServlet{

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

		String str = req.getParameter("merchId");

		System.out.println(str);

		if (str != null && !str.isEmpty()) {
			Integer merchId = Integer.valueOf(str);
			MerchService_Interface merchSvc = new MerchService();
			MerchVO Merch = merchSvc.getMerchByMerchId(merchId);

			Gson gson = new Gson();

			if (Merch != null) {

				Map<String, Object> merchMap = convertMerchToMap(Merch);
				String merchJson = gson.toJson(merchMap);

				System.out.println(merchJson);

				out.print(merchJson); // 將JSON字串寫入響應
				out.flush();

			} else {
				String errorJson = gson.toJson("Merch not found");
				out.println(errorJson);
			}
		} else {
			// 处理空字符串的情况，例如返回错误消息
		}

	}

	public Map<String, Object> convertMerchToMap(MerchVO merch) {
		Map<String, Object> merchMap = new HashMap<>();
		merchMap.put("merchId", merch.getMerchId());
		merchMap.put("merchPicture1", merch.getMerchPicture1());
		merchMap.put("merchPicture2", merch.getMerchPicture2());
		merchMap.put("merchPicture3", merch.getMerchPicture3());
		merchMap.put("merchPicture4", merch.getMerchPicture4());
		merchMap.put("merchName", merch.getMerchName());
		merchMap.put("merchTotal", merch.getMerchTotal());
		merchMap.put("merchPrice", merch.getMerchPrice());
		merchMap.put("merchSort", merch.getMerchSort());
		merchMap.put("merchStartTime", merch.getMerchStartTime());
		merchMap.put("merchEndTime", merch.getMerchEndTime());
		merchMap.put("merchIntroduction", merch.getMerchIntroduction());
		merchMap.put("merchSellAmount", merch.getMerchSellAmount());
		merchMap.put("merchStatus", merch.getMerchStatus());
		// 将其他管理员信息字段也添加到 adminMap 中

		return merchMap;
	}
	
}
