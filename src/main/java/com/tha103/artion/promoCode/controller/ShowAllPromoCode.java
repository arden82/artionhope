package com.tha103.artion.promoCode.controller;

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
import com.tha103.artion.promoCode.model.PromoCodeVO;
import com.tha103.artion.promoCode.service.PromoCodeService;
import com.tha103.artion.promoCode.service.PromoCodeService_Interface;

@WebServlet("/showAllPromoCode")
public class ShowAllPromoCode extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setHeader("Access-Control-Allow-Origin", "*");

		PromoCodeService_Interface promoCodeSvc = new PromoCodeService();
		List<PromoCodeVO> promoCodeList = promoCodeSvc.getAllPromoCodes();

		List<Map<String, Object>> promoCodeMapList = new ArrayList<>();
		for (PromoCodeVO promoCode : promoCodeList) {
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

			promoCodeMapList.add(promoCodeMap);
		}
		Gson gson = new Gson();
		String json = gson.toJson(promoCodeMapList);

		PrintWriter out = res.getWriter();
		out.print(json); // 將JSON字串寫入響應
		out.flush();

	}

}
