package com.tha103.artion.activity.model;

import java.util.List;

public interface ActivityDAO_interface {
	// 此介面定義對資料庫的相關存取抽象方法
	int add(ActivityVO activity);
	int update(ActivityVO activity);
	ActivityVO findByPK(Integer act_id);
	List<ActivityVO> getAll();
}