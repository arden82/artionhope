package com.tha103.artion.merchOrder.model;

import java.lang.reflect.Member;
import java.util.List;

import com.tha103.artion.merchOrderDetail.model.MerchOrderDetailVO;

public class MerchOrderService {
	private MerchOrderDAO_interface dao;

	public MerchOrderService() {
		dao = new MerchOrderDAO();
	}

	public MerchOrderVO insertMerchrder(Member member, Integer merOrderActuallyAmount, Integer merOrderPayStatus,
			Integer merOrderStatus, String merOrderAddress, String merOrderCode, MerchOrderDetailVO MerOrdDets) {

		MerchOrderVO merchorderVO = new MerchOrderVO();

		merchorderVO.setMember(member);
		merchorderVO.setMerOrderActuallyAmount(merOrderActuallyAmount);
		merchorderVO.setMerOrderPayStatus(merOrderPayStatus);
		merchorderVO.setMerOrderStatus(merOrderStatus);
		merchorderVO.setMerOrderAddress(merOrderAddress);
		merchorderVO.setMerOrderCode(merOrderCode);
		merchorderVO.setMerOrdDets(merOrdDets);
		dao.insert(merchorderVO);

		return merchorderVO;
	}

	public MerchOrderVO updateMerchrder(Member member, Integer merOrderActuallyAmount, Integer merOrderPayStatus,
			Integer merOrderStatus, String merOrderAddress, String merOrderCode, MerchOrderDetailVO MerOrdDets) {

		MerchOrderVO merchorderVO = new MerchOrderVO();

		merchorderVO.setMember(member);
		merchorderVO.setMerOrderActuallyAmount(merOrderActuallyAmount);
		merchorderVO.setMerOrderPayStatus(merOrderPayStatus);
		merchorderVO.setMerOrderStatus(merOrderStatus);
		merchorderVO.setMerOrderAddress(merOrderAddress);
		merchorderVO.setMerOrderCode(merOrderCode);
		merchorderVO.setMerOrdDets(merOrdDets);
		dao.insert(merchorderVO);

		return merchorderVO;

	}

	public void deleteMerchrder(Integer merOrderId) {
		dao.delete(merOrderId);
	}

	public MerchOrderVO getOneMerchrder(Integer merOrderId) {
		return dao.getById(merOrderId);
	}

	public List<MerchOrderVO> getAll() {
		return dao.getAll();
	}

}
