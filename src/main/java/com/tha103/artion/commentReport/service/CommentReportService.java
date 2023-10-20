package com.tha103.artion.commentReport.service;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.commentReport.model.CommentReportDAO;
import com.tha103.artion.commentReport.model.CommentReportVO;
import com.tha103.artion.util.HibernateUtil;

public class CommentReportService implements CommentReportService_Interface{
	
	private CommentReportDAO dao;
	
	public CommentReportService() {
		dao = new CommentReportDAO(HibernateUtil.getSessionFactory());
	}

	@Override
	public CommentReportVO addComRep(CommentReportVO comRep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentReportVO updateComRep(CommentReportVO comRep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentReportVO getComRepByComRepSerialNumber(Integer comRepSerialNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentReportVO> getAllComReps() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<CommentReportVO> list = dao.getAll();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}
	
	

}
