package com.tha103.artion.activityComment.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.activityComment.service.ActivityCommentService;
import com.tha103.artion.member.model.MemberVO;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/addActComServlet")
public class AddActComServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		res.setHeader("Access-Control-Allow-Origin", "*");
		String action = req.getParameter("action");
		System.out.println(action);
		String url = null;
		System.out.println("成功轉到Servlet");
		/* ============ 新增資料 ============ */
		if ("insert".equals(action)) {

			String actComContent = req.getParameter("actComContent");
			String actIdString = req.getParameter("actId");
			System.out.println("actIdString = " + actIdString);
			ActivityCommentVO activityCommentVO = new ActivityCommentVO();
			activityCommentVO.setActComContent(actComContent);
			ActivityVO activityVO = new ActivityVO();
			activityVO.setActId(Integer.valueOf(actIdString));
			activityCommentVO.setActivity(activityVO);
			
			/*************************** 2.開始新增資料 ***************************************/
			byte[] actComCoverPicture = null;
			byte[] actComPicture1 = null;
			byte[] actComPicture2 = null;
			byte[] actComPicture3 = null;
			String filename =null;
			String partName =null;
			
			Part part1 = req.getPart("actComCovPicture");
			if (part1 != null) {
				actComCoverPicture = part1.getInputStream().readAllBytes();
			}
			
			activityCommentVO.setActComCoverPicture(actComCoverPicture);
			
			Part part2 = req.getPart("actComPicture1");
			if (part2 != null) {
				actComPicture1 = part2.getInputStream().readAllBytes();
			}
			
			activityCommentVO.setActComPicture1(actComPicture1);
			
			Part part3 = req.getPart("actComPicture2");
			if (part3 != null) {
				actComPicture2 = part3.getInputStream().readAllBytes();
			}
			
			activityCommentVO.setActComPicture2(actComPicture2);
			
			Part part4 = req.getPart("actComPicture3");
			if (part4 != null) {
				actComPicture3 = part4.getInputStream().readAllBytes();
			}
			
			activityCommentVO.setActComPicture3(actComPicture3);
			
			MemberVO memberVO = new MemberVO();  //改成動態會員id
			memberVO.setMemId(7001);
			activityCommentVO.setMember(memberVO);
			
			activityCommentVO.setActComLikeTimes(0);
			activityCommentVO.setActComReportTimes(0);
			
			
			ActivityCommentService actComSvc = new ActivityCommentService();
			
			activityCommentVO = actComSvc.addActCom(activityCommentVO);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			url = "/singleActivity.html?"+ actIdString;
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}
	}
}


