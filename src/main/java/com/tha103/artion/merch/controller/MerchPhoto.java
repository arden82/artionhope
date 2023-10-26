package com.tha103.artion.merch.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.merch.model.MerchVO;
import com.tha103.artion.merch.service.MerchService;
import com.tha103.artion.merch.service.MerchService_Interface;

@WebServlet("/merchPhoto")
public class MerchPhoto extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setHeader("Access-Control-Allow-Origin", "*");

		// ============接受參數===================

		String str = req.getParameter("merchId");
		String merchPicture = req.getParameter("merchPicture");

		if (str == null || str.trim().isEmpty() || merchPicture == null || merchPicture.trim().isEmpty()) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		

		try {

			Integer merchId = Integer.valueOf(str);

			MerchService_Interface merchSvc = new MerchService();
			MerchVO merchVO = merchSvc.getMerchByMerchId(merchId);

			byte[] pictureData = null;

			switch (merchPicture) {
			case "1":
				pictureData = merchVO.getMerchPicture1();
				break;
			case "2":
				pictureData = merchVO.getMerchPicture2();
				break;
			case "3":
				pictureData = merchVO.getMerchPicture3();
				break;
			case "4":
				pictureData = merchVO.getMerchPicture4();
				break;
			default:
				res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}

			if (pictureData != null) {
				res.setContentType("image/gif");
				InputStream in = new ByteArrayInputStream(pictureData);
				ServletOutputStream out = res.getOutputStream();
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
				}
			}

		} catch (NumberFormatException e) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
