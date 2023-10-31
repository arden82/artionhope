package com.tha103.artion.ticketOrder.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailVO;
import com.tha103.artion.util.HibernateUtil;

public class TicketOrderDAO implements TicketOrderDAO_interface {

	@Override
	public int insert(TicketOrderVO ticketOrderVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int ticketOrdId = 0;

		try {
//			session.beginTransaction();

			ticketOrdId = (int) session.save(ticketOrderVO);
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return ticketOrdId;
	}

	@Override
	public int update(TicketOrderVO ticketOrderVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(ticketOrderVO);
			session.getTransaction().commit();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int delete(Integer ticketOrdId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			TicketOrderVO ticketOrderVO = session.get(TicketOrderVO.class, ticketOrdId);
			if (ticketOrderVO != null) {
				session.delete(ticketOrderVO);
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
	public TicketOrderVO getById(Integer ticketOrdId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			TicketOrderVO ticketOrderVO = session.get(TicketOrderVO.class, ticketOrdId);
			session.getTransaction().commit();
			return ticketOrderVO;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<TicketOrderVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			List<TicketOrderVO> list = session.createQuery("from TicketOrderVO", TicketOrderVO.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public TicketOrderVO getOrderByMemId(Integer memId) {
		String hql = "SELECT t.ticketOrdId, t.ticketOrdCode, m.memName, t.ticketOrdTime, s.selName " +
	             "FROM TicketOrderVO t " +
	             "JOIN t.member m " +
	             "JOIN t.seller s " +
	             "WHERE m.memId = :memId";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query<Object[]> query = session.createQuery(hql);
			query.setParameter("memId", memId);

			List<Object[]> results = query.list();

			for (Object[] result : results) {
			    Integer ticketOrdId = (Integer) result[0];
			    String ticketOrdCode = (String) result[1];
			    String memName = (String) result[2];
			    Timestamp ticketOrdTime = (Timestamp) result[3];
			    String selName = (String) result[4];
			    
			    // Process the retrieved data as needed
			}
			
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public TicketOrderDetailVO getDetailByOrderId(Integer ticketOrdId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
