package com.tha103.artion.activityComment.service;

import java.sql.Timestamp;
import java.util.List;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activityComment.model.ActivityCommentDAO;
import com.tha103.artion.activityComment.model.ActivityCommentDAO_interface;
import com.tha103.artion.activityComment.model.ActivityCommentVO;

public class ActivityCommentService {
	
private ActivityCommentDAO_interface dao;
	
	public ActivityCommentService() {
		dao = new ActivityCommentDAO();
	}
	//新增活動留言
	public ActivityCommentVO addActCom(ActivityVO activityVO) {
		dao.add(activityVO);
		return activityVO;
	}
	
	public List<ActivityCommentVO>getAll(){
		return dao.getAll();
	}

	public static byte[] getActCoverPicture() {
		
		return null;
	}
}
