package com.tha103.artion.merchOrderDetail.model;

import java.util.List;

public interface MerchOrderDetailDAO_interface {
	int insert(MerchOrderDetailVO merchorderdetailVO);

	int update(MerchOrderDetailVO merchorderdetailVO);

	int delete(Integer id);

	MerchOrderDetailVO getById(Integer merchOrdDetailId);

	List<MerchOrderDetailVO> getAll();

//	List<MerchOrderDetailVO> getByCompositeQuery(Map<String, String> map);
//
//	List<MerchOrderDetailVO> getAll(int currentPage);
//
//	long getTotal();
}
