package com.tha103.artion.merch.controller;

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

import com.tha103.artion.merch.model.MerchVO;
import com.tha103.artion.merch.service.MerchService;
import com.tha103.artion.merch.service.MerchService_Interface;

@WebServlet("/showAllMerches")
public class ShowAllMerches extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");

		res.setHeader("Access-Control-Allow-Origin", "*");
		
		MerchService_Interface merchSvc = new MerchService();
		List<MerchVO> merchList = merchSvc.getAllMerches();


		
		List<Map<String, Object>> merchMapList = new ArrayList<>();
		for (MerchVO merch : merchList) {
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
			


			
			merchMapList.add(merchMap);
		}

		Gson gson = new Gson();
		String json = gson.toJson(merchMapList);

		PrintWriter out = res.getWriter();
		out.print(json); // 將JSON字串寫入響應
		out.flush();
		
		
		
	}

}
