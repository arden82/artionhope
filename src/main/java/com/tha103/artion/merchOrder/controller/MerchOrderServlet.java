package com.tha103.artion.merchOrder.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.merchOrder.model.MerchOrderService;
import com.tha103.artion.merchOrder.model.MerchOrderVO;

@WebServlet("/MerchOrderServlet")
public class MerchOrderServlet extends HttpServlet {

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
			String str = req.getParameter("merOrderId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入員工編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer merOrderId = null;
			try {
				merOrderId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("員工編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			MerchOrderService merchorderSvc = new MerchOrderService();
			MerchOrderVO merchorderVO = merchorderSvc.getOneMerchorder(merOrderId);
			if (merchorderVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("merchorderVO", merchorderVO); // 資料庫取出的memberNotifyVO物件,存入req
			String url = "/merchorder/listOneMerchOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer merOrderId = Integer.valueOf(req.getParameter("merOrderId"));

			/*************************** 2.開始查詢資料 ****************************************/
			MerchOrderService merchorderSvc = new MerchOrderService();
			MerchOrderVO merchorderVO = merchorderSvc.getOneMerchorder(merOrderId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("merchorderVO", merchorderVO); // 資料庫取出的memberNotifyVO物件,存入req
			String url = "/merchorder/update_merchorder_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

			Integer merOrderId = Integer.valueOf(req.getParameter("merOrderId"));

			MemberVO member = Integer.valueOf(req.getParameter("member"));

			Integer merOrderActuallyAmount = Integer.valueOf(req.getParameter("merOrderActuallyAmount").trim());

			Timestamp merOrderTime = Timestamp.valueOf("merOrderTime");

			Integer merOrderPayStatus = Integer.valueOf(req.getParameter("merOrderPayStatus").trim());

			Integer merOrderStatus = Integer.valueOf(req.getParameter("merOrderStatus").trim());

			String merOrderAddress = req.getParameter("merOrderAddress");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (merOrderAddress == null || merOrderAddress.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			}

			String merOrderCode = req.getParameter("merOrderCode");
			String enameReg1 = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (merOrderCode == null || merOrderCode.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			}

			MemberVO membervo = new MemberVO();
			membervo.setMemId(7002);

			MerchOrderVO merchorderVO = new MerchOrderVO();
			merchorderVO.setMerOrderId(merOrderId);
			merchorderVO.setMember(membervo);
			merchorderVO.setMerOrderActuallyAmount(merOrderActuallyAmount);
			merchorderVO.setMerOrderPayStatus(merOrderPayStatus);
			merchorderVO.setMerOrderStatus(merOrderStatus);
			merchorderVO.setMerOrderAddress(merOrderAddress);
			merchorderVO.setMerOrderCode(merOrderCode);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("merchorderVO", merchorderVO); // 含有輸入格式錯誤的memberNotifyVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/update_MerchOrder_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			MerchOrderService merchorderSvc = new MerchOrderService();
			merchorderVO = merchorderSvc.updateMerchorder(merOrderId, member, merOrderActuallyAmount, merOrderTime,
					merOrderPayStatus, merOrderStatus, merOrderAddress, merOrderCode);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("merchorderVO", merchorderVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/merchorder/listOneEmp.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer merOrderId = Integer.valueOf(req.getParameter("merOrderId").trim());

			MemberVO member = Integer.valueOf(req.getParameter("member").trim());

			Integer merOrderActuallyAmount = Integer.valueOf(req.getParameter("merOrderActuallyAmount").trim());

			Timestamp merOrderTime = Timestamp.valueOf("merOrderTime");

			Integer merOrderPayStatus = Integer.valueOf(req.getParameter("merOrderPayStatus").trim());

			Integer merOrderStatus = Integer.valueOf(req.getParameter("merOrderStatus").trim());

			String merOrderAddress = req.getParameter("merOrderAddress");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (merOrderAddress == null || merOrderAddress.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			}
//			else if (!merOrder_address.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//			}

			String merOrderCode = req.getParameter("merOrderCode");
			String enameReg1 = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (merOrderCode == null || merOrderCode.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			}
//			else if (!merOrder_code.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//			}

			MemberVO membervo = new MemberVO();
			membervo.setMemId(7002);

			MerchOrderVO merchorderVO = new MerchOrderVO();
			merchorderVO.setMember(membervo);
			merchorderVO.setMerOrderActuallyAmount(merOrderActuallyAmount);
			merchorderVO.setMerOrderPayStatus(merOrderPayStatus);
			merchorderVO.setMerOrderStatus(merOrderStatus);
			merchorderVO.setMerOrderAddress(merOrderAddress);
			merchorderVO.setMerOrderCode(merOrderCode);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("merchorderVO", merchorderVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/addMerchOrder.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			MerchOrderService merchorderSvc = new MerchOrderService();
			merchorderVO = merchorderSvc.insertMerchorder(member, merOrderActuallyAmount, merOrderTime,
					merOrderPayStatus, merOrderStatus, merOrderAddress, merOrderCode);

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
			Integer merOrderId = Integer.valueOf(req.getParameter("merOrderId"));

			/*************************** 2.開始刪除資料 ***************************************/
			MerchOrderService merchorderSvc = new MerchOrderService();
			merchorderSvc.deleteMerchorder(merOrderId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/merchorder/listAllMerchOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
