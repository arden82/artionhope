package com.tha103.artion.ticketOrder.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.ticketOrder.model.TicketOrderData;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailVO;

@WebServlet("/ticketOrderServlet")
public class TicketOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 獲取json資料
            BufferedReader reader = request.getReader();
            StringBuilder jsonBuffer = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuffer.append(line);
            }

            // 使用 Gson 库解析 JSON 数据为 Java 对象
            Gson gson = new Gson();
            TicketOrderData ticketOrderData = gson.fromJson(jsonBuffer.toString(), TicketOrderData.class);
//            System.out.println(ticketOrderData);
//            TicketOrderData tikOrdData = new TicketOrderData();
            System.out.println("會員ID="+ticketOrderData.getMemId());  //會員ID
            System.out.println("廠商名稱="+ticketOrderData.getSelName());  //廠商名稱
            System.out.println("活動名稱="+ticketOrderData.getActName());  //活動名稱
            System.out.println("票價="+ticketOrderData.getActTicPrice());  //票價
            System.out.println("數量="+ticketOrderData.getQuantity());  //數量
            System.out.println("小計="+ticketOrderData.getSubtotal());  //小計
            System.out.println("總金額="+ticketOrderData.getTotalAmount());  //總價
            
            
            // step1: 建立訂單
            TicketOrderVO ticketOrder = new TicketOrderVO();
            
//            ticketOrder.getMember().setMemId(ticketOrderData.getMemId()); //會員ID
//            ticketOrder.setTicketOrdStatus(1); //SQL預設為1
            ticketOrder.setTicketOrdTotalPrice(ticketOrderData.getTotalAmount()); // 總金額
            //未做優惠金額
            ticketOrder.setTicketOrdActuallyAmount(ticketOrderData.getTotalAmount()); // 實付金額
//            ticketOrder.setTicketOrdPayStatus();  //SQL預設為1
            //未插入優惠碼ID
            //未做使用者地址
//            ticketOrder.setSelId(ticketOrderData.getSelId()); // 设置厂商ID
            ticketOrder.setTicketOrdCode(generateOrderCode()); // 亂碼代入
            
            
//            String selName = ticketOrderData.getSelName();
//            SellerVO sellerVO = new SellerVO();
//            sellerVO.setSelName();
           
            
            // step2: 建立訂單明細
//            List<TicketOrderDetailVO> orderDetails = new ArrayList<>();
//            for (TicketOrderDetailVO ticketOrderDetailData : ticketOrderData.getCartData()) {
//                TicketOrderDetailVO ticketOrderDetail = new TicketOrderDetailVO();
//                ticketOrderDetail.setActName(ticketOrderDetailData.getActName()); // 活動名稱
//                ticketOrderDetail.setActTicPrice(ticketOrderDetailData.getActTicPrice()); // 活動票價
//                ticketOrderDetail.setQuantity(ticketOrderDetailData.getQuantity()); // 購買數量
//                ticketOrderDetail.setSubtotal(ticketOrderDetailData.getSubtotal()); // 小計

                // 步骤3: 明細關聯到訂單
//                ticketOrderDetail.setTicketOrder(ticketOrder);
//
//                orderDetails.add(ticketOrderDetail);
//            }

            // 步骤4: 使用 Hibernate 保存订单对象
            // 请确保配置了 Hibernate 的 SessionFactory
            // session.save(ticketOrder);

            // 步骤5: 使用 Hibernate 保存订单明细对象（这应该在订单之后进行）
            // 请确保配置了 Hibernate 的 SessionFactory
            // for (TicketOrderDetailVO orderDetail : orderDetails) {
            //     session.save(orderDetail);
            // }

            
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("成功訂單建立！");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("訂單建立失敗");
        }
    }

    private String generateOrderCode() {
    	 SecureRandom random = new SecureRandom();
    	 return new BigInteger(130, random).toString(32).substring(0, 15).toUpperCase();
    }
}


		
		
		/*********************** 1.接收請求參數 *************************/
		
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

//		if ("goToCart".equals(action)) {
//
//			String actName = request.getParameter("actName");
//
//			String quantity = request.getParameter("quantity");
//
//			String total_price = request.getParameter("total_price");
//
//			System.out.println(actName);
//		}

//	}
//
//}
