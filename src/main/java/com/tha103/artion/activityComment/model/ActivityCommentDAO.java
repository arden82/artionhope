package com.tha103.artion.activityComment.model;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.io.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.util.HibernateUtil;

public class ActivityCommentDAO implements ActivityCommentDAO_interface {

	private SessionFactory factory;

	public ActivityCommentDAO(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public int add(ActivityCommentVO actCom) {
		try {
			getSession().getTransaction().begin();
			Integer id = (Integer) getSession().save(actCom);
			getSession().getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(ActivityCommentVO actCom) {
		try {
			getSession().getTransaction().begin();
			getSession().update(actCom);
			getSession().getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return -1;
	}
	
	@Override
	public ActivityCommentVO findByPK(Integer actComId) {
		try {
			getSession().beginTransaction();
			ActivityCommentVO actCom = getSession().get(ActivityCommentVO.class, actComId);
			getSession().getTransaction().commit();
			return actCom;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<ActivityCommentVO> getAll() {
		try {
			getSession().beginTransaction();
			List<ActivityCommentVO> list = getSession().createQuery("from activitycomment", ActivityCommentVO.class).list();
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
			//新增資料
//			ActivityCommentVO actCom = new ActivityCommentVO();
//			MemberVO member = session.get(MemberVO.class, 7001);
//			actCom.setMember(member);
//			ActivityVO activity = session.get(ActivityVO.class, 10001);
//			actCom.setActivity(activity);
//			actCom.setActComContent("寫code好難");
//			actCom.setActComReportTimes(1);
//			actCom.setActComLikeTimes(2);
//			try {
//				byte[] coverpicture = writePicture("C:/Users/Tibame_T14/Desktop/java養成班/專題/Artion/image/留言圖片3-1.jpg");
//				byte[] actpicture1 = writePicture("C:/Users/Tibame_T14/Desktop/java養成班/專題/Artion/image/留言圖片3-2.jpg");
//				byte[] actpicture2 = writePicture("C:/Users/Tibame_T14/Desktop/java養成班/專題/Artion/image/留言圖片3-3.jpg");
//				byte[] actpicture3 = writePicture("C:/Users/Tibame_T14/Desktop/java養成班/專題/Artion/image/留言圖片3-4.jpg");
//				actCom.setActComCoverPicture(coverpicture);
//				actCom.setActComPicture1(actpicture1);
//				actCom.setActComPicture2(actpicture2);
//				actCom.setActComPicture3(actpicture3);
//				
//			}catch(IOException e){
//				e.printStackTrace();
//			}
//			actCom.setActComStatus(true);
//			
//			session.save(actCom);
			
			
			//查詢單筆資料
			List<ActivityCommentVO> actCom = session.createQuery("from ActivityCommentVO",ActivityCommentVO.class).list();
//			ActivityCommentVO actCom = session.get(ActivityCommentVO.class,2);
			System.out.println(actCom);
			
			
			
			
			session.getTransaction().commit();
		}catch(Exception e){
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
