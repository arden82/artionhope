//package com.tha103.artion.merchOrderDetail.controller;
//
//import java.io.IOException;
//import java.util.LinkedList;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.tha103.artion.merch.model.MerchVO;
//import com.tha103.artion.merchOrder.model.MerchOrderVO;
//import com.tha103.artion.merchOrderDetail.model.MerchOrderDetailService;
//import com.tha103.artion.merchOrderDetail.model.MerchOrderDetailVO;
//
//@WebServlet("/MerchOrderDetailServlet")
//public class MerchOrderDetailServlet extends HttpServlet {
//
//	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		doPost(req, res);
//	}
//
//	@Override
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//		req.setCharacterEncoding("UTF-8");
//		String action = req.getParameter("action");
//
//		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//			String str = req.getParameter("merchOrdDetailId");
//			if (str == null || (str.trim()).length() == 0) {
//				errorMsgs.add("請輸入周邊商品明細編號");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/select_page.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}
//
//			Integer merchOrdDetailId = null;
//			try {
//				merchOrdDetailId = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.add("周邊商品明細編號格式不正確");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/select_page.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}
//
//			/*************************** 2.開始查詢資料 *****************************************/
//			MerchOrderDetailService merchorderdetailSvc = new MerchOrderDetailService();
//			MerchOrderDetailVO merchorderdetailVO = merchorderdetailSvc.getOneMerchrderdetail(merchOrdDetailId);
//			if (merchorderdetailVO == null) {
//				errorMsgs.add("查無資料");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/select_page.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("merchorderdetailVO", merchorderdetailVO); // 資料庫取出的memberNotifyVO物件,存入req
//			String url = "/merchorder/listOneMerchOrderDetail.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//			successView.forward(req, res);
//		}
//
//		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 ****************************************/
//			Integer merchOrdDetailId = Integer.valueOf(req.getParameter("merchOrdDetailId"));
//
//			/*************************** 2.開始查詢資料 ****************************************/
//			MerchOrderDetailService merchorderdetailSvc = new MerchOrderDetailService();
//			MerchOrderDetailVO merchorderdetailVO = merchorderdetailSvc.getOneMerchrderdetail(merchOrdDetailId);
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
//			req.setAttribute("merchorderdetailVO", merchorderdetailVO); // 資料庫取出的memberNotifyVO物件,存入req
//			String url = "/merchOrderDetail/update_merchOrderDetail_input.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
//			successView.forward(req, res);
//		}
//
//		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//			Integer merchOrdDetailId = Integer.valueOf(req.getParameter("merchOrdDetailId"));
//
//			MerchOrderVO merchorder = Integer.valueOf(req.getParameter("merchorder"));
//
//			MerchVO merch = Integer.valueOf(req.getParameter("merch").trim());
//
//			Integer merOrderDetailQuantity = Integer.valueOf(req.getParameter("merOrderDetailQuantity").trim());
//
//			Integer merOrderDetailPrice = Integer.valueOf(req.getParameter("merOrderDetailPrice").trim());
//
//			MerchOrderVO merchorderVO = new MerchOrderVO();
//			merchorderVO.setMerOrderId(134804);
//
//			MerchVO merchVO = new MerchVO();
//			merchVO.setMerchId(1);
//
////			MerchOrderVO merchorderVO = new MerchOrderService().getMerchOrder(1);
////			MemberVO membervo = new MemberServiceImp().getMember(1);
//
//			MerchOrderDetailVO merchorderdetailVO = new MerchOrderDetailVO();
//			merchorderdetailVO.setMerchOrdDetailId(merchOrdDetailId);
//			merchorderdetailVO.setMerchOrder(merchorderVO);
//			merchorderdetailVO.setMerch(merchVO);
//			merchorderdetailVO.setMerOrderDetailQuantity(merOrderDetailQuantity);
//			merchorderdetailVO.setMerOrderDetailPrice(merOrderDetailPrice);
//
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("merchorderdetailVO", merchorderdetailVO); // 含有輸入格式錯誤的memberNotifyVO物件,也存入req
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/merchorder/update_merchOrderDetail_input.jsp");
//				failureView.forward(req, res);
//				return; // 程式中斷
//			}
//
//			/*************************** 2.開始修改資料 *****************************************/
//			MerchOrderDetailService merchorderdetailSvc = new MerchOrderDetailService();
//			merchorderdetailVO = merchorderdetailSvc.updateMerchrderdetail(merchOrdDetailId, merchorder, merch,
//					merOrderDetailQuantity, merOrderDetailPrice);
//
//			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("merchorderdetailVO", merchorderdetailVO); // 資料庫update成功後,正確的的empVO物件,存入req
//			String url = "/merchorder/listOneMerchOrderDetail.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//			successView.forward(req, res);
//		}
//
//		if ("insert".equals(action)) { // 來自addEmp.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
////			Integer merchOrdDetailId = Integer.valueOf(req.getParameter("merchOrdDetailId"));
//
//			MerchOrderVO merchorder = Integer.valueOf(req.getParameter("merchorder"));
//
//			MerchVO merch = Integer.valueOf(req.getParameter("merch").trim());
//
//			Integer merOrderDetailQuantity = Integer.valueOf(req.getParameter("merOrderDetailQuantity").trim());
//
//			Integer merOrderDetailPrice = Integer.valueOf(req.getParameter("merOrderDetailPrice").trim());
//
//			MerchOrderVO merchorderVO = new MerchOrderVO();
//			merchorderVO.setMerOrderId(134804);
//
//			MerchVO merchVO = new MerchVO();
//			merchVO.setMerchId(1);
//
//			MerchOrderDetailVO merchorderdetailVO = new MerchOrderDetailVO();
//			merchorderdetailVO.setMerchOrder(merchorder);
//			merchorderdetailVO.setMerch(merchVO);
//			merchorderdetailVO.setMerOrderDetailQuantity(merOrderDetailQuantity);
//			merchorderdetailVO.setMerOrderDetailPrice(merOrderDetailPrice);
//
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("merchorderdetailVO", merchorderdetailVO); // 含有輸入格式錯誤的empVO物件,也存入req
//				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/addMerchOrderDetail.jsp");
//				failureView.forward(req, res);
//				return;
//			}
//
//			/*************************** 2.開始新增資料 ***************************************/
//			MerchOrderDetailService merchorderdetailSvc = new MerchOrderDetailService();
//			merchorderdetailVO = merchorderdetailSvc.insertMerchorderdetail(merchorder, merch, merOrderDetailQuantity,
//					merOrderDetailPrice);
//
//			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//			String url = "/merchorder/listAllMerchOrderDetail.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//			successView.forward(req, res);
//		}
//
//		if ("delete".equals(action)) { // 來自listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 ***************************************/
//			Integer merchOrdDetailId = Integer.valueOf(req.getParameter("merchOrdDetailId"));
//
//			/*************************** 2.開始刪除資料 ***************************************/
//			MerchOrderDetailService merchorderdetailSvc = new MerchOrderDetailService();
//			merchorderdetailSvc.deleteMerchrderdetail(merchOrdDetailId);
//
//			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
//			String url = "/merchorder/listAllMerchOrderDetail.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//			successView.forward(req, res);
//		}
//	}
//}
