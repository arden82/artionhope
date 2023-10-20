package com.tha103.artion.ticketOrderDetail.model;

import java.util.List;

public interface TicketOrderDetailDAO_interface {

	int insert(TicketOrderDetailVO ticketorderetailVO);

	int update(TicketOrderDetailVO ticketorderetailVO);

	int delete(Integer id);

	TicketOrderDetailVO getById(Integer id);

	List<TicketOrderDetailVO> getAll();

}
