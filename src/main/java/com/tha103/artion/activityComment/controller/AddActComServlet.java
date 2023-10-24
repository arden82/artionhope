package com.tha103.artion.activityComment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.member.model.MemberVO;

@WebServlet("/addActComServlet")
public class AddActComServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String actComContent = request.getParameter("actComContent");
        String actIdParam = request.getParameter("actId");
        
        try {
            System.out.println("actComContent: " + actComContent);
            System.out.println("actIdParam: " + actIdParam);
            
            if (actComContent != null && !actComContent.trim().isEmpty()) {
                ActivityCommentVO actComVO = new ActivityCommentVO();
                
                // 初始化MemberVO
                MemberVO memberVO = new MemberVO();
                memberVO.setMemId(7001); // 要在处理session的memId
                actComVO.setMember(memberVO);
                
                // 设置actId
                actComVO.getActivity().setActId(Integer.parseInt(actIdParam)); 
                
                actComVO.setActComContent(actComContent);
                actComVO.setActComReportTimes(0);
                actComVO.setActComLikeTimes(0);
                actComVO.setActComStatus(true);
                
                // 这里可以添加将数据插入数据库的代码
                // ActivityCommentService actComSvc = new ActivityCommentService();
                // actComVO = actComSvc.addActCom(null, 7001, Integer.parseInt(actIdParam), actComContent, 0, null, 0,
                //         null, null, null, null, true);
            }
        } catch (Exception e) {
            // 捕获异常并打印异常信息
            e.printStackTrace();
        }
    }
}


