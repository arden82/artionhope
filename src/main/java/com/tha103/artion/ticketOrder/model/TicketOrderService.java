package com.tha103.artion.ticketOrder.model;

import java.util.List;




public class TicketOrderService implements TicketOrderService_Interface{

	
	private TicketOrderDAO dao;

	public TicketOrderService() {

		dao = new TicketOrderDAO();
	}

	@Override
	public int addTicketOrder(TicketOrderVO ticketOrderVO) {
		return dao.insert(ticketOrderVO);
	}

	@Override
	public int updateTicketOrder(TicketOrderVO ticketOrderVO) {
		return dao.update(ticketOrderVO);
	}

	@Override
	public int deleteTicketorder(Integer ticketOrdId) {
		return dao.delete(ticketOrdId);
		
	}

	@Override
	public TicketOrderVO getTicketOrderById(Integer ticketOrdId) {
		
		return dao.getById(ticketOrdId);
	}

	@Override
	public List<TicketOrderVO> getAllTicketOrders() {
		List<TicketOrderVO> list = dao.getAll();
		return list;
	}


	// 利用selId取得對應的ticketOrderList
	public List<TicketOrderVO> getTicketOrderBySellerId(Integer sel_id) {
		List<TicketOrderVO> ticketOrderList = dao.getTicketOrderBySellerId(sel_id);
		return ticketOrderList;
	}

	public TicketOrderVO getTicketOrderDetailsByTicketOrdId(Integer ticketOrdId) {
		TicketOrderVO ticketOrder = dao.getTicketOrderDetailsByTicketOrdId(ticketOrdId);
		if (ticketOrder != null) {
			return ticketOrder;
		} else {
			return null;
		}
	}

//	public TicketOrderVO insertTicketorder(Integer membervo, Integer ticketOrdStatus, Double ticketOrdTotalPrice,
//			Double ticketOrdProCodeAmount, Double ticketOrdActuallyAmount, Integer ticketOrdPayStatus,
//			Integer mypromocodeNo, String ticketOrdAddress, Integer sellerVO, String ticketOrdCode) {
//
//		TicketOrderVO ticketOrderVO = new TicketOrderVO();
//
//		ticketOrderVO.setMember(memberVO);
//		ticketOrderVO.setTicketOrdStatus(ticketOrdStatus);
//		ticketOrderVO.setTicketOrdTotalPrice(ticketOrdTotalPrice);
//		ticketOrderVO.setTicketOrdProCodeAmount(ticketOrdProCodeAmount);
//		ticketOrderVO.setTicketOrdActuallyAmount(ticketOrdActuallyAmount);
//		ticketOrderVO.setTicketOrdPayStatus(ticketOrdPayStatus);
//		ticketOrderVO.setMypromocode(mypromocodeVO);
//		ticketOrderVO.setTicketOrdAddress(ticketOrdAddress);
//		ticketOrderVO.setSeller(sellerVO);
//		ticketOrderVO.setTicketOrdCode(ticketOrdCode);
//		dao.insert(ticketOrderVO);
//
//		return ticketOrderVO;
//	}

	public TicketOrderVO updateTicketorder(Integer ticketOrdId, MemberVO member, Integer ticketOrdStatus,
			Double ticketOrdTotalPrice, Double ticketOrdProCodeAmount, Double ticketOrdActuallyAmount,
			Integer ticketOrdPayStatus, MyPromoCodeVO mypromocode, String ticketOrdAddress, SellerVO seller,
			String ticketOrdCode) {

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

		dao.insert(ticketOrderVO);

		return ticketOrderVO;
	}
	public List<TicketOrderVO> getTicketlist(Integer memId){
		return dao.getTicketlist(memId);
	}
	public MemberVO getmember(Integer memId) {
		return dao.getmember(memId);
	}


}
