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
			TicketOrderVO ticketorderVO = ticketorderSvc.getOneTicketOrder(ticketOrdId);
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
			TicketOrderVO ticketorderVO = ticketorderSvc.getOneTicketOrder(ticketOrdId);

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

			Integer member = Integer.valueOf(req.getParameter("member"));

			Integer ticketOrdStatus = Integer.valueOf(req.getParameter("ticketOrdStatus").trim());

			Integer ticketOrdTotalPrice = Integer.valueOf(req.getParameter("ticketOrdTotalPrice").trim());

			Integer ticketOrdProCodeAmount = Integer.valueOf(req.getParameter("ticketOrdProCodeAmount());
					
			Double 	ticketOrdActuallyAmount = Double.valueOf(req.getParameter("ticketOrdActuallyAmount"));	
			
			Integer ticketOrdPayStatus = Integer.valueOf(req.getParameter("ticketOrdPayStatus());
			
			MyPromoCodeVO mypromocode = MyPromoCodeVO.valueOf(req.getParameter("mypromocode"));
				
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

			TicketOrderVO TicketOrderVO = new TicketOrderVO();
			TicketOrderVO.setMerOrderId(merOrderId);
			TicketOrderVO.setMember(member);
			TicketOrderVO.setTicketOrdStatus(ticketOrdStatus);
			TicketOrderVO.setTicketOrdTotalPrice(ticketOrdTotalPrice);
			TicketOrderVO.setTicketOrdProCodeAmount(ticketOrdProCodeAmount);
			TicketOrderVO.setTicketOrdActuallyAmount(ticketOrdActuallyAmount);
			TicketOrderVO.setTicketOrdPayStatus(ticketOrdPayStatus);
			TicketOrderVO.setMypromocode(mypromocode);
			TicketOrderVO.setTicketOrdAddress(ticketOrdAddress);
			TicketOrderVO.setSeller(seller);
			TicketOrderVO.setTicketOrdCode(ticketOrdCode);
			TicketOrderVO.setTicOrdDets(ticOrdDets);



			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("TicketOrderVO", TicketorderVO); // 含有輸入格式錯誤的memberNotifyVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/update_TicketOrder_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			TicketOrderService ticketorderSvc = new TicketOrderService();
			TicketOrderVO = ticketorderSvc.updateTicketOrderVO(merOrderId, member, merOrderActuallyAmount,
					merOrderPayStatus, merOrderStatus, merOrderAddress, merOrderCode);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("TicketOrderVO", TicketOrderVO); // 資料庫update成功後,正確的的empVO物件,存入req
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
			Integer ticketOrdId = Integer.valueOf(req.getParameter("ticketOrdId"));

			Integer member = Integer.valueOf(req.getParameter("member"));

			Integer ticketOrdStatus = Integer.valueOf(req.getParameter("ticketOrdStatus").trim());

			Integer ticketOrdTotalPrice = Integer.valueOf(req.getParameter("ticketOrdTotalPrice").trim());

			Integer ticketOrdProCodeAmount = Integer.valueOf(req.getParameter("ticketOrdProCodeAmount());
					
			Double 	ticketOrdActuallyAmount = Double.valueOf(req.getParameter("ticketOrdActuallyAmount"));	
			
			Integer ticketOrdPayStatus = Integer.valueOf(req.getParameter("ticketOrdPayStatus());
			
			MyPromoCodeVO mypromocode = MyPromoCodeVO.valueOf(req.getParameter("mypromocode"));
				
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

			TicketOrderVO TicketOrderVO = new TicketOrderVO();
			TicketOrderVO.setMerOrderId(merOrderId);
			TicketOrderVO.setMember(member);
			TicketOrderVO.setTicketOrdStatus(ticketOrdStatus);
			TicketOrderVO.setTicketOrdTotalPrice(ticketOrdTotalPrice);
			TicketOrderVO.setTicketOrdProCodeAmount(ticketOrdProCodeAmount);
			TicketOrderVO.setTicketOrdActuallyAmount(ticketOrdActuallyAmount);
			TicketOrderVO.setTicketOrdPayStatus(ticketOrdPayStatus);
			TicketOrderVO.setMypromocode(mypromocode);
			TicketOrderVO.setTicketOrdAddress(ticketOrdAddress);
			TicketOrderVO.setSeller(seller);
			TicketOrderVO.setTicketOrdCode(ticketOrdCode);
			TicketOrderVO.setTicOrdDets(ticOrdDets);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("TicketOrderVO", TicketOrderVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/ticketorder/addTicketOrder.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			TicketOrderService ticketorderSvc = new TicketOrderService();
			ticketorderVO = ticketorderSvc.addMerchorder(member, merOrderActuallyAmount, merOrderPayStatus,
					merOrderStatus, merOrderAddress, merOrderCode, MerOrdDets);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/merchorder/listAllMerchOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			IntegerticketOrdId = Integer.valueOf(req.getParameter("merOrderId"));

			/*************************** 2.開始刪除資料 ***************************************/
			TicketOrderService merchorderSvc = new TicketOrderService();
			merchorderSvc.deleteMerchOrder(merOrderId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/merchorder/listAllMerchOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
