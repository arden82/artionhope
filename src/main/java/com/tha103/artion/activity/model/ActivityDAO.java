package com.tha103.artion.activity.model;

import java.io.IOException;
import java.io.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.seller.model.SellerVO;

import util.HibernateUtil;

public class ActivityDAO implements ActivityDAO_interface {

	private SessionFactory factory;

	public ActivityDAO(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int add(ActivityVO activityVO) {
		try {
			getSession().getTransaction().begin();
			Integer actId = (Integer) getSession().save(activityVO);
			getSession().getTransaction().commit();
			return actId;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(ActivityVO activityVO) {
		try {
			getSession().getTransaction().begin();
			getSession().update(activityVO);
			getSession().getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public ActivityVO findByPK(Integer actId) {
		try {
			getSession().beginTransaction();
			ActivityVO activity = getSession().get(ActivityVO.class, actId);
			getSession().getTransaction().commit();
			return activity;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<ActivityVO> getAll() {
		try {
			getSession().beginTransaction();
			List<ActivityVO> list = getSession().createQuery("from Activity", ActivityVO.class).list();
			getSession().getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			// 新增資料
//			ActivityVO activityVO = new ActivityVO();

//			activityVO.setActName("汐止啤酒節");
//			activityVO.setActTicketID(200);
//			activityVO.setActTicketPrice(120);
//			activityVO.setActTicketStartTime(Timestamp.valueOf("2023-09-12 00:00:00"));
//			activityVO.setActTicketEndTime(Timestamp.valueOf("2023-09-12 00:00:00"));
//			activityVO.setActType(1);
//			activityVO.setActStartDate(Date.valueOf("2023-10-10"));
//			activityVO.setActEndDate(Date.valueOf("2023-10-31"));
//			activityVO.setActStartTime(Time.valueOf("00:00:00"));
//			activityVO.setActEndTime(Time.valueOf("00:00:00"));
//			activityVO.setActCity("台北市");
//			activityVO.setActZone("中正區");
//			activityVO.setActAddress("台北市中正區博愛路1號");
//			activityVO.setActOrganization("寬宏藝術");
//			activityVO.setActEmail("abc@gmail.com");
//			activityVO.setActPhone("0912345678");
//			activityVO.setActTicketTotal(2000);
//			activityVO.setActContent("歡迎來玩");
//			try {
//				byte[] actCoverPicture = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
//				byte[] actPicture1 = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
//				byte[] actPicture2 = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
//				byte[] actPicture3 = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
//				activityVO.setActCoverPicture(actCoverPicture);
//				activityVO.setActPicture1(actPicture1);
//				activityVO.setActPicture2(actPicture2);
//				activityVO.setActPicture3(actPicture3);
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			activityVO.setActLikeTimes(200);
//			activityVO.setActViews(58);
//			activityVO.setActApproalStatus(1);
//			activityVO.setActStatus(1);
//
//			SellerVO sellerVO = session.get(SellerVO.class, 2001);
//			activityVO.setActLongitude(new BigDecimal("55.40338"));
//			activityVO.setActLatitude(new BigDecimal("22.17403"));
//			activityVO.setActTicketTotalSell(158);
//			AdministratorVO administratorVO = session.get(AdministratorVO.class, 1001);
//
//			activityVO.setActLastModifiedTime(Timestamp.valueOf("2023-09-23 01:12:36"));
//			activityVO.setActResultContent("你好!我是寬宏藝術");
//
//			session.save(activityVO);

			// 查詢單筆資料
			ActivityVO activityVO1 = session.get(ActivityVO.class, 10001);
			System.out.println(activityVO1);

//			List<ActivityVO> list = session.createQuery("from ActivityVO", ActivityVO.class).list();
//			System.out.println(list);

			session.getTransaction().commit();
		} catch (Exception e) {
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