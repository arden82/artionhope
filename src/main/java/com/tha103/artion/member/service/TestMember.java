package com.tha103.artion.member.service;

import util.HibernateUtil;
import org.hibernate.Session;

import com.tha103.artion.member.model.MemberVO;
public class TestMember {
public static void main(String[] args) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	try {
	
		session.beginTransaction(); 
		MemberVO member=session.get(MemberVO.class, 7001);
		System.out.println(member.getMemCols());
		session.getTransaction().commit();
}catch(Exception e) {
	e.printStackTrace();
	session.getTransaction().rollback();
} finally {
	HibernateUtil.shutdown();
}
}}
