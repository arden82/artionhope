package com.tha103.artion.promoCode.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.promoCode.service.PromoCodeService;
import com.tha103.artion.promoCode.service.PromoCodeService_Interface;

@WebServlet("/deletePromoCode")
public class DeletePromoCode extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setHeader("Access-Control-Allow-Origin", "*");

		try {

			String strPromoCodeId = req.getParameter("promoCodeId");

			if (strPromoCodeId != null) {

				int promoCodeId = Integer.parseInt(strPromoCodeId);

				PromoCodeService_Interface promoCodeSvc = new PromoCodeService();

				promoCodeSvc.deletePromoCode(promoCodeId);

				res.getWriter().write("1");

			} else {
				res.getWriter().write("-1");
			}

		} catch (Exception e) {
			res.getWriter().write("-1");
		}
	}

}
