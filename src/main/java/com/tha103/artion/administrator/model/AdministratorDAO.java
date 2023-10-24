package com.tha103.artion.administrator.model;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.Session;

import com.tha103.artion.util.HibernateUtil;

public class AdministratorDAO implements AdministratorDAO_Interface {

	@Override
	public int insert(AdministratorVO admin) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		int admId = 0;

		try {
			session.beginTransaction();

			admId = (int) session.save(admin);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return admId;
	}

	@Override
	public int update(AdministratorVO admin) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(admin);
			session.getTransaction().commit();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int delete(Integer admId) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			AdministratorVO admin = session.get(AdministratorVO.class, admId);
			if (admin != null) {
				session.delete(admin);
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
	public AdministratorVO getById(Integer admId) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			AdministratorVO admin = session.get(AdministratorVO.class, admId);
//			admin.getProCodes().size();
			session.getTransaction().commit();
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<AdministratorVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			List<AdministratorVO> list = session.createQuery("from AdministratorVO", AdministratorVO.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public AdministratorVO checkMail(String admMail) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			
			session.beginTransaction();
			String hql = "from AdministratorVO where admMail = :admMail";
			AdministratorVO admin = (AdministratorVO) session.createQuery(hql).setParameter("admMail",admMail).uniqueResult();
			session.getTransaction().commit();
			
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
		
	}


}
