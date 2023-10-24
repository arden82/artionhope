package com.tha103.artion.activityComment.service;

import java.sql.Timestamp;
import java.util.List;

import com.tha103.artion.activityComment.model.ActivityCommentDAO;
import com.tha103.artion.activityComment.model.ActivityCommentDAO_interface;
import com.tha103.artion.activityComment.model.ActivityCommentVO;

public class ActivityCommentService {
	
	private ActivityCommentDAO_interface dao;

	public ActivityCommentService() {
		dao = new ActivityCommentDAO();
	}

	// 新增活動留言
	public ActivityCommentVO addActCom(ActivityCommentVO activityCommentVO) {
		dao.add(activityCommentVO);
		return activityCommentVO;
	}

	// 取得活動所有留言
	public List<ActivityCommentVO> getAll() {
		return dao.getAll();
	}

	// 取得單一活動留言
	public ActivityCommentVO getOneActCom(Integer actComId) {
		ActivityCommentVO actComVO = dao.findByPK(actComId);
		if (actComVO != null) {
			return actComVO;
		} else {
			return null;
		}
	}

	public static byte[] getActCoverPicture() {
		return null;
	}
}
