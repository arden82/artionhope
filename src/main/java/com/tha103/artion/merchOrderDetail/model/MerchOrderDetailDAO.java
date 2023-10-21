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
	public MerchOrderDetailVO getById(Integer merchOrdDetailId) {
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

	public static void main(String[] args) throws Exception {
		MerchOrderDetailDAO dao = new MerchOrderDetailDAO();

		// 新增

//		MerchOrderVO merchorderVO = new MerchOrderVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
//		merchorderVO.setMerOrderId(134804);
//
//		MerchVO merchVO = new MerchVO();
//		merchVO.setMerchId(1);
//
//		MerchOrderDetailVO merchorderdetailVO = new MerchOrderDetailVO();
//		merchorderdetailVO.setMerchorder(merchorderVO);
//		merchorderdetailVO.setMerch(merchVO);
//		merchorderdetailVO.setMerOrderDetailQuantity(1000);
//		merchorderdetailVO.setMerOrderDetailPrice(5000);
//
//		dao.insert(merchorderdetailVO);

//		// 修改
//		MerchOrderVO merchorderVO1 = new MerchOrderVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
//		merchorderVO1.setMerOrderId(134804);
//
//		MerchVO merchVO1 = new MerchVO();
//		merchVO1.setMerchId(1);
//
//		MerchOrderDetailVO merchorderdetailVO1 = new MerchOrderDetailVO();
//		merchorderdetailVO1.setMerchOrdDetailId(4);
//		merchorderdetailVO1.setMerchorder(merchorderVO1);
//		merchorderdetailVO1.setMerch(merchVO1);
//		merchorderdetailVO1.setMerOrderDetailQuantity(10);
//		merchorderdetailVO1.setMerOrderDetailPrice(10);

//		dao.update(merchorderdetailVO1);
//
////		// 刪除
//		dao.delete(8);
////

////		// 查詢單筆  **QQQ
//		MerchOrderVO merchorderVO1 = new MerchOrderVO(); 
//		merchorderVO1.setMerOrderId(134804);
//
//		MerchVO merchVO1 = new MerchVO();
//		merchVO1.setMerchId(1);
//
//		MerchOrderDetailVO merchorderdetailVO2 = dao.getById(4);
//		System.out.print(merchorderdetailVO2.getMerchorder() + ",");
//		System.out.print(merchorderdetailVO2.getMerch() + ",");
//		System.out.print(merchorderdetailVO2.getMerOrderDetailQuantity() + ",");
//		System.out.print(merchorderdetailVO2.getMerOrderDetailPrice() + ",");
//
//		System.out.println("---------------------");

//		// 查詢多筆 **Q
//		MerchOrderVO merchorderVO1 = new MerchOrderVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼

//

//		List<MerchOrderDetailVO> list = dao.getAll();
//		for (MerchOrderDetailVO merchorderdetailVO1 : list) {
//			System.out.print(merchorderdetailVO1.getMerchOrdDetailId() + ",");
//			System.out.print(merchorderdetailVO1.getMerchorder() + ",");
//			System.out.print(merchorderdetailVO1.getMerch() + ",");
//			System.out.print(merchorderdetailVO1.getMerOrderDetailQuantity() + ",");
//			System.out.print(merchorderdetailVO1.getMerOrderDetailPrice() + ",");
//
//			System.out.println();
//		}

//		List<MerchOrderDetailVO> merchOrderDetails = dao.getAll();
//
//		if (merchOrderDetails != null) {
//			System.out.println("MerchOrderDetail List:");
//			for (MerchOrderDetailVO detail : merchOrderDetails) {
//				System.out.println(detail); // 假设MerchOrderDetailVO有适当的toString方法
//			}
//		} else {
//			System.out.println("Failed to retrieve MerchOrderDetail List.");
//		}
//
//	}
	}
}
