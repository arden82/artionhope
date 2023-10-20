package com.tha103.artion.activity.model;

import java.util.List;

import com.tha103.artion.seller.model.SellerVO;

public interface ActivityDAO_interface {
	// 此介面定義對資料庫的相關存取抽象方法
	  public int insert(ActivityVO activityVO);
      public int update(ActivityVO activityVO);
      public ActivityVO findByPK(Integer actId);
      public List<ActivityVO> getAll();
//      public List<ActivityVO> getExhAct();
//      public List<ActivityVO> getMarAct();
//      public List<ActivityVO> getPerAct();
      public List<ActivityVO> getActType(String type);
}