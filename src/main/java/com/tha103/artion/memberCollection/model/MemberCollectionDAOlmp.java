package com.tha103.artion.memberCollection.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.member.model.MemberVO;

public class MemberCollectionDAOlmp implements MemberCollectionDAO {
	private SessionFactory factory;

	public MemberCollectionDAOlmp(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(MemberCollectionVO entity, Integer memId, Integer actId) {
		MemberCollectionVO check = null;
		check = getSession()
				.createQuery("form MemberCollectionVO where mem_id=:memId and act_id=:actId", MemberCollectionVO.class)
				.setParameter("memId", memId).setParameter("actId", actId).uniqueResult();
		if (check != null) {
			return -1; // 重複收藏
		}
		MemberVO member = getSession().get(MemberVO.class, memId);
		ActivityVO activity = getSession().get(ActivityVO.class, actId);
		entity.setActivity(activity);
		entity.setMember(member);
		return (Integer) getSession().save(entity);
	}

	@Override
	public int update(MemberCollectionVO entity) {
		try {
			getSession().update(entity);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public List<MemberCollectionVO> getMember(Integer memId) {
		List<MemberCollectionVO> member = getSession()
				.createQuery("from MemberCollectionVO where mem_id = :memId", MemberCollectionVO.class)
				.setParameter("memId",memId).list();
		return member;
	}

}