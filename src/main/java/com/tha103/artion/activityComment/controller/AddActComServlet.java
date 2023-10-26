package com.tha103.artion.activityComment.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

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
			
			
			
			
//			Collection<Part> parts = req.getParts();
//			for (Part part : parts) {
//			 filename = part.getSubmittedFileName();
//				partName = part.getName();
//				if (filename!= null && filename.length()!=0 && part.getContentType()!=null) {
//					
//					if ("actComCoverPicture".equals(partName)) {
//						InputStream is = part.getInputStream();
//						ByteArrayOutputStream byteA = new ByteArrayOutputStream();
//						     byte[] buf = new byte[4 * 1024];
//						     int len;
//						     while ((len = is.read(buf)) != -1) {
//						      byteA.write(buf, 0, len);
//						     }
//						     actComCoverPicture = byteA.toByteArray();
//						     byteA.close();
//					}
//					if ("actComPicture1".equals(partName)) {
//						InputStream is = part.getInputStream();
//						ByteArrayOutputStream byteA = new ByteArrayOutputStream();
//						     byte[] buf = new byte[4 * 1024];
//						     int len;
//						     while ((len = is.read(buf)) != -1) {
//						      byteA.write(buf, 0, len);
//						     }
//						     actComPicture1 = byteA.toByteArray();
//						     byteA.close();
//					}
//					if ("actComPicture2".equals(partName)) {
//						InputStream is = part.getInputStream();
//						ByteArrayOutputStream byteA = new ByteArrayOutputStream();
//						byte[] buf = new byte[4 * 1024];
//						int len;
//						while ((len = is.read(buf)) != -1) {
//							byteA.write(buf, 0, len);
//						}
//						actComPicture2 = byteA.toByteArray();
//						byteA.close();
//					}
//					
//					if ("actComPicture3".equals(partName)) {
//						InputStream is = part.getInputStream();
//						ByteArrayOutputStream byteA = new ByteArrayOutputStream();
//						byte[] buf = new byte[4 * 1024];
//						int len;
//						while ((len = is.read(buf)) != -1) {
//							byteA.write(buf, 0, len);
//						}
//						actComPicture3 = byteA.toByteArray();
//						byteA.close();
//					}
//					
//					}
//				}
			MemberVO memberVO = new MemberVO();  //改成動態會員id
			memberVO.setMemId(7001);
			
			activityCommentVO.setMember(memberVO);
			
			ActivityCommentService actComSvc = new ActivityCommentService();
			
			activityCommentVO = actComSvc.addActCom(activityCommentVO);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//			url = "/activitycomment/listAllActCom.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);

		}
		
//		===========================================================
//		PrintWriter out = res.getWriter();
//		HttpSession session = req.getSession();
//		
////		接收參數
//		String actComContent = req.getParameter("actComContent");
//	    String actIdParam = req.getParameter("actId");
//	    Part part1 = req.getPart("actComCoverPicture");
//		Part part2 = req.getPart("actComPicture1");
//		Part part3 = req.getPart("actComPicture2");
//		Part part4 = req.getPart("actComPicture3");
//	    byte[] actComCoverPicture = null;
//		byte[] actComPicture1 = null;
//		byte[] actComPicture2 = null;
//		byte[] actComPicture3 = null;
//		
//		if (part1 != null && part1.getSize() > 0) {
//			InputStream in = part1.getInputStream();
//			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//			byte[] buf = new byte[4 * 1024]; // 4K buffer
//			int len;
//			while ((len = in.read(buf)) != -1) {
//				byteArrayOutputStream.write(buf, 0, len);
//			}
//			actComCoverPicture = byteArrayOutputStream.toByteArray();
//		}
//		
//		if (part2 != null && part1.getSize() > 0) {
//			InputStream in = part1.getInputStream();
//			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//			byte[] buf = new byte[4 * 1024]; // 4K buffer
//			int len;
//			while ((len = in.read(buf)) != -1) {
//				byteArrayOutputStream.write(buf, 0, len);
//			}
//			actComPicture1 = byteArrayOutputStream.toByteArray();
//		}
//
//		if (part3 != null && part1.getSize() > 0) {
//			InputStream in = part1.getInputStream();
//			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//			byte[] buf = new byte[4 * 1024]; // 4K buffer
//			int len;
//			while ((len = in.read(buf)) != -1) {
//				byteArrayOutputStream.write(buf, 0, len);
//			}
//			actComPicture2 = byteArrayOutputStream.toByteArray();
//		}
//		
//		if (part3 != null && part1.getSize() > 0) {
//			InputStream in = part1.getInputStream();
//			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//			byte[] buf = new byte[4 * 1024]; // 4K buffer
//			int len;
//			while ((len = in.read(buf)) != -1) {
//				byteArrayOutputStream.write(buf, 0, len);
//			}
//			actComPicture3 = byteArrayOutputStream.toByteArray();
//		}
		
		
//	    try {
//	        System.out.println("actComContent: " + actComContent);
//	        
//	        ActivityCommentService actComSvc = new ActivityCommentService();
//	        ActivityCommentVO actComVO = new ActivityCommentVO();
//	        MemberVO memberVO = new MemberVO();
//        	memberVO.setMemId(7001); // 7001是在Servlet中硬编码的，你可以根据需要进行修改
//        	actComVO.setMember(memberVO);
//        	
//	        actComVO.setActComContent(actComContent);
//	        actComVO.setActComCoverPicture(actComCoverPicture);
//	        actComVO.setActComPicture1(actComPicture1);
//	        actComVO.setActComPicture2(actComPicture2);
//	        actComVO.setActComPicture3(actComPicture3);
//	        actComVO.setActComReportTimes(0); 
//        	actComVO.setActComLikeTimes(0); 
//        	actComVO.setActComStatus(true);
//	        
//        	actComSvc.addActCom(actComVO);
//        	System.out.println("傳送資料庫成功");
//	      
//        	Gson gson = new Gson();
//			String json = gson.toJson(res);
//			out.print(json);
//			out.flush();
//	        
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
	}
}


