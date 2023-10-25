package com.tha103.artion.merch.servlet;

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
import com.tha103.artion.merch.model.MerchVO;
import com.tha103.artion.merch.service.MerchService;

//@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/getAllMerch")
public class GetAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("成功接收ajax");
//		res.setContentType("text/html; charset=UTF-8");
		res.setContentType("application/json; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		

		MerchService merchSvc = new MerchService();
		List<MerchVO> merchList = merchSvc.getAllMerches();

//		System.out.println(actList);

		// 將ActVO列表轉換為Map列表
		List<Map<String, Object>> merchMapList = new ArrayList<>();
		for (MerchVO merch : merchList) {
			Map<String, Object> merchMap = new HashMap<>();
			merchMap.put("merchId", merch.getMerchId());
			merchMap.put("merchPic1", merch.getMerchPicture1());
			merchMap.put("merchPic2", merch.getMerchPicture2());
			merchMap.put("merchPic3", merch.getMerchPicture3());
			merchMap.put("merchPic4", merch.getMerchPicture4());
			merchMap.put("merchName", merch.getMerchName());
			merchMap.put("merchTotal", merch.getMerchTotal());
			merchMap.put("merchPrice", merch.getMerchPrice());
			merchMap.put("merchSort", merch.getMerchSort());
//			merchMap.put("merchStart", merch.getMerchStartTime());
//			merchMap.put("merchIntro", merch.getMerchIntroduction());
			merchMap.put("merchSelAmount", merch.getMerchSellAmount());
//			merchMap.put("merchStatus", merch.getMerchStatus());
//			merchMap.put("merchOrdDets", merch.getMetOrdDets());
			
			merchMapList.add(merchMap);
		}
		
		
		
		Gson gson = new GsonBuilder().create();
//		Gson gson = new Gson();
		String json = gson.toJson(merchMapList);

//		PrintWriter out = res.getWriter();
		out.print(json); // 將JSON字串寫入響應
		out.flush();

	}
}