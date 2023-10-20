package com.tha103.artion.ticketOrderDetail.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailService;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailVO;

@WebServlet("/TicketOrderDetailServlet")
public class TicketOrderDetailServlet extends HttpServlet {
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
			String str = req.getParameter("ticOrdDetId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入票券明細編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/ticketorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer ticOrdDetId = null;
			try {
				ticOrdDetId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("票券明細編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/ticketorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			TicketOrderDetailService ticketorderSvc = new TicketOrderDetailService();
			TicketOrderDetailVO ticketorderdetailVO = ticketorderSvc.getOneTicketOrderDetail(ticOrdDetId);
			if (ticketorderdetailVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/ticketorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("ticketorderdetailVO", ticketorderdetailVO); // 資料庫取出的memberNotifyVO物件,存入req
			String url = "/ticketorder/listOneTicketOrderDetail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer ticOrdDetId = Integer.valueOf(req.getParameter("ticOrdDetId"));

			/*************************** 2.開始查詢資料 ****************************************/
			TicketOrderDetailService ticketorderSvc = new TicketOrderDetailService();
			TicketOrderDetailVO ticketorderdetailVO = ticketorderSvc.getOneTicketOrderDetail(ticOrdDetId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("ticketorderdetailVO", ticketorderdetailVO); // 資料庫取出的memberNotifyVO物件,存入req
			String url = "/ticketorder/update_ticketOrderDetail_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer ticOrdDetId = Integer.valueOf(req.getParameter("ticOrdDetId"));

			TicketOrderVO ticketorder = Integer.valueOf(req.getParameter("ticketorder"));

			Integer ticOrdDetQuantity = Integer.valueOf(req.getParameter("ticOrdDetQuantity").trim());

			Double ticOrdDetPrice = Integer.valueOf(req.getParameter("ticOrdDetPrice").trim());

			ActivityVO activity = Integer.valueOf(req.getParameter("activity").trim());

			TicketOrderDetailVO ticketorderdetailVO = new TicketOrderDetailVO();
			ticketorderdetailVO.setTicOrdDetId(ticOrdDetId);
			ticketorderdetailVO.setTicketorder(ticketorder);
			ticketorderdetailVO.setTicOrdDetQuantity(ticOrdDetQuantity);
			ticketorderdetailVO.setTicOrdDetPrice(ticOrdDetPrice);
			ticketorderdetailVO.setActivity(activity);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("ticketorderdetailVO", ticketorderdetailVO); // 含有輸入格式錯誤的memberNotifyVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/ticketorder/update_ticketOrderDetail_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			TicketOrderDetailService ticketorderSvc = new TicketOrderDetailService();
			ticketorderdetailVO = ticketorderSvc.updateticketorderdetailVO(ticOrdDetId, ticketorder, ticOrdDetQuantity,
					ticOrdDetPrice, activity);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("ticketorderdetailVO", ticketorderdetailVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/ticketorder/listOneticketOrderDetail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer ticOrdDetId = Integer.valueOf(req.getParameter("ticOrdDetId"));

			TicketOrderVO ticketorder = Integer.valueOf(req.getParameter("ticketorder"));

			Integer ticOrdDetQuantity = Integer.valueOf(req.getParameter("ticOrdDetQuantity").trim());

			Double ticOrdDetPrice = Integer.valueOf(req.getParameter("ticOrdDetPrice").trim());

			ActivityVO activity = Integer.valueOf(req.getParameter("activity").trim());

			TicketOrderDetailVO ticketorderdetailVO = new TicketOrderDetailVO();
			ticketorderdetailVO.setTicOrdDetId(ticOrdDetId);
			ticketorderdetailVO.setTicketorder(ticketorder);
			ticketorderdetailVO.setTicOrdDetQuantity(ticOrdDetQuantity);
			ticketorderdetailVO.setTicOrdDetPrice(ticOrdDetPrice);
			ticketorderdetailVO.setActivity(activity);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("ticketorderdetailVO", ticketorderdetailVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/ticketorder/addTicketOrderDetail.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			TicketOrderDetailService ticketorderSvc = new TicketOrderDetailService();
			ticketorderdetailVO = ticketorderSvc.addTicketorderdetailVO(ticOrdDetId, ticketorder, ticOrdDetQuantity,
					ticOrdDetPrice, activity);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/ticketorder/listAllTicketOrderDetail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer ticOrdDetId = Integer.valueOf(req.getParameter("ticOrdDetId"));

			/*************************** 2.開始刪除資料 ***************************************/
			TicketOrderDetailService ticketorderdetailSvc = new TicketOrderDetailService();
			ticketorderdetailSvc.deleteTicketOrderDetail(ticOrdDetId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/ticketorder/listAllTicketOrderDetail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
