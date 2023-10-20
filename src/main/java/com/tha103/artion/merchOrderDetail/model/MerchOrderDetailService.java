package com.tha103.artion.merchOrderDetail.model;

import java.util.List;

import com.tha103.artion.merchOrder.model.MerchOrderVO;

public class MerchOrderDetailService {
	private MerchOrderDetailDAO_interface dao;

	public MerchOrderDetailService() {
		dao = new MerchOrderDetailDAO();
	}

	public MerchOrderDetailVO insertMerchrderdetail(MerchOrderVO merchorder, MerchVO merch,
			Integer merOrderDetailQuantity, Integer merOrderDetailPrice) {

		MerchOrderDetailVO merchorderdetailVO = new MerchOrderDetailVO();

		merchorderdetailVO.setMerchorder(merchorder);
		merchorderdetailVO.setMerch(merch);
		merchorderdetailVO.setMerOrderDetailQuantity(merOrderDetailQuantity);
		merchorderdetailVO.setMerOrderDetailPrice(merOrderDetailPrice);

		dao.insert(merchorderdetailVO);

		return merchorderdetailVO;
	}

	public MerchOrderDetailVO updateMerchrderdetail(MerchOrderVO merchorder, MerchVO merch,
			Integer merOrderDetailQuantity, Integer merOrderDetailPrice) {

		MerchOrderDetailVO merchorderdetailVO = new MerchOrderDetailVO();

		merchorderdetailVO.setMerchorder(merchorder);
		merchorderdetailVO.setMerch(merch);
		merchorderdetailVO.setMerOrderDetailQuantity(merOrderDetailQuantity);
		merchorderdetailVO.setMerOrderDetailPrice(merOrderDetailPrice);

		dao.insert(merchorderdetailVO);

		return merchorderdetailVO;
	}

	public void deleteMerchrderdetail(Integer merchOrdDetailId) {
		dao.delete(merchOrdDetailId);
	}

	public MerchOrderDetailVO getOneMerchrderdetail(Integer merchOrdDetailId) {
		return dao.findByPK(merchOrdDetailId);
	}

	public List<MerchOrderDetailVO> getAll() {
		return dao.getAll();
	}

}
