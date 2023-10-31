package com.tha103.artion.ticketOrder.model;

import java.util.List;



public interface TicketOrderService_Interface {
	
	// 新增
	public int addTicketOrder(TicketOrderVO ticketOrderVO);
	
	
	// 更新
	public int updateTicketOrder(TicketOrderVO ticketOrderVO);
	
		
	// 刪除
	public int deleteTicketorder(Integer ticketOrdId);
	
	
	// 取得PK
	public TicketOrderVO getTicketOrderById(Integer ticketOrdId);
	
	// 取得所有
	public List<TicketOrderVO> getAllTicketOrders();
	
	
	
}
