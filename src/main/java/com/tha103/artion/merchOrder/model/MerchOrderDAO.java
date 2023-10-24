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
//
//	@Override
//	public Set<MerchOrderVO> getMerchOrdersBymerOrderId(Integer merOrderId) {
//		Set<MerchOrderVO> set = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Query<MerchOrderVO> query = session.createQuery(GET_Emps_ByDeptno_STMT, MerchOrderVO.class);
//			query.setParameter(0, merOrderId);
//			List<MerchOrderVO> list = query.getResultList();
//			set = new HashSet<MerchOrderVO>(list);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return set;
//	}

	public static void main(String[] args) throws Exception {
		MerchOrderDAO dao = new MerchOrderDAO();

//		MemberVO membervo = new MemberVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
//		membervo.setMemId(7001);
////		// 新增
//		MerchOrderVO merchorderVO = new MerchOrderVO();
//		merchorderVO.setMember(membervo);
//		merchorderVO.setMerOrderActuallyAmount(1000);
//		merchorderVO.setMerOrderPayStatus(1);
//		merchorderVO.setMerOrderStatus(1);
//		merchorderVO.setMerOrderAddress("新北市三芝區");
//		merchorderVO.setMerOrderCode("anx2755");
//		dao.insert(merchorderVO);
//
//		// 修改
//		MemberVO membervo = new MemberVO();
//		membervo.setMemId(7002);
//
//		MerchOrderVO merchorderVO1 = new MerchOrderVO();
//		merchorderVO1.setMerOrderId(134805);
//		merchorderVO1.setMember(membervo);
//		merchorderVO1.setMerOrderActuallyAmount(1000);
//		merchorderVO1.setMerOrderPayStatus(2);
//		merchorderVO1.setMerOrderStatus(2);
//		merchorderVO1.setMerOrderAddress("新北市三芝區中正路");
//		merchorderVO1.setMerOrderCode("anx27558888");
//		dao.update(merchorderVO1);
////
////		// 刪除
//		dao.delete(134789);
////
////		// 查詢單筆
//		MemberVO membervo1 = new MemberVO();
//		membervo1.setMemId(7001);
//
//		MerchOrderVO merchorderVO2 = dao.getById(134790);
//		System.out.print(merchorderVO2.getMember() + ",");
//		System.out.print(merchorderVO2.getMerOrderActuallyAmount() + ",");
//		System.out.print(merchorderVO2.getMerOrderTime() + ",");
//		System.out.print(merchorderVO2.getMerOrderPayStatus() + ",");
//		System.out.print(merchorderVO2.getMerOrderStatus() + ",");
//		System.out.print(merchorderVO2.getMerOrderAddress() + ",");
//		System.out.print(merchorderVO2.getMerOrderCode() + ",");
//		System.out.println("---------------------");
//
//		// 查詢多筆 **Q
//		MemberVO membervo = new MemberVO();
//		membervo.setMemId(7001);

//		List<MerchOrderVO> list = dao.getAll();
//		for (MerchOrderVO merchorderVO2 : list) {
//			System.out.print(merchorderVO2.getMerOrderId() + ",");
//			System.out.print(merchorderVO2.getMember() + ",");
//			System.out.print(merchorderVO2.getMerOrderActuallyAmount() + ",");
//			System.out.print(merchorderVO2.getMerOrderTime() + ",");
//			System.out.print(merchorderVO2.getMerOrderPayStatus() + ",");
//			System.out.print(merchorderVO2.getMerOrderStatus() + ",");
//			System.out.print(merchorderVO2.getMerOrderAddress() + ",");
//			System.out.print(merchorderVO2.getMerOrderCode() + ",");
//
//			System.out.println();
//		}
//
//		List<MerchOrderVO> merchOrder = dao.getAll();
//
//		if (merchOrder != null) {
//			System.out.println("MerchOrder List:");
//			for (MerchOrderVO detail : merchOrder) {
//				System.out.println(detail); // 假设MerchOrderDetailVO有适当的toString方法
//			}
//		} else {
//			System.out.println("Failed to retrieve MerchOrderDetail List.");
//		}

//		List<MerchOrderVO> list = dao.getAll();
//
//		if (list != null) {
//			for (MerchOrderVO merchorderVO : list) {
//				System.out.print("MerchOrderID: " + merchorderVO.getMerOrderId() + ", ");
//				System.out.print("Member: " + merchorderVO.getMember() + ", ");
//				System.out.print("Actually Amount: " + merchorderVO.getMerOrderActuallyAmount() + ", ");
//				System.out.print("Order Time: " + merchorderVO.getMerOrderTime() + ", ");
//				System.out.print("Pay Status: " + merchorderVO.getMerOrderPayStatus() + ", ");
//				System.out.print("Order Status: " + merchorderVO.getMerOrderStatus() + ", ");
//				System.out.print("Order Address: " + merchorderVO.getMerOrderAddress() + ", ");
//				System.out.print("Order Code: " + merchorderVO.getMerOrderCode());
//
//				System.out.println();
//			}
//		} else {
//			System.out.println("Failed to retrieve MerchOrder List.");
//		}
	}
}
