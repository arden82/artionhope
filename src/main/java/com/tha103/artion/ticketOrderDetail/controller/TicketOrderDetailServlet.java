package com.tha103.artion.ticketOrderDetail.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.promoCode.model.PromoCodeVO;
import com.tha103.artion.promoCode.service.PromoCodeService;
import com.tha103.artion.promoCode.service.PromoCodeService_Interface;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailService;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailVO;

@WebServlet("/getAllTicketOrderDets")
public class TicketOrderDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setHeader("Access-Control-Allow-Origin", "*");

		TicketOrderDetailService ticketOrderDetailSvc = new TicketOrderDetailService();
		List<TicketOrderDetailVO> ticketOrderDetailList = ticketOrderDetailSvc.getAllTicketOrderDets();

		List<Map<String, Object>> ticketOrderDetailMapList = new ArrayList<>();
		for (TicketOrderDetailVO ticketOrderDetail : ticketOrderDetailList) {
			Map<String, Object> ticketOrderMap = new HashMap<>();
			ticketOrderMap.put("actName", ticketOrderDetail.getActivity().getActId());
			ticketOrderMap.put("actTicPrice", ticketOrderDetail.getActivity().getActTicketPrice());
			ticketOrderMap.put("promoCodeCode", ticketOrderDetail.getTicOrdDetQuantity());
			ticketOrderMap.put("proCodeType", ticketOrderDetail.getTicOrdDetPrice());
			

			promoCodeMapList.add(promoCodeMap);
		}
		Gson gson = new Gson();
		String json = gson.toJson(promoCodeMapList);

		PrintWriter out = res.getWriter();
		out.print(json); // 將JSON字串寫入響應
		out.flush();
	}
	
	

}

