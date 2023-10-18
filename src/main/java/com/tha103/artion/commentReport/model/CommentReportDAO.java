package com.tha103.artion.commentReport.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class CommentReportDAO implements CommentReportDAO_Interface{
	
private SessionFactory factory;
	
	public CommentReportDAO(SessionFactory factory) {
		this.factory = factory;
		
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(CommentReportVO comRep) {
		// TODO Auto-generated method stub
		return (Integer) getSession().save(comRep);	}

	@Override
	public int update(CommentReportVO comRep) {
		// TODO Auto-generated method stub
		try {
			getSession().update(comRep);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public CommentReportVO getById(Integer comRepSerialNumber) {
		// TODO Auto-generated method stub
		return getSession().get(CommentReportVO.class, comRepSerialNumber);
	}

	@Override
	public List<CommentReportVO> getAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from CommentReportVO", CommentReportVO.class).list();
	}

}
