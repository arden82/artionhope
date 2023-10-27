package com.tha103.artion.ticketOrder.model;

import java.util.List;

public interface TicketOrderDAO_interface {
	int insert(TicketOrderVO ticketOrderVO);

	int update(TicketOrderVO ticketOrderVO);

	int delete(Integer id);

	TicketOrderVO getById(Integer id);

	List<TicketOrderVO> getAll();

	List<TicketOrderVO> getTicketOrderBySellerId(Integer selId);

//	List<TicketOrderVO> getByCompositeQuery(Map<String, String> map);
//
//	List<TicketOrderVO> getAll(int currentPage);
//
//	long getTotal();

	TicketOrderVO getTicketOrderDetailsByTicketOrdId(Integer ticketOrdId);

}
