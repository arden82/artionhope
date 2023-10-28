package com.tha103.artion.promoCode.model;

import java.util.List;

import com.tha103.artion.util.HibernateUtil;

public class PromoCodeEmailDAO {

	public List<String> selectAllMemberEmail() {
		var session = HibernateUtil.getSessionFactory().getCurrentSession();
		return session.createQuery("SELECT memAccount FROM MemberVO", String.class).list();
	}
}
