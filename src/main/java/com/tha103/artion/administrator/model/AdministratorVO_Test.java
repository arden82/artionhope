package com.tha103.artion.administrator.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tha103.artion.util.*;

public class AdministratorVO_Test {
	
	public static byte[] writePicture(String path) throws IOException {
		  FileInputStream fis = new FileInputStream(path);
		  byte[] buffer = fis.readAllBytes();
		  fis.close();
		  return buffer;
		 }

	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//
//		try {
//
//			session.beginTransaction();

//			AdministratorVO admin = new AdministratorVO();

//			admin.setAdmId(1006);
//			admin.setAdmName("lawrence");
//			admin.setAdmIdentity(1);
//			admin.setAdmStatus(1);
//			admin.setAdmMail("123");
//			admin.setAdmPassword("123");
//			admin.setAdmBirthday(Date.valueOf("2000-07-25"));
//			admin.setAdmMobile("0970308725");
//			admin.setAdmAddTime(null);
//			admin.setAdmLastModifiedTime(null);
//			try {
//				
//				byte[] test = writePicture("C:\\Users\\Tibame_T14\\Desktop\\peakyblinder1.jpg");
//				
//				admin.setAdmProfilePhoto(test);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			admin.setAdmRight(1);

			// 新增及修改
//			session.saveOrUpdate(admin);

			// 刪除
//			AdministratorVO admin2 = session.get(AdministratorVO.class, 1001);
//			if (admin2 != null)
//				session.delete(admin2);
			
			
//			List<AdministratorVO> list = session.createQuery("from AdministratorVO",AdministratorVO.class).list();
			//查全部
//			System.out.println(list);
			//查詢
//			System.out.println(admin2);

//			session.getTransaction().commit();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		} finally {
//			HibernateUtil.shutdown();
//		}
		
		
		AdministratorDAO_Interface dao = new AdministratorDAO(HibernateUtil.getSessionFactory());
		
		AdministratorVO admin = dao.getById(1001);
		System.out.println(admin);
	}
}
