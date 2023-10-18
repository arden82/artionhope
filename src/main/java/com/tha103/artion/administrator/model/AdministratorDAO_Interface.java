package com.tha103.artion.administrator.model;

import java.util.List;
import java.util.Map;

public interface AdministratorDAO_Interface {

	public int insert(AdministratorVO admin);
	
	public int update(AdministratorVO admin);
	
	public int delete(Integer admId);
	
	public AdministratorVO getById(Integer admId);
	
	public List<AdministratorVO> getAll();
	
	
	
}
