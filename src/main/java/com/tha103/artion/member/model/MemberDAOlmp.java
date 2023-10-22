package com.tha103.artion.member.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tha103.artion.memberLevel.model.MemberLevelVO;

public class MemberDAOlmp implements MemberDAO {
	private SessionFactory factory;

	public MemberDAOlmp(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	
	
	@Override
	public int examine(String account) {
		 MemberVO member=null;
		  member =getSession().createQuery("from MemberVO where mem_account = :account",  MemberVO.class)
			.setParameter("account", account)
			.uniqueResult();
		  if(member!=null) {
			  return 1; //此帳號註冊過
		  }
		  return -1;
	}

	@Override
	public int insert(MemberVO entity) {
		 String account=entity.getMemAccount();
		 MemberVO member=null;
		  member =getSession().createQuery("from MemberVO where mem_account = :account",  MemberVO.class)
			.setParameter("account", account)
			.uniqueResult();
		  if(member!=null) {
			  return -1;
		  }
		MemberLevelVO level = getSession().get(MemberLevelVO.class, 1);
		 entity.setMemLevLevel(level);
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
	public MemberVO login(String account, String password ) {
		MemberVO member = getSession().createQuery("from MemberVO where mem_account = :account",  MemberVO.class)
				.setParameter("account", account)
				.uniqueResult();
		if(member!=null) {
			return member;
		}
		return null;//沒有註冊過的帳號回傳null
	}

	
	
	@Override
	public MemberVO getMember(Integer id) {
		return getSession().get(MemberVO.class,id);
	}

}
