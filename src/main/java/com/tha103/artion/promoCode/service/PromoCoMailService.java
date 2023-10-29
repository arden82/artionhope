package com.tha103.artion.promoCode.service;

import java.util.List;

import com.tha103.artion.promoCode.model.PromoCodeEmailDAO;
import com.tha103.artion.promoCode.util.PromocoEmailutil;

public class PromoCoMailService {

	private PromocoEmailutil memberEmailutil;
	private PromoCodeEmailDAO promoCodeEmailDAO;

	public PromoCoMailService() {
		this.memberEmailutil = new PromocoEmailutil();
		this.promoCodeEmailDAO = new PromoCodeEmailDAO();
	}

	// 方法1: 发送重置邮件
	public void sendPromocodeEmail(String userEmail, String proCodeCode, String url) {
		memberEmailutil.sendRestMail(userEmail, proCodeCode, url);
	}

	// 方法2: 获取所有会员的邮箱
	public List<String> getAllMemberEmails() {
		return promoCodeEmailDAO.selectAllMemberEmail();
	}
}
