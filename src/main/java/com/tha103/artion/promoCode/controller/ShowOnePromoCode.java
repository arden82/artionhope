package com.tha103.artion.promoCode.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tha103.artion.promoCode.model.PromoCodeEmailDAO;
import com.tha103.artion.promoCode.service.PromoCodeService;
import com.tha103.artion.promoCode.service.PromoCodeService_Interface;

@WebServlet("/showOnePromoCode")
public class ShowOnePromoCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").excludeFieldsWithoutExposeAnnotation()
			.create();
	private PromoCodeService_Interface service;

	@Override
	public void init() throws ServletException {
		service = new PromoCodeService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var promoCodeId = Integer.valueOf(req.getParameter("promoCodeId"));
		var vo = service.getByPromoCodeId(promoCodeId);
		resp.setContentType("application/json; charset=utf-8");
		String jsonStr = gson.toJson(vo);
		PrintWriter out = resp.getWriter();
		out.write(jsonStr);

		resp.getWriter().write(gson.toJson(new PromoCodeEmailDAO().selectAllMemberEmail()));
	}
}
