package com.tha103.artion.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/memberlogout")
public class MemberLogout extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession session=req.getSession(false);
		if (session != null) {
            session.invalidate(); //讓session無效
        }
		res.sendRedirect(req.getContextPath() + "/html/activity/ActivityPage.html");
		return;
	}
}
