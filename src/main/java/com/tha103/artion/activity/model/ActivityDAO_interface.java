package com.tha103.artion.activity.model;

import java.util.List;

import com.tha103.artion.seller.model.SellerVO;

public interface ActivityDAO_interface {
	// 此介面定義對資料庫的相關存取抽象方法
	  public int insert(ActivityVO activityVO);
      public int update(ActivityVO activityVO);
      public ActivityVO findByPK(Integer act_id);
      public List<ActivityVO> getAll();//皓瑄
      public List<ActivityVO> getActType(String type);//皓瑄
      List<ActivityVO> getActivitiesBySellerId(Integer selId);
      public void delete(Integer actId);
}