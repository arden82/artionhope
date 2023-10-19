package com.tha103.artion.merch.service;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.merch.model.MerchDAO;
import com.tha103.artion.merch.model.MerchVO;
import com.tha103.artion.util.HibernateUtil;

public class MerchService implements MerchService_Interface{

	private MerchDAO dao;
	
	public MerchService() {
		dao = new MerchDAO(HibernateUtil.getSessionFactory());
	}

	@Override
	public MerchVO addMerch(MerchVO merch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchVO updateMerch(MerchVO merch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMerch(Integer merchId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MerchVO getMerchByMerchId(Integer merchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MerchVO> getAllMerches() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<MerchVO> list = dao.getAll();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}
	
	
}
