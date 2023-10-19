package com.tha103.artion.activityLike.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.util.HibernateUtil;


public class ActivityLikeDAO implements ActivityLikeVO_interface {
	private SessionFactory factory;

	public ActivityLikeDAO(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int add(ActivityLikeVO actComLike) {
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
	public int update(ActivityLikeVO actComLike) {
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
			ActivityLikeVO actComLike = new ActivityLikeVO();

			MemberVO member = session.get(MemberVO.class, 7001);
			actComLike.setMember(member);

			ActivityVO activity = session.get(ActivityVO.class, 10001);
			actComLike.setActivity(activity);
			
			actComLike.setActLikeStatus(1);
			session.save(actComLike);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		HibernateUtil.shutdown();
	}
}
