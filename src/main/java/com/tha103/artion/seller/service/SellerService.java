package com.tha103.artion.seller.service;

import com.tha103.artion.seller.model.SellerVO;

public interface SellerService {
	
	SellerVO addSeller(SellerVO sellerVO);
	
	SellerVO updateSeller(SellerVO sellerVO);
	
	void deleteSeller(Integer selId);

	SellerVO getOneSeller(Integer selId);
	
}

