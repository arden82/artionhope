package com.tha103.artion.seller.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.seller.service.SellerService;

@WebServlet("/getSelServlet")
public class GetSelServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//		res.setContentType("text/html; charset=UTF-8");
		res.setContentType("application/json; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		
		SellerService SellerSvc = new SellerService();
		List<SellerVO> SellerList = SellerSvc.getAll();

//		System.out.println(actComList);

		// 將ActVO列表轉換為Map列表
		List<Map<String, Object>> SellerMapList = new ArrayList<>();
		for (SellerVO seller : SellerList) {
			Map<String, Object> SellerMap = new HashMap<>();
//			SellerMap.put("selId", seller.getSelId());
//			SellerMap.put("selAcc", seller.getSelAccount());
//			SellerMap.put("selPass", seller.getSelPassword());
			SellerMap.put("selName", seller.getSelName());
//			SellerMap.put("selPhone", seller.getSelPhone());
//			SellerMap.put("selAdd", seller.getSelAddress());
//			SellerMap.put("selUrl", seller.getSelUrl());
//			SellerMap.put("selFB", seller.getSelFacebook());
//			SellerMap.put("selConPer", seller.getSelContactPerson());
			SellerMap.put("selInfo", seller.getSelIntroduction());
//			SellerMap.put("selBankCode", seller.getSelBankCode());
//			SellerMap.put("selBankNumber", seller.getSelBankNumber());
//			SellerMap.put("selBankName", seller.getSelBankName());
//			SellerMap.put("selRemark", seller.getSelRemark());
//			SellerMap.put("selTitle", seller.getSelTitle());
//			SellerMap.put("selPrin", seller.getSelPrincipal());
//			SellerMap.put("selUniNum", seller.getSelUniformNumbers());
//			SellerMap.put("selResgister", seller.getSelRegisteredAddress());
			SellerMap.put("selPhoto", seller.getSelProfilePicture());
//			SellerMap.put("selResTime", seller.getSelRegisterdTime());
//			SellerMap.put("selLastTime", seller.getSelLastModifiedTime());
//			SellerMap.put("selStatus", seller.getSelStatus());
//			SellerMap.put("actId", seller.getActivitys().getClass());
			
//			
			SellerMapList.add(SellerMap);
		}
		
		
		
		Gson gson = new GsonBuilder().create();
//		Gson gson = new Gson();
		String json = gson.toJson(SellerMapList);

//		PrintWriter out = res.getWriter();
		out.print(json); // 將JSON字串寫入響應
		out.flush();

	}

}
