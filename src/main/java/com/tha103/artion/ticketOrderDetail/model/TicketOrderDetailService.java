package com.tha103.artion.ticketOrderDetail.model;

import java.util.List;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;

public class TicketOrderDetailService {
	private TicketOrderDetailDAO_interface dao;

	public TicketOrderDetailService() {
		dao = new TicketOrderDetailDAO();
	}

	public TicketOrderDetailVO insertTicketorderdetail(Integer ticOrdDetId, TicketOrderVO ticketorder,
			Integer ticOrdDetQuantity, Double ticOrdDetPrice, ActivityVO activity) {

		TicketOrderDetailVO ticketorderetailVO = new TicketOrderDetailVO();

		ticketorderetailVO.setTicketorder(ticketorder);
		ticketorderetailVO.setTicOrdDetQuantity(ticOrdDetQuantity);
		ticketorderetailVO.setTicOrdDetPrice(ticOrdDetPrice);
		ticketorderetailVO.setActivity(activity);

		dao.insert(ticketorderetailVO);

		return ticketorderetailVO;
	}

	public TicketOrderDetailVO updateTicketorderdetail(Integer Integer, Integer ticketorder, Integer ticOrdDetQuantity,
			Double ticOrdDetPrice, Integer activity) {

		TicketOrderDetailVO ticketorderetailVO = new TicketOrderDetailVO();

//		ticketorderetailVO.setTicketorder(ticketorder);
		ticketorderetailVO.setTicOrdDetQuantity(ticOrdDetQuantity);
		ticketorderetailVO.setTicOrdDetPrice(ticOrdDetPrice);
//		ticketorderetailVO.setActivity(activity);

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

	public TicketOrderDetailVO getOneTicketOrderByActId(Integer act_id) {
		// 修改dao方法，使其返回单一的TicketOrderVO，根据selId获取一个订单
		TicketOrderDetailVO ticketOrderDetailVO = dao.getOneTicketOrderByActId(act_id);
		if (ticketOrderDetailVO != null) {
			return ticketOrderDetailVO; // 返回第一个订单
		} else {
			return null; // 或者可以根据业务需求返回默认值或抛出异常
		}
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