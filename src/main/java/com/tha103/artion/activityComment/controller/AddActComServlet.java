package com.tha103.artion.activityComment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.activityComment.service.ActivityCommentService;
import com.tha103.artion.member.model.MemberVO;

@WebServlet("/addActComServlet")
public class AddActComServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String actComContent = request.getParameter("actComContent");
	    String actIdParam = request.getParameter("actId");
//	    byte[] actComCoverPicture = null;
//		byte[] actComPicture1 = null;
//		byte[] actComPicture2 = null;
//		byte[] actComPicture3 = null;

	    try {
	        System.out.println("actComContent: " + actComContent);
	        System.out.println("actIdParam: " + actIdParam);

	        if (actComContent != null && !actComContent.trim().isEmpty()) {
	        	ActivityCommentVO actComVO = new ActivityCommentVO();

	        	// 初始化ActivityVO
	        	ActivityVO activityVO = new ActivityVO();
	        	activityVO.setActId(Integer.parseInt(actIdParam));
	        	actComVO.setActivity(activityVO);

	        	// 初始化MemberVO
	        	MemberVO memberVO = new MemberVO();
	        	memberVO.setMemId(7001); // 7001是在Servlet中硬编码的，你可以根据需要进行修改
	        	actComVO.setMember(memberVO);

	        	actComVO.setActComContent(actComContent);
	        	actComVO.setActComReportTimes(0); // 可以根据需要设置报告次数
	        	actComVO.setActComLikeTimes(0); // 可以根据需要设置点赞次数
	        	actComVO.setActComStatus(true); // 可以根据需要设置评论状态

	        	System.out.println(actComVO); // 输出 actComVO 的内容

	        	ActivityCommentService actComSvc = new ActivityCommentService();
	        	actComSvc.addActCom(actComVO);

	        	System.out.println("传输成功");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}


