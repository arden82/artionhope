package com.tha103.artion.administrator.service;

import java.util.List;

import org.hibernate.Session;

import com.tha103.artion.administrator.model.AdministratorDAO;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.util.HibernateUtil;

public class AdministratorService implements AdministratorService_Interface {

	private AdministratorDAO dao;

	public AdministratorService() {

		dao = new AdministratorDAO();
	}

	@Override
	public int addAdmin(AdministratorVO admin) {
		return dao.insert(admin);
	}

	@Override
	public int updateAdmin(AdministratorVO admin) {
		return dao.update(admin);
	}

	@Override
	public void deleteAdmin(Integer admId) {
		// TODO Auto-generated method stub

	}

	@Override
	public AdministratorVO getAdminByAdmId(Integer admId) {
		return dao.getById(admId);
	}

	@Override
	public List<AdministratorVO> getAllAdmins() {
		// TODO Auto-generated method stub
		List<AdministratorVO> list = dao.getAll();
		return list;
	}

	public static void main(String[] args) {
		AdministratorService svc = new AdministratorService();
		System.out.println(svc.getAllAdmins());
	}

}
