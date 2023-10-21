package com.tha103.artion.merchOrderDetail.model;

import java.util.List;

import com.tha103.artion.merch.model.MerchVO;
import com.tha103.artion.merchOrder.model.MerchOrderVO;

public class MerchOrderDetailService {
	private MerchOrderDetailDAO_interface dao;

	public MerchOrderDetailService() {
		dao = new MerchOrderDetailDAO();
	}

	public MerchOrderDetailVO insertMerchorderdetail(MerchOrderVO merchorder, MerchVO merch,
			Integer merOrderDetailQuantity, Integer merOrderDetailPrice) {

		MerchOrderDetailVO merchorderdetailVO = new MerchOrderDetailVO();

		merchorderdetailVO.setMerchOrder(merchorder);
		merchorderdetailVO.setMerch(merch);
		merchorderdetailVO.setMerOrderDetailQuantity(merOrderDetailQuantity);
		merchorderdetailVO.setMerOrderDetailPrice(merOrderDetailPrice);

		dao.insert(merchorderdetailVO);

		return merchorderdetailVO;
	}

	public MerchOrderDetailVO updateMerchrderdetail(Integer merchOrdDetailId, MerchOrderVO merchorder, MerchVO merch,
			Integer merOrderDetailQuantity, Integer merOrderDetailPrice) {

		MerchOrderDetailVO merchorderdetailVO = new MerchOrderDetailVO();

		merchorderdetailVO.setMerchOrder(merchorder);
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
		return dao.getById(merchOrdDetailId);
	}

	public List<MerchOrderDetailVO> getAll() {
		return dao.getAll();
	}

}
