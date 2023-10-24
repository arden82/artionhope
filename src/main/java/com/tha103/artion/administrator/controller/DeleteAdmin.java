package com.tha103.artion.administrator.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.administrator.service.AdministratorService;
import com.tha103.artion.administrator.service.AdministratorService_Interface;

@WebServlet("/DeleteAdmin")
public class DeleteAdmin extends HttpServlet{
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doPost(req, res);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			try {
				
			String strAdmId = req.getParameter("admId");
			
			if (strAdmId != null) {
				
				int admId = Integer.parseInt(strAdmId);
				
				AdministratorService_Interface admSvc = new AdministratorService();
				
				admSvc.deleteAdmin(admId);
				
				res.getWriter().write("1");
				
			}else {
				res.getWriter().write("-1");
			}
				
			} catch (Exception e) {
				res.getWriter().write("-1");
			}
		}

	
	
}
