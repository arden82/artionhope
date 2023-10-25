package com.tha103.artion.administrator.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.google.gson.Gson;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.administrator.service.AdministratorService;
import com.tha103.artion.administrator.service.AdministratorService_Interface;

@WebServlet("/loginAdmin")
public class LoginAdmin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
			res.setHeader("Access-Control-Allow-Origin", "*");
			PrintWriter out = res.getWriter();
			Gson gson = new Gson();
			HashMap<String, String> data = new HashMap<>();
		
			//==========接受請求參數=====================
		
			String mail = req.getParameter("mail");
			String password = req.getParameter("password"); 
		
			//==========接受請求參數=====================

		
			System.out.println(password);
			
			AdministratorService_Interface admSvc = new AdministratorService();
			
			
			if(admSvc.checkAdminMail(mail) == null) {
				data.put("status", "pswFailed");
				System.out.println(data);
				String json = gson.toJson(data);
				out.write(json);
				return;
			}
			if (!admSvc.checkAdminMail(mail).getAdmPassword().equals(password)) {
				data.put("status", "pswFailed");
				System.out.println(data);
				String json = gson.toJson(data);
				out.write(json);
				return;
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("mail", mail);
			
			String admId = admSvc.checkAdminMail(mail).getAdmId().toString();
			session.setAttribute("admId", admId);
			
			data.put("status","success");
			data.put("admId", admId);
			data.put("mail", mail);
			
			String json = gson.toJson(data);
			out.write(json);
			
			
		
		

	}

}
