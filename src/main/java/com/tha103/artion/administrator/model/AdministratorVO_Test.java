package com.tha103.artion.administrator.model;

import org.hibernate.Session;

import util.HibernateUtil;

public class AdministratorVO_Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {

			session.beginTransaction();

			AdministratorVO admin = new AdministratorVO();

			admin.setAdmId(null);
			admin.setAdmName(null);
			admin.setAdmIdentity(null);
			admin.setAdmStatus(false);
			admin.setAdmMail(null);
			admin.setAdmPassword(null);
			admin.setAdmBirthday(null);
			admin.setAdmMobile(null);
			admin.setAdmAddTime(null);
			admin.setAdmLastModifiedTime(null);
			admin.setAdmProfilePhoto(null);
			admin.setAdmRight(null);

			// 新增及修改
			session.saveOrUpdate(admin);

			// 刪除
			AdministratorVO admin2 = session.get(AdministratorVO.class, null);
			if (admin2 != null)
				session.delete(admin2);
			
			//查詢
			System.out.println(admin2);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
