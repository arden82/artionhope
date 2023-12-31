package com.tha103.artion.seller.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.tha103.artion.seller.service.SellerService;
import com.tha103.artion.seller.model.SellerVO;

@WebServlet("/seller/SellerServlet.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class SellerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

//		if ("getOne_For_Display".equals(action))
//
//		{ // 來自select_page.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);

//			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//			String str = req.getParameter("sel_id");
//			if (str == null || (str.trim()).length() == 0) {
//				errorMsgs.add("請輸入廠商編號");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/seller/select_page.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}
//
//			Integer sel_id = null;
//			try {
//				sel_id = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.add("廠商格式不正確");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/seller/select_page.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}

//			/*************************** 2.開始查詢資料 *****************************************/
//			SellerService sellerSvc = new SellerService();
//			SellerVO sellerVO = sellerSvc.getOneSeller(sel_id);
//			if (sellerVO == null) {
//				errorMsgs.add("查無資料");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/seller/select_page.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}

//			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("sellerVO", sellerVO); // 資料庫取出的empVO物件,存入req
//			String url = "/seller/listOneSeller.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//			successView.forward(req, res);
//		}
//
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

//			/*************************** 1.接收請求參數 ****************************************/
			Integer sel_id = Integer.valueOf(req.getParameter("selId"));
			
//			/*************************** 2.開始查詢資料 ****************************************/
			SellerService sellerSvc = new SellerService();
			SellerVO sellerVO = sellerSvc.getOneSeller(sel_id);
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("sellerVO", sellerVO); // 資料庫取出的empVO物件,存入req
			String url = "/seller/sel_profileRevise.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}
//
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

//			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer sel_id = Integer.valueOf(req.getParameter("selId"));

			String sel_account = req.getParameter("selAccount");
			String sel_accountReg = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
			if (sel_account == null || sel_account.trim().length() == 0) {
				errorMsgs.add("帳號: 請勿空白");
			} else if (!sel_account.trim().matches(sel_accountReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("帳號: 只能是email");
			}

			String sel_password = req.getParameter("selPassword");
			String sel_passwordReg = "^[((a-zA-Z0-9)]{2,10}$";
			if (sel_password == null || sel_password.trim().length() == 0) {
				errorMsgs.add("密碼: 請勿空白");
			} else if (!sel_password.trim().matches(sel_passwordReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("密碼: 只能是英文字母、數字,且長度必需在2到10之間");
			}

			String sel_name = req.getParameter("selName");
			if (sel_name == null || sel_name.trim().length() == 0) {
				errorMsgs.add("廠商名稱: 請勿空白");
			}

			String sel_phone = req.getParameter("selPhone").trim();
			if (sel_phone == null || sel_phone.trim().length() == 0) {
				errorMsgs.add("電話請勿空白");
			}

			String sel_address = req.getParameter("selAddress").trim();
			if (sel_address == null || sel_address.trim().length() == 0) {
				errorMsgs.add("地址請勿空白");
			}

			String sel_url = req.getParameter("selUrl").trim();
			if (sel_url == null || sel_url.trim().length() == 0) {
				errorMsgs.add("官方網站請勿空白");
			}

			String sel_facebook = req.getParameter("selFacebook");
			if (sel_facebook != null && sel_facebook.trim().length() == 0) {
			    errorMsgs.add("Facebook請勿空白");
			}

			String sel_contactPerson = req.getParameter("selContactPerson").trim();
			if (sel_contactPerson == null || sel_contactPerson.trim().length() == 0) {
				errorMsgs.add("單位連絡人");
			}

			String sel_introduction = req.getParameter("selIntroduction").trim();
			if (sel_introduction == null || sel_introduction.trim().length() == 0) {
				errorMsgs.add("廠商介紹請勿空白");
			}

			String sel_bankCode = req.getParameter("selBankCode");
			if (sel_bankCode == null || sel_bankCode.trim().length() == 0) {
				errorMsgs.add("銀行代碼請勿空白");
			}

			String sel_bankNumber = req.getParameter("selBankNumber").trim();
			if (sel_bankNumber == null || sel_bankNumber.trim().length() == 0) {
				errorMsgs.add("銀行帳號請勿空白");
			}

			String sel_bankName = req.getParameter("selBankName").trim();
			if (sel_bankName == null || sel_bankName.trim().length() == 0) {
				errorMsgs.add("戶名請勿空白");
			}

			String sel_remark = req.getParameter("selRemark").trim();

			String sel_title = req.getParameter("selTitle").trim();
			if (sel_title == null || sel_title.trim().length() == 0) {
				errorMsgs.add("單位名稱請勿空白");
			}

			String sel_principal = req.getParameter("selPrincipal").trim();
			if (sel_principal == null || sel_principal.trim().length() == 0) {
				errorMsgs.add("單位負責人請勿空白");
			}

			String sel_uniformNumbers = req.getParameter("selUniformNumbers").trim();
			if (sel_uniformNumbers == null || sel_uniformNumbers.trim().length() == 0) {
				errorMsgs.add("統一編號請勿空白");
			}

			String sel_registeredAddress = req.getParameter("selRegisteredAddress").trim();
			if (sel_registeredAddress == null || sel_registeredAddress.trim().length() == 0) {
				errorMsgs.add("單位立案地址請勿空白");
			}

			Part newSelProfilePicture = req.getPart("newSelProfilePicture");
			byte[] profilePhotoByte = null;
			// 沒有選圖片也不會null而是空物件 與insert 處理方式不同(未選圖就抓原本的圖)
			if (newSelProfilePicture != null && newSelProfilePicture.getSize() > 0) {
				System.out.println("profilePhoto1," + newSelProfilePicture);
				InputStream is = newSelProfilePicture.getInputStream();
				ByteArrayOutputStream byteArros = new ByteArrayOutputStream();
				byte[] buf = new byte[4 * 1024];
				int len;
				while ((len = is.read(buf)) != -1) {
					byteArros.write(buf, 0, len);
				}
				profilePhotoByte = byteArros.toByteArray();
				byteArros.close();
			} else {
				SellerVO sellerVO = new SellerVO();
				SellerService sellerSvc = new SellerService();
				sellerVO = sellerSvc.getOneSeller(sel_id);
				profilePhotoByte = sellerVO.getSelProfilePicture();// 抓原本舊圖
			}

//			String sel_registerdTimeStr = req.getParameter("selRegisterdTime");
//			Timestamp sel_registerdTime = null;

//			if (sel_registerdTimeStr != null && !sel_registerdTimeStr.trim().isEmpty()) {
//				try {
//					sel_registerdTime = Timestamp.valueOf(sel_registerdTimeStr);
//				} catch (IllegalArgumentException e) {
//					errorMsgs.add("无效的时间戳格式");
//				}
//			} else {
//				errorMsgs.add("廠商註冊時間請勿空白");
//			}

//			Timestamp sel_lastModifiedTime = new Timestamp(System.currentTimeMillis());

			
			SellerVO sellerVO = new SellerVO();
			sellerVO.setSelId(sel_id);
			sellerVO.setSelAccount(sel_account);
			sellerVO.setSelPassword(sel_password);
			sellerVO.setSelName(sel_name);
			sellerVO.setSelPhone(sel_phone);
			sellerVO.setSelAddress(sel_address);
			sellerVO.setSelUrl(sel_url);
			sellerVO.setSelFacebook(sel_facebook);
			sellerVO.setSelContactPerson(sel_contactPerson);
			sellerVO.setSelIntroduction(sel_introduction);
			sellerVO.setSelBankCode(sel_bankCode);
			sellerVO.setSelBankNumber(sel_bankNumber);
			sellerVO.setSelBankName(sel_bankName);
			sellerVO.setSelRemark(sel_remark);
			sellerVO.setSelTitle(sel_title);
			sellerVO.setSelPrincipal(sel_principal);
			sellerVO.setSelUniformNumbers(sel_uniformNumbers);
			sellerVO.setSelRegisteredAddress(sel_registeredAddress);

//			byte[] sel_profilePicture = byteArrayOutputStream.toByteArray();
//			sellerVO.setSelProfilePicture(profilePhotoByte);

//			sellerVO.setSelRegisterdTime(sel_registerdTime);
//			sellerVO.setSelLastModifiedTime(sel_lastModifiedTime);
//			sellerVO.setSelStatus(sel_status);

			// Send the use back to the form, if here were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("sellerVO", sellerVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/seller/sel_profileRevise.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
//
//			/*************************** 2.開始修改資料 *****************************************/
			SellerService sellerSvc = new SellerService();
			sellerVO = sellerSvc.updateSeller(sel_id, sel_account, sel_password, sel_name, sel_phone, sel_address,
					sel_url, sel_facebook, sel_contactPerson, sel_introduction, sel_bankCode, sel_bankNumber,
					sel_bankName, sel_remark, sel_title, sel_principal, sel_uniformNumbers, sel_registeredAddress
					, profilePhotoByte);
//			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("sellerVO", sellerVO); // 使用更新后的卖家信息
			String url = "/seller/sel_profile.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String sel_account = req.getParameter("selAccount");
			String sel_accountReg = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
			;
			if (sel_account == null || sel_account.trim().length() == 0) {
				errorMsgs.add("帳號: 請勿空白");
			} else if (!sel_account.trim().matches(sel_accountReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("帳號: 只能是email");
			}

			String sel_password = req.getParameter("selPassword");
			String sel_passwordReg = "^[((a-zA-Z0-9)]{2,10}$";
			if (sel_password == null || sel_password.trim().length() == 0) {
				errorMsgs.add("密碼: 請勿空白");
			} else if (!sel_password.trim().matches(sel_passwordReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("密碼: 只能是英文字母、數字,且長度必需在2到10之間");
			}

			String sel_name = req.getParameter("selName");
//			String sel_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (sel_name == null || sel_name.trim().length() == 0) {
				errorMsgs.add("廠商名稱: 請勿空白");
//			} else if(!sel_name.trim().matches(sel_nameReg)) { //以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("廠商名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String sel_phone = req.getParameter("selPhone");
			if (sel_phone != null && sel_phone.trim().length() == 0) {
			    errorMsgs.add("電話請勿空白");
			}

			String sel_address = req.getParameter("selAddress");
			if (sel_address == null || sel_address.trim().length() == 0) {
				errorMsgs.add("地址請勿空白");
			}

			String sel_url = req.getParameter("selUrl");
			if (sel_url == null || sel_url.trim().length() == 0) {
				errorMsgs.add("官方網站請勿空白");
			}

			String sel_facebook = req.getParameter("selFacebook");
			if (sel_facebook == null || sel_facebook.trim().length() == 0) {
				errorMsgs.add("Facebook請勿空白");
			}

			String sel_contactPerson = req.getParameter("selContactPerson");
			if (sel_contactPerson == null || sel_contactPerson.trim().length() == 0) {
				errorMsgs.add("單位連絡人");
			}

			String sel_introduction = req.getParameter("selIntroduction");
			if (sel_introduction == null || sel_introduction.trim().length() == 0) {
				errorMsgs.add("廠商介紹請勿空白");
			}

			String sel_bankCode = req.getParameter("selBankCode");
			if (sel_bankCode == null || sel_bankCode.trim().length() == 0) {
				errorMsgs.add("銀行代碼請勿空白");
			}

			String sel_bankNumber = req.getParameter("selBankNumber");
			if (sel_bankNumber == null || sel_bankNumber.trim().length() == 0) {
				errorMsgs.add("銀行帳號請勿空白");
			}

			String sel_bankName = req.getParameter("selBankName");
			if (sel_bankName == null || sel_bankName.trim().length() == 0) {
				errorMsgs.add("戶名請勿空白");
			}

			String sel_remark = req.getParameter("selRemark");
			if (sel_remark == null || sel_remark.trim().length() == 0) {
				errorMsgs.add("備註請勿空白");
			}

			String sel_title = req.getParameter("selTitle");
			if (sel_title == null || sel_title.trim().length() == 0) {
				errorMsgs.add("單位名稱請勿空白");
			}

			String sel_principal = req.getParameter("selPrincipal");
			if (sel_principal == null || sel_principal.trim().length() == 0) {
				errorMsgs.add("單位負責人請勿空白");
			}

			String sel_uniformNumbers = req.getParameter("selUniformNumbers");
			if (sel_uniformNumbers == null || sel_uniformNumbers.trim().length() == 0) {
				errorMsgs.add("統一編號請勿空白");
			}

			String sel_registeredAddress = req.getParameter("selRegisteredAddress");
			if (sel_registeredAddress == null || sel_registeredAddress.trim().length() == 0) {
				errorMsgs.add("單位立案地址請勿空白");
			}

			Part part = req.getPart("selProfilePicture");
			InputStream in = part.getInputStream();

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			byte[] buf = new byte[4 * 1024]; // 4K buffer
			int len;
			while ((len = in.read(buf)) != -1) {
				byteArrayOutputStream.write(buf, 0, len);
			}

			SellerVO sellerVO = new SellerVO();

			sellerVO.setSelAccount(sel_account);
			sellerVO.setSelPassword(sel_password);
			sellerVO.setSelName(sel_name);
			sellerVO.setSelPhone(sel_phone);
			sellerVO.setSelAddress(sel_address);
			sellerVO.setSelUrl(sel_url);
			sellerVO.setSelFacebook(sel_facebook);
			sellerVO.setSelContactPerson(sel_contactPerson);
			sellerVO.setSelIntroduction(sel_introduction);
			sellerVO.setSelBankCode(sel_bankCode);
			sellerVO.setSelBankNumber(sel_bankNumber);
			sellerVO.setSelBankName(sel_bankName);
			sellerVO.setSelRemark(sel_remark);
			sellerVO.setSelTitle(sel_title);
			sellerVO.setSelPrincipal(sel_principal);
			sellerVO.setSelRegisteredAddress(sel_registeredAddress);

			byte[] selProfilePicture = byteArrayOutputStream.toByteArray();
			sellerVO.setSelProfilePicture(selProfilePicture);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("sellerVO", sellerVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/seller/sel_signup.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			SellerService sellerSvc = new SellerService();
			sellerVO = sellerSvc.addSeller(sel_account, sel_password, sel_name, sel_phone, sel_address, sel_url,
					sel_facebook, sel_contactPerson, sel_introduction, sel_bankCode, sel_bankNumber, sel_bankName,
					sel_remark, sel_title, sel_principal, sel_uniformNumbers, sel_registeredAddress, selProfilePicture);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/seller/sel_login.jsp";
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
