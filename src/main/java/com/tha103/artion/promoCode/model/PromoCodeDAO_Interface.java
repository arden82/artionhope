package com.tha103.artion.promoCode.model;

import java.util.List;

public interface PromoCodeDAO_Interface {

	public int add(PromoCodeVO promoCode, int memLevLevel, int admId);

	public int update(PromoCodeVO promoCode, int memLevLevel, int admId);

	public int delete(Integer proCodeId);

	public PromoCodeVO getById(Integer proCodeId);

	public List<PromoCodeVO> getAll();
}
