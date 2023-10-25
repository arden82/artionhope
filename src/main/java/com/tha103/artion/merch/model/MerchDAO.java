package com.tha103.artion.merch.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.tha103.artion.util.HibernateUtil;



public class MerchDAO implements MerchDAO_Interface{

	@Override
	public int insert(MerchVO merch) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int merchId = 0;

		try {
			session.beginTransaction();

			merchId = (int) session.save(merch);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return merchId;
	}

	@Override
	public int update(MerchVO merch) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(merch);
			session.getTransaction().commit();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int delete(Integer merchId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			MerchVO merch = session.get(MerchVO.class, merchId);
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
	public MerchVO getById(Integer merchId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			MerchVO merch = session.get(MerchVO.class, merchId);

			session.getTransaction().commit();
			return merch;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<MerchVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			List<MerchVO> list = session.createQuery("from MerchVO", MerchVO.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}


	
	
}
