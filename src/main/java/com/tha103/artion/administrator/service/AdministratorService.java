package com.tha103.artion.administrator.service;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.administrator.model.AdministratorDAO;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.util.HibernateUtil;

public class AdministratorService implements AdministratorService_Interface{
	
	private AdministratorDAO dao;
	
	
	
public AdministratorService() {
		
		dao = new AdministratorDAO(HibernateUtil.getSessionFactory());
	}



@Override
public AdministratorVO addAdmin(AdministratorVO admin) {
	// TODO Auto-generated method stub
	return null;
}



@Override
public AdministratorVO updateAdmin(AdministratorVO admin) {
	// TODO Auto-generated method stub
	return null;
}



@Override
public void deleteAdmin(Integer admId) {
	// TODO Auto-generated method stub
	
}



@Override
public AdministratorVO getAdminByAdmId(Integer admId) {
	// TODO Auto-generated method stub
	return null;
}



@Override
public List<AdministratorVO> getAllAdmins() {
	// TODO Auto-generated method stub
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	try {
		session.beginTransaction();
		List<AdministratorVO> list = dao.getAll();
		session.getTransaction().commit();
		return list;
	} catch (Exception e) {
		session.getTransaction().rollback();
		e.printStackTrace();
		return null;
	}
}

	
	
}
