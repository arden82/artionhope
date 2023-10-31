package com.tha103.artion.ticketOrder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.member.service.MemberService;
import com.tha103.artion.member.service.MemberServiceImp;
import com.tha103.artion.ticketOrder.model.TicketOrderService;
import com.tha103.artion.ticketOrder.model.TicketOrderService_Interface;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;

@WebServlet("/showOneOrder")
public class showOneOrder extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setHeader("Access-Control-Allow-Origin", "*");
		HttpSession session = req.getSession();
		
//		String action = req.getParameter("action");
		
		//拿會員id
//		String sessionMemId = session.getAttribute("memId").toString();
//		Integer memId = Integer.valueOf(sessionMemId);
		String string = req.getParameter("memId");
		Integer memId = Integer.valueOf(string);
		System.out.println(memId);
		//拿訂單id
		String str = req.getParameter("ticketOrdId");
		Integer ticketOrdId = Integer.valueOf(str);
//		int ticketOrdId = 134789;
		
		//會員id查詢
		MemberService memSvc = new MemberServiceImp();
		MemberVO memberVO = memSvc.getMember(memId);
		String memName = memberVO.getMemName();
		System.out.println(memName);

		//訂單id查詢
		TicketOrderService_Interface ticOrdSvc = new TicketOrderService();
		//拿訂單代號
		String ticketOrdCode = ticOrdSvc.getTicketOrderById(ticketOrdId).getTicketOrdCode();
		System.out.println(ticketOrdCode);
		//拿訂單時間
		Timestamp ticketOrdTime = ticOrdSvc.getTicketOrderById(ticketOrdId).getTicketOrdTime();
		//拿廠商名稱
		String selName = ticOrdSvc.getTicketOrderById(ticketOrdId).getSeller().getSelName();
		System.out.println(selName);
		
		//拿訂單明細
		
		
		Map<String, Object> ticketMap = new HashMap<>();
		
		ticketMap.put("ticketOrdId", ticketOrdId);
		ticketMap.put("memName", memName);
		ticketMap.put("ticketOrdCode", ticketOrdCode);
		ticketMap.put("ticketOrdTime", ticketOrdTime);
		ticketMap.put("selName", selName);
		
		Gson gson= new Gson();
		
		String json = gson.toJson(ticketMap);
		
		PrintWriter out = res.getWriter();
		out.print(json); // 將JSON字串寫入響應
		out.flush();
		
	}

}
