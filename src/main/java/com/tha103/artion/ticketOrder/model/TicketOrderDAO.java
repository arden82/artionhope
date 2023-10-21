package com.tha103.artion.ticketOrder.model;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.myPromoCode.model.MyPromoCodeVO;
import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.util.HibernateUtil;

public class TicketOrderDAO implements TicketOrderDAO_interface {

	@Override
	public int insert(TicketOrderVO ticketorderVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer ticketOrdId = (Integer) session.save(ticketorderVO);
			session.getTransaction().commit();
			return ticketOrdId;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(TicketOrderVO ticketorderVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(ticketorderVO);
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
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			TicketOrderVO ticketorderVO = session.get(TicketOrderVO.class, ticketOrdId);
			if (ticketorderVO != null) {
				session.delete(ticketorderVO);
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
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			TicketOrderVO ticketorderVO = session.get(TicketOrderVO.class, ticketOrdId);
			session.getTransaction().commit();
			return ticketorderVO;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<TicketOrderVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
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

	public static void main(String[] args) throws Exception {
		TicketOrderDAO dao = new TicketOrderDAO();

//		SellerVO sellerVO = new SellerVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
//		sellerVO.setSelId(2001);
//
//		MyPromoCodeVO mypromocodeVO = new MyPromoCodeVO();
//		mypromocodeVO.setMyProCodeId(1);
//
//		MemberVO membervo = new MemberVO();
//		membervo.setMemId(7001);
//		// 新增
//		TicketOrderVO ticketorderVO = new TicketOrderVO();
//		ticketorderVO.setMember(membervo);
//		ticketorderVO.setTicketOrdStatus(2);
//		ticketorderVO.setTicketOrdTotalPrice(500.0);
//		ticketorderVO.setTicketOrdProCodeAmount(100.0);
//		ticketorderVO.setTicketOrdActuallyAmount(400.0);
//		ticketorderVO.setTicketOrdPayStatus(1);
//		ticketorderVO.setMypromocode(mypromocodeVO);
//		ticketorderVO.setTicketOrdAddress("新北市淡水區");
//		ticketorderVO.setSeller(sellerVO);
//		ticketorderVO.setTicketOrdCode("vvv9999");
//
//		dao.insert(ticketorderVO);

//		// 修改
		SellerVO sellerVO = new SellerVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
		sellerVO.setSelId(2001);

		MyPromoCodeVO mypromocodeVO = new MyPromoCodeVO();
		mypromocodeVO.setMyProCodeId(1);

		MemberVO membervo = new MemberVO();
		membervo.setMemId(7001);

//		TicketOrderVO ticketorderVO1 = new TicketOrderVO();
//		ticketorderVO1.setTicketOrdId(134789);
//		ticketorderVO1.setTicketOrdTime(java.sql.Timestamp.valueOf("2023-09-20 10:10:10"));
//		ticketorderVO1.setMember(membervo);
//		ticketorderVO1.setTicketOrdStatus(1);
//		ticketorderVO1.setTicketOrdTotalPrice(1000.0);
//		ticketorderVO1.setTicketOrdProCodeAmount(100.0);
//		ticketorderVO1.setTicketOrdActuallyAmount(900.0);
//		ticketorderVO1.setTicketOrdPayStatus(1);
//		ticketorderVO1.setMypromocode(mypromocodeVO);
//		ticketorderVO1.setTicketOrdAddress("新北市三芝區");
//		ticketorderVO1.setSeller(sellerVO);
//		ticketorderVO1.setTicketOrdCode("anx12345");
//
//		dao.update(ticketorderVO1);
//
////		// 刪除
//		dao.delete(14790);
////
////		// 查詢單筆
//		SellerVO sellerVO = new SellerVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
//		sellerVO.setSelId(2001);
//
//		MyPromoCodeVO mypromocodeVO = new MyPromoCodeVO();
//		mypromocodeVO.setMyProCodeId(1);
//
//		MemberVO membervo = new MemberVO();
//		membervo.setMemId(7001);
//
//		TicketOrderVO ticketorderVO = dao.getById(134789);
//		System.out.print(ticketorderVO.getTicketOrdTime() + ",");
//		System.out.print(ticketorderVO.getMember() + ",");
//		System.out.print(ticketorderVO.getTicketOrdStatus() + ",");
//		System.out.print(ticketorderVO.getTicketOrdTotalPrice() + ",");
//		System.out.print(ticketorderVO.getTicketOrdProCodeAmount() + ",");
//		System.out.print(ticketorderVO.getTicketOrdActuallyAmount() + ",");
//		System.out.print(ticketorderVO.getTicketOrdPayStatus() + ",");
//		System.out.print(ticketorderVO.getMypromocode() + ",");
//		System.out.print(ticketorderVO.getTicketOrdAddress() + ",");
//		System.out.print(ticketorderVO.getSeller() + ",");
//		System.out.print(ticketorderVO.getTicketOrdCode() + ",");
//		System.out.println("---------------------");
////
//		// 查詢多筆
//		SellerVO sellerVO = new SellerVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
//		sellerVO.setSelId(2001);
//
//		MyPromoCodeVO mypromocodeVO = new MyPromoCodeVO();
//		mypromocodeVO.setMyProCodeId(1);
//
//		MemberVO membervo = new MemberVO();
//		membervo.setMemId(7001);

		List<TicketOrderVO> list = dao.getAll();
		for (TicketOrderVO merchorderVO2 : list) {
			System.out.print(merchorderVO2.getTicketOrdId() + ",");
			System.out.print(merchorderVO2.getMember() + ",");
			System.out.print(merchorderVO2.getTicketOrdStatus() + ",");
			System.out.print(merchorderVO2.getTicketOrdTotalPrice() + ",");
			System.out.print(merchorderVO2.getTicketOrdProCodeAmount() + ",");
			System.out.print(merchorderVO2.getTicketOrdActuallyAmount() + ",");
			System.out.print(merchorderVO2.getTicketOrdPayStatus() + ",");
			System.out.print(merchorderVO2.getMypromocode() + ",");
			System.out.print(merchorderVO2.getTicketOrdAddress() + ",");
			System.out.print(merchorderVO2.getSeller() + ",");
			System.out.print(merchorderVO2.getTicketOrdCode() + ",");

			System.out.println();
		}
	}
}
