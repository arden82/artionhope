package com.tha103.artion.ticketOrder.model;

import java.util.List;

import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.myPromoCode.model.MyPromoCodeVO;
import com.tha103.artion.seller.model.SellerVO;

public class TicketOrderService {
	private TicketOrderDAO_interface dao;

	public TicketOrderService() {
		dao = new TicketOrderDAO();
	}

	// 新增
	public TicketOrderVO add(TicketOrderVO ticketOrderVO) {
		dao.insert(ticketOrderVO);
		return ticketOrderVO;
	}

	// 更新
	public TicketOrderVO update(TicketOrderVO ticketOrderVO) {
		dao.update(ticketOrderVO);
		return ticketOrderVO;
	}

	// 刪除
	public void deleteTicketorder(Integer ticketOrdId) {
		dao.delete(ticketOrdId);
	}

	// 取得PK
	public TicketOrderVO getById(Integer ticketOrdId) {
		return dao.getById(ticketOrdId);
	}

	// 取得所有
	public List<TicketOrderVO> getAll() {
		return dao.getAll();
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