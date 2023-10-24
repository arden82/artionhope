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

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String actName = req.getParameter("actName");
			String actTicketPriceString = req.getParameter("actTicketPriceString");
			String ticOrdDetQuantity = req.getParameter("ticOrdDetQuantity");
			String ticketOrdTotalPrice = req.getParameter("ticketOrdTotalPrice");
			String ticketOrdProCodeAmount = req.getParameter("ticketOrdProCodeAmount");
			String ticketOrdActuallyAmount = req.getParameter("ticketOrdActuallyAmount");

			String ticketOrdProCodeAmountReg = "^[a-zA-Z0-9]{1,15}$";
			if (ticketOrdProCodeAmount != "^[a-zA-Z0-9]{1,15}$") {
				errorMsgs.add("折扣碼限定輸入英文和數字");
			}

			Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());

			TicketOrderVO ticketorderVO = new TicketOrderVO();
			ticketorderVO.setactName(ename);
			ticketorderVO.setJob(job);
			ticketorderVO.setHiredate(hiredate);
			ticketorderVO.setSal(sal);
			ticketorderVO.setComm(comm);
			ticketorderVO.setDeptno(deptno);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/emp/addEmp.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			TicketOrderService ticketorderSvc = new TicketOrderService();
			ticketorderVO = ticketorderSvc.addEmp(ename, job, hiredate, sal, comm, deptno);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/emp/listAllEmp.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action))

		{ // 來自listAllEmp.jsp

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
