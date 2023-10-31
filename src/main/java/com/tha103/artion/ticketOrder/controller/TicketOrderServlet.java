package com.tha103.artion.ticketOrder.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.member.service.MemberService;
import com.tha103.artion.member.service.MemberServiceImp;
import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.seller.service.SellerService;
import com.tha103.artion.ticketOrder.model.TicketOrderDAO;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;

@WebServlet("/ticketOrderServlet")
public class TicketOrderServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

        session.setAttribute("memId", "7001");
		
		String memId = (String) session.getAttribute("memId");
		System.out.println(memId);
		BufferedReader reader = request.getReader();
		StringBuilder jsonInput = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null) {
			jsonInput.append(line);
		}

		// ============= 取得ajax串來的json陣列 =============
		String jsonData = jsonInput.toString();
		JsonReader jsonReader = Json.createReader(new StringReader(jsonData));
		JsonArray jsonArray = jsonReader.readArray();
		System.out.println(jsonArray);

		// ============= 取得陣列中第一個json的selId =============
		JsonObject jsonObject2 = jsonArray.getJsonObject(0); // 获取数组中的每个 JSON 对象
		if (jsonObject2.containsKey("selId")) {
			String selId = jsonObject2.getString("selId");
			System.out.println("selId=" + selId);
			SellerService sellerService = new SellerService();
			int selIdInt = Integer.parseInt(selId);
			SellerVO sellerVO = sellerService.getOneSeller(selIdInt);
			
			// ============= 計算訂單總金額 =============
			double totalSubtotal = 0.0;
			for (JsonValue jsonValue : jsonArray) {
				JsonObject jsonObject = (JsonObject) jsonValue;
				double subtotal = jsonObject.getJsonNumber("subtotal").doubleValue();
				totalSubtotal += subtotal;
			}
			
			// ============= 設定memID ============= 
			MemberService memberService = new MemberServiceImp();
			MemberVO memberVO = memberService.getMember(Integer.parseInt(memId));
			
			
			
			TicketOrderVO ticketOrderVO = new TicketOrderVO();
			ticketOrderVO.setMember(memberVO); 
			ticketOrderVO.setTicketOrdAddress(memberVO.getMemAddress());
			ticketOrderVO.setTicketOrdTotalPrice(totalSubtotal); // 總金額(完成)
			ticketOrderVO.setTicketOrdActuallyAmount(totalSubtotal); // 實付金額(完成)
			ticketOrderVO.setSeller(sellerVO);
			ticketOrderVO.setTicketOrdCode(generateOrderCode()); // 訂單代碼(完成)
			TicketOrderDAO ticketOrderDAO = new TicketOrderDAO();
			ticketOrderDAO.insert(ticketOrderVO);
		}

	}
//	        List<> dataList = new ArrayList<>();

	// 15位大寫英文數字亂數
	private String generateOrderCode() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32).substring(0, 15).toUpperCase();
	}

//	        for (JsonValue jsonValue : jsonArray) {
//	            JsonObject jsonObject = (JsonObject) jsonValue;
//	            String actName = jsonObject.getString("actName");
//	            // ...
//	            // 创建 YourDataClass 对象并添加到 dataList 中
//	        }

	// 现在 dataList 包含了解析后的数据，你可以在这里进行进一步的处理
}

//		    
//		  MemberVO memberVO = new MemberVO();
//          MemberService mscImp = new MemberServiceImp();
//          memberVO =mscImp.getMember(memId);
//          
//          SellerVO sellerVO = new SellerVO();
//          SellerService selSvc = new SellerService();
//          sellerVO = selSvc.getOneSeller(selId);
//		    

//		    for (JsonObject item : cartData.getValuesAs(JsonObject.class)) {
//		        String selName = item.getString("selName");
//		        String actName = item.getString("actName");
//		        double actTicPrice = item.getJsonNumber("actTicPrice").doubleValue();
//		        int quantity = item.getInt("quantity");
//		        double subtotal = item.getJsonNumber("subtotal").doubleValue();
//		        
//		        System.out.println("selName: " + selName);
//		        System.out.println("actName: " + actName);
//		        System.out.println("actTicPrice: " + actTicPrice);
//		        System.out.println("quantity: " + quantity);
//		        System.out.println("subtotal: " + subtotal);
//		    }
//		    SellerDAO sellerDAO = new SellerDAO();
//
//		 // 获取第一筆資料的 selName
//		 String firstSelName = cartData.get(0).getString("selName");
//
//		 // 使用 selName 查询对应的 selId
//		 int selId = sellerDAO.findSelIdBySelName(firstSelName);
//
//		 System.out.println("selId: " + selId);

//		jsonReader.close();
//	}catch(
////
//	JsonParsingException e)
//	{
//		e.printStackTrace();
//	}
//	}
//	}

// 取得ticketOrderData所有參數
//            int memId = ticketOrderData.getMemId();
//           HttpSession session =request.getSession();
//           Integer memId= (Integer)session.getAttribute("memId");
//            double ticketTotalAmount = ticketOrderData.getTotalAmount();
//            String selName = ticketOrderData.getCartData().get(0).getSelName();
//            System.out.println(memId);

//            SellerDAO sellerDAO = new SellerDAO(); 
//            String selName = ticketOrderData.getCartData().get(0).getSelName(); // 假设 selName 就在 cartData 的第一项
//            Integer selId = sellerDAO.findSelIdBySelName(selName);

//            MemberVO memberVO = new MemberVO();
//            MemberService mscImp = new MemberServiceImp();
//            memberVO =mscImp.getMember(memId);
//            
//            SellerVO sellerVO = new SellerVO();
//            SellerService selSvc = new SellerService();
//            sellerVO = selSvc.getOneSeller(selId);

// step1: 建立訂單
//            TicketOrderVO ticketOrder = new TicketOrderVO();
//            ticketOrder.setMember(memberVO); //會員ID
//            ticketOrder.setTicketOrdStatus(1); //SQL預設為1
//            ticketOrder.setTicketOrdTotalPrice(ticketOrderData.getTotalAmount()); // 總金額
// 未做優惠金額
//            ticketOrder.setTicketOrdActuallyAmount(ticketOrderData.getTotalAmount()); // 實付金額
//            ticketOrder.setTicketOrdPayStatus();  //SQL預設為1
// 未插入優惠碼ID
// 未做使用者地址
//            ticketOrder.setSeller(sellerVO);// 廠商ID
//            ticketOrder.setTicketOrdCode(generateOrderCode()); // 亂碼代入
//            
//            TicketOrderService ticketOrderService = new TicketOrderService(); // 假设你有一个 Service 接口
//            ticketOrderService.add(ticketOrder);

//            String selName = ((ItemData) cartData).getSelName();
//            String actName = ((ItemData) cartData).getActName();
//            double actTicPrice  = ((ItemData) cartData).getActTicPrice();
//            int quantity  = ((ItemData) cartData).getQuantity();
//            double subtotal  = ((ItemData) cartData).getSubtotal();
//            System.out.println(selName);
//            System.out.println(actName);
//            System.out.println(actTicPrice);
//            System.out.println(quantity);
//            System.out.println(subtotal);

//            Ticketln("總金額="+ticketOrderData.getTotalAmount());  //總價
//            OrderData tikOrdData = new TicketOrderData();
//            System.out.println("會員ID="+ticketOrderData.getMemId());  //會員ID
//            System.out.println("廠商名稱="+ticketOrderData.getSelName());  //廠商名稱
//            System.out.println("活動名稱="+ticketOrderData.getActName());  //活動名稱
//            System.out.println("票價="+ticketOrderData.getActTicPrice());  //票價
//            System.out.println("數量="+ticketOrderData.getQuantity());  //數量
//            System.out.println("小計="+ticketOrderData.getSubtotal());  //小計
//            System.out.print
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
// session.save(orderDetail);
// }

//            response.setStatus(HttpServletResponse.SC_OK);
//            response.getWriter().println("成功訂單建立！");
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            response.getWriter().println("訂單建立失敗");
//        }
//    }

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
