package com.tha103.artion.member.model;

public interface MemberDAO {
	int insert(MemberVO entity);

	int update(MemberVO entity);
	
	int login(MemberVO entity);

	MemberVO getMember(Integer id);
}
