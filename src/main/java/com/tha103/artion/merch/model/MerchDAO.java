package com.tha103.artion.merch.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class MerchDAO implements MerchDAO_Interface{

private SessionFactory factory;
	
	public MerchDAO(SessionFactory factory) {
		this.factory = factory;
		
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(MerchVO merch) {
		// TODO Auto-generated method stub
		return (Integer) getSession().save(merch);
	}

	@Override
	public int update(MerchVO merch) {
		// TODO Auto-generated method stub
		try {
			getSession().update(merch);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delete(Integer merchId) {
		// TODO Auto-generated method stub
		MerchVO merch = getSession().get(MerchVO.class,merchId);
		if (merch != null) {
			getSession().delete(merch);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}
	}

	@Override
	public MerchVO getById(Integer merchId) {
		// TODO Auto-generated method stub
		return getSession().get(MerchVO.class, merchId);
	}

	@Override
	public List<MerchVO> getAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from MerchVO", MerchVO.class).list();
	}
	
	
}
