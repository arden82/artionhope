package com.tha103.artion.administrator.service;

import java.util.List;

import com.tha103.artion.administrator.model.AdministratorVO;

public interface AdministratorService_Interface {
	AdministratorVO addAdmin(AdministratorVO admin);
	
	AdministratorVO updateAdmin(AdministratorVO admin);
	
	void deleteAdmin(Integer admId);
	
	AdministratorVO getAdminByAdmId(Integer admId);
	
	List<AdministratorVO> getAllAdmins();
	

}
