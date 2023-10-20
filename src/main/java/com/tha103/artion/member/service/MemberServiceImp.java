package com.tha103.artion.member.service;

import org.hibernate.Session;

import com.tha103.artion.member.model.MemberDAO;
import com.tha103.artion.member.model.MemberDAOlmp;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.memberLevel.model.MemberLevelVO;
import com.tha103.artion.util.HibernateUtil;

public class MemberServiceImp implements MemberService {
	MemberDAO dao;
	MemberVO memberVO = null;
	Integer memId;

	public MemberServiceImp() {
		dao = new MemberDAOlmp(HibernateUtil.getSessionFactory());
	}

	@Override
	public int insert(MemberVO member) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MemberLevelVO level=session.get(MemberLevelVO.class, 1);
			memberVO = member;
			memberVO.setMemLevLevel(level);
			memId=dao.insert(member);
			session.getTransaction().commit();
			return memId;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int update(MemberVO member) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			memberVO = member;
			memId=dao.update(member);
			session.getTransaction().commit();
			return memId;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public MemberVO getMember(Integer mem_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			memberVO=dao.getMember(mem_id);
			session.getTransaction().commit();
			return memberVO;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

}
