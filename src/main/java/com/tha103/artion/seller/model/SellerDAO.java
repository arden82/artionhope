package com.tha103.artion.seller.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.tha103.artion.util.HibernateUtil;

public class SellerDAO implements SellerDAO_interface {

	private static final String GET_ALL_STMT = "from SellerVO";

	@Override
	public void insert(SellerVO sellerVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
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
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.merge(sellerVO);
			System.out.println("a");
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			System.out.println("b");
			throw ex;
		}
	}

	@Override
	public SellerVO findByPrimaryKey(Integer selId) {
		SellerVO sellerVO = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
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
	
	//皓瑄
	public Integer findSelIdBySelName(String selName) {
	    Integer selId = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("SELECT sel.selId FROM SellerVO sel WHERE sel.selName = :selName");
	        query.setParameter("selName", selName);
	        selId = (Integer) query.uniqueResult();
	        session.getTransaction().commit();
	    } catch (RuntimeException ex) {
	        session.getTransaction().rollback();
	        throw ex;
	    } finally {
	        session.close();
	    }
	    return selId;
	}

	public Integer findFirstSelIdBySelName(String selName) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    Integer selId = null;
	    
	    try {
	        tx = session.beginTransaction();
	        
	        // 使用 HQL 查询获取第一条匹配记录的 selId
	        String hql = "SELECT sel.selId FROM SellerVO sel WHERE sel.selName = :selName";
	        Query<Integer> query = session.createQuery(hql, Integer.class);
	        query.setParameter("selName", selName);
	        query.setMaxResults(1);  // 只获取第一条记录
	        selId = query.uniqueResult();
	        
	        tx.commit();
	    } catch (RuntimeException ex) {
	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }
	        throw ex;
	    } finally {
	        session.close();
	    }
	    
	    return selId;
	}

	
	
	@Override
	public List<SellerVO> getAll() {
		List<SellerVO> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
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

	public SellerVO getSellerByAccount(String selAccount) {
		SellerVO sellerVO = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			// session.beginTransaction();

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

			// session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (session != null && session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw ex;
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return sellerVO;
	}

	public static byte[] writePicture(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = fis.readAllBytes();
		fis.close();
		return buffer;
	}

	public boolean checkUser(String account, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// 使用 Hibernate Criteria API 执行查询
		Criteria criteria = session.createCriteria(SellerVO.class).add(Restrictions.eq("selAccount", account))
				.add(Restrictions.eq("selPassword", password));

		SellerVO sellerVO = (SellerVO) criteria.uniqueResult();

		session.getTransaction().commit();

		return sellerVO != null;
	}

	@Override
	public SellerVO getSingleSeller() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		SellerVO sellerVO = null;

		try {
			session.beginTransaction();

			// 在此处执行查询以获取单一的卖家对象，你可以使用 Hibernate Criteria API 或 HQL 查询
			// 这里假设你使用 Hibernate Criteria API
			Criteria criteria = session.createCriteria(SellerVO.class);

			// 添加查询条件，例如根据卖家ID、卖家名称等来获取单一卖家
			// 例如：criteria.add(Restrictions.eq("selId", 1));
			criteria.setMaxResults(1);
			sellerVO = (SellerVO) criteria.uniqueResult();

			System.out.print(sellerVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (session.getTransaction() != null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
			throw ex;
		} finally {
			session.close();
		}

		return sellerVO;
	}

	@Override
	public SellerVO getSellerById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SellerVO getOneSeller(Integer sel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getSetSelRegisterdTime(Integer sel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean doesSellerAccountExist(String selAccount) {
		SellerVO sellerVO = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			// 使用 HQL 查询来检查帐号是否存在
			String hql = "SELECT COUNT(*) FROM SellerVO s WHERE s.selAccount = :selAccount";
			Query<Long> query = session.createQuery(hql, Long.class);
			query.setParameter("selAccount", selAccount);

			Long count = query.uniqueResult();
			return count != null && count > 0;

		} catch (Exception e) {
			e.printStackTrace(); // 处理异常
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return false; // 出现异常时返回false
	}

	public void updatePassword(String selAccount, String newPassword) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			SellerVO seller = getSellerByAccount(selAccount);
			if (seller != null) {
				seller.setSelPassword(newPassword);
				System.out.println("設置新密碼");
				session.update(seller);
				session.getTransaction().commit();
				System.out.println("設置新密碼成功");
				// 如果找不到卖家，你可以抛出异常或采取其他适当的操作
			}
		} catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
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
//			sellerVO.setSelAccount("xxx@yahoo.com.tw");
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
//}