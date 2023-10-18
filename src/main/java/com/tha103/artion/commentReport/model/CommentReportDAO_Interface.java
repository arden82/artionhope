package com.tha103.artion.commentReport.model;

import java.util.List;


public interface CommentReportDAO_Interface {
	public int insert(CommentReportVO comRep);
	
	public int update(CommentReportVO comRep);
	
	public CommentReportVO getById(Integer comRepSerialNumber);
	
	public List<CommentReportVO> getAll();
}
