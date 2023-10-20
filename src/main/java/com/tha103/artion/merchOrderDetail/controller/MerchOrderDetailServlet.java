package com.tha103.artion.merchOrderDetail.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.merchOrder.model.MerchOrderService;
import com.tha103.artion.merchOrder.model.merchorderdetailVO;
import com.tha103.artion.merchOrderDetail.model.MerchOrderDetailService;
import com.tha103.artion.merchOrderDetail.model.MerchOrderDetailVO;

@WebServlet("/MerchOrderDetailServlet")
public class MerchOrderDetailServlet extends HttpServlet {

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
			String str = req.getParameter("merchOrdDetailId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入周邊商品明細編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer merchOrdDetailId = null;
			try {
				merchOrdDetailId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("周邊商品明細編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			MerchOrderService merchorderSvc = new MerchOrderService();
			MerchOrderDetailVO merchorderdetailVO = merchorderSvc.getOneMerchOrder(merchOrdDetailId);
			if (merchorderdetailVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("merchorderdetailVO", merchorderdetailVO); // 資料庫取出的memberNotifyVO物件,存入req
			String url = "/merchorder/listOneMerchOrderDetail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer merchOrdDetailId = Integer.valueOf(req.getParameter("merchOrdDetailId"));

			/*************************** 2.開始查詢資料 ****************************************/
			MerchOrderService merchorderSvc = new MerchOrderService();
			MerchOrderDetailVO merchorderdetailVO = merchorderSvc.getOneMerchOrderDetail(merchOrdDetailId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("merchorderdetailVO", merchorderdetailVO); // 資料庫取出的memberNotifyVO物件,存入req
			String url = "/merchorder/update_merchOrderDetail_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer merchOrdDetailId = Integer.valueOf(req.getParameter("merchOrdDetailId"));

			Integer merchorder = Integer.valueOf(req.getParameter("merchorder"));

			Integer merch = Integer.valueOf(req.getParameter("merch").trim());

			Integer merOrderDetailQuantity = Integer.valueOf(req.getParameter("merOrderDetailQuantity").trim());

			Integer merOrderDetailPrice = Integer.valueOf(req.getParameter("merOrderDetailPrice").trim());

			MerchOrderDetailVO merchorderdetailVO = new MerchOrderDetailVO();
			merchorderdetailVO.setMerchOrdDetailId(merchOrdDetailId);
			merchorderdetailVO.setMerchorder(merchorder);
			merchorderdetailVO.setMerch(merch);
			merchorderdetailVO.setMerOrderDetailQuantity(merOrderDetailQuantity);
			merchorderdetailVO.setMerOrderDetailPrice(merOrderDetailPrice);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("merchorderdetailVO", merchorderdetailVO); // 含有輸入格式錯誤的memberNotifyVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/merchorder/update_merchOrderDetail_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			MerchOrderDetailService merchorderdetailSvc = new MerchOrderDetailService();
			merchorderdetailVO = merchorderdetailSvc.updateMerchOrderDetail(merchOrdDetailId, merchorder, merch,
					merOrderDetailQuantity, merOrderDetailPrice);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("merchorderdetailVO", merchorderdetailVO); // 資料庫update成功後,正確的的empVO物件,存入req
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
			Integer mem_id = Integer.valueOf(req.getParameter("mem_id").trim());

			Integer merOrder_actuallyAmount = Integer.valueOf(req.getParameter("merOrder_actuallyAmount").trim());

			Integer merOrder_payStatus = Integer.valueOf(req.getParameter("merOrder_payStatus").trim());

			Integer merOrder_status = Integer.valueOf(req.getParameter("merOrder_status").trim());

			String merOrder_address = req.getParameter("merOrder_address");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (merOrder_address == null || merOrder_address.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			}
//			else if (!merOrder_address.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//			}

			String merOrder_code = req.getParameter("merOrder_code");
			String enameReg1 = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (merOrder_code == null || merOrder_code.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			}
//			else if (!merOrder_code.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//			}

			merchorderdetailVO merchorderdetailVO = new merchorderdetailVO();
			merchorderdetailVO.setMem_id(mem_id);
			merchorderdetailVO.setMerOrder_actuallyAmount(merOrder_actuallyAmount);
			merchorderdetailVO.setMerOrder_payStatus(merOrder_payStatus);
			merchorderdetailVO.setMerOrder_status(merOrder_status);
			merchorderdetailVO.setMerOrder_address(merOrder_address);
			merchorderdetailVO.setMerOrder_code(merOrder_code);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("merchorderdetailVO", merchorderdetailVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/merchorder/addEmp.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			MerchOrderService merchorderSvc = new MerchOrderService();
			merchorderdetailVO = merchorderSvc.addEmp(mem_id, merOrder_actuallyAmount, merOrder_payStatus,
					merOrder_status, merOrder_address, merOrder_code);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/merchorder/listAllMerchOrderDetail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer merchOrdDetailId = Integer.valueOf(req.getParameter("merchOrdDetailId"));

			/*************************** 2.開始刪除資料 ***************************************/
			MerchOrderDetailService merchorderdetailSvc = new MerchOrderDetailService();
			merchorderdetailSvc.deleteMerchOrderDetail(merchOrdDetailId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/merchorder/listAllMerchOrderDetail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
