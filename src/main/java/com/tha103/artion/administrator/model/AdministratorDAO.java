package com.tha103.artion.administrator.model;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AdministratorDAO implements AdministratorDAO_Interface{
	
	private SessionFactory factory;
	
	public AdministratorDAO(SessionFactory factory) {
		this.factory = factory;
		
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	public int insert(AdministratorVO admin) {
		return (Integer) getSession().save(admin);
	}
	
	public int update(AdministratorVO admin) {
		try {
			getSession().update(admin);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}
	
	public int delete(Integer admId) {
		AdministratorVO admin = getSession().get(AdministratorVO.class,admId);
		if (admin != null) {
			getSession().delete(admin);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}
	}
	
	public AdministratorVO getById(Integer admId) {
		return getSession().get(AdministratorVO.class, admId);
	}
	
	public List<AdministratorVO> getAll(){
		return getSession().createQuery("from AdministratorVO", AdministratorVO.class).list();
	}
	
	

}
