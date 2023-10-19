package com.tha103.artion.member.service;

import com.tha103.artion.member.model.MemberVO;

public interface MemberService {
	int insert(MemberVO member);
	int update(MemberVO member);
	MemberVO getMember(Integer mem_id);
	
}
