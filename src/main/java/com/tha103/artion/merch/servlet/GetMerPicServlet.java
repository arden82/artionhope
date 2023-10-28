package com.tha103.artion.merch.servlet;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.merch.model.MerchVO;
import com.tha103.artion.merch.service.MerchService;

@WebServlet("/merPicServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class GetMerPicServlet extends HttpServlet{
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  
		ServletOutputStream out = res.getOutputStream();
	    res.setContentType("image/gif");
	    ByteArrayInputStream byteInputStream = null;
	    
	    try {
			String string = req.getParameter("merchId");
			String picNumber = req.getParameter("picNumber");
	        Integer merchId = Integer.valueOf(string);
	        MerchService merchSvc = new MerchService();
	        MerchVO merchVO =merchSvc.getMerchByMerchId(merchId);
	        
	        if ("1".equals(picNumber)) {
	        	byteInputStream = new ByteArrayInputStream(merchVO.getMerchPicture1());
	        } else if ("2".equals(picNumber)) {
	        	byteInputStream = new ByteArrayInputStream(merchVO.getMerchPicture2());
	        } else if ("3".equals(picNumber)) {
	        	byteInputStream = new ByteArrayInputStream(merchVO.getMerchPicture3());
	        } else if ("4".equals(picNumber)) {
	        	byteInputStream = new ByteArrayInputStream(merchVO.getMerchPicture4());
	        }
	        
	        BufferedInputStream in = new BufferedInputStream(byteInputStream);
	        byte[] buf = new byte[4 * 1024]; // 4K buffer
	        int len;
	        while ((len = in.read(buf)) != -1) {
	            out.write(buf, 0, len);
	        }
	        in.close();
	        
		} catch (Exception e) {
			InputStream in = getServletContext().getResourceAsStream("images/1.jpg");
			   byte[] b = new byte[in.available()];
			   in.read(b);
			   out.write(b);
			   in.close();
		}
	 }
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  
	  doGet(req, res);
	 }


}
