package com.tha103.artion.ticketOrder.model;

import java.util.List;

import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailVO;



public interface TicketOrderDAO_interface {
	
	
	public int insert(TicketOrderVO ticketOrderVO);
	
	public int update(TicketOrderVO ticketOrderVO);
	
	public int delete(Integer ticketOrdId);
	
	public TicketOrderVO getById(Integer ticketOrdId);
	
	public List<TicketOrderVO> getAll();
	
	TicketOrderVO getOrderByMemId(Integer memId);
	
	TicketOrderDetailVO getDetailByOrderId(Integer ticketOrdId);
	
	

}
