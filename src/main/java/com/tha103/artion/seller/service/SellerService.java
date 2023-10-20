package com.tha103.artion.seller.service;

import java.sql.Timestamp;
import java.util.List;

import com.tha103.artion.seller.model.*;


public class SellerService {

	private SellerDAO_interface dao;

	public SellerService() {
		dao = new SellerDAO();
	}

	public SellerVO addSeller(String sel_account, String sel_password, String sel_name, 
			String sel_phone, String sel_address, String sel_url, String sel_facebook, String sel_contactPerson,
			String sel_introduction, String sel_bankCode, String sel_bankNumber, String sel_bankName, 
			String sel_remark, String sel_title, String sel_principal, String sel_uniformNumbers, 
			String sel_registeredAddress, Timestamp sel_registerdTime, 
			Timestamp sel_lastModifiedTime, Integer sel_status) {

		SellerVO sellerVO = new SellerVO();

		sellerVO.setSelAccount(sel_account);
		sellerVO.setSelPassword(sel_password);
		sellerVO.setSelName(sel_name);
		sellerVO.setSelPhone(sel_phone);
		sellerVO.setSelAddress(sel_address);
		sellerVO.setSelUrl(sel_url);
		sellerVO.setSelFacebook(sel_facebook);
		sellerVO.setSelContactPerson(sel_contactPerson);
		sellerVO.setSelIntroduction(sel_introduction);
		sellerVO.setSelBankCode(sel_bankCode);
		sellerVO.setSelBankNumber(sel_bankNumber);
		sellerVO.setSelBankName(sel_bankName);
		sellerVO.setSelRemark(sel_remark);
		sellerVO.setSelTitle(sel_title);
		sellerVO.setSelPrincipal(sel_principal);
		sellerVO.setSelUniformNumbers(sel_uniformNumbers);
		sellerVO.setSelRegisteredAddress(sel_registeredAddress);
		sellerVO.setSelRegisterdTime(sel_registerdTime);
		sellerVO.setSelLastModifiedTime(sel_lastModifiedTime);
		sellerVO.setSelStatus(sel_status);

		return sellerVO;
	}

	public SellerVO updateSeller(Integer sel_id, String sel_account, String sel_password, String sel_name, 
			String sel_phone, String sel_address, String sel_url, String sel_facebook, String sel_contactPerson,
			String sel_introduction, String sel_bankCode, String sel_bankNumber, String sel_bankName, 
			String sel_remark, String sel_title, String sel_principal, String sel_uniformNumbers, String sel_registeredAddress, 
		byte[] sel_profilePicture, Timestamp sel_registerdTime, Timestamp sel_lastModifiedTime, Integer sel_status) {

		SellerVO sellerVO = new SellerVO();

		sellerVO.setSelId(sel_id);
		sellerVO.setSelAccount(sel_account);
		sellerVO.setSelPassword(sel_password);
		sellerVO.setSelName(sel_name);
		sellerVO.setSelPhone(sel_phone);
		sellerVO.setSelAddress(sel_address);
		sellerVO.setSelUrl(sel_url);
		sellerVO.setSelFacebook(sel_facebook);
		sellerVO.setSelContactPerson(sel_contactPerson);
		sellerVO.setSelIntroduction(sel_introduction);
		sellerVO.setSelBankCode(sel_bankCode);
		sellerVO.setSelBankNumber(sel_bankNumber);
		sellerVO.setSelBankName(sel_bankName);
		sellerVO.setSelRemark(sel_remark);
		sellerVO.setSelTitle(sel_title);
		sellerVO.setSelPrincipal(sel_principal);
		sellerVO.setSelUniformNumbers(sel_uniformNumbers);
		sellerVO.setSelRegisteredAddress(sel_registeredAddress);
		sellerVO.setSelProfilePicture(sel_profilePicture);
		sellerVO.setSelRegisterdTime(sel_registerdTime);
		sellerVO.setSelLastModifiedTime(sel_lastModifiedTime);
		sellerVO.setSelStatus(sel_status);
		dao.update(sellerVO);

		return sellerVO;
	}

	public SellerVO getOneSeller(Integer SelId) {
		return dao.findByPrimaryKey(SelId);
	}

	public List<SellerVO> getAll() {
		return dao.getAll();
	}
}
