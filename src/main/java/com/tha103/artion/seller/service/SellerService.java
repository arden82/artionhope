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
			String sel_registeredAddress) {

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
		sellerVO.setSelRegisterdTime(new Timestamp(System.currentTimeMillis())); 
        sellerVO.setSelLastModifiedTime(new Timestamp(System.currentTimeMillis()));
		sellerVO.setSelStatus(1);
		dao.insert(sellerVO);
		return sellerVO;
	}

	public SellerVO updateSeller(Integer sel_id, String sel_account, String sel_password, String sel_name, 
			String sel_phone, String sel_address, String sel_url, String sel_facebook, String sel_contactPerson,
			String sel_introduction, String sel_bankCode, String sel_bankNumber, String sel_bankName, 
			String sel_remark, String sel_title, String sel_principal, String sel_uniformNumbers, String sel_registeredAddress 
		    ) {

		   SellerVO sellerVO = dao.getSellerByAccount(sel_account); // 獲取現有的賣家資料

		    if (sellerVO != null) {
		        // 更新賣家的其他資料
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

		        // 更新最後修改時間
		        sellerVO.setSelLastModifiedTime(new Timestamp(System.currentTimeMillis()));
		        // 保留現有的sel_status值
		        Integer existingStatus = sellerVO.getSelStatus();
		        // 恢復現有的sel_status值
		        sellerVO.setSelStatus(existingStatus);

		        dao.update(sellerVO);
		    }

		    return sellerVO;
		}

	public SellerVO getOneSeller(Integer SelId) {
		return dao.findByPrimaryKey(SelId);
	}

	public List<SellerVO> getAll() {
		return dao.getAll();
	}
	
	public SellerVO getSellerByAccount(String account) {
	    SellerVO sellerVO = dao.getSellerByAccount(account);
	    return sellerVO; // 返回整个 SellerVO 对象，包括所有数据
	}
	

//	// 服务层方法
//	 public SellerVO getSellerWithTicketOrders(int sellerId) {
//	        // 实现获取 SellerVO 及相关 TicketOrders 的逻辑
//	        SellerVO sellerVO = getSellerById(sellerId);
//	        sellerVO.setTicketOrders(getTicketOrdersForSeller(sellerId));
//
//	        return sellerVO;
//	    }
//	public SellerVO getSellerById(String Id) {
//	    SellerVO sellerVO = dao.getSellerById(Id);
//	    return sellerVO; // 返回整个 SellerVO 对象，包括所有数据
//	}
//	
//	    private List<TicketOrder> getTicketOrdersForSeller(int sellerId) {
//	        // 实现获取与卖家相关的 TicketOrder 列表的逻辑
//	        // ...
//	    }
//	}


}
