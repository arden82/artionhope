package com.tha103.artion.merch;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.merch.service.MerchService;
import com.tha103.artion.merch.service.MerchService_Interface;

@WebServlet("/DeleteMerch")
public class DeleteMerch extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		
		res.setHeader("Access-Control-Allow-Origin", "*");
		
		try {
			
		String strMerchId = req.getParameter("merchId");
		
		System.out.println(strMerchId);
		
		if (strMerchId != null) {
			
			int merchId = Integer.parseInt(strMerchId);
			
			MerchService_Interface merchSvc = new MerchService();
			
			merchSvc.deleteMerch(merchId);
			
			res.getWriter().write("1");
			
		}else {
			res.getWriter().write("-1");
		}
			
		} catch (Exception e) {
			res.getWriter().write("-1");
		}
	}

}
