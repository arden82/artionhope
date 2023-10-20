package com.tha103.artion.activity.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.administrator.model.AdministratorVO;

import com.tha103.artion.util.HibernateUtil;

public class ActivityDAO implements ActivityDAO_interface {

	private static final String INSERT_STMT = "INSERT INTO activity (act_name, act_ticketID,"
			+ "	act_ticketPrice, act_ticketStartTime, act_ticketEndTime, act_type, act_startDate,"
			+ "	act_endDate, act_startTime, act_endTime, act_city, act_zone, act_address, act_organization,"
			+ "	act_email, act_phone, act_ticketTotal, act_content, act_coverPicture, act_picture1,"
			+ "	act_picture2, act_picture3, act_likeTimes, act_views, act_approalStatus, act_status,"
			+ "	sel_id, act_longitude, act_latitude, act_ticketTotalSell, adm_id, act_lastModifiedTime,"
			+ "	act_ResultContent)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT act_id, act_name, act_ticketID,"
			+ "act_ticketPrice, act_ticketStartTime, act_ticketEndTime, act_type, act_startDate,"
			+ "act_endDate, act_startTime, act_endTime, act_city, act_zone, act_address, act_organization,"
			+ "act_email, act_phone, act_ticketTotal, act_content, act_coverPicture, act_picture1,"
			+ "act_picture2, act_picture3, act_likeTimes, act_views, act_approalStatus, act_status,"
			+ "sel_id, act_longitude, act_latitude, act_ticketTotalSell, adm_id, act_lastModifiedTime,"
			+ "act_ResultContent" + " FROM activity order by act_id";

	private static final String GET_ONE_STMT = "SELECT act_id, act_name, act_ticketID,"
			+ "act_ticketPrice, act_ticketStartTime, act_ticketEndTime, act_type, act_startDate,"
			+ "act_endDate, act_startTime, act_endTime, act_city, act_zone, act_address, act_organization,"
			+ "act_email, act_phone, act_ticketTotal, act_content, act_coverPicture, act_picture1,"
			+ "act_picture2, act_picture3, act_likeTimes, act_views, act_approalStatus, act_status,"
			+ "sel_id, act_longitude, act_latitude, act_ticketTotalSell, adm_id, act_lastModifiedTime,"
			+ "act_ResultContent" + " FROM activity where act_id = ?";
	
	private static final String UPDATE = "UPDATE activity set act_name = ?, act_ticketID = ?, "
			+ "act_ticketPrice = ?, act_ticketStartTime = ?, act_ticketEndTime = ?, act_type = ?, act_startDate = ?,"
			+ "act_endDate = ?, act_startTime = ?, act_endTime = ?, act_city = ?, act_zone = ?, act_address = ?, "
			+ "act_organization = ?, act_email = ?, act_phone = ?, act_ticketTotal = ?, act_content = ?, "
			+ "act_coverPicture = ?, act_picture1 = ?, act_picture2 = ?, act_picture3 = ?, act_likeTimes = ?, "
			+ "act_views = ?, act_approalStatus = ?, act_status = ? ,sel_id = ?, act_longitude = ?, act_latitude = ?,"
			+ "act_ticketTotalSell = ?, adm_id = ?, act_lastModifiedTime = ?, act_ResultContent = ? where act_id = ?";

	@Override
	public void insert(ActivityVO activityVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(activityVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(ActivityVO activityVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(activityVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public ActivityVO findByPrimaryKey(Integer actId) {
		ActivityVO activityVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			activityVO = (ActivityVO) session.get(ActivityVO.class, actId);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return activityVO;
	}

	@Override
	public List<ActivityVO> getAll() {
		List<ActivityVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<ActivityVO> query = session.createQuery(GET_ALL_STMT, ActivityVO.class);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			// 新增資料
			ActivityVO activityVO = new ActivityVO();

			activityVO.setActName("天母啤酒節");
			activityVO.setActTicketID(200);
			activityVO.setActTicketPrice(120);
			activityVO.setActTicketStartTime(Timestamp.valueOf("2023-09-12 00:00:00"));
			activityVO.setActTicketEndTime(Timestamp.valueOf("2023-09-20 00:00:00"));
			activityVO.setActType(1);
			activityVO.setActStartDate(Date.valueOf("2023-10-10"));
			activityVO.setActEndDate(Date.valueOf("2023-10-31"));
			activityVO.setActStartTime(Time.valueOf("00:00:00"));
			activityVO.setActEndTime(Time.valueOf("00:00:00"));
			activityVO.setActCity("台北市");
			activityVO.setActZone("中正區");
			activityVO.setActAddress("台北市中正區博愛路1號");
			activityVO.setActOrganization("寬宏藝術");
			activityVO.setActEmail("abc@gmail.com");
			activityVO.setActPhone("0912345678");
			activityVO.setActTicketTotal(2000);
			activityVO.setActContent("歡迎來玩");
			try {
			    // 
			    byte[] picture1 = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
			    byte[] picture2 = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
			    byte[] picture3 = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
			    byte[] picture4 = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
	
			    activityVO.setActCoverPicture(picture1);
			    activityVO.setActPicture1(picture2);
			    activityVO.setActPicture2(picture3);
			    activityVO.setActPicture3(picture4);
			} catch (IOException e) {
			    e.printStackTrace(); // 这里可以根据需要处理异常，例如记录日志或显示错误消息
			}
			activityVO.setActLikeTimes(200);
			activityVO.setActViews(58);
			activityVO.setActApproalStatus(1);
			activityVO.setActStatus(1);
			SellerVO seller = session.get(SellerVO.class, 2001);
			activityVO.setSeller(seller);
			
			activityVO.setActLongitude(new BigDecimal("55.40338"));
			activityVO.setActLatitude(new BigDecimal("55.40338"));
			activityVO.setActTicketTotalSell(158);
			
			AdministratorVO administrator = session.get(AdministratorVO.class, 1001);
			activityVO.setAdmId(administrator);
			activityVO.setActLastModifiedTime(Timestamp.valueOf("2023-09-23 01:12:36"));
			activityVO.setActResultContent("你好!我是寬宏藝術");

			session.save(activityVO);
			
			// 查詢單筆資料
//		SellerVO sellerVO1 = session.get(SellerVO.class, 2001);
//		System.out.println(sellerVO1);

			// 查詢全部資料
//		List<SellerVO> list = session.createQuery("from SellerVO", SellerVO.class).list();
//		System.out.println(list);

			session.getTransaction().commit();
		} catch (

		Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		HibernateUtil.shutdown();
	}

	public static byte[] writePicture(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = fis.readAllBytes();
		fis.close();
		return buffer;
	}

}
