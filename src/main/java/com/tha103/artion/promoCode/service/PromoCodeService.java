package com.tha103.artion.promoCode.service;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.promoCode.model.PromoCodeDAO;
import com.tha103.artion.promoCode.model.PromoCodeVO;
import com.tha103.artion.util.HibernateUtil;

public class PromoCodeService implements PromoCodeService_Interface{
	
	private PromoCodeDAO dao;
	
	public PromoCodeService() {
		dao = new PromoCodeDAO(HibernateUtil.getSessionFactory());
	}

	@Override
	public PromoCodeVO addPromoCode(PromoCodeVO promoCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromoCodeVO updatePromoCode(PromoCodeVO promoCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePromoCode(Integer proCodeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PromoCodeVO getByPromoCodeId(Integer proCodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PromoCodeVO> getAllPromoCodes() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<PromoCodeVO> list = dao.getAll();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}
	
}
