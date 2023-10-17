package com.tha103.artion.memberNotify.model;

import java.util.List;

public class MemberNotifyService {

	private MemberNotifyDAO_interface dao;

	public MemberNotifyService() {
		dao = new MemberNotifyDAO();
	}

	public MemberNotifyVO addEmp(Integer memId, Boolean memberNotReadStatus, Boolean memberNotExistStatus, String memberNotContent ) 
	{

		MemberNotifyVO memberNotifyVO = new MemberNotifyVO();

		memberNotifyVO.setMemId(memId);
		memberNotifyVO.setMemberNotReadStatus(memberNotReadStatus);
		memberNotifyVO.setMemberNotExistStatus(memberNotExistStatus);
		memberNotifyVO.setMemberNotContent(memberNotContent);
		
		dao.insert(memberNotifyVO);

		return memberNotifyVO;
	}

	public MemberNotifyVO updateEmp(Integer memberNotSerialNumber, Integer memId, Boolean memberNotReadStatus, Boolean memberNotExistStatus,
			String memberNotContent) {

		MemberNotifyVO memberNotifyVO = new MemberNotifyVO();

		memberNotifyVO.setMemberNotSerialNumber(memberNotSerialNumber);
		memberNotifyVO.setMemId(memId);
		memberNotifyVO.setMemberNotReadStatus(memberNotReadStatus);
		memberNotifyVO.setMemberNotExistStatus(memberNotExistStatus);
		memberNotifyVO.setMemberNotContent(memberNotContent);
		
		dao.update(memberNotifyVO);

		return memberNotifyVO;
	}

	public void deleteEmp(Integer memberNotSerialNumber) {
		dao.delete(memberNotSerialNumber);
	}

	public MemberNotifyVO getOneEmp(Integer memberNotSerialNumber) {
		return dao.findByPrimaryKey(memberNotSerialNumber);
	}

	public List<MemberNotifyVO> getMemID(Integer memId) {
		MemberNotifyDAO dao2=new MemberNotifyDAO();
		return dao2.getMemID(memId);

	}
	
	public List<MemberNotifyVO> getAll() {
		return dao.getAll();
	}
}
