package com.tha103.artion.member.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tha103.artion.member.model.MemberVO;

@WebServlet("/member/member.do")
@MultipartConfig
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		   BufferedReader reader = req.getReader();
	        StringBuilder json = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            json.append(line);
	        }
		MemberVO data=gson.fromJson(json.toString(), MemberVO.class);
		
	}
}
