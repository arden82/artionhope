package com.tha103.artion.ticketOrder.model;

import java.util.List;

import com.tha103.artion.util.HibernateUtil;

public class TicketOrderServiceImpl implements TicketOrderService {

	// 一個 service 實體對應一個 dao 實體
	private TicketOrderDAO dao;

	public TicketOrderServiceImpl() {
		dao = new TicketOrderDAO(HibernateUtil.getSessionFactory());
	}

	@Override
	public TicketOrderVO addTicketorder(TicketOrderVO ticketorderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketOrderVO updateTicketorder(TicketOrderVO ticketorderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTicketorder(Integer ticketOrdId) {
		// TODO Auto-generated method stub

	}

	@Override
	public TicketOrderVO getTicketorderByticketOrdId(Integer ticketOrdId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TicketOrderVO> getAllTicketorders(int currentPage) {
		return dao.getAll(currentPage);
	}

}
