package com.tha103.artion.activityComment.controller;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.activityComment.model.ActivityCommentService;



@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ActivityCommentServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String url = null;
		
		/* ============ 新增資料 ============ */
		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			String actComContent = req.getParameter("actComContent");
			if (actComContent != null && actComContent.trim().equals("")) {
				errorMsgs.add("活動留言請勿空白");
			}

			Integer memId = null;
			try {
				memId = Integer.valueOf(req.getParameter("memId"));
				if(memId == null || memId <7001) {
					errorMsgs.add("會員編號請勿空白或小於7001");
				}
			} catch (NumberFormatException e) {
				errorMsgs.add("");
			}

			Integer actId = null;
			try {
				actId = Integer.valueOf(req.getParameter("actId"));
				if(actId == null || actId <10001) {
					errorMsgs.add("活動編號請勿空白或小於10001");
				}
			} catch (NumberFormatException e) {
				errorMsgs.add("");
			}		

			ActivityCommentVO activityCommentVO = new ActivityCommentVO();
			activityCommentVO.setMember(member);
			activityCommentVO.setActivity(activity);
			activityCommentVO.setActComContent(actComContent);


			if (!errorMsgs.isEmpty()) {
				 url = "/activitycomment/addComment.jsp";
				RequestDispatcher failureView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				failureView.forward(req, res);
			}

			/*************************** 2.開始新增資料 ***************************************/
			byte[] actComCoverPicture = null;
			byte[] actComPicture1 = null;
			byte[] actComPicture2 = null;
			byte[] actComPicture3 = null;
			String filename =null;
			String partName =null;
			
			Collection<Part> parts = req.getParts();
			for (Part part : parts) {
			 filename = part.getSubmittedFileName();
				partName = part.getName();
				if (filename!= null && filename.length()!=0 && part.getContentType()!=null) {
					
					if ("actCom_CoverPicture".equals(partName)) {
						InputStream is = part.getInputStream();
						ByteArrayOutputStream byteA = new ByteArrayOutputStream();
						     byte[] buf = new byte[4 * 1024];
						     int len;
						     while ((len = is.read(buf)) != -1) {
						      byteA.write(buf, 0, len);
						     }
						     actComCoverPicture = byteA.toByteArray();
						     byteA.close();
					}
					if ("actCom_Picture1".equals(partName)) {
						InputStream is = part.getInputStream();
						ByteArrayOutputStream byteA = new ByteArrayOutputStream();
						     byte[] buf = new byte[4 * 1024];
						     int len;
						     while ((len = is.read(buf)) != -1) {
						      byteA.write(buf, 0, len);
						     }
						     actComPicture1 = byteA.toByteArray();
						     byteA.close();
					}
					if ("actCom_Picture2".equals(partName)) {
						InputStream is = part.getInputStream();
						ByteArrayOutputStream byteA = new ByteArrayOutputStream();
						byte[] buf = new byte[4 * 1024];
						int len;
						while ((len = is.read(buf)) != -1) {
							byteA.write(buf, 0, len);
						}
						actComPicture2 = byteA.toByteArray();
						byteA.close();
					}
					
					if ("actCom_Picture3".equals(partName)) {
						InputStream is = part.getInputStream();
						ByteArrayOutputStream byteA = new ByteArrayOutputStream();
						byte[] buf = new byte[4 * 1024];
						int len;
						while ((len = is.read(buf)) != -1) {
							byteA.write(buf, 0, len);
						}
						actComPicture3 = byteA.toByteArray();
						byteA.close();
					}
					
					}
				}

			ActivityCommentService actComSvc = new ActivityCommentService();
			activityCommentVO = actComSvc.addActivityComment(null, memId, actId, actComContent, null, null, null,
					actComCoverPicture, actComPicture1, actComPicture2, actComPicture3, true);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			url = "/activitycomment/listAllActCom.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);

		}
		
	}
}
