package com.tha103.artion.ticketOrderDetail.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;
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
			List<TicketOrderDetailVO> list = session.createQuery("from TicketOrderDetailVO", TicketOrderDetailVO.class)
					.list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		TicketOrderDetailDAO dao = new TicketOrderDetailDAO();

//		TicketOrderVO ticketorderVO = new TicketOrderVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
//		ticketorderVO.setTicketOrdId(134789);
//
//		ActivityVO activityVO = new ActivityVO();
//		activityVO.setActId(10001);
//		// 新增
//		TicketOrderDetailVO ticketorderdetailVO = new TicketOrderDetailVO();
//
//		ticketorderdetailVO.setTicketorder(ticketorderVO);
//		ticketorderdetailVO.setTicOrdDetQuantity(20);
//		ticketorderdetailVO.setTicOrdDetPrice(200.0);
//		ticketorderdetailVO.setActivity(activityVO);
//
//		dao.insert(ticketorderdetailVO);

//		// 修改
//		
//		TicketOrderVO ticketorderVO = new TicketOrderVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
//		ticketorderVO.setTicketOrdId(134789);
//
//		ActivityVO activityVO = new ActivityVO();
//		activityVO.setActId(10001);
//
//		TicketOrderDetailVO ticketorderdetailVO1 = new TicketOrderDetailVO();
//		ticketorderdetailVO1.setTicOrdDetId(1);
//		ticketorderdetailVO1.setTicketorder(ticketorderVO);
//		ticketorderdetailVO1.setTicOrdDetQuantity(50);
//		ticketorderdetailVO1.setTicOrdDetPrice(900.0);
//		ticketorderdetailVO1.setActivity(activityVO);
//
//		dao.update(ticketorderdetailVO1);
//
////		// 刪除
//		dao.delete(14790);
////
////		// 查詢單筆

		TicketOrderVO ticketorderVO = new TicketOrderVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
		ticketorderVO.setTicketOrdId(134789);

		ActivityVO activityVO = new ActivityVO();
		activityVO.setActId(10001);

		TicketOrderDetailVO ticketorderdetailVO = dao.getById(1);
		System.out.print(ticketorderdetailVO.getTicketorder() + ",");
		System.out.print(ticketorderdetailVO.getTicOrdDetQuantity() + ",");
		System.out.print(ticketorderdetailVO.getTicOrdDetPrice() + ",");
		System.out.print(ticketorderdetailVO.getActivity() + ",");
		System.out.println("---------------------");
	}
//		// 查詢多筆 QQ**
//		TicketOrderVO ticketorderVO = new TicketOrderVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
//		ticketorderVO.setTicketOrdId(134789);
////
//		ActivityVO activityVO = new ActivityVO();
//		activityVO.setActId(10001);

//	List<TicketOrderDetailVO> list = dao.getAll()for(
//	TicketOrderDetailVO ticketorderdetailVO1:list)
//	{
//		System.out.print(ticketorderdetailVO1.getTicOrdDetId() + ",");
//		System.out.print(ticketorderdetailVO1.getTicketorder() + ",");
//		System.out.print(ticketorderdetailVO1.getTicOrdDetQuantity() + ",");
//		System.out.print(ticketorderdetailVO1.getTicOrdDetPrice() + ",");
//		System.out.print(ticketorderdetailVO1.getActivity() + ",");
//
//		System.out.println();
//	}

//		List<TicketOrderDetailVO> list = dao.getAll();
//
//		if (list != null) {
//			for (TicketOrderDetailVO ticketorderdetailVO : list) {
//				System.out.print("ticOrdDetId: " + ticketorderdetailVO.getTicOrdDetId() + ", ");
//				System.out.print("TicketOrder: " + ticketorderdetailVO.getTicketorder() + ", ");
//				System.out.print("TicOrdDetQuantity: " + ticketorderdetailVO.getTicOrdDetQuantity() + ", ");
//				System.out.print("TicOrdDetPrice: " + ticketorderdetailVO.getTicOrdDetPrice() + ", ");
//				System.out.print("Activity: " + ticketorderdetailVO.getActivity() + ", ");
//
//				System.out.println();
//			}
//		} else {
//			System.out.println("Failed to retrieve TicketOrderDetail List.");
//		}

	@Override
	public TicketOrderDetailVO getOneTicketOrderByActId(Integer actId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String hql = "FROM TicketOrderDetailVO AS t WHERE t.activity.actId = :actId";
			Query<TicketOrderDetailVO> query = session.createQuery(hql, TicketOrderDetailVO.class);
			query.setParameter("actId", actId);

			// 使用uniqueResult()方法來獲取唯一的結果
			TicketOrderDetailVO result = query.uniqueResult();
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public TicketOrderDetailVO getTicketorder(Integer ticketOrdId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<TicketOrderDetailVO> resultList=session
					.createQuery("from TicketOrderDetailVO  where ticketOrd_id=:ticketOrdId ", TicketOrderDetailVO.class)
					.setParameter("ticketOrdId", ticketOrdId).setMaxResults(1).list();
			session.getTransaction().commit();
			  if (resultList != null && !resultList.isEmpty()) {
		            return resultList.get(0); 
		        }
			  return null;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public List<TicketOrderDetailVO> getTicketordelist(Integer ticketOrdId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<TicketOrderDetailVO> list=session
					.createQuery("from TicketOrderDetailVO  where ticketOrd_id=:ticketOrdId ", TicketOrderDetailVO.class)
					.setParameter("ticketOrdId", ticketOrdId).list();
			session.getTransaction().commit();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
	
	

}