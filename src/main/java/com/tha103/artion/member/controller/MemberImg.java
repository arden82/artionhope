package com.tha103.artion.member.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.member.service.MemberService;
import com.tha103.artion.member.service.MemberServiceImp;


@WebServlet("/memberImg")
public class MemberImg extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletOutputStream out = res.getOutputStream();
		res.setContentType("image/gif");
		try {
			String id=req.getParameter("id").trim();
			MemberService memSvc =new MemberServiceImp();
			Integer intID = Integer.valueOf(id);
			MemberVO memberVO =memSvc.getMember(intID);
			ByteArrayInputStream byteInputStream = new ByteArrayInputStream(memberVO.getMemProfilePhoto());
			BufferedInputStream in = new BufferedInputStream(byteInputStream);
			byte[] buf = new byte[4 * 1024]; // 4K buffer
			int len;
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			in.close();
	
		} catch (Exception e) {

			InputStream in = getServletContext().getResourceAsStream("/images/artionLogo.png");
			byte[] b = new byte[in.available()];
			in.read(b);
			out.write(b);
			in.close();
		}
	}
}
