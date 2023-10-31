package com.tha103.artion.ticketOrderDetail.model;

import java.util.List;

public interface TicketOrderDetailService_Interface {
	
	int addTicketOrderDet(TicketOrderDetailVO ticketorderetailVO);

	int updateTicketOrderDet(TicketOrderDetailVO ticketorderetailVO);

	int deleteTicketorderDet(Integer id);

	TicketOrderDetailVO getTicketOrderDetById(Integer id);

	List<TicketOrderDetailVO> getAllTicketOrderDets();

}
