package com.tha103.artion.ticketOrderDetail.model;

import java.util.List;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.ticketOrder.model.TicketOrderDAO;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;

public class TicketOrderDetailService implements TicketOrderDetailService_Interface{
	
	private TicketOrderDetailDAO dao;

	public TicketOrderDetailService() {

		dao = new TicketOrderDetailDAO();
	}

	@Override
	public int addTicketOrderDet(TicketOrderDetailVO ticketorderetailVO) {
		return dao.insert(ticketorderetailVO);
	}

	@Override
	public int updateTicketOrderDet(TicketOrderDetailVO ticketorderetailVO) {
		return dao.update(ticketorderetailVO);
	}

	@Override
	public int deleteTicketorderDet(Integer id) {
		return dao.delete(id);
	}

	@Override
	public TicketOrderDetailVO getTicketOrderDetById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<TicketOrderDetailVO> getAllTicketOrderDets() {
		List<TicketOrderDetailVO> list = dao.getAll();
		return list;
	}
	
	
	

	public TicketOrderDetailVO ticketbyticketorder(Integer ticketOrderVO) {
		TicketOrderDetailVO ticketOrderDetailVO = dao.getTicketorder(ticketOrderVO);
		if (ticketOrderDetailVO != null) {
			return ticketOrderDetailVO;
		}
		return null;
	}
	public List<TicketOrderDetailVO> getTicketordelist(Integer ticketOrdId) {
		return dao.getTicketordelist(ticketOrdId);
	}
}