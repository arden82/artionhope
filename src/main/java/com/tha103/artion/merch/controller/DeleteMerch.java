package com.tha103.artion.merch.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.administrator.service.AdministratorService;
import com.tha103.artion.administrator.service.AdministratorService_Interface;
import com.tha103.artion.merch.service.MerchService;
import com.tha103.artion.merch.service.MerchService_Interface;

@WebServlet("/deleteMerch")
public class DeleteMerch extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setHeader("Access-Control-Allow-Origin", "*");

		try {

			String strmerchId = req.getParameter("merchId");

			if (strmerchId != null) {

				int merchId = Integer.parseInt(strmerchId);

				MerchService_Interface merchSvc = new MerchService();

				merchSvc.deleteMerch(merchId);

				res.getWriter().write("1");

			} else {
				res.getWriter().write("-1");
			}

		} catch (Exception e) {
			res.getWriter().write("-1");
		}
	}

}
