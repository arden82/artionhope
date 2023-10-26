package com.tha103.artion.promoCode.controller;

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
import com.tha103.artion.merch.model.MerchVO;
import com.tha103.artion.merch.service.MerchService;
import com.tha103.artion.merch.service.MerchService_Interface;
import com.tha103.artion.promoCode.model.PromoCodeVO;
import com.tha103.artion.promoCode.service.PromoCodeService;
import com.tha103.artion.promoCode.service.PromoCodeService_Interface;

@WebServlet("/showOnePromoCode")
public class ShowOnePromoCode extends HttpServlet{
	
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

		String str = req.getParameter("promoCodeId");

		System.out.println(str);

		if (str != null && !str.isEmpty()) {
			Integer promoCodeId = Integer.valueOf(str);
			PromoCodeService_Interface promoCodeSvc = new PromoCodeService();
			PromoCodeVO promoCode = promoCodeSvc.getByPromoCodeId(promoCodeId);

			Gson gson = new Gson();

			if (promoCode != null) {

				Map<String, Object> promoCodeMap = convertpromoCodeToMap(promoCode);
				String merchJson = gson.toJson(promoCodeMap);

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

	public Map<String, Object> convertpromoCodeToMap(PromoCodeVO promoCode) {
		Map<String, Object> promoCodeMap = new HashMap<>();
		promoCodeMap.put("promoCodeId", promoCode.getProCodeId());
		promoCodeMap.put("promoCodeName", promoCode.getProCodeName());
		promoCodeMap.put("promoCodeCode", promoCode.getProCodeCode());
		promoCodeMap.put("proCodeType", promoCode.getProCodeType());
		promoCodeMap.put("proCodeValue", promoCode.getProCodeValue());
		promoCodeMap.put("proCodeStartDate", promoCode.getProCodeStartDate());
		promoCodeMap.put("proCodeEndDate", promoCode.getProCodeEndDate());
		promoCodeMap.put("proCodeActType", promoCode.getProCodeActType());
		promoCodeMap.put("proCodeTotal", promoCode.getProCodeTotal());
		promoCodeMap.put("proCodeStatus", promoCode.getProCodeStatus());
		promoCodeMap.put("proCodeDescribe", promoCode.getProCodeDescribe());
		promoCodeMap.put("memLevLevel", promoCode.getMemLevLevel().getMemLevLevel());

		return promoCodeMap;
	}

}
