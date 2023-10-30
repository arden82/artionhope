package com.tha103.artion.memberCollection.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.member.service.MemberService;
import com.tha103.artion.member.service.MemberServiceImp;
import com.tha103.artion.member.service.Membermsg;
import com.tha103.artion.memberCollection.model.MemberCollectionVO;
import com.tha103.artion.memberCollection.service.MemberCollectionService;
import com.tha103.artion.memberCollection.service.MemberCollectionServicelmp;

@WebServlet("/CollectionServlet")
@MultipartConfig
public class CollectionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		Integer memId = (Integer) session.getAttribute("memId");
		if (memId == null) {
			res.sendRedirect(req.getContextPath() + "/html/member/memberLogin.html");
			return;
		}
		String actIdStr = req.getParameter("actId");
		String action = req.getParameter("action");
		action = (action != null) ? action : "";
//		System.out.println("action:" + action);
		Integer actId = null;
		Integer result = null;
		if (actIdStr != null) {
			actId = Integer.valueOf(actIdStr);
		}
		MemberCollectionService mecSv = null;
		MemberCollectionVO collection = null;
		Membermsg msg = null;
		Gson gson = null;

		switch (action) {
		case "insert":
			mecSv = new MemberCollectionServicelmp();
			if (mecSv.getCollection(memId, actId) == null) {// null代表沒有收藏過
				collection = new MemberCollectionVO();
				collection.setMemColStatus(1);
				result = mecSv.insert(collection, memId, actId);
				if (result == -1) {
					session.setAttribute("errmsg", "收藏失敗");
					msg = new Membermsg("收藏失敗");
					System.out.println("msg:" + msg);
					gson = new Gson();
					res.setContentType("application/json");
					res.setCharacterEncoding("UTF-8");
					res.getWriter().write(gson.toJson(msg));
				}
			}
			if (mecSv.getCollection(memId, actId) != null && mecSv.getCollection(memId, actId).getMemColStatus() == 0) {
				collection = new MemberCollectionVO(); //曾經收藏過又重新加入收藏
				collection = mecSv.getCollection(memId, actId);
				collection.setMemColStatus(1);
				result = mecSv.update(collection);
			}
			break;
		case "update":
			mecSv = new MemberCollectionServicelmp();
			collection = new MemberCollectionVO();
			collection = mecSv.getCollection(memId, actId);
			collection.setMemColStatus(0);
			result = mecSv.update(collection);
			System.out.println("result:" + result);// 檢驗結果
			if (result == -1) {
				session.setAttribute("errmsg", "收藏更新失敗");
				msg = new Membermsg("收藏更新失敗");
				System.out.println("msg:" + msg);
				gson = new Gson();
				res.setContentType("application/json");
				res.setCharacterEncoding("UTF-8");
				res.getWriter().write(gson.toJson(msg));
			}
			break;

		default:
			mecSv = new MemberCollectionServicelmp();
			List<MemberCollectionVO> list = mecSv.memberCollectionList(memId);
			List<Object> listJson = new ArrayList<>();
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			if (list.size() == 0) {
				toObject obj = new toObject();
				MemberService mecs = new MemberServiceImp();
				MemberVO member = mecs.getMember(memId);
				obj.getData().put("mem_nickname", String.valueOf(member.getMemNickname()));
				obj.getData().put("memLev_levelName", String.valueOf(member.getMemLevLevel().getMemLevLevelName()));
				listJson.add(obj);
				gson = new Gson();
				String json = gson.toJson(listJson);
				res.setContentType("application/json");
				res.setCharacterEncoding("UTF-8");
				res.getWriter().write(json);
				break;
			}
			for (MemberCollectionVO alist : list) {
				toObject obj = new toObject();
				obj.getData().put("act_id", alist.getActivity().getActId());
				obj.getData().put("act_name", alist.getActivity().getActName());
				java.util.Date startDate = new Date(alist.getActivity().getActStartDate().getTime());
				String act_startDate = dateformat.format(startDate);
				obj.getData().put("act_startDate", act_startDate);
				java.util.Date endDate = new Date(alist.getActivity().getActEndDate().getTime());
				String act_endDate = dateformat.format(endDate);
				obj.getData().put("act_endDate", act_endDate);
				obj.getData().put("act_startTime", alist.getActivity().getActStartTime());
				obj.getData().put("act_endTime", alist.getActivity().getActEndTime());
				obj.getData().put("act_type", alist.getActivity().getActType());
				obj.getData().put("act_status", alist.getActivity().getActStatus());
				obj.getData().put("memCol_status", alist.getMemColStatus());
				obj.getData().put("mem_nickname", alist.getMember().getMemNickname());
				obj.getData().put("memLev_levelName", alist.getMember().getMemLevLevel().getMemLevLevelName());
				listJson.add(obj);
			}
			gson = new Gson();
			String json = gson.toJson(listJson);
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(json);
			break;
		}

	}

	class toObject {
		private Map<String, Object> obj = new HashMap<>();

		public Map<String, Object> getData() {
			return obj;
		}
	}
}
