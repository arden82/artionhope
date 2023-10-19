package com.tha103.artion.merchOrder.model;

import java.util.List;

public interface MerchOrderDAO_interface {
	int insert(MerchOrderVO merchorderVO);

	int update(MerchOrderVO merchorderVO);

	int delete(Integer id);

	MerchOrderVO getById(Integer id);

	List<MerchOrderVO> getAll();

//	List<MerchOrderVO> getByCompositeQuery(Map<String, String> map);
//
//	List<MerchOrderVO> getAll(int currentPage);
//
//	long getTotal();
}
