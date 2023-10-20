package com.tha103.artion.merchOrderDetail.model;

import java.util.List;

public interface MerchOrderDetailService {
	MerchOrderDetailVO insertMerchorderdetail(MerchOrderDetailVO merchorderdetailVO);

	MerchOrderDetailVO updateMerchorderdetail(MerchOrderDetailVO merchorderdetailVO);

	void deleteMerchorderdetail(Integer merchOrdDetailId);

	MerchOrderDetailVO getMerchOrdDetailIdByMerchOrdDetailId(Integer merchOrdDetailId);

	List<MerchOrderDetailVO> getAllMerchOrdDetailIds(int currentPage);

//	int getPageTotal();
//
//	List<MerchOrderDetailVO> getMerchOrdDetailIdsByCompositeQuery(Map<String, String[]> map);
}
