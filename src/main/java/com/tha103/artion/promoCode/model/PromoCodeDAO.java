package com.tha103.artion.promoCode.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.memberLevel.model.MemberLevelVO;
import com.tha103.artion.merch.model.MerchVO;
import com.tha103.artion.util.HibernateUtil;

public class PromoCodeDAO implements PromoCodeDAO_Interface {
	private SessionFactory factory;

	public PromoCodeDAO(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int add(PromoCodeVO promoCode, int memLevel, int admId) {

		MemberLevelVO levelVO = getSession().get(MemberLevelVO.class, memLevel);
		AdministratorVO administratorVO = getSession().get(AdministratorVO.class, admId);
		promoCode.setMemLevLevel(levelVO);
		promoCode.setAdministrator(administratorVO);
		return (Integer) getSession().save(promoCode);

	}

	@Override
	public int update(PromoCodeVO promoCode, int memLevel, int admId) {

		MemberLevelVO levelVO = getSession().get(MemberLevelVO.class, memLevel);
		AdministratorVO administratorVO = getSession().get(AdministratorVO.class, admId);
		promoCode.setMemLevLevel(levelVO);
		promoCode.setAdministrator(administratorVO);
		return (Integer) getSession().save(promoCode);

	}

	@Override
	public int delete(Integer proCodeId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			MerchVO merch = session.get(MerchVO.class, proCodeId);
			if (merch != null) {
				session.delete(merch);
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
		List<PromoCodeVO> list = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			list = session.createQuery("from PromoCodeVO", PromoCodeVO.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
