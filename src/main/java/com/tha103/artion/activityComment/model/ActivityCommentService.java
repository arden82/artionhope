package com.tha103.artion.activityComment.model;

import java.sql.Timestamp;
import java.util.List;
import com.tha103.artion.activityComment.model.ActivityCommentDAO;

public class ActivityCommentService {
	
private ActivityCommentDAO_interface dao;
	
	public ActivityCommentService() {
		dao = new ActivityCommentDAO();
	}

	public ActivityCommentVO addActivityComment(Integer actComId, Integer memId, Integer actId, String actComContent
			, Integer actComReportTimes,Timestamp actComTime ,Integer actComLikeTimes ,byte[] actComCoverPicture
			, byte[] actComPicture1 , byte[] actComPicture2, byte[] actComPicture3, Boolean actComStatus) {
		
		ActivityCommentVO activityCommentVO = new ActivityCommentVO();
		
		activityCommentVO.setActComId(actComId);
		activityCommentVO.setMember(member);
		activityCommentVO.setActivity(activity);
		activityCommentVO.setActComContent(actComContent);
		activityCommentVO.setActComReportTimes(0);
		activityCommentVO.setActComTime(actComTime);
		activityCommentVO.setActComLikeTimes(0);
		activityCommentVO.setActComCoverPicture(actComCoverPicture);
		activityCommentVO.setActComPicture1(actComPicture1);
		activityCommentVO.setActComPicture2(actComPicture2);
		activityCommentVO.setActComPicture3(actComPicture3);
		activityCommentVO.setActComStatus(actComStatus);
		dao.insert(activityCommentVO);
		return  activityCommentVO;
	}
	
	public ActivityCommentVO updateActivityComment(Integer actComId, Integer memId, Integer actId, String actComContent
			, Integer actComReportTimes,Timestamp actComTime ,Integer actComLikeTimes ,byte[] actComCoverPicture
			, byte[] actComPicture1 , byte[] actComPicture2, byte[] actComPicture3, Boolean actComStatus) {
		
		ActivityCommentVO activityCommentVO = new ActivityCommentVO();
		
		activityCommentVO.setActComId(actComId);
		activityCommentVO.setMember(member);
		activityCommentVO.setActivity(activity);
		activityCommentVO.setActComContent(actComContent);
		activityCommentVO.setActComReportTimes(actComReportTimes);
		activityCommentVO.setActComTime(actComTime);
		activityCommentVO.setActComLikeTimes(actComLikeTimes);
		activityCommentVO.setActComCoverPicture(actComCoverPicture);
		activityCommentVO.setActComPicture1(actComPicture1);
		activityCommentVO.setActComPicture2(actComPicture2);
		activityCommentVO.setActComPicture3(actComPicture3);
		activityCommentVO.setActComStatus(actComStatus);
		dao.insert(activityCommentVO);
		return  activityCommentVO;
	}
	
	
	public ActivityCommentVO getOneActCom(Integer actComId) {
		return dao.findByPK(actComId);
	}
	
	public List<ActivityCommentVO>getAll(){
		return dao.getAll();
	}

	public static byte[] getActCoverPicture() {
		
		return null;
	}
}
