package com.tha103.artion.ticketOrderDetail.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.google.gson.annotations.Until;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;
import com.tha103.artion.util.HibernateUtil;

public class TicketOrderDetailDAO implements TicketOrderDetailDAO_interface {

	@Override
	public int insert(TicketOrderDetailVO ticketorderetailVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int ticOrdDetId = 0;

		try {
			session.beginTransaction();

			ticOrdDetId = (int) session.save(ticketorderetailVO);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return ticOrdDetId;
	}

	@Override
	public int update(TicketOrderDetailVO ticketorderetailVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(ticketorderetailVO);
			session.getTransaction().commit();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			TicketOrderDetailVO ticketorderetailVO = session.get(TicketOrderDetailVO.class, id);
			if (ticketorderetailVO != null) {
				session.delete(ticketorderetailVO);
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
	public TicketOrderDetailVO getById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			TicketOrderDetailVO ticketorderetailVO = session.get(TicketOrderDetailVO.class, id);
			session.getTransaction().commit();
			return ticketorderetailVO;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<TicketOrderDetailVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			List<TicketOrderDetailVO> list = session.createQuery("from TicketOrderDetailVO", TicketOrderDetailVO.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	
}
