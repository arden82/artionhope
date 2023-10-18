package com.tha103.artion.seller.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tha103.artion.seller.model.*;
import com.tha103.artion.seller.service.*;


public class SellerServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    
		String str = req.getParameter("sel_id");
	    Integer sel_id = Integer.valueOf(str);

	    SellerServiceImpl sellerSil = new SellerServiceImpl();
	    SellerVO sellerVO = sellerSil.getOneSeller(sel_id);

	    if (sellerVO != null && sellerVO.getSelProfilePicture() != null) {
	        res.setContentType("image/jpeg");
	        InputStream in = new ByteArrayInputStream(sellerVO.getSelProfilePicture());
	        ServletOutputStream out = res.getOutputStream();
	        byte[] buf = new byte[4 * 1024]; // 4K buffer
	        int len;
	        while ((len = in.read(buf)) != -1) {
	            out.write(buf, 0, len);
	        }
	    } else {
	        // Handle the case where sellerVO or its profile picture is null.
	        // You can return an error message or perform other appropriate actions here.
	    }
	}

}
	