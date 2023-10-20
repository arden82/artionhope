package com.tha103.artion.ticketOrderDetail.model;

import java.util.List;

import com.tha103.artion.ticketOrder.model.TicketOrderVO;

public class TicketOrderDetailService {
	private TicketOrderDetailDAO_interface dao;

	public TicketOrderDetailService() {
		dao = new TicketOrderDetailDAO();
	}

	public TicketOrderDetailVO insertTicketorderdetail(TicketOrderVO ticketorder, Integer ticOrdDetQuantity,
			Double ticOrdDetPrice, ActivityVO activity) {

		TicketOrderDetailVO ticketorderetailVO = new TicketOrderDetailVO();

		ticketorderetailVO.setTicketorder(ticketorder);
		ticketorderetailVO.setTicOrdDetQuantity(ticOrdDetQuantity);
		ticketorderetailVO.setTicOrdDetPrice(ticOrdDetPrice);
		ticketorderetailVO.setActivity(activity);

		dao.insert(ticketorderetailVO);

		return ticketorderetailVO;
	}

	public TicketOrderDetailVO updateTicketorderdetail(TicketOrderVO ticketorder, Integer ticOrdDetQuantity,
			Double ticOrdDetPrice, ActivityVO activity) {

		TicketOrderDetailVO ticketorderetailVO = new TicketOrderDetailVO();

		ticketorderetailVO.setTicketorder(ticketorder);
		ticketorderetailVO.setTicOrdDetQuantity(ticOrdDetQuantity);
		ticketorderetailVO.setTicOrdDetPrice(ticOrdDetPrice);
		ticketorderetailVO.setActivity(activity);

		dao.insert(ticketorderetailVO);

		return ticketorderetailVO;
	}

	public void deleteTicketorderdetail(Integer ticOrdDetId) {
		dao.delete(ticOrdDetId);
	}

	public TicketOrderDetailVO getById(Integer ticOrdDetId) {
		return dao.getById(ticOrdDetId);
	}

	public List<TicketOrderDetailVO> getAll() {
		return dao.getAll();
	}

}