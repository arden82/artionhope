package com.tha103.artion.activity.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tha103.artion.activity.model.ActivityDAO;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activity.service.ActivityService;

@WebServlet("/actComPicServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class GetActPicServlet extends HttpServlet{

	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  
	  String str = req.getParameter("actId");
	  if (str == null || str.trim().isEmpty()) {
	      
	  } else {
	      try {
	          Integer actId = Integer.valueOf(str);
	          
	          ActivityService actSvc = new ActivityService();
	          ActivityVO actVO = actSvc.getOneActivity(actId);

	    res.setContentType("image/gif");
	    InputStream in = new ByteArrayInputStream(actVO.getActCoverPicture());
	    ServletOutputStream out = res.getOutputStream();
	    byte[] buf = new byte[4 * 1024]; // 4K buffer
	    int len;
	    while ((len = in.read(buf)) != -1) {
	     out.write(buf, 0, len);
	    }
	      } catch (NumberFormatException e) {
	          // 如果無法轉換為整數，處理錯誤或執行適當的操作
	      }
	  }
	 }
	 
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  
	  doGet(req, res);
	 }
}

	
