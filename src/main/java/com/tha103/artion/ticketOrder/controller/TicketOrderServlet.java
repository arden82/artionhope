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

import org.hibernate.jpa.internal.AfterCompletionActionLegacyJpaImpl;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activity.service.ActivityService;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.member.service.MemberService;
import com.tha103.artion.member.service.MemberServiceImp;
import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.seller.service.SellerService;
import com.tha103.artion.ticketOrder.model.TicketOrderDAO;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailDAO;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailVO;

@WebServlet("/ticketOrderServlet")
public class TicketOrderServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

//        session.setAttribute("memId", "7002");
		
        
		
		Integer memId = (Integer) session.getAttribute("memId");
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
		JsonObject jsonObject2 = jsonArray.getJsonObject(0); 
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
			
//			// ============= 設定memID ============= 
			MemberService memberService = new MemberServiceImp();
			MemberVO memberVO = memberService.getMember(memId);
			
			// ============= 將購物車資訊送進訂單資料庫 =============
			TicketOrderVO ticketOrderVO = new TicketOrderVO();
			ticketOrderVO.setMember(memberVO); // 會員編號
			ticketOrderVO.setTicketOrdAddress(memberVO.getMemAddress());
			ticketOrderVO.setTicketOrdTotalPrice(totalSubtotal); // 總金額
			ticketOrderVO.setTicketOrdActuallyAmount(totalSubtotal); // 實付金額
			ticketOrderVO.setSeller(sellerVO); // 廠商編號
			ticketOrderVO.setTicketOrdCode(generateOrderCode()); // 訂單代碼
			TicketOrderDAO ticketOrderDAO = new TicketOrderDAO();
			ticketOrderDAO.insert(ticketOrderVO);
			
			int newTicketOrderPK = ticketOrderVO.getTicketOrdId(); 
System.out.println("新PK值: " + newTicketOrderPK);
	        
	        JsonObject jsonResponse = Json.createObjectBuilder()
	                .add("status", "success")
	                .add("ticOrdId", newTicketOrderPK)
	                .build();

	        response.getWriter().write(jsonResponse.toString());
	        
	     // ============= 存入票卷明細 =============
	        if (jsonArray != null && jsonArray.size() > 0) {
	            TicketOrderDetailDAO ticketOrderDetailDAO = new TicketOrderDetailDAO();

	            for (JsonValue jsonValue : jsonArray) {
	                JsonObject jsonObject = (JsonObject) jsonValue;
	                String actId = jsonObject.getString("actId");
	                int quantity = jsonObject.getInt("quantity");
	                double actTicPrice = jsonObject.getJsonNumber("actTicPrice").doubleValue();

	                ActivityService activityService = new ActivityService();
	                ActivityVO activityVO = activityService.getOneActivity(Integer.parseInt(actId));
	                
	                // 創建新的TicketOrderDetail物件
	                TicketOrderDetailVO ticketOrderDetailVO = new TicketOrderDetailVO();
	                ticketOrderDetailVO.setTicketorder(ticketOrderVO);
	                ticketOrderDetailVO.setActivity(activityVO);
	                ticketOrderDetailVO.setTicOrdDetQuantity(quantity);
	                ticketOrderDetailVO.setTicOrdDetPrice(actTicPrice);

	                // 將該項目插入到TicketOrderDetail表格
	                ticketOrderDetailDAO.insert(ticketOrderDetailVO);
	            }
	        }
	        

		}

	}

	// ============= 15位大寫英文數字亂數 =============
	private String generateOrderCode() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32).substring(0, 15).toUpperCase();
	}
}
	