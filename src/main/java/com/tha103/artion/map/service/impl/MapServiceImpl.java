package com.tha103.artion.map.service.impl;

import java.util.List;

import com.tha103.artion.map.dao.ActivityDao;
import com.tha103.artion.map.dao.impl.ActivityDaoImpl;
import com.tha103.artion.map.entity.Activity;
import com.tha103.artion.map.service.MapService;

public class MapServiceImpl implements MapService {
	private ActivityDao dao;
	
	public MapServiceImpl() {
		dao = new ActivityDaoImpl();
	}

	@Override
	public List<Activity> findAllActivities() {
		return dao.selectAll();
	}
}
