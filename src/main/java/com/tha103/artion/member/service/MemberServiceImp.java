package com.tha103.artion.member.service;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.member.model.MemberDAO;
import com.tha103.artion.member.model.MemberDAOlmp;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.memberLevel.model.MemberLevelVO;
import com.tha103.artion.util.HibernateUtil;

public class MemberServiceImp implements MemberService {
	MemberDAO dao;

	public MemberServiceImp() {
		dao = new MemberDAOlmp(HibernateUtil.getSessionFactory());
	}

	@Override
	public int examine(String account) {
		return dao.examine(account);
	}

	@Override
	public int insert(MemberVO member) {
		return dao.insert(member);
	}

	@Override
	public int update(MemberVO member) {
		return dao.update(member);
	}

	@Override
	public MemberVO login(String account, String password) {
		MemberVO member = dao.login(account, password);
		MemberVO msg = new MemberVO();
		if (member != null) {
			String check = member.getMemPassword();
			if (!(check.equals(password))) {
				msg.setMemPassword("密碼錯誤");
				return msg;// 有註冊過的帳號但密碼錯誤
			}
			return member;
		}
		return null;

	}

	@Override
	public MemberVO getMember(String account) {
		return dao.getMember(account);
	}
	@Override
	public MemberVO getMember(Integer mem_id) {
		return dao.getMember(mem_id);
	}

	@Override
	public List<MemberVO> getAll() {
		return dao.getAll();
	}
	

}
