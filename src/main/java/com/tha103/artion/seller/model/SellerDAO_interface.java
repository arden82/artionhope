package com.tha103.artion.seller.model;

import java.util.List;

import com.tha103.artion.seller.model.*;

public interface SellerDAO_interface {

	  public void insert(SellerVO seller);
      public void update(SellerVO seller);
      public SellerVO findByPrimaryKey(Integer selId);
      public List<SellerVO> getAll();
		
	}
