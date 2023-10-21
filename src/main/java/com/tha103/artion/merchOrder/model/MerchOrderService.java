package com.tha103.artion.merchOrder.model;

import java.sql.Timestamp;
import java.util.List;

import com.tha103.artion.member.model.MemberVO;

public class MerchOrderService {
	private MerchOrderDAO_interface dao;

	public MerchOrderService() {
		dao = new MerchOrderDAO();
	}

	public MerchOrderVO insertMerchorder(MemberVO member, Integer merOrderActuallyAmount, Timestamp merOrderTime,
			Integer merOrderPayStatus, Integer merOrderStatus, String merOrderAddress, String merOrderCode) {

		MemberVO membervo = new MemberVO();
		membervo.setMemId(7002);

		MerchOrderVO merchorderVO = new MerchOrderVO();

		merchorderVO.setMember(membervo);
		merchorderVO.setMerOrderActuallyAmount(merOrderActuallyAmount);
		merchorderVO.setMerOrderPayStatus(merOrderPayStatus);
		merchorderVO.setMerOrderStatus(merOrderStatus);
		merchorderVO.setMerOrderAddress(merOrderAddress);
		merchorderVO.setMerOrderCode(merOrderCode);

		dao.insert(merchorderVO);

		return merchorderVO;
	}

	public MerchOrderVO updateMerchorder(Integer merOrderId, MemberVO member, Integer merOrderActuallyAmount,
			Timestamp merOrderTime, Integer merOrderPayStatus, Integer merOrderStatus, String merOrderAddress,
			String merOrderCode) {

		MemberVO membervo = new MemberVO();
		membervo.setMemId(7002);

		MerchOrderVO merchorderVO = new MerchOrderVO();

		merchorderVO.setMember(membervo);
		merchorderVO.setMerOrderActuallyAmount(merOrderActuallyAmount);
		merchorderVO.setMerOrderPayStatus(merOrderPayStatus);
		merchorderVO.setMerOrderStatus(merOrderStatus);
		merchorderVO.setMerOrderAddress(merOrderAddress);
		merchorderVO.setMerOrderCode(merOrderCode);
		dao.insert(merchorderVO);

		return merchorderVO;

	}

	public void deleteMerchorder(Integer merOrderId) {
		dao.delete(merOrderId);
	}

	public MerchOrderVO getOneMerchorder(Integer merOrderId) {
		return dao.getById(merOrderId);
	}

	public List<MerchOrderVO> getAll() {
		return dao.getAll();
	}

}
