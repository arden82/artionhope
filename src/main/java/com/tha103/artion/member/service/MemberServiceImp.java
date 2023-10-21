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
			MemberLevelVO level = session.get(MemberLevelVO.class, 1);
			memberVO = member;
			memberVO.setMemLevLevel(level);
			memId = dao.insert(member);
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
			memId = dao.update(member);
			session.getTransaction().commit();
			return memId;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public MemberVO login(String account, String password) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MemberVO member = session.createQuery("from member where mem_account =" + account, MemberVO.class)
					.uniqueResult();
			session.getTransaction().commit();
			if(member!=null) {
				String check = member.getMemPassword();
				if(!(check.equals(password))) {
					member.setMemPassword("密碼錯誤");//有註冊過的帳號但密碼錯誤
					
				}
				return member;
			}
			return null;//沒有註冊過的帳號回傳null
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public MemberVO getMember(Integer mem_id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			memberVO = dao.getMember(mem_id);
			session.getTransaction().commit();
			return memberVO;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

}
