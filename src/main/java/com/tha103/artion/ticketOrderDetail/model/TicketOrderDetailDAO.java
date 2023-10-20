package com.tha103.artion.ticketOrderDetail.model;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.util.HibernateUtil;

public class TicketOrderDetailDAO implements TicketOrderDetailDAO_interface {
	@Override
	public int insert(TicketOrderDetailVO ticketorderdetailVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer id = (Integer) session.save(ticketorderdetailVO);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(TicketOrderDetailVO ticketorderdetailVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(ticketorderdetailVO);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int delete(Integer ticOrdDetId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			TicketOrderDetailVO ticketorderdetailVO = session.get(TicketOrderDetailVO.class, ticOrdDetId);
			if (ticketorderdetailVO != null) {
				session.delete(ticketorderdetailVO);
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
	public TicketOrderDetailVO getById(Integer ticOrdDetId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			TicketOrderDetailVO ticketorderdetailVO = session.get(TicketOrderDetailVO.class, ticOrdDetId);
			session.getTransaction().commit();
			return ticketorderdetailVO;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<TicketOrderDetailVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<TicketOrderDetailVO> list = session.createQuery("from Emp", TicketOrderDetailVO.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
