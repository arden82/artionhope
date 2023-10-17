package com.tha103.artion.merchOrderDetail.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MerchOrderDetailDAO {
	// SessionFactory 為 thread-safe，可宣告為屬性讓請求執行緒們共用
	private SessionFactory factory;

	public MerchOrderDetailDAO(SessionFactory factory) {
		this.factory = factory;
	}

	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}
}
