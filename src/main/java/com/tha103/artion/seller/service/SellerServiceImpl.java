package com.tha103.artion.seller.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tha103.artion.seller.model.SellerDAO;
import com.tha103.artion.seller.model.SellerDAOImpl;
import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.seller.service.SellerService;

import util.HibernateUtil;

public class SellerServiceImpl implements SellerService{

	// 一個 service 實體對應一個 dao 實體

	    private SellerDAO dao;

	    public SellerServiceImpl() {
	        dao = new SellerDAOImpl(HibernateUtil.getSessionFactory());
	    }

	    @Override
	    public SellerVO addSeller(SellerVO sellerVO) {
	    	return null;
	    }

	    @Override
	    public SellerVO updateSeller(SellerVO sellerVO) {
	    	return null;
	    }

	    @Override
	    public void deleteSeller(Integer selId) {
	    	
	    }

	    @Override
	    public SellerVO getOneSeller(Integer selId) {
	    	return null;
	    }

		public SellerVO updateSeller(Integer sel_id, String sel_account, String sel_password, String sel_name,
				String sel_phone, String sel_address, String sel_url, String sel_facebook, String sel_contactPerson,
				String sel_introduction, String sel_bankCode, String sel_bankNumber, String sel_bankName,
				String sel_remark, String sel_title, String sel_principal, String sel_uniformNumbers,
				String sel_registeredAddress, byte[] profilePhotoByte, Timestamp sel_registerdTime,
				Timestamp sel_lastModifiedTime, Integer sel_status) {
			// TODO Auto-generated method stub
			return null;
		}

		public SellerVO addSeller(String sel_account, String sel_password, String sel_name, String sel_phone,
				String sel_address, String sel_url, String sel_facebook, String sel_contactPerson,
				String sel_introduction, String sel_bankCode, String sel_bankNumber, String sel_bankName,
				String sel_remark, String sel_title, String sel_principal, String sel_uniformNumbers,
				String sel_registeredAddress,  byte[] sel_profilePicture, Timestamp sel_registeredTime,
				Timestamp sel_lastModifiedTime, Integer sel_status) {
			// TODO Auto-generated method stub
			return null;
		}
	}
