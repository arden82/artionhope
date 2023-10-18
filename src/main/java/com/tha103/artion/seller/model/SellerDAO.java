package com.tha103.artion.seller.model;

import java.util.List;

public interface SellerDAO {
	int add(SellerVO sellerVO);
	int update(SellerVO sellerVO);
	SellerVO findByPK(Integer selId);
	List<SellerVO> getAll();
	boolean checkUser(String account, String password);
}
