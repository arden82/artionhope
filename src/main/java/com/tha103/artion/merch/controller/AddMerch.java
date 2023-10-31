package com.tha103.artion.merch.controller;

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
import com.tha103.artion.merch.model.MerchVO;
import com.tha103.artion.merch.service.MerchService;
import com.tha103.artion.merch.service.MerchService_Interface;

@WebServlet("/addMerch")
@MultipartConfig
public class AddMerch extends HttpServlet {
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
			// =============接受請求參數===============================

			String merchName = req.getParameter("merchName");

			String strMerchTotal = req.getParameter("merchTotal");
			Integer merchTotal = null;
			try {
				merchTotal = Integer.valueOf(strMerchTotal);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String strMerchPrice = req.getParameter("merchPrice");
			Integer merchPrice = null;
			try {
				merchPrice = Integer.valueOf(strMerchPrice);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String strMerchSort = req.getParameter("merchSort");
			Integer merchSort = null;
			try {
				merchSort = Integer.valueOf(strMerchSort);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String strMerchStartTime = req.getParameter("merchStartTime");
			java.sql.Timestamp merchStartTime = null;
			try {
				merchStartTime = java.sql.Timestamp.valueOf(strMerchStartTime);
			} catch (IllegalArgumentException e) {
				merchStartTime = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入有效日期!");
			}

			String strMerchEndTime = req.getParameter("merchEndTime");
			java.sql.Timestamp merchEndTime = null;
			try {
				merchEndTime = java.sql.Timestamp.valueOf(strMerchEndTime);
			} catch (IllegalArgumentException e) {
				merchEndTime = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入有效日期!");
			}

			String merchIntroduction = req.getParameter("merchIntroduction");

			String strMerchSellAmount = req.getParameter("merchSellAmount");
			Integer merchSellAmount = null;
			try {
				merchSellAmount = Integer.valueOf(strMerchSellAmount);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String strMerchStatus = req.getParameter("merchStatus");
			Integer merchStatus = null;
			try {
				merchStatus = Integer.valueOf(strMerchStatus);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 獲取圖片上傳的部分

			Part part1 = req.getPart("merchPicture1");
			Part part2 = req.getPart("merchPicture2");
			Part part3 = req.getPart("merchPicture3");
			Part part4 = req.getPart("merchPicture4");

			byte[] merchPicture1 = null;
			byte[] merchPicture2 = null;
			byte[] merchPicture3 = null;
			byte[] merchPicture4 = null;

			if (part1 != null && part1.getSize() > 0) {
				InputStream in = part1.getInputStream();
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;

				while ((len = in.read(buf)) != -1) {
					byteArrayOutputStream.write(buf, 0, len);
				}

				merchPicture1 = byteArrayOutputStream.toByteArray();
			}

			if (part2 != null && part2.getSize() > 0) {
				InputStream in = part2.getInputStream();
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;

				while ((len = in.read(buf)) != -1) {
					byteArrayOutputStream.write(buf, 0, len);
				}

				merchPicture2 = byteArrayOutputStream.toByteArray();
			}

			if (part3 != null && part3.getSize() > 0) {
				InputStream in = part3.getInputStream();
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;

				while ((len = in.read(buf)) != -1) {
					byteArrayOutputStream.write(buf, 0, len);
				}

				merchPicture3 = byteArrayOutputStream.toByteArray();
			}

			if (part4 != null && part4.getSize() > 0) {
				InputStream in = part4.getInputStream();
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;

				while ((len = in.read(buf)) != -1) {
					byteArrayOutputStream.write(buf, 0, len);
				}

				merchPicture4 = byteArrayOutputStream.toByteArray();
			}
			// ============接受請求參數==============================

			// ============開始新增==============================
			try {

				MerchService_Interface merchSvc = new MerchService();
				MerchVO merchVO = new MerchVO();

				merchVO.setMerchName(merchName);
				merchVO.setMerchTotal(merchTotal);
				merchVO.setMerchPrice(merchPrice);
				merchVO.setMerchSort(merchSort);
				merchVO.setMerchStartTime(merchStartTime);
				merchVO.setMerchEndTime(merchEndTime);
				merchVO.setMerchIntroduction(merchIntroduction);
				merchVO.setMerchSellAmount(merchSellAmount);
				merchVO.setMerchStatus(merchStatus);
				merchVO.setMerchPicture1(merchPicture1);
				merchVO.setMerchPicture2(merchPicture2);
				merchVO.setMerchPicture3(merchPicture3);
				merchVO.setMerchPicture4(merchPicture4);

				// 調用新增方法

				int addResult = merchSvc.addMerch(merchVO);

				if (addResult > 0) {
					Map<String, Object> response = new HashMap<>();
					response.put("status", "success");
					response.put("message", "已成功新增。");

					Gson gson = new Gson();
					String json = gson.toJson(response);
					out.print(json);
					out.flush();
				} else {
					// 返回错误信息
					Map<String, Object> response = new HashMap<>();
					response.put("status", "error");
					response.put("message", "新增失败。");
					out.write(new Gson().toJson(response));
				}

			} catch (Exception e) {
				Map<String, Object> response = new HashMap<>();
				response.put("status", "error");
				response.put("message", "无效的 ID 参数.");
				out.write(new Gson().toJson(response));
			}
		}else {
			res.sendRedirect(req.getContextPath() + "/admin/signin.html");
			return;
		}

		

	}

}
