package com.tha103.artion.activity.controller;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mysql.cj.util.Util;
import com.tha103.artion.activity.model.*;
import com.tha103.artion.activity.service.ActivityService;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.seller.model.SellerVO;
import javax.sql.DataSource;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

@WebServlet("/activity/ActivityServlet.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ActivityServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		HttpSession session = req.getSession();
		Integer sel_id = (Integer) session.getAttribute("sel_id");

		System.out.println(sel_id);

		if (sel_id == null) {
			// 如果 selId 不存在，則執行您的錯誤處理邏輯
			// TODO 執行登入
		}

		if (null == action) {
			String url = "/seller/sel_index.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
			return;
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String act_name = req.getParameter("actName");
			System.out.println(act_name);

			String actTicketPriceParam = req.getParameter("actTicketPrice");
			Integer act_ticketPrice = null;

			if (actTicketPriceParam != null && !actTicketPriceParam.isEmpty()) {
				act_ticketPrice = Integer.valueOf(actTicketPriceParam);
			}

			java.sql.Date act_ticketStartTime = null;
			try {
				act_ticketStartTime = java.sql.Date.valueOf(req.getParameter("actTicketStartTime").trim());
			} catch (IllegalArgumentException e) {
				act_ticketStartTime = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
				System.out.println("1");
			}

			java.sql.Date act_ticketEndTime = null;
			try {
				act_ticketEndTime = java.sql.Date.valueOf(req.getParameter("actTicketEndTime").trim());
			} catch (IllegalArgumentException e) {
				act_ticketEndTime = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
				System.out.println("2");
			}

			Integer act_type = Integer.valueOf(req.getParameter("actType").trim());

			java.sql.Date act_startDate = null;
			try {
				act_startDate = java.sql.Date.valueOf(req.getParameter("actStartDate").trim());
			} catch (IllegalArgumentException e) {
				act_startDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Date act_endDate = null;
			try {
				act_endDate = java.sql.Date.valueOf(req.getParameter("actEndDate").trim());
			} catch (IllegalArgumentException e) {
				act_endDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Time act_startTime = null;
			try {
				act_startTime = java.sql.Time.valueOf(req.getParameter("actStartTime").trim());
			} catch (IllegalArgumentException e) {

				errorMsgs.add("請輸入活動開始時間!");
			}

			java.sql.Time act_endTime = null;
			try {
				act_endTime = java.sql.Time.valueOf(req.getParameter("actEndTime").trim());
			} catch (IllegalArgumentException e) {

				errorMsgs.add("請輸入活動結束時間!");
			}

			String act_city = req.getParameter("actCity").trim();
			if (act_city == null || act_city.trim().length() == 0) {
				errorMsgs.add("縣市請勿空白");
			}

			String act_zone = req.getParameter("actZone").trim();
			if (act_zone == null || act_zone.trim().length() == 0) {
				errorMsgs.add("鄉鎮區域請勿空白");
			}

			String act_address = req.getParameter("actAddress").trim();
			if (act_address == null || act_address.trim().length() == 0) {
				errorMsgs.add("活動地址請勿空白");
			}

			String act_organization = req.getParameter("actOrganization").trim();
			if (act_organization == null || act_organization.trim().length() == 0) {
				errorMsgs.add("主辦單位請勿空白");
			}

			String act_email = req.getParameter("actEmail").trim();
			if (act_email == null || act_email.trim().length() == 0) {
				errorMsgs.add("email請勿空白");
			}

			String act_phone = req.getParameter("actPhone").trim();
			if (act_phone == null || act_phone.trim().length() == 0) {
				errorMsgs.add("連絡電話請勿空白");
			}

			int act_ticketTotal = 0; // 在這裡聲明變量

			   try {
			       // 從請求中獲取參數，去除首尾空格，並嘗試將其轉換為整數
			       String actTicketTotalParam = req.getParameter("actTicketTotal").trim();
			       act_ticketTotal = Integer.parseInt(actTicketTotalParam); // 在這裡使用變量

			       // ... 使用轉換後的數字進行後續操作 ...

			   } catch (NumberFormatException e) {
			       // 輸入的字符串不是一個有效的整數，進行錯誤處理
			       System.err.println("票卷總數輸入錯誤");
			   }

			String act_content = req.getParameter("actContent");
			if (act_content != null && !act_content.trim().isEmpty()) {
				// 执行您的逻辑，例如存储或处理 act_content
			} else {
				errorMsgs.add("活動內容");
			}

			Part part = req.getPart("actCoverPicture");
			InputStream in = part.getInputStream();

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			byte[] buf = new byte[4 * 1024]; // 4K buffer
			int len;
			while ((len = in.read(buf)) != -1) {
				byteArrayOutputStream.write(buf, 0, len);
			}

			ActivityVO activityVO = new ActivityVO();

			activityVO.setActName(act_name);
			activityVO.setActTicketPrice(act_ticketPrice);
			activityVO.setActTicketStartTime(act_ticketStartTime);
			activityVO.setActTicketEndTime(act_ticketEndTime);
			activityVO.setActType(act_type);
			activityVO.setActStartDate(act_startDate);
			activityVO.setActEndDate(act_endDate);
			activityVO.setActStartTime(act_startTime);
			activityVO.setActEndTime(act_endTime);
			activityVO.setActCity(act_city);
			activityVO.setActZone(act_zone);
			activityVO.setActAddress(act_address);
			activityVO.setActOrganization(act_organization);
			activityVO.setActEmail(act_email);
			activityVO.setActPhone(act_phone);
			activityVO.setActTicketTotal(act_ticketTotal);
			activityVO.setActContent(act_content);
			byte[] act_coverPicture = byteArrayOutputStream.toByteArray();
			activityVO.setActCoverPicture(act_coverPicture);
//			byte[] act_picture1 = byteArrayOutputStream.toByteArray();
//			activityVO.setActPicture1(act_picture1);
//			byte[] act_picture2 = byteArrayOutputStream.toByteArray();
//			activityVO.setActPicture2(act_picture2);
//			byte[] act_picture3 = byteArrayOutputStream.toByteArray();
//			activityVO.setActPicture3(act_picture3);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("activityVO", activityVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/activity/sel_actadd.jsp");
				failureView.forward(req, res);
				System.out.println("1");
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ActivityService activitySvc = new ActivityService();
			activityVO = activitySvc.addActivity( act_name,  act_ticketPrice,  act_ticketStartTime,
					 act_ticketEndTime, act_type, act_startDate, act_endDate, act_startTime,
					 act_endTime, act_city, act_zone, act_address, act_organization,
					 act_email, act_phone, act_ticketTotal, act_content, 
				    sel_id, act_coverPicture);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/activity/sel_index.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
			return;
		}
		
		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer actId = new Integer(req.getParameter("actId"));
				
				/***************************2.�}�l�R�����***************************************/
				ActivityService ActivitySvc = new ActivityService();
				ActivitySvc.delete(actId);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/activity/sel_index.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法刪除:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/activity/sel_index.jsp");
				failureView.forward(req, res);
			}
		}

//		if ("getOne_For_Display".equals(action))
//
//		{ // 來自select_page.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
////			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//			String str = req.getParameter("actId");
//			if (str == null || (str.trim()).length() == 0) {
//				errorMsgs.add("請輸入活動編號");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/activity/sel_actadd.jsp");
//				System.out.println("錯誤!!!");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}
//
//			Integer act_id = null;
//			try {
//				act_id = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.add("活動編號不正確");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/activity/sel_index.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}
//
////			/*************************** 2.開始查詢資料 *****************************************/
//			ActivityService activitySvc = new ActivityService();
//			ActivityVO activityVO = activitySvc.getOneActivity(act_id);
//			if (activityVO == null) {
//				errorMsgs.add("查無資料");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/activity/sel_actadd.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}
//
////			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("activityVO", activityVO); // 資料庫取出的empVO物件,存入req
//			String url = "/activity/sel_index.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//			successView.forward(req, res);
//		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 ****************************************/
			Integer act_id = Integer.valueOf(req.getParameter("actId"));
//
//			/*************************** 2.開始查詢資料 ****************************************/
			ActivityService activitySvc = new ActivityService();
			ActivityVO activityVO = activitySvc.getOneActivity(act_id);
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("activityVO", activityVO); // 資料庫取出的empVO物件,存入req
			String url = "/activity/sel_actrevise.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}
//
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer act_id = Integer.valueOf(req.getParameter("actId").trim());
			
			String act_name = req.getParameter("actName");
			System.out.println(act_name);

			String actTicketPriceParam = req.getParameter("actTicketPrice");
			Integer act_ticketPrice = null;

			if (actTicketPriceParam != null && !actTicketPriceParam.isEmpty()) {
				act_ticketPrice = Integer.valueOf(actTicketPriceParam);
			}

			java.sql.Date act_ticketStartTime = null;
			try {
				act_ticketStartTime = java.sql.Date.valueOf(req.getParameter("actTicketStartTime").trim());
			} catch (IllegalArgumentException e) {
				act_ticketStartTime = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
				System.out.println("1");
			}

			java.sql.Date act_ticketEndTime = null;
			try {
				act_ticketEndTime = java.sql.Date.valueOf(req.getParameter("actTicketEndTime").trim());
			} catch (IllegalArgumentException e) {
				act_ticketEndTime = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
				System.out.println("2");
			}

			Integer act_type = Integer.valueOf(req.getParameter("actType").trim());
			

			java.sql.Date act_startDate = null;
			try {
				act_startDate = java.sql.Date.valueOf(req.getParameter("actStartDate").trim());
			} catch (IllegalArgumentException e) {
				act_startDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Date act_endDate = null;
			try {
				act_endDate = java.sql.Date.valueOf(req.getParameter("actEndDate").trim());
			} catch (IllegalArgumentException e) {
				act_endDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Time act_startTime = null;
			try {
				act_startTime = java.sql.Time.valueOf(req.getParameter("actStartTime").trim());
			} catch (IllegalArgumentException e) {

				errorMsgs.add("請輸入活動開始時間!");
			}

			java.sql.Time act_endTime = null;
			try {
				act_endTime = java.sql.Time.valueOf(req.getParameter("actEndTime").trim());
			} catch (IllegalArgumentException e) {

				errorMsgs.add("請輸入活動結束時間!");
			}

			String act_city = req.getParameter("actCity").trim();
			if (act_city == null || act_city.trim().length() == 0) {
				errorMsgs.add("縣市請勿空白");
			}

			String act_zone = req.getParameter("actZone").trim();
			if (act_zone == null || act_zone.trim().length() == 0) {
				errorMsgs.add("鄉鎮區域請勿空白");
			}

			String act_address = req.getParameter("actAddress").trim();
			if (act_address == null || act_address.trim().length() == 0) {
				errorMsgs.add("活動地址請勿空白");
			}

			String act_organization = req.getParameter("actOrganization").trim();
			if (act_organization == null || act_organization.trim().length() == 0) {
				errorMsgs.add("主辦單位請勿空白");
			}

			String act_email = req.getParameter("actEmail").trim();
			if (act_email == null || act_email.trim().length() == 0) {
				errorMsgs.add("email請勿空白");
			}

			String act_phone = req.getParameter("actPhone").trim();
			if (act_phone == null || act_phone.trim().length() == 0) {
				errorMsgs.add("連絡電話請勿空白");
			}

			Integer act_ticketTotal = Integer.valueOf(req.getParameter("actTicketTotal").trim());

			String act_content = req.getParameter("actContent");
			if (act_content != null && !act_content.trim().isEmpty()) {
				// 执行您的逻辑，例如存储或处理 act_content
			} else {
				errorMsgs.add("活動內容");
			}

			Part newSelProfilePicture = req.getPart("actCoverPicture");
			byte[] profilePhotoByte = null;

			// 检查是否上传了新图片
			if (newSelProfilePicture != null && newSelProfilePicture.getSize() > 0) {
			    // 处理上传的新图片
			    InputStream is = newSelProfilePicture.getInputStream();
			    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			    byte[] buffer = new byte[4096];
			    int bytesRead;
			    while ((bytesRead = is.read(buffer)) != -1) {
			        byteArrayOutputStream.write(buffer, 0, bytesRead);
			    }
			    profilePhotoByte = byteArrayOutputStream.toByteArray();
			    byteArrayOutputStream.close();
			} else {
			    // 如果没有上传新图片，则使用原有图片
			    ActivityService activitySvc = new ActivityService();
			    ActivityVO activityVO = activitySvc.getOneActivity(act_id);
			    profilePhotoByte = activityVO.getActCoverPicture();
			}
			
			ActivityVO activityVO = new ActivityVO();

			activityVO.setActName(act_name);
			activityVO.setActTicketPrice(act_ticketPrice);
			activityVO.setActTicketStartTime(act_ticketStartTime);
			activityVO.setActTicketEndTime(act_ticketEndTime);
			activityVO.setActType(act_type);
			activityVO.setActStartDate(act_startDate);
			activityVO.setActEndDate(act_endDate);
			activityVO.setActStartTime(act_startTime);
			activityVO.setActEndTime(act_endTime);
			activityVO.setActCity(act_city);
			activityVO.setActZone(act_zone);
			activityVO.setActAddress(act_address);
			activityVO.setActOrganization(act_organization);
			activityVO.setActEmail(act_email);
			activityVO.setActPhone(act_phone);
			activityVO.setActTicketTotal(act_ticketTotal);
			activityVO.setActContent(act_content);
			
//			byte[] newSelProfilePicture = byteArrayOutputStream.toByteArray();
			activityVO.setActCoverPicture(profilePhotoByte);
			
//			byte[] act_picture1 = byteArrayOutputStream.toByteArray();
//			activityVO.setActPicture1(act_picture1);
//			byte[] act_picture2 = byteArrayOutputStream.toByteArray();
//			activityVO.setActPicture2(act_picture2);
//			byte[] act_picture3 = byteArrayOutputStream.toByteArray();
//			activityVO.setActPicture3(act_picture3);


			// Send the use back to the form, if here were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("activityVO", activityVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/activity/sel_index.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			ActivityService activitySvc = new ActivityService();
			activityVO = activitySvc.updateActivity(act_id, act_name, act_ticketPrice, act_ticketStartTime,
					act_ticketEndTime, act_type, act_startDate, act_endDate, act_startTime,
					act_endTime, act_city, act_zone, act_address, act_organization,
					act_email, act_phone, act_ticketTotal, act_content, profilePhotoByte);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("activityVO", activityVO); // 使用更新后的卖家信息
			String url = "/activity/sel_index.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
	
	}
}
