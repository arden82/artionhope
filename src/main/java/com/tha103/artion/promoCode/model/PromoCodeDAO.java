package com.tha103.artion.promoCode.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class PromoCodeDAO implements PromoCodeDAO_Interface{

private SessionFactory factory;
	
	public PromoCodeDAO(SessionFactory factory) {
		this.factory = factory;
		
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(PromoCodeVO promoCode) {
		// TODO Auto-generated method stub
		return (Integer) getSession().save(promoCode);
	}

	@Override
	public int update(PromoCodeVO promoCode) {
		// TODO Auto-generated method stub
		try {
			getSession().update(promoCode);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delete(Integer proCodeId) {
		// TODO Auto-generated method stub
		PromoCodeVO promoCode = getSession().get(PromoCodeVO.class,proCodeId);
		if (promoCode != null) {
			getSession().delete(promoCode);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}
	}

	@Override
	public PromoCodeVO getById(Integer proCodeId) {
		// TODO Auto-generated method stub
		return getSession().get(PromoCodeVO.class, proCodeId);
	}

	@Override
	public List<PromoCodeVO> getAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from PromoCodeVO", PromoCodeVO.class).list();
	}
	
	
}
