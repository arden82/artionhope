package com.tha103.artion.seller.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.io.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.tha103.artion.seller.model.*;
import com.tha103.artion.util.HibernateUtil;

public class SellerDAO implements SellerDAO_interface {
	/*
	 * �`�N: A. �ثe�u�O��B����Hibernate���򥻥\�� B. �ثe�|�ݤ��XHibernate���¤O�Ҧb
	 */
	private static final String INSERT_STMT = "INSERT INTO seller (sel_account, sel_password, sel_name, sel_phone,sel_address, sel_url,"
			+ "sel_facebook,sel_contactPerson,sel_introduction,sel_bankCode,sel_bankNumber,sel_bankName,sel_remark,"
			+ "sel_title,sel_principal,sel_uniformNumbers,sel_registeredAddress,sel_profilePicture,sel_registerdTime,"
			+ "sel_lastModifiedTime,sel_status)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "from SellerVO";
//	private static final String GET_ALL_STMT = "SELECT sel_id, sel_account, sel_password, sel_name, sel_phone, sel_address,sel_url,"
//			+ "sel_facebook,sel_contactPerson,sel_introduction,sel_bankCode, sel_bankNumber, sel_bankName, sel_remark,"
//			+ "sel_title,sel_principal,sel_uniformNumbers,sel_registeredAddress,sel_profilePicture,sel_registerdTime,"
//			+ "sel_lastModifiedTime,sel_status FROM seller order by sel_id";

	private static final String GET_ONE_STMT = "SELECT sel_id, sel_account, sel_password, sel_name, sel_phone,sel_address, sel_url,"
			+ "sel_facebook, sel_contactPerson, sel_introduction, sel_bankCode, sel_bankNumber, sel_bankName, sel_remark,"
			+ "sel_title, sel_principal, sel_uniformNumbers, sel_registeredAddress, sel_profilePicture, sel_registerdTime,"
			+ "sel_lastModifiedTime, sel_status FROM seller where sel_id = ?";

	private static final String UPDATE = "UPDATE seller set sel_account = ?,sel_password = ?,sel_name = ?,sel_phone = ?,sel_address = ?, sel_url = ?,"
			+ "sel_facebook = ?,sel_contactPerson = ?,sel_introduction = ?,sel_bankCode = ?,sel_bankNumber = ?,sel_bankName = ?,sel_remark = ?,"
			+ "sel_title = ?,sel_principal = ?,sel_uniformNumbers =?,sel_registeredAddress =?,sel_profilePicture = ?,sel_registerdTime = ?,"
			+ "sel_lastModifiedTime = ?,sel_status = ? where sel_id = ?";

	private static final String GET_BY_ACCOUNT = "SELECT * FROM seller WHERE sel_account = ?";

	@Override
	public void insert(SellerVO sellerVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(sellerVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(SellerVO sellerVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(sellerVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public SellerVO findByPrimaryKey(Integer selId) {
		SellerVO sellerVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			sellerVO = (SellerVO) session.get(SellerVO.class, selId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return sellerVO;
	}

	@Override
	public List<SellerVO> getAll() {
		List<SellerVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<SellerVO> query = session.createQuery(GET_ALL_STMT, SellerVO.class);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
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

	public SellerVO getSellerByAccount(String selAccount) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		SellerVO sellerVO = null;

		try {
			session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<SellerVO> criteria = builder.createQuery(SellerVO.class);
			Root<SellerVO> root = criteria.from(SellerVO.class);
			criteria.select(root);
			criteria.where(builder.equal(root.get("selAccount"), selAccount));

			Query<SellerVO> query = session.createQuery(criteria);
			List<SellerVO> results = query.getResultList();

			if (!results.isEmpty()) {
				sellerVO = results.get(0); // 如果有結果，取第一個
			}

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw ex;
		}

		return sellerVO;
	}

//	@Override
//	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {		
//		Set<EmpVO> set = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Query<EmpVO> query = session.createQuery(GET_Emps_ByDeptno_STMT, EmpVO.class);
//			query.setParameter(0, deptno);
//			List<EmpVO> list = query.getResultList();
//			set = new HashSet<EmpVO>(list);
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return set;
//	}
//	public static void main(String[] args) throws Exception {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			// 新增資料
//			SellerVO sellerVO = new SellerVO();
//
//			sellerVO.setSelAccount("aaa@yahoo.com.tw");
//			sellerVO.setSelPassword("Aa26422268");
//			sellerVO.setSelName("J米素食餐廳");
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

			// 查詢單筆資料
//		SellerVO sellerVO1 = session.get(SellerVO.class, 2001);
//		System.out.println(sellerVO1);

			// 查詢全部資料
//		List<SellerVO> list = session.createQuery("from SellerVO", SellerVO.class).list();
//		System.out.println(list);

//			session.getTransaction().commit();
//		} catch (
//
//		Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		HibernateUtil.shutdown();
//	}

	public static byte[] writePicture(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = fis.readAllBytes();
		fis.close();
		return buffer;
	}

}
