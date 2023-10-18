package com.tha103.artion.merch.model;

import java.util.List;


public interface MerchDAO_Interface {

	public int insert(MerchVO merch);
	
	public int update(MerchVO merch);
	
	public int delete(Integer merchId);
	
	public MerchVO getById(Integer merchId);
	
	public List<MerchVO> getAll();
}
