package com.tha103.artion.map.dao.impl;

import java.util.List;

import com.tha103.artion.map.dao.ActivityDao;
import com.tha103.artion.map.entity.Activity;
import com.tha103.artion.util.HibernateUtil;

public class ActivityDaoImpl implements ActivityDao {

	@Override
	public List<Activity> selectAll() {
		var session = HibernateUtil.getSessionFactory().getCurrentSession();
		return session
				.createQuery("FROM Activity", Activity.class)
				.getResultList(); 
	}
}
