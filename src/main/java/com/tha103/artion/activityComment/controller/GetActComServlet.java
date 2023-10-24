package com.tha103.artion.activityComment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activity.service.ActivityService;
import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.activityComment.service.ActivityCommentService;

@WebServlet("/getActComServlet")
public class GetActComServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//		res.setContentType("text/html; charset=UTF-8");
		res.setContentType("application/json; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		
		ActivityCommentService actComSvc = new ActivityCommentService();
		List<ActivityCommentVO> actComList = actComSvc.getAll();

//		System.out.println(actComList);

		// 將ActVO列表轉換為Map列表
		List<Map<String, Object>> actComMapList = new ArrayList<>();
		for (ActivityCommentVO actCom : actComList) {
			Map<String, Object> actComMap = new HashMap<>();
			actComMap.put("actComId", actCom.getActComId());
			actComMap.put("memNickName", actCom.getMember().getMemNickname());
			actComMap.put("memPhoto", actCom.getMember().getMemProfilePhoto());
			actComMap.put("actId", actCom.getActivity().getActId());
			actComMap.put("actComContent", actCom.getActComContent());
//			actComMap.put("actComRepTimes", actCom.getActComReportTimes());
			actComMap.put("actComTime", actCom.getActComTime());
			actComMap.put("actComLikeTimes", actCom.getActComLikeTimes());
			actComMap.put("actComCovPic", actCom.getActComCoverPicture());
			actComMap.put("actComPic1", actCom.getActComPicture1());
			actComMap.put("actComPic2", actCom.getActComPicture2());
			actComMap.put("actComPic3", actCom.getActComPicture3());
//			actComMap.put("actComStatus", actCom.getActComStatus());
//			actComMap.put("actComLikes", actCom.getActComLikes());
//			actComMap.put("actComReports", actCom.getComReports());
//			
			actComMapList.add(actComMap);
		}
		
		
		
		Gson gson = new GsonBuilder().create();
//		Gson gson = new Gson();
		String json = gson.toJson(actComMapList);

//		PrintWriter out = res.getWriter();
		out.print(json); // 將JSON字串寫入響應
		out.flush();

	}
}


