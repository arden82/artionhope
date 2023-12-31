package com.tha103.artion.merch.service;

import java.util.List;

import com.tha103.artion.merch.model.MerchVO;


public interface MerchService_Interface {
	
	int addMerch(MerchVO merch);
	
	int updateMerch(MerchVO merch);
	
	void deleteMerch(Integer merchId);
	
	MerchVO getMerchByMerchId(Integer merchId);
	
	List<MerchVO> getAllMerches();

}
