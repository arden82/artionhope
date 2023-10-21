package com.tha103.artion.ticketOrder.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.member.service.MemberServiceImp;
import com.tha103.artion.myPromoCode.model.MyPromoCodeVO;
import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.ticketOrder.model.TicketOrderService;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;

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

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("ticketOrdId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入票券訂單編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/ticketorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer ticketOrdId = null;
			try {
				ticketOrdId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("票券訂單編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/ticketorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			TicketOrderService ticketorderSvc = new TicketOrderService();
			TicketOrderVO ticketorderVO = ticketorderSvc.getById(ticketOrdId);
			if (ticketOrdId == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/ticketorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("TicketOrderVO", ticketorderVO); // 資料庫取出的memberNotifyVO物件,存入req
			String url = "/ticketorder/listOneTicketOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer ticketOrdId = Integer.valueOf(req.getParameter("ticketOrdId"));

			/*************************** 2.開始查詢資料 ****************************************/
			TicketOrderService ticketorderSvc = new TicketOrderService();
			TicketOrderVO ticketorderVO = ticketorderSvc.getById(ticketOrdId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("TicketOrderVO", ticketorderVO); // 資料庫取出的memberNotifyVO物件,存入req
			String url = "/ticketorder/update_ticketOrder_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer ticketOrdId = Integer.valueOf(req.getParameter("ticketOrdId"));

//			Timestamp ticketOrdTime = Timestamp.valueOf("");

			MemberVO member = Integer.valueOf(req.getParameter("member"));

			Integer ticketOrdStatus = Integer.valueOf(req.getParameter("ticketOrdStatus").trim());

			Double ticketOrdTotalPrice = Double.valueOf(req.getParameter("ticketOrdTotalPrice").trim());

			Double ticketOrdProCodeAmount = Double.valueOf(req.getParameter("ticketOrdProCodeAmount").trim());

			Double ticketOrdActuallyAmount = Double.valueOf(req.getParameter("ticketOrdActuallyAmount"));

			Integer ticketOrdPayStatus = Integer.valueOf(req.getParameter("ticketOrdPayStatus"));

			MyPromoCodeVO mypromocode = Integer.valueOf(req.getParameter("mypromocode"));

			String ticketOrdAddress = req.getParameter("ticketOrdAddress");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (ticketOrdAddress == null || ticketOrdAddress.trim().length() == 0) {
				errorMsgs.add("票券地址: 請勿空白");
			}

			SellerVO seller = SellerVO.valueOf(req.getParameter("seller"));

			String ticketOrdCode = req.getParameter("ticketOrdCode");
			String enameReg1 = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (ticketOrdCode == null || ticketOrdCode.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			}

			SellerVO sellerVO = new SellerVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
			sellerVO.setSelId(2001);

			MyPromoCodeVO mypromocodeVO = new MyPromoCodeVO();
			mypromocodeVO.setMyProCodeId(1);

			MemberVO membervo = new MemberVO();
			membervo.setMemId(7001);

			TicketOrderVO ticketorderVO = new TicketOrderVO();
			ticketorderVO.setTicketOrdId(ticketOrdId);
			ticketorderVO.setTicketOrdTime(ticketOrdTime);
			ticketorderVO.setMember(membervo);
			ticketorderVO.setTicketOrdStatus(ticketOrdStatus);
			ticketorderVO.setTicketOrdTotalPrice(ticketOrdTotalPrice);
			ticketorderVO.setTicketOrdProCodeAmount(ticketOrdProCodeAmount);
			ticketorderVO.setTicketOrdActuallyAmount(ticketOrdActuallyAmount);
			ticketorderVO.setTicketOrdPayStatus(ticketOrdPayStatus);
			ticketorderVO.setMypromocode(mypromocodeVO);
			ticketorderVO.setTicketOrdAddress(ticketOrdAddress);
			ticketorderVO.setSeller(seller);
			ticketorderVO.setTicketOrdCode(ticketOrdCode);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("TicketOrderVO", ticketorderVO); // 含有輸入格式錯誤的memberNotifyVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/ticketorder/update_TicketOrder_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			TicketOrderService ticketorderSvc = new TicketOrderService();
			ticketorderVO = ticketorderSvc.updateTicketorder(ticketOrdId, member, ticketOrdStatus, ticketOrdTotalPrice,
					ticketOrdProCodeAmount, ticketOrdActuallyAmount, ticketOrdPayStatus, mypromocode, ticketOrdAddress,
					seller, ticketOrdCode);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("TicketOrderVO", ticketorderVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/merchorder/listOneTicketOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
//			Integer ticketOrdId = Integer.valueOf(req.getParameter("ticketOrdId"));

//			Timestamp ticketOrdTime = Timestamp.valueOf("");

			MemberVO member = MemberVO.valueOf(req.getParameter("member"));

			Integer ticketOrdStatus = Integer.valueOf(req.getParameter("ticketOrdStatus").trim());

			Double ticketOrdTotalPrice = Double.valueOf(req.getParameter("ticketOrdTotalPrice").trim());

			Double ticketOrdProCodeAmount = Double.valueOf(req.getParameter("ticketOrdProCodeAmount").trim());

			Double ticketOrdActuallyAmount = Double.valueOf(req.getParameter("ticketOrdActuallyAmount"));

			Integer ticketOrdPayStatus = Integer.valueOf(req.getParameter("ticketOrdPayStatus").trim());

			MyPromoCodeVO mypromocode = MyPromoCodeVO.valueOf(req.getParameter("mypromocode").trim());

			String ticketOrdAddress = req.getParameter("ticketOrdAddress");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (ticketOrdAddress == null || ticketOrdAddress.trim().length() == 0) {
				errorMsgs.add("票券地址: 請勿空白");
			}

			SellerVO seller = SellerVO.valueOf(req.getParameter("seller"));

			String ticketOrdCode = req.getParameter("ticketOrdCode");
			String enameReg1 = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (ticketOrdCode == null || ticketOrdCode.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			}

			MemberVO membervo = new MemberServiceImp().getMember(1);
//
//			MyPromoCodeVO mypromocodeVO = new MyPromoCodeVO();
//			mypromocodeVO.setMyProCodeId(11);

			TicketOrderVO ticketorderVO = new TicketOrderVO();
//			ticketorderVO.setTicketOrdId(ticketOrdId);
//			ticketorderVO.setTicketOrdTime(ticketOrdTime);
			ticketorderVO.setMember(member);
			ticketorderVO.setTicketOrdStatus(ticketOrdStatus);
			ticketorderVO.setTicketOrdTotalPrice(ticketOrdTotalPrice);
			ticketorderVO.setTicketOrdProCodeAmount(ticketOrdProCodeAmount);
			ticketorderVO.setTicketOrdActuallyAmount(ticketOrdActuallyAmount);
			ticketorderVO.setTicketOrdPayStatus(ticketOrdPayStatus);
			ticketorderVO.setMypromocode(mypromocode);
			ticketorderVO.setTicketOrdAddress(ticketOrdAddress);
			ticketorderVO.setSeller(seller);
			ticketorderVO.setTicketOrdCode(ticketOrdCode);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("TicketOrderVO", ticketorderVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/ticketorder/addTicketOrder.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			TicketOrderService ticketorderSvc = new TicketOrderService();
			ticketorderVO = ticketorderSvc.insertTicketorder(member, ticketOrdStatus, ticketOrdTotalPrice,
					ticketOrdProCodeAmount, ticketOrdActuallyAmount, ticketOrdPayStatus, mypromocode, ticketOrdAddress,
					seller, ticketOrdCode);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/ticketorder/listAllTicketOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer ticketOrdId = Integer.valueOf(req.getParameter("ticketOrdId"));

			/*************************** 2.開始刪除資料 ***************************************/
			TicketOrderService ticketorderSvc = new TicketOrderService();
			ticketorderSvc.deleteTicketorder(ticketOrdId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/ticketorder/listAllTicketOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
