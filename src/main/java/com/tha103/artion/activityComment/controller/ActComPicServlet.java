package com.tha103.artion.activityComment.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.activityComment.service.ActivityCommentService;

@WebServlet("/actComPicServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ActComPicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 ServletOutputStream out = res.getOutputStream();
		  res.setContentType("image/gif");
		  ByteArrayInputStream byteInputStream =null;
		  try {
			  String str = req.getParameter("actComId");
			  String actComCoverPicture=req.getParameter("actComCoverPicture");
			  String actComPicture1=req.getParameter("actComPicture1");
			  String actComPicture2=req.getParameter("actComPicture2");
			  String actComPicture3=req.getParameter("actComPicture3");
			  Integer actComId;
			  actComId = Integer.valueOf(str);
			  ActivityCommentService actComSvc = new ActivityCommentService();
			  ActivityCommentVO ActivityCommentVO = actComSvc.getOneActCom(actComId);
	
		if(actComCoverPicture!=null) {
			 byteInputStream = new ByteArrayInputStream(ActivityCommentVO.getActComCoverPicture());
		}else if(actComPicture1!=null) {
			 byteInputStream = new ByteArrayInputStream(ActivityCommentVO.getActComPicture1());
		}else if(actComPicture2!=null){
			 byteInputStream = new ByteArrayInputStream(ActivityCommentVO.getActComPicture2());
		}else{
			 byteInputStream = new ByteArrayInputStream(ActivityCommentVO.getActComPicture3());
		}
		   BufferedInputStream in = new BufferedInputStream(byteInputStream);
		   byte[] buf = new byte[4 * 1024]; // 4K buffer
		   int len;
		   while ((len = in.read(buf)) != -1) {
		    out.write(buf, 0, len);
		   }
		   in.close();
		 
		  } catch (Exception e) {
//		   InputStream in = getServletContext().getResourceAsStream("images/1.jpg");
//		   byte[] b = new byte[in.available()];
//		   in.read(b);
//		   out.write(b);
//		   in.close();
		  }

		
		 }
}
