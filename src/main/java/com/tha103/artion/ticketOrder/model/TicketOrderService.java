package com.tha103.artion.ticketOrder.model;

import java.util.List;

import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailVO;

public class TicketOrderService {
	private TicketOrderDAO_interface dao;

	public TicketOrderService() {
		dao = new TicketOrderDAO();
	}

	public TicketOrderVO insertTicketorder(MemberVO member, Integer ticketOrdStatus, Double ticketOrdTotalPrice,
			Double ticketOrdProCodeAmount, Double ticketOrdActuallyAmount, Integer ticketOrdPayStatus,
			MyPromoCodeVO mypromocode, String ticketOrdAddress, SellerVO seller, String ticketOrdCode,
			TicketOrderDetailVO ticOrdDets) {

		TicketOrderVO ticketOrderVO = new TicketOrderVO();

		ticketOrderVO.setMember(member);
		ticketOrderVO.setTicketOrdStatus(ticketOrdStatus);
		ticketOrderVO.setTicketOrdTotalPrice(ticketOrdTotalPrice);
		ticketOrderVO.setTicketOrdProCodeAmount(ticketOrdProCodeAmount);
		ticketOrderVO.setTicketOrdActuallyAmount(ticketOrdActuallyAmount);
		ticketOrderVO.setTicketOrdPayStatus(ticketOrdPayStatus);
		ticketOrderVO.setMypromocode(mypromocode);
		ticketOrderVO.setTicketOrdAddress(ticketOrdAddress);
		ticketOrderVO.setSeller(seller);
		ticketOrderVO.setTicketOrdCode(ticketOrdCode);
		ticketOrderVO.setTicOrdDets(ticOrdDets);

		dao.insert(ticketOrderVO);

		return ticketOrderVO;
	}

	public TicketOrderVO updateTicketorder(MemberVO member, Integer ticketOrdStatus, Double ticketOrdTotalPrice,
			Double ticketOrdProCodeAmount, Double ticketOrdActuallyAmount, Integer ticketOrdPayStatus,
			MyPromoCodeVO mypromocode, String ticketOrdAddress, SellerVO seller, String ticketOrdCode,
			TicketOrderDetailVO ticOrdDets) {

		TicketOrderVO ticketOrderVO = new TicketOrderVO();

		ticketOrderVO.setMember(member);
		ticketOrderVO.setTicketOrdStatus(ticketOrdStatus);
		ticketOrderVO.setTicketOrdTotalPrice(ticketOrdTotalPrice);
		ticketOrderVO.setTicketOrdProCodeAmount(ticketOrdProCodeAmount);
		ticketOrderVO.setTicketOrdActuallyAmount(ticketOrdActuallyAmount);
		ticketOrderVO.setTicketOrdPayStatus(ticketOrdPayStatus);
		ticketOrderVO.setMypromocode(mypromocode);
		ticketOrderVO.setTicketOrdAddress(ticketOrdAddress);
		ticketOrderVO.setSeller(seller);
		ticketOrderVO.setTicketOrdCode(ticketOrdCode);
		ticketOrderVO.setTicOrdDets(ticOrdDets);

		dao.insert(ticketOrderVO);

		return ticketOrderVO;
	}

	public void deleteTicketorder(Integer ticketOrdId) {
		dao.delete(ticketOrdId);
	}

	public TicketOrderVO getOneTicketorder(Integer ticketOrdId) {
		return dao.getById(ticketOrdId);
	}

	public List<TicketOrderVO> getAll() {
		return dao.getAll();
	}

}
