package com.tha103.artion.activityComment.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.activityComment.service.ActivityCommentService;

@WebServlet("/actComPicServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ActComPicServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String str = req.getParameter("actComId");
		String picNumber = req.getParameter("picNumber"); // Parameter to indicate which picture to fetch (cover, 1, 2,
															// or 3)

		if (str == null || str.trim().isEmpty() || picNumber == null || picNumber.trim().isEmpty()) {
			// Handle invalid request
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		try {
			Integer actComId = Integer.valueOf(str);
			ActivityCommentService actComSvc = new ActivityCommentService();
			ActivityCommentVO actComVO = actComSvc.getOneActCom(actComId);

			byte[] pictureData = null;

			// Determine which picture to retrieve based on picNumber
			switch (picNumber) {
			case "cover":
				pictureData = actComVO.getActComCoverPicture();
				break;
			case "1":
				pictureData = actComVO.getActComPicture1();
				break;
			case "2":
				pictureData = actComVO.getActComPicture2();
				break;
			case "3":
				pictureData = actComVO.getActComPicture3();
				break;
			default:
				// Handle invalid picNumber
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
			// Handle invalid actComId
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
