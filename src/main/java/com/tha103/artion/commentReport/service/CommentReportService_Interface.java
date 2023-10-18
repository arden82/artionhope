package com.tha103.artion.commentReport.service;

import java.util.List;

import com.tha103.artion.commentReport.model.CommentReportVO;

public interface CommentReportService_Interface {

	CommentReportVO addComRep(CommentReportVO comRep);
	
	CommentReportVO updateComRep(CommentReportVO comRep);
	
	CommentReportVO getComRepByComRepSerialNumber(Integer comRepSerialNumber);
	
	List<CommentReportVO> getAllComReps();
	
}
