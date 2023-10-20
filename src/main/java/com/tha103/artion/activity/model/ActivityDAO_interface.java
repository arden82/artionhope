package com.tha103.artion.activity.model;

import java.util.List;

import com.tha103.artion.seller.model.SellerVO;

public interface ActivityDAO_interface {
	// 此介面定義對資料庫的相關存取抽象方法
	  public void insert(ActivityVO activityVO);
      public void update(ActivityVO activityVO);
      public ActivityVO findByPrimaryKey(Integer actId);
      public List<ActivityVO> getAll();
}