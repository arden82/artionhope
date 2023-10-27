package com.tha103.artion.ticketOrder.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TicketOrderServlet")
public class TicketOrderServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

//		if ("insert".equals(action)) { // 來自checkout.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
////			 Store this set in the request scope, in case we need to
////			 send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
//
//			Integer memId = Integer.valueOf(req.getParameter("memId").trim());
//
//			Integer ticketOrdStatus = Integer.valueOf(req.getParameter("ticketOrdStatus").trim());
//
//			Double ticketOrdTotalPrice = null;
//			try {
//				ticketOrdTotalPrice = Double.valueOf(req.getParameter("ticketOrdTotalPrice").trim());
//			} catch (NumberFormatException e) {
//				ticketOrdTotalPrice = 0.0;
//				errorMsgs.add("薪水請填數字.");
//			}
//
//			Double ticketOrdProCodeAmount = null;
//			try {
//				ticketOrdProCodeAmount = Double.valueOf(req.getParameter("ticketOrdProCodeAmount").trim());
//			} catch (NumberFormatException e) {
//				ticketOrdProCodeAmount = 0.0;
//				errorMsgs.add("薪水請填數字.");
//			}
//
//			Double ticketOrdActuallyAmount = null;
//			try {
//				ticketOrdActuallyAmount = Double.valueOf(req.getParameter("ticketOrdProCodeAmount").trim());
//			} catch (NumberFormatException e) {
//				ticketOrdActuallyAmount = 0.0;
//				errorMsgs.add("薪水請填數字.");
//			}
//
//			Integer ticketOrdPayStatus = Integer.valueOf(req.getParameter("ticketOrdPayStatus").trim());
//
//			Integer mypromocodeNo = null;
//			try {
//				mypromocodeNo = Integer.valueOf(req.getParameter("mypromocode").trim());
//			} catch (NumberFormatException e) {
//				mypromocodeNo = 100;
//				errorMsgs.add("薪水請填數字.");
//			}
//
//			String ticketOrdAddress = req.getParameter("ticketOrdAddress");
//
//			Integer sellerNo = Integer.valueOf(req.getParameter("seller").trim());
//
//			String ticketOrdCode = req.getParameter("ticketOrdCode");
//
//			TicketOrderVO ticketorderVO = new TicketOrderVO();
//			ticketorderVO.setMemId(memId);
//			ticketorderVO.setTicketOrdStatus(ticketOrdStatus);
//			ticketorderVO.setTicketOrdTotalPrice(ticketOrdTotalPrice);
//			ticketorderVO.setTicketOrdProCodeAmount(ticketOrdProCodeAmount);
//			ticketorderVO.setTicketOrdActuallyAmount(ticketOrdActuallyAmount);
//			ticketorderVO.setTicketOrdPayStatus(ticketOrdPayStatus);
//			ticketorderVO.setMypromocodeNo(mypromocodeNo);
//			ticketorderVO.setTicketOrdAddress(ticketOrdAddress);
//			ticketorderVO.setSellerNo(sellerNo);
//			ticketorderVO.setTicketOrdCode(ticketOrdCode);
//			// Send the use back to the form, if there were errors
////			if (!errorMsgs.isEmpty()) {
////				req.setAttribute("ticketorderVO", ticketorderVO); // 含有輸入格式錯誤的empVO物件,也存入req
////				RequestDispatcher failureView = req.getRequestDispatcher("/ticketOrder/ticketOrderCheck.jsp");
////				failureView.forward(req, res);
////				return;
////			}
//
//			/*************************** 2.開始新增資料 ***************************************/
//			TicketOrderService ticketorderSvc = new TicketOrderService();
//			ticketorderVO = ticketorderSvc.insertTicketorder(member, ticketOrdStatus, ticketOrdTotalPrice,
//					ticketOrdProCodeAmount, ticketOrdActuallyAmount, ticketOrdPayStatus, mypromocodeNo,
//					ticketOrdAddress, sellerNo, ticketOrdCode);
//
//			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//			String url = "/ticketOrder/ticketOrderCheck.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//			successView.forward(req, res);
//		}

//		if ("delete".equals(action))
//
//		{ // 來自listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*************************** 1.接收請求參數 ***************************************/
//			Integer ticketOrdId = Integer.valueOf(req.getParameter("ticketOrdId"));
//
//			/*************************** 2.開始刪除資料 ***************************************/
//			TicketOrderService ticketorderSvc = new TicketOrderService();
//			ticketorderSvc.deleteTicketorder(ticketOrdId);
//
//			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
//			String url = "/ticketorder/listAllTicketOrder.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//			successView.forward(req, res);
//		}

		if ("goToCart".equals(action)) {

			String actName = req.getParameter("actName");

			String quantity = req.getParameter("quantity");

			String total_price = req.getParameter("total_price");

			System.out.println(actName);
		}

	}

}
