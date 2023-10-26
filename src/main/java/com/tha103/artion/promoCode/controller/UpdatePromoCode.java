package com.tha103.artion.promoCode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.tha103.artion.memberLevel.model.MemberLevelVO;
import com.tha103.artion.promoCode.model.PromoCodeVO;
import com.tha103.artion.promoCode.service.PromoCodeService;
import com.tha103.artion.promoCode.service.PromoCodeService_Interface;

@WebServlet("/updatePromoCode")
public class UpdatePromoCode extends HttpServlet{
	
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
		
		// =============接受請求參數===============================
		
		String strPromoCodeId = req.getParameter("promoCodeId");
		
		System.out.println(strPromoCodeId);
		
		String promoCodeName = req.getParameter("promoCodeName");
		
		String promoCodeCode = req.getParameter("promoCodeCode");
		
		String strProCodeType = req.getParameter("proCodeType");
		Integer proCodeType = null;
		try {
			proCodeType = Integer.valueOf(strProCodeType);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String proCodeValue = req.getParameter("proCodeValue");
		
		String strProCodeStartDate = req.getParameter("proCodeStartDate");
		java.sql.Date proCodeStartDate = null;
		try {
			proCodeStartDate = java.sql.Date.valueOf(strProCodeStartDate);
		} catch (IllegalArgumentException e) {
			proCodeStartDate = new java.sql.Date(System.currentTimeMillis());
			errorMsgs.add("請輸入有效日期!");
		}
		
		String strProCodeEndDate = req.getParameter("proCodeEndDate");
		java.sql.Date proCodeEndDate = null;
		try {
			proCodeEndDate = java.sql.Date.valueOf(strProCodeEndDate);
		} catch (IllegalArgumentException e) {
			proCodeEndDate = new java.sql.Date(System.currentTimeMillis());
			errorMsgs.add("請輸入有效日期!");
		}
		
		String strPoCodeActType = req.getParameter("proCodeActType");
		Integer proCodeActType = null;
		try {
			proCodeActType = Integer.valueOf(strPoCodeActType);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String strProCodeTotal = req.getParameter("proCodeTotal");
		Integer proCodeTotal = null;
		try {
			proCodeTotal = Integer.valueOf(strProCodeTotal);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String strProCodeStatus = req.getParameter("proCodeStatus");
		Integer proCodeStatus = null;
		try {
			proCodeStatus = Integer.valueOf(strProCodeStatus);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String proCodeDescribe = req.getParameter("proCodeDescribe");
		
		String strMemLevLevel = req.getParameter("memLevLevel");
		Integer memLevLevel = null;
		try {
			memLevLevel = Integer.valueOf(strMemLevLevel);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String StrAdmId = req.getParameter("strAdmId");
		
		// ============開始修改==============================
		try {
			
			Integer promoCodeId = Integer.valueOf(strPromoCodeId);
			Integer admId = Integer.valueOf(StrAdmId);

			PromoCodeService_Interface promoCodeSvc = new PromoCodeService();
			PromoCodeVO promoCodeVO = new PromoCodeVO();

			promoCodeVO.setProCodeName(promoCodeName);
			promoCodeVO.setProCodeCode(promoCodeCode);
			promoCodeVO.setProCodeType(proCodeType);
			promoCodeVO.setProCodeValue(proCodeValue);
			promoCodeVO.setProCodeStartDate(proCodeStartDate);
			promoCodeVO.setProCodeEndDate(proCodeEndDate);
			promoCodeVO.setProCodeActType(proCodeActType);
			promoCodeVO.setProCodeTotal(proCodeTotal);
			promoCodeVO.setProCodeStatus(proCodeStatus);
			promoCodeVO.setProCodeDescribe(proCodeDescribe);
			promoCodeVO.getMemLevLevel().setMemLevLevel(memLevLevel);
			promoCodeVO.getAdministrator().setAdmId(admId);
			
			
			//不修改
			promoCodeVO.setProCodeId(promoCodeSvc.getByPromoCodeId(promoCodeId).getProCodeId());

			// 調用更新方法

			int addResult = promoCodeSvc.updatePromoCode(promoCodeVO);
			
			System.out.println(addResult);

			if (addResult > 0) {
				Map<String, Object> response = new HashMap<>();
				response.put("status", "success");
				response.put("message", "已成功修改。");

				Gson gson = new Gson();
				String json = gson.toJson(response);
				out.print(json);
				out.flush();
			} else {
				// 返回错误信息
				Map<String, Object> response = new HashMap<>();
				response.put("status", "error");
				response.put("message", "修改失败。");
				out.write(new Gson().toJson(response));
			}

		} catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("status", "error");
			response.put("message", "无效的 ID 参数.");
			out.write(new Gson().toJson(response));
		}
		
		
	}

}
