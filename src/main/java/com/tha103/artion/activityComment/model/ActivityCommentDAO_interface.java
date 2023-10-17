package com.tha103.artion.activityComment.model;

import java.util.List;

public interface ActivityCommentDAO_interface {
	int add(ActivityCommentVO actCom);
	
	int update(ActivityCommentVO actCom);
	
	int delete(Integer actComId);
	
	ActivityCommentVO findByPK(Integer actComId);
	
	List<ActivityCommentVO> getAll();
}
