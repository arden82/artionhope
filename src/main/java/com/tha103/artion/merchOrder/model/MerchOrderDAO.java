package com.tha103.artion.merchOrder.model;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.util.HibernateUtil;

public class MerchOrderDAO implements MerchOrderDAO_interface {

	@Override
	public int insert(MerchOrderVO merchorderVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer merOrderId = (Integer) session.save(merchorderVO);
			session.getTransaction().commit();
			return merOrderId;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(MerchOrderVO merchorderVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(merchorderVO);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int delete(Integer merOrderId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MerchOrderVO merchorderVO = session.get(MerchOrderVO.class, merOrderId);
			if (merchorderVO != null) {
				session.delete(merchorderVO);
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
	public MerchOrderVO getById(Integer merOrderId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MerchOrderVO merchorderVO = session.get(MerchOrderVO.class, merOrderId);
			session.getTransaction().commit();
			return merchorderVO;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<MerchOrderVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<MerchOrderVO> list = session.createQuery("from MerchOrderVO", MerchOrderVO.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
}
