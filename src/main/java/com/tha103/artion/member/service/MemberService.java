package com.tha103.artion.member.service;

import java.util.List;

import com.tha103.artion.member.model.MemberVO;

public interface MemberService {
	int insert(MemberVO member);
	int update(MemberVO member);
	int examine(String account);
	MemberVO login(String account,String password);
	MemberVO getMember(Integer mem_id);
	MemberVO getMember(String account);
	List<MemberVO> getAll();

	
	
}
