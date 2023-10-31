package com.tha103.artion.activity.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activity.service.ActivityService;

//@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/getAllAct")
public class GetAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//		res.setContentType("text/html; charset=UTF-8");
		res.setContentType("application/json; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		

		ActivityService actSvc = new ActivityService();
		List<ActivityVO> actList = actSvc.getAll();

//		System.out.println(actList);

		// 將ActVO列表轉換為Map列表
		List<Map<String, Object>> actMapList = new ArrayList<>();
		for (ActivityVO act : actList) {
			Map<String, Object> actMap = new HashMap<>();
			actMap.put("actId", act.getActId());
			actMap.put("actName", act.getActName());
			actMap.put("actTicPrice", act.getActTicketPrice());
			actMap.put("actTicStrTime", act.getActTicketStartTime());
			actMap.put("actTicEndTime", act.getActTicketEndTime());
			actMap.put("actType", act.getActType());
			actMap.put("actStartDate", act.getActStartDate());
			actMap.put("actEndDate", act.getActEndDate());
			actMap.put("ActStartTime", act.getActStartTime());
			actMap.put("ActEndTime", act.getActEndTime());
//			actMap.put("ActCity", act.getActCity());
//			actMap.put("ActZone", act.getActZone());
			actMap.put("ActAdd", act.getActAddress());
//			actMap.put("ActOrg", act.getActOrganization());
//			actMap.put("ActEmail", act.getActEmail());
//			actMap.put("ActPhone", act.getActPhone());
			actMap.put("ActTicTotal", act.getActTicketTotal());
			actMap.put("ActContent", act.getActContent());
			actMap.put("ActCovPic", act.getActCoverPicture());
//			actMap.put("ActPic1", act.getActPicture1());
//			actMap.put("ActPic2", act.getActPicture2());
//			actMap.put("ActPic3", act.getActPicture3());
			actMap.put("ActLikeTimes", act.getActLikeTimes());
			actMap.put("ActViews", act.getActViews());
//			actMap.put("ActAppStatus", act.getActApproalStatus());
//			actMap.put("ActStatus", act.getActStatus());
			actMap.put("selId", act.getSeller().getSelId());
//			actMap.put("selName", act.getSeller().getSelName());
//			actMap.put("selInfo", act.getSeller().getSelIntroduction());
//			actMap.put("ActLongitude", act.getActLongitude());
//			actMap.put("ActLatitude", act.getActLatitude());
//			actMap.put("ActTicTotSel", act.getActTicketTotalSell());
//			actMap.put("AdmId", act.getAdmId());
//			actMap.put("ActLastModTime", act.getActLastModifiedTime());
//			actMap.put("ActResContent", act.getActResultContent());
//			
//			actMap.put("MemCols", act.getMemCols());
//			actMap.put("ActLikes", act.getActLikes());
//			actMap.put("ActComs", act.getActComs());
//			actMap.put("TicOrdDets", act.getTicOrdDets());
			actMapList.add(actMap);
		}
		
		
		
		Gson gson = new GsonBuilder().create();
//		Gson gson = new Gson();
		String json = gson.toJson(actMapList);

//		PrintWriter out = res.getWriter();
		out.print(json); // 將JSON字串寫入響應
		out.flush();

	}
}