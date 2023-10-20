package com.tha103.artion.merchOrderDetail.model;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.util.HibernateUtil;

public class MerchOrderDetailDAO implements MerchOrderDetailDAO_interface {
	@Override
	public int insert(MerchOrderDetailVO merchorderdetailVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer merchOrdDetailId = (Integer) session.save(merchorderdetailVO);
			session.getTransaction().commit();
			return merchOrdDetailId;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(MerchOrderDetailVO merchorderdetailVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(merchorderdetailVO);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int delete(Integer merchOrdDetailId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MerchOrderDetailVO merchorderdetailVO = session.get(MerchOrderDetailVO.class, merchOrdDetailId);
			if (merchorderdetailVO != null) {
				session.delete(merchorderdetailVO);
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
	public MerchOrderDetailVO findByPK(Integer merchOrdDetailId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MerchOrderDetailVO merchorderdetailVO = session.get(MerchOrderDetailVO.class, merchOrdDetailId);
			session.getTransaction().commit();
			return merchorderdetailVO;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<MerchOrderDetailVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<MerchOrderDetailVO> list = session.createQuery("from MerchOrderDetailVO", MerchOrderDetailVO.class)
					.list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
}
