package com.tha103.artion.activityComment.model;

import java.util.List;
import java.util.Set;

public interface ActivityCommentDAO_interface {
	int add(ActivityCommentVO actCom);
	
	List<ActivityCommentVO> getAll();
	
//	int update(ActivityCommentVO actCom);
	
	ActivityCommentVO findByPK(Integer actComId);
	
	
}
