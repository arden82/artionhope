package com.tha103.artion.ticketOrder.model;

import java.util.List;




public class TicketOrderService implements TicketOrderService_Interface{

	
	private TicketOrderDAO dao;

	public TicketOrderService() {

		dao = new TicketOrderDAO();
	}

	@Override
	public int addTicketOrder(TicketOrderVO ticketOrderVO) {
		return dao.insert(ticketOrderVO);
	}

	@Override
	public int updateTicketOrder(TicketOrderVO ticketOrderVO) {
		return dao.update(ticketOrderVO);
	}

	@Override
	public int deleteTicketorder(Integer ticketOrdId) {
		return dao.delete(ticketOrdId);
		
	}

	@Override
	public TicketOrderVO getTicketOrderById(Integer ticketOrdId) {
		
		return dao.getById(ticketOrdId);
	}

	@Override
	public List<TicketOrderVO> getAllTicketOrders() {
		List<TicketOrderVO> list = dao.getAll();
		return list;
	}
	
	
	

}
