package com.tha103.artion.activity.model;

import java.io.IOException;
import java.io.*;
import java.sql.Connection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.tha103.artion.util.AddressToLatLng;
import com.tha103.artion.util.HibernateUtil;

public class ActivityDAO implements ActivityDAO_interface {

	@Override
	public int insert(ActivityVO activityVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int actId = 0;
		try {
			session.getTransaction().begin();
			actId = (int) session.save(activityVO);
			session.getTransaction().commit();
			return actId;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(ActivityVO activityVO) {
		Session session = HibernateUtil.getSessionFactory().openSession(); // 使用 openSession 获取当前会话
		try {
			session.beginTransaction();
			session.merge(activityVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		} finally {
			session.close(); // 在完成操作后关闭会话
		}
		return 0;
	}

//	@Override
//	public int update(ActivityVO activityVO) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		try {
//			session.getTransaction().begin();
//			session.merge(activityVO);
//			session.getTransaction().commit();
//			return 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return -1;
//	}

	@Override // 皓瑄
	public ActivityVO findByPK(Integer actId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ActivityVO activity = session.get(ActivityVO.class, actId);
			session.getTransaction().commit();
			return activity;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	public List<ActivityVO> getAll() {
		List<ActivityVO> list = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			list = session.createQuery("from ActivityVO", ActivityVO.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}

	// 透過種類查詢
	public List<ActivityVO> getActType(String type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String hql = "FROM Activity WHERE actType = :type";
			Query<ActivityVO> query = session.createQuery(hql, ActivityVO.class);
			query.setParameter("type", type);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	// DAO測試
//	public static void main(String[] args) throws Exception {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			// 新增資料
//			ActivityVO activityVO = new ActivityVO();
//
//			activityVO.setActName("啤酒節");
//			activityVO.setActTicketPrice(120);
//			activityVO.setActTicketStartTime(Date.valueOf("2023-09-12"));
//			activityVO.setActTicketEndTime(Date.valueOf("2023-09-12"));
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
//			SellerVO sellerVO = session.get(SellerVO.class, 2001); // 以賣家的ID為例
//			activityVO.setSeller(sellerVO);
//			
//			activityVO.setActLongitude(new BigDecimal("55.40338"));
//			activityVO.setActLatitude(new BigDecimal("22.17403"));
//			activityVO.setActTicketTotalSell(158);
//			
//			AdministratorVO administratorVO = session.get(AdministratorVO.class, 1001);
//			activityVO.setAdmId(administratorVO);
//			
//			activityVO.setActLastModifiedTime(Timestamp.valueOf("2023-09-23 01:12:36"));
//			activityVO.setActResultContent("你好!我是寬宏藝術");
//
//			session.save(activityVO);
//			// 查詢單筆資料
////			ActivityVO activityVO1 = session.get(ActivityVO.class, 10001);
////			System.out.println(activityVO1);
//
////			List<ActivityVO> list = session.createQuery("from ActivityVO", ActivityVO.class).list();
////			System.out.println(list);
//			
////			ActivityDAO dao = new ActivityDAO();
////			System.out.println(dao.getAll());
//			
//			//刪除單筆資料
////			 ActivityVO activity = session.get(ActivityVO.class, 10001);
////			 session.delete(activity);
//			
//			session.getTransaction().commit();
//		} catch (Exception e) {
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

	@Override
	public List<ActivityVO> getActivitiesBySellerId(Integer selId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String hql = "FROM ActivityVO AS a WHERE a.seller.selId = :selId";
			Query<ActivityVO> query = session.createQuery(hql, ActivityVO.class);
			query.setParameter("selId", selId);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public void delete(Integer actId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			// Load the entity by its ID
			ActivityVO activity = session.get(ActivityVO.class, actId);

			if (activity != null) {
				// If the entity exists, delete it
				session.delete(activity);
			}

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		} finally {
			session.close();
		}
	}
}
//	public static void main(String[] args) {
//		String address = "台北市中正區黎明里北平西路3號"; // 你要转换的地址
//		double[] coordinates = AddressToLatLng.addressToLatLng(address);
//
//		if (coordinates != null) {
//			double latitude = coordinates[0];
//			double longitude = coordinates[1];
//			System.out.println("Latitude: " + latitude);
//			System.out.println("Longitude: " + longitude);
//		} else {
//			System.out.println("地址转换失败");
//		}
//	}
//}

//	private static double[] addressToLatLng(String address) {
//		final String API_KEY = "AIzaSyBMvmNl9HJ9NkBAsw68E5NfRuZ4g2rIFz4";
//		String apiUrl="https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + API_KEY;
//
//			try {
//				   HttpClient httpClient = HttpClients.createDefault();
//				   HttpGet httpGet = new HttpGet(apiUrl);
//				   org.apache.http.HttpResponse httpResponse = httpClient.execute(httpGet);
//		            String jsonResult = EntityUtils.toString(httpResponse.getEntity());
//		            
//		            JsonObject data = JsonParser.parseString(jsonResult).getAsJsonObject();
//		            if (data.get("status").getAsString().equals("OK")) {
//		                JsonObject location = data.getAsJsonArray("results").get(0)
//		                        .getAsJsonObject().getAsJsonObject("geometry").getAsJsonObject("location");
//		                double latitude = location.get("lat").getAsDouble();
//		                double longitude = location.get("lng").getAsDouble();
//
//		                double[] coordinates = {latitude,longitude};
//		                return coordinates;
//		            }
//			} catch (Exception e) {
//	            e.printStackTrace();
//	        }
//			return null; //轉換失敗
//		}
//}