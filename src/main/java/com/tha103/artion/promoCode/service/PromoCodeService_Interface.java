package com.tha103.artion.promoCode.service;

import java.util.List;

import com.tha103.artion.promoCode.model.PromoCodeVO;


public interface PromoCodeService_Interface {
	
	PromoCodeVO addPromoCode(PromoCodeVO promoCode);
	
	PromoCodeVO updatePromoCode(PromoCodeVO promoCode);
	
	void deletePromoCode(Integer proCodeId);
	
	PromoCodeVO getByPromoCodeId(Integer proCodeId);
	
	List<PromoCodeVO> getAllPromoCodes();

}
