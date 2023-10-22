package com.tha103.artion.activityComment.service;

import java.sql.Timestamp;
import java.util.List;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activityComment.model.ActivityCommentDAO;
import com.tha103.artion.activityComment.model.ActivityCommentDAO_interface;
import com.tha103.artion.activityComment.model.ActivityCommentVO;

public class ActivityCommentService {
	
private ActivityCommentDAO_interface actComDAO;
	
	public ActivityCommentService() {
//		actComDAO = new ActivityCommentDAO();
	}
	//新增活動留言
	public ActivityCommentVO addActCom(ActivityCommentVO activityCommentVO) {
		actComDAO.add(activityCommentVO);
		return activityCommentVO;
	}
	//取得活動留言
	public List<ActivityCommentVO>getAll(){
		return actComDAO.getAll();
	}

	public static byte[] getActCoverPicture() {
		
		return null;
	}
}
