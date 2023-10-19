package com.tha103.artion.member.service;

import com.tha103.artion.util.HibernateUtil;
import org.hibernate.Session;

import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.memberLevel.model.MemberLevelVO;
public class TestMember {
public static void main(String[] args) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	try {
	
		session.beginTransaction(); 
//		MemberVO member=session.get(MemberVO.class, 7001);
//		System.out.println(member.getMemCols());
		MemberVO memberVO =new MemberVO();
		MemberLevelVO level=session.get(MemberLevelVO.class, 1);
		memberVO.setMemId(7002);
		memberVO.setMemName("陳亮竹");
		memberVO.setMemNickname("福利熊");
		memberVO.setMemAccount("xddsd123@gmail.com");
		memberVO.setMemPassword("1232445");
		memberVO.setMemGender("男");
		memberVO.setMemBirthday(java.sql.Date.valueOf("2000-09-19"));
		memberVO.setMemMobile("0911278999");
		memberVO.setMemAddress("新北市新莊區福慧路188號");
		memberVO.setMemRegisterdTime(new java.sql.Timestamp(new java.util.Date().getTime()));
//		memberVO.setMemLastModifiedTime(java.sql.Date.valueOf("2023-09-12"));
		memberVO.setMemLevLevel(level);
		memberVO.setMemProfilePhoto(null);
		memberVO.setMemTotalCost(0);
		session.update(memberVO);
		session.getTransaction().commit();
}catch(Exception e) {
	e.printStackTrace();
	session.getTransaction().rollback();
} finally {
	HibernateUtil.shutdown();
}
}}
