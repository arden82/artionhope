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
import com.tha103.artion.activity.service.*;
import javax.servlet.annotation.MultipartConfig;
import javax.sql.DataSource;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

@WebServlet("/activity/activity.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ActivityServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action))

		{ // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

//			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("act_id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入活動編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/activity/sel_index.jsp");
				System.out.println("錯誤!!!");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer act_id = null;
			try {
				act_id = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("活動編號不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/activity/sel_index.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

//			/*************************** 2.開始查詢資料 *****************************************/
			ActivityService activitySvc = new ActivityService();
			ActivityVO activityVO = activitySvc.getOneActivity(act_id);
			if (activityVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/activity/sel_index.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

//			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("activityVO", activityVO); // 資料庫取出的empVO物件,存入req
			String url = "/activity/listOneActivity.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 ****************************************/
			Integer act_id = Integer.valueOf(req.getParameter("act_id"));
//
//			/*************************** 2.開始查詢資料 ****************************************/
			ActivityService activitySvc = new ActivityService();
			ActivityVO activityVO = activitySvc.getOneActivity(act_id);
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("activityVO", activityVO); // 資料庫取出的empVO物件,存入req
			String url = "/activity/update_seller_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}
//
//		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//			Integer sel_id = Integer.valueOf(req.getParameter("sel_id"));
//
//			String sel_account = req.getParameter("sel_account");
//			String sel_accountReg = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
//			if (sel_account == null || sel_account.trim().length() == 0) {
//				errorMsgs.add("帳號: 請勿空白");
//			} else if (!sel_account.trim().matches(sel_accountReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("帳號: 只能是email");
//			}
//
//			String sel_password = req.getParameter("sel_password");
//			String sel_passwordReg = "^[((a-zA-Z0-9)]{2,10}$";
//			if (sel_password == null || sel_password.trim().length() == 0) {
//				errorMsgs.add("密碼: 請勿空白");
//			} else if (!sel_password.trim().matches(sel_passwordReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("密碼: 只能是英文字母、數字,且長度必需在2到10之間");
//			}
//
//			String sel_name = req.getParameter("sel_name");
//			if (sel_name == null || sel_name.trim().length() == 0) {
//				errorMsgs.add("廠商名稱: 請勿空白");
//			}
//
//			String sel_phone = req.getParameter("sel_phone").trim();
//			if (sel_phone == null || sel_phone.trim().length() == 0) {
//				errorMsgs.add("電話請勿空白");
//			}
//
//			String sel_address = req.getParameter("sel_address").trim();
//			if (sel_address == null || sel_address.trim().length() == 0) {
//				errorMsgs.add("地址請勿空白");
//			}
//
//			String sel_url = req.getParameter("sel_url").trim();
//			if (sel_url == null || sel_url.trim().length() == 0) {
//				errorMsgs.add("官方網站請勿空白");
//			}
//
//			String sel_facebook = req.getParameter("sel_facebook").trim();
//			if (sel_facebook == null || sel_facebook.trim().length() == 0) {
//				errorMsgs.add("Facebook請勿空白");
//			}
//
//			String sel_contactPerson = req.getParameter("sel_contactPerson").trim();
//			if (sel_contactPerson == null || sel_contactPerson.trim().length() == 0) {
//				errorMsgs.add("單位連絡人");
//			}
//
//			String sel_introduction = req.getParameter("sel_introduction").trim();
//			if (sel_introduction == null || sel_introduction.trim().length() == 0) {
//				errorMsgs.add("廠商介紹請勿空白");
//			}
//
//			String sel_bankCode = req.getParameter("sel_bankCode").trim();
//			if (sel_bankCode == null || sel_bankCode.trim().length() == 0) {
//				errorMsgs.add("銀行代碼請勿空白");
//			}
//
//			String sel_bankNumber = req.getParameter("sel_bankNumber").trim();
//			if (sel_bankNumber == null || sel_bankNumber.trim().length() == 0) {
//				errorMsgs.add("銀行帳號請勿空白");
//			}
//
//			String sel_bankName = req.getParameter("sel_bankName").trim();
//			if (sel_bankName == null || sel_bankName.trim().length() == 0) {
//				errorMsgs.add("戶名請勿空白");
//			}
//
//			String sel_remark = req.getParameter("sel_remark").trim();
//
//			String sel_title = req.getParameter("sel_title").trim();
//			if (sel_title == null || sel_title.trim().length() == 0) {
//				errorMsgs.add("單位名稱請勿空白");
//			}
//
//			String sel_principal = req.getParameter("sel_principal").trim();
//			if (sel_principal == null || sel_principal.trim().length() == 0) {
//				errorMsgs.add("單位負責人請勿空白");
//			}
//
//			String sel_uniformNumbers = req.getParameter("sel_uniformNumbers").trim();
//			if (sel_uniformNumbers == null || sel_uniformNumbers.trim().length() == 0) {
//				errorMsgs.add("統一編號請勿空白");
//			}
//
//			String sel_registeredAddress = req.getParameter("sel_registeredAddress").trim();
//			if (sel_registeredAddress == null || sel_registeredAddress.trim().length() == 0) {
//				errorMsgs.add("單位立案地址請勿空白");
//			}
//
//			Part newSelProfilePicture = req.getPart("newSelProfilePicture");
//			byte[] profilePhotoByte = null;
//			// 沒有選圖片也不會null而是空物件 與insert 處理方式不同(未選圖就抓原本的圖)
//			if (newSelProfilePicture != null && newSelProfilePicture.getSize() > 0) {
//				System.out.println("profilePhoto1," + newSelProfilePicture);
//				InputStream is = newSelProfilePicture.getInputStream();
//				ByteArrayOutputStream byteArros = new ByteArrayOutputStream();
//				byte[] buf = new byte[4 * 1024];
//				int len;
//				while ((len = is.read(buf)) != -1) {
//					byteArros.write(buf, 0, len);
//				}
//				profilePhotoByte = byteArros.toByteArray();
//				byteArros.close();
//			} else {
//				SellerVO sellerVO = new SellerVO();
//				SellerService sellerSvc = new SellerService();
//				sellerVO = sellerSvc.getOneSeller(sel_id);
//				profilePhotoByte = sellerVO.getSel_profilePicture();// 抓原本舊圖
//			}
//
//			String sel_registerdTimeStr = req.getParameter("sel_registerdTime");
//			Timestamp sel_registerdTime = null;
//
//			if (sel_registerdTimeStr != null && !sel_registerdTimeStr.trim().isEmpty()) {
//				try {
//					sel_registerdTime = Timestamp.valueOf(sel_registerdTimeStr);
//				} catch (IllegalArgumentException e) {
//					errorMsgs.add("无效的时间戳格式");
//				}
//			} else {
//				errorMsgs.add("廠商註冊時間請勿空白");
//			}
//
//			Timestamp sel_lastModifiedTime = new Timestamp(System.currentTimeMillis());
//
//			String sel_status = req.getParameter("sel_status");
//			if (sel_status == null || sel_status.trim().length() == 0) {
//				sel_status = "1"; // 如果为空，则默认设置为 "1"
//			}
//			sel_status = sel_status.trim();
//
////				java.sql.Date hiredate = null;
////				try {
////					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
////				} catch (IllegalArgumentException e) {
////					hiredate=new java.sql.Date(System.currentTimeMillis());
////					errorMsgs.add("請輸入日期!");
////				}
//
////				Double sal = null;
////				try {
////					sal = Double.valueOf(req.getParameter("sal").trim());
////				} catch (NumberFormatException e) {
////					sal = 0.0;
////					errorMsgs.add("薪水請填數字.");
////				}
//
////				Double comm = null;
////				try {
////					comm = Double.valueOf(req.getParameter("comm").trim());
////				} catch (NumberFormatException e) {
////					comm = 0.0;
////					errorMsgs.add("獎金請填數字.");
////				}
//
////				Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());
//
//			SellerVO sellerVO = new SellerVO();
//			sellerVO.setSel_id(sel_id);
//			sellerVO.setSel_account(sel_account);
//			sellerVO.setSel_password(sel_password);
//			sellerVO.setSel_name(sel_name);
//			sellerVO.setSel_phone(sel_phone);
//			sellerVO.setSel_address(sel_address);
//			sellerVO.setSel_url(sel_url);
//			sellerVO.setSel_facebook(sel_facebook);
//			sellerVO.setSel_contactPerson(sel_contactPerson);
//			sellerVO.setSel_introduction(sel_introduction);
//			sellerVO.setSel_bankCode(sel_bankCode);
//			sellerVO.setSel_bankNumber(sel_bankNumber);
//			sellerVO.setSel_bankName(sel_bankName);
//			sellerVO.setSel_remark(sel_remark);
//			sellerVO.setSel_title(sel_title);
//			sellerVO.setSel_principal(sel_principal);
//			sellerVO.setSel_uniformNumbers(sel_uniformNumbers);
//			sellerVO.setSel_registeredAddress(sel_registeredAddress);
//
////			byte[] sel_profilePicture = byteArrayOutputStream.toByteArray();
//			sellerVO.setSel_profilePicture(profilePhotoByte);
//
//			sellerVO.setSel_registerdTime(sel_registerdTime);
//			sellerVO.setSel_lastModifiedTime(sel_lastModifiedTime);
//			sellerVO.setSel_status(sel_status);
//
//			// Send the use back to the form, if here were errors
//			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("sellerVO", sellerVO); // 含有輸入格式錯誤的empVO物件,也存入req
//				RequestDispatcher failureView = req.getRequestDispatcher("/seller/update_seller_input.jsp");
//				failureView.forward(req, res);
//				return; // 程式中斷
//			}
//
//			/*************************** 2.開始修改資料 *****************************************/
//			SellerService sellerSvc = new SellerService();
//			sellerVO = sellerSvc.updateSeller(sel_id, sel_account, sel_password, sel_name, sel_phone, sel_address,
//					sel_url, sel_facebook, sel_contactPerson, sel_introduction, sel_bankCode, sel_bankNumber,
//					sel_bankName, sel_remark, sel_title, sel_principal, sel_uniformNumbers, sel_registeredAddress,
//					profilePhotoByte, sel_registerdTime, sel_lastModifiedTime, sel_status);
//			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("sellerVO", sellerVO); // 使用更新后的卖家信息
//			String url = "/seller/listOneSeller.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);
//		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String act_name = req.getParameter("act_name");
			System.out.println(act_name);
			
			Integer act_ticketPrice = Integer.valueOf(req.getParameter("act_ticketPrice").trim());

			java.sql.Timestamp act_ticketStartTime = null;
			try {
				act_ticketStartTime = java.sql.Timestamp.valueOf(req.getParameter("act_ticketStartTime").trim());
			} catch (IllegalArgumentException e) {
				act_ticketStartTime = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
				System.out.println("1");
			}

			java.sql.Timestamp act_ticketEndTime = null;
			try {
				act_ticketEndTime = java.sql.Timestamp.valueOf(req.getParameter("act_ticketEndTime").trim());
			} catch (IllegalArgumentException e) {
				act_ticketEndTime = new java.sql.Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
				System.out.println("2");
			}

			Integer act_type = Integer.valueOf(req.getParameter("act_type").trim());

			java.sql.Date act_startDate = null;
			try {
				act_startDate = java.sql.Date.valueOf(req.getParameter("act_startDate").trim());
			} catch (IllegalArgumentException e) {
				act_startDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Date act_endDate = null;
			try {
				act_endDate = java.sql.Date.valueOf(req.getParameter("act_endDate").trim());
			} catch (IllegalArgumentException e) {
				act_endDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			java.sql.Time act_startTime = null;
			try {
				act_startTime = java.sql.Time.valueOf(req.getParameter("act_startTime").trim());
			} catch (IllegalArgumentException e) {
				
				errorMsgs.add("請輸入活動開始時間!");
			}

			java.sql.Time act_endTime = null;
			try {
				act_endTime = java.sql.Time.valueOf(req.getParameter("act_endTime").trim());
			} catch (IllegalArgumentException e) {
			
				errorMsgs.add("請輸入活動結束時間!");
			}

			String act_city = req.getParameter("act_city").trim();
			if (act_city == null || act_city.trim().length() == 0) {
				errorMsgs.add("縣市請勿空白");
			}

			String act_zone = req.getParameter("act_zone").trim();
			if (act_zone == null || act_zone.trim().length() == 0) {
				errorMsgs.add("鄉鎮區域請勿空白");
			}

			String act_address = req.getParameter("act_address").trim();
			if (act_address == null || act_address.trim().length() == 0) {
				errorMsgs.add("活動地址請勿空白");
			}

			String act_organization = req.getParameter("act_organization").trim();
			if (act_organization == null || act_organization.trim().length() == 0) {
				errorMsgs.add("主辦單位請勿空白");
			}

			String act_email = req.getParameter("act_email").trim();
			if (act_email == null || act_email.trim().length() == 0) {
				errorMsgs.add("email請勿空白");
			}

			String act_phone = req.getParameter("act_phone").trim();
			if (act_phone == null || act_phone.trim().length() == 0) {
				errorMsgs.add("連絡電話請勿空白");
			}

			Integer act_ticketTotal = Integer.valueOf(req.getParameter("act_ticketTotal").trim());

			String act_content = req.getParameter("act_content").trim();
			if (act_content == null || act_content.trim().length() == 0) {
				errorMsgs.add("票券總數");
			}

			Part part = req.getPart("act_coverPicture");
			InputStream in = part.getInputStream();

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			byte[] buf = new byte[4 * 1024]; // 4K buffer
			int len;
			while ((len = in.read(buf)) != -1) {
				byteArrayOutputStream.write(buf, 0, len);
			}

			Part part1 = req.getPart("act_picture1");
			InputStream in1 = part1.getInputStream();

			ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();

			byte[] buf1 = new byte[4 * 1024]; // 4K buffer
			int len1;
			while ((len1 = in1.read(buf1)) != -1) {
				byteArrayOutputStream1.write(buf1, 0, len1);
			}

			Part part2 = req.getPart("act_picture2");
			InputStream in2 = part2.getInputStream();

			ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();

			byte[] buf2 = new byte[4 * 1024]; // 4K buffer
			int len2;
			while ((len2 = in2.read(buf2)) != -1) {
				byteArrayOutputStream2.write(buf2, 0, len2);
			}

			Part part3 = req.getPart("act_picture3");
			InputStream in3 = part3.getInputStream();

			ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();

			byte[] buf3 = new byte[4 * 1024]; // 4K buffer
			int len3;
			while ((len3 = in3.read(buf3)) != -1) {
				byteArrayOutputStream3.write(buf3, 0, len3);
			}
			
			Timestamp act_lastModifiedTime = new Timestamp(System.currentTimeMillis());
	
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
			byte[] act_picture1 = byteArrayOutputStream.toByteArray();
			activityVO.setActPicture1(act_picture1);
			byte[] act_picture2 = byteArrayOutputStream.toByteArray();
			activityVO.setActPicture2(act_picture2);
			byte[] act_picture3 = byteArrayOutputStream.toByteArray();
			activityVO.setActPicture3(act_picture3);
			activityVO.setActLastModifiedTime(act_lastModifiedTime);
	

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
			activityVO = activitySvc.addActivity(act_name, act_ticketPrice, act_ticketStartTime, act_ticketEndTime,
					act_type, act_startDate, act_endDate, act_startTime, act_endTime, act_city, act_zone, act_address,
					act_organization, act_email, act_phone, act_ticketTotal, act_content, act_coverPicture,
					act_picture1, act_picture2, act_picture3, act_lastModifiedTime);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/activity/listAllActivity.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

		}
	}
}
