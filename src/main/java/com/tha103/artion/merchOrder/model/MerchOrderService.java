package com.tha103.artion.merchOrder.model;

import java.util.List;
import java.util.Map;

public interface MerchOrderService {
	MerchOrderVO insertMerchorder(MerchOrderVO merchorderVO);

	MerchOrderVO updateMerchorder(MerchOrderVO merchorderVO);

	void deleteMerchorder(Integer merOrderId);

	MerchOrderVO getMerchorderBymerOrderId(Integer merOrderId);

	List<MerchOrderVO> getAllMerchorders(int currentPage);

	int getPageTotal();

	List<MerchOrderVO> getMerchordersByCompositeQuery(Map<String, String[]> map);

}
