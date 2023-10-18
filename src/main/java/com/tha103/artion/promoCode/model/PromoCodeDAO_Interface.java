package com.tha103.artion.promoCode.model;

import java.util.List;


public interface PromoCodeDAO_Interface {

	public int insert(PromoCodeVO promoCode);
	
	public int update(PromoCodeVO promoCode);
	
	public int delete(Integer proCodeId);
	
	public PromoCodeVO getById(Integer proCodeId);
	
	public List<PromoCodeVO> getAll();
}
