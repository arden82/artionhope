package com.tha103.artion.ticketOrder.model;

import java.util.List;

public interface TicketOrderService {

	TicketOrderVO addTicketorder(TicketOrderVO ticketorderVO);

	TicketOrderVO updateTicketorder(TicketOrderVO ticketorderVO);

	void deleteTicketorder(Integer ticketOrdId);

	TicketOrderVO getTicketorderByticketOrdId(Integer ticketOrdId);

	List<TicketOrderVO> getAllTicketorders(int currentPage);

//	int getPageTotal();
//
//	List<TicketOrderVO> getEmpsByCompositeQuery(Map<String, String[]> map);
}
