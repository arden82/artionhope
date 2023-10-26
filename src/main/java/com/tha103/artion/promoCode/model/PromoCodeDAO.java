package com.tha103.artion.promoCode.model;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.util.HibernateUtil;

public class PromoCodeDAO implements PromoCodeDAO_Interface{

	@Override
	public int insert(PromoCodeVO promoCode) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int promoCodeId = 0;

		try {
			session.beginTransaction();

			promoCodeId = (int) session.save(promoCode);
			session.getTransaction().commit();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return promoCodeId;
	}

	@Override
	public int update(PromoCodeVO promoCode) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(promoCode);
			session.getTransaction().commit();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int delete(Integer proCodeId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			PromoCodeVO promoCode = session.get(PromoCodeVO.class, proCodeId);
			if (promoCode != null) {
				session.delete(promoCode);
			}
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public PromoCodeVO getById(Integer proCodeId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			PromoCodeVO promoCode = session.get(PromoCodeVO.class, proCodeId);
			promoCode.getMyProCodes().size();
			session.getTransaction().commit();
			return promoCode;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<PromoCodeVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			List<PromoCodeVO> list = session.createQuery("from PromoCodeVO", PromoCodeVO.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}


	
	
	
}
