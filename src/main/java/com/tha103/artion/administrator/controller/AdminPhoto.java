package com.tha103.artion.administrator.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.administrator.service.AdministratorService;

@WebServlet("/adminphoto")
public class AdminPhoto extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setHeader("Access-Control-Allow-Origin", "*");
		String str = req.getParameter("admId");
		if (str == null || str.trim().isEmpty()) {
		    
		} else {
		    try {
		        Integer admId = Integer.valueOf(str);
		        
		        AdministratorService adminSvc = new AdministratorService();
				AdministratorVO adminVO = adminSvc.getAdminByAdmId(admId);

				res.setContentType("image/gif");
				InputStream in = new ByteArrayInputStream(adminVO.getAdmProfilePhoto());
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
