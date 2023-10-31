package com.tha103.artion.member.model;

import java.util.List;

public interface MemberDAO {
	int insert(MemberVO entity);

	int update(MemberVO entity);

	int examine(String account);

	MemberVO login(String account, String password);
	
	MemberVO getMember(String account);

	MemberVO getMember(Integer id);
	
	List<MemberVO>getAll();
}
