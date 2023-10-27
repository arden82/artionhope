package com.tha103.artion.promoCode.service;

import java.util.List;

import com.tha103.artion.promoCode.model.PromoCodeVO;

public interface PromoCodeService_Interface {

	public int addPromoCode(PromoCodeVO promoCode, int memLevLevel, int admId);

	int updatePromoCode(PromoCodeVO promoCode, int memLevLevel, int admId);

	void deletePromoCode(Integer proCodeId);

	PromoCodeVO getByPromoCodeId(Integer proCodeId);

	List<PromoCodeVO> getAllPromoCodes();

}
