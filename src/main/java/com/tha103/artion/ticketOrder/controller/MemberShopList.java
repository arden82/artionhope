package com.tha103.artion.ticketOrder.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import com.tha103.artion.ticketOrder.model.TicketOrderVO;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailService;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailVO;

@WebServlet("/membershoplist")
@MultipartConfig
public class MemberShopList extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		Integer memId = (Integer) session.getAttribute("memId");
		if (memId == null) {
			res.sendRedirect(req.getContextPath() + "/html/member/memberLogin.html");
			return;
		}
	System.out.println("memId:" +memId);
		List<Object> listJson = new ArrayList<>();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		TicketOrderService tos = new TicketOrderService();
		Gson gson=null;
		List<TicketOrderVO> list = tos.getTicketlist(memId);
		MemberVO member = tos.getmember(memId);
		if (list.size() == 0) {//從來沒有下訂過
			toObject obj = new toObject();
			obj.getData().put("mem_nickname", String.valueOf(member.getMemNickname()));
			obj.getData().put("memLev_levelName", String.valueOf(member.getMemLevLevel().getMemLevLevelName()));
			listJson.add(obj);
			gson = new Gson();
			String json = gson.toJson(listJson);
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(json);
			return; 
		}
		for (TicketOrderVO alist : list) {
			toObject obj = new toObject();
			TicketOrderDetailService tods = new TicketOrderDetailService();
			TicketOrderDetailVO tickettOrderDetailVO = new TicketOrderDetailVO();
			obj.getData().put("mem_id",memId);
			obj.getData().put("mem_nickname", String.valueOf(alist.getMember().getMemNickname()));
			obj.getData().put("memLev_levelName", String.valueOf(alist.getMember().getMemLevLevel().getMemLevLevelName()));
			obj.getData().put("ticketOrd_id", alist.getTicketOrdId());
			obj.getData().put("ticketOrd_totalPrice", alist.getTicketOrdTotalPrice());
			obj.getData().put("ticketOrd_address", alist.getTicketOrdAddress());
			obj.getData().put("ticketOrd_code", alist.getTicketOrdCode());
			java.util.Date ticketOrdTime=new Date(alist.getTicketOrdTime().getTime());
			String strticketOrdTime =dateformat.format(ticketOrdTime);
			obj.getData().put("ticketOrd_time", strticketOrdTime);
			System.out.println(alist.getTicketOrdId());
			tickettOrderDetailVO = tods.ticketbyticketorder(alist.getTicketOrdId());
			obj.getData().put("ticketOrdDetail_quantity", tickettOrderDetailVO.getTicOrdDetQuantity());
			obj.getData().put("ticOrdDetail_price", tickettOrderDetailVO.getTicOrdDetPrice());
			obj.getData().put("act_id", tickettOrderDetailVO.getActivity().getActId());
			obj.getData().put("act_name", tickettOrderDetailVO.getActivity().getActName());
			listJson.add(obj);
		}
		gson = new Gson();
		String json = gson.toJson(listJson);
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(json);
		return; 

	}
}

	class toObject {
		private Map<String, Object> obj = new HashMap<>();
	
		public Map<String, Object> getData() {
			return obj;
		}
}
