package com.tha103.artion.member.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MemberDAOlmp implements MemberDAO {
	private SessionFactory factory;

	public MemberDAOlmp(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(MemberVO entity) {
		return (Integer) getSession().save(entity);
	}

	@Override
	public int update(MemberVO entity) {
		try {
			getSession().update(entity);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public MemberVO getMember(Integer id) {
		return getSession().get(MemberVO.class,id);
	}

}
