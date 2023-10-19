package com.tha103.artion.activityCommentLike.model;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.util.HibernateUtil;


public class ActivityCommentLikeDAO implements ActivityCommentLikeDAO_interface {
	private SessionFactory factory;

	public ActivityCommentLikeDAO(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int add(ActivityCommentLikeVO actComLike) {
		try {
			getSession().getTransaction().begin();
			Integer id = (Integer) getSession().save(actComLike);
			getSession().getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(ActivityCommentLikeVO actComLike) {
		try {
			getSession().getTransaction().begin();
			getSession().update(actComLike);
			getSession().getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			// 新增資料
			ActivityCommentLikeVO actComLike = new ActivityCommentLikeVO();
			MemberVO member = session.get(MemberVO.class, 7001);
			actComLike.setMember(member);
			ActivityCommentVO actCom = session.get(ActivityCommentVO.class, 2);
			actComLike.setActCom(actCom);
			actComLike.setActComLikeStatus(1);
			session.save(actComLike);			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		HibernateUtil.shutdown();
	}
}
