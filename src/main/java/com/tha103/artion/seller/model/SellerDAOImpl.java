package com.tha103.artion.seller.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.tha103.artion.seller.model.SellerVO;

public class SellerDAOImpl implements SellerDAO{

	private SessionFactory factory;

	public SellerDAOImpl(SessionFactory factory) {
		this.factory = factory;
	}

	public SellerDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int add(SellerVO sellerVO) {
		try {
			getSession().getTransaction().begin();
			Integer selId = (Integer) getSession().save(sellerVO);
			getSession().getTransaction().commit();
			return selId;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(SellerVO sellerVO) {
		try {
			getSession().getTransaction().begin();
			getSession().update(sellerVO);
			getSession().getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public SellerVO findByPK(Integer selId) {
		try {
			getSession().beginTransaction();
			SellerVO Seller = getSession().get(SellerVO.class, selId);
			getSession().getTransaction().commit();
			return Seller;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<SellerVO> getAll() {
		try {
			getSession().beginTransaction();
			List<SellerVO> list = getSession().createQuery("from SellerVO", SellerVO.class).list();
			getSession().getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return null;
	}
	
	public boolean checkUser(String account, String password) {
	    SellerVO sellerVO = getSellerByAccount(account);

	    if (sellerVO != null) {
	        if (sellerVO.getSelPassword() != null && sellerVO.getSelPassword().equals(password)) {
	            return true; // Password matches
	        }
	    }
	    return false; // Password doesn't match
	}


	public SellerVO getSellerByAccount(String sel_account) {
	    try {
	        getSession().beginTransaction();
	        Query<SellerVO> query = getSession().createQuery("FROM SellerVO WHERE selAccount = :selAccount", SellerVO.class);
	        query.setParameter("selAccount", sel_account);
	        SellerVO sellerVO = query.uniqueResult();
	        getSession().getTransaction().commit();
	        return sellerVO;
	    } catch (Exception e) {
	        e.printStackTrace();
	        getSession().getTransaction().rollback();
	    }
	    return null;
	}
}

//	public static void main(String[] args) throws Exception {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			// 新增資料
//			SellerVO sellerVO = new SellerVO();
//
//			sellerVO.setSelAccount("xxx@yahoo.com.tw");
//			sellerVO.setSelPassword("Aa26422268");
//			sellerVO.setSelName("王小明有機廚房");
//			sellerVO.setSelPhone("02-26422268");
//			sellerVO.setSelAddress("汐止唷");
//			sellerVO.setSelUrl("www.abckitchen.com.tw");
//			sellerVO.setSelFacebook("https://www.facebook.com/abckitchen");
//			sellerVO.setSelContactPerson("王小明");
//			sellerVO.setSelIntroduction("我們是一間有機食物的廚房~歡迎看看!");
//			sellerVO.setSelBankCode("001");
//			sellerVO.setSelBankNumber("003004005006");
//			sellerVO.setSelBankName("王小明有機廚房");
//			sellerVO.setSelRemark("無");
//			sellerVO.setSelTitle("無");
//			sellerVO.setSelPrincipal("王小明");
//			sellerVO.setSelUniformNumbers("12345678");
//			sellerVO.setSelRegisteredAddress("100台北市中正區博愛路100號");
//			try {
//				byte[] selProfilePicture = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
//				sellerVO.setSelProfilePicture(selProfilePicture);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			sellerVO.setSelRegisterdTime(Timestamp.valueOf("2023-09-12 00:00:00"));
//			sellerVO.setSelLastModifiedTime(Timestamp.valueOf("2023-09-12 00:00:00"));
//			sellerVO.setSelStatus(2);
//
//			session.save(sellerVO);
//
//			// 查詢單筆資料
////			SellerVO sellerVO1 = session.get(SellerVO.class, 2001);
////			System.out.println(sellerVO1);
//
//			// 查詢全部資料
//			List<SellerVO> list = session.createQuery("from SellerVO", SellerVO.class).list();
//			System.out.println(list);
//
//			session.getTransaction().commit();
//		} catch (
//
//		Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		HibernateUtil.shutdown();
//	}
//
//	public static byte[] writePicture(String path) throws IOException {
//		FileInputStream fis = new FileInputStream(path);
//		byte[] buffer = fis.readAllBytes();
//		fis.close();
//		return buffer;
//	}
//
//}