package com.tha103.artion.promoCode.service;

import java.util.List;

import com.tha103.artion.promoCode.model.PromoCodeDAO;
import com.tha103.artion.promoCode.model.PromoCodeVO;
import com.tha103.artion.util.HibernateUtil;

public class PromoCodeService implements PromoCodeService_Interface {

	private PromoCodeDAO dao;

	public PromoCodeService() {
		dao = new PromoCodeDAO(HibernateUtil.getSessionFactory());
	}

	@Override
	public int addPromoCode(PromoCodeVO promoCode, int memLevLevel, int admId) {
		// TODO Auto-generated method stub
		return dao.add(promoCode, memLevLevel, admId);
	}

	@Override
	public int updatePromoCode(PromoCodeVO promoCode, int memLevLevel, int admId) {
		// TODO Auto-generated method stub
		return dao.update(promoCode, memLevLevel, admId);
	}

//	 暫時不用此功能
	@Override
	public void deletePromoCode(Integer proCodeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public PromoCodeVO getByPromoCodeId(Integer proCodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PromoCodeVO> getAllPromoCodes() {
		// TODO Auto-generated method stub
		List<PromoCodeVO> list = dao.getAll();
		return list;
	}

}
