package com.tha103.artion.promoCode.service;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.promoCode.model.PromoCodeDAO;
import com.tha103.artion.promoCode.model.PromoCodeVO;
import com.tha103.artion.util.HibernateUtil;

public class PromoCodeService implements PromoCodeService_Interface{
	
	private PromoCodeDAO dao;
	
	public PromoCodeService() {
		dao = new PromoCodeDAO();
	}

	@Override
	public int addPromoCode(PromoCodeVO promoCode) {
		// TODO Auto-generated method stub
		return dao.insert(promoCode);
	}

	@Override
	public int updatePromoCode(PromoCodeVO promoCode) {
		// TODO Auto-generated method stub
		return dao.update(promoCode);
	}

	@Override
	public void deletePromoCode(Integer proCodeId) {
		dao.delete(proCodeId);
		
	}

	@Override
	public PromoCodeVO getByPromoCodeId(Integer proCodeId) {
		// TODO Auto-generated method stub
		return dao.getById(proCodeId);
	}

	@Override
	public List<PromoCodeVO> getAllPromoCodes() {
		List<PromoCodeVO> list = dao.getAll();
		return list;
	}
	
}
