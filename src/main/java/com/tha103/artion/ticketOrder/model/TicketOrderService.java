package com.tha103.artion.ticketOrder.model;

import java.util.List;

import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.myPromoCode.model.MyPromoCodeVO;
import com.tha103.artion.seller.model.SellerVO;

public class TicketOrderService {
	private TicketOrderDAO_interface dao;

	public TicketOrderService() {
		dao = new TicketOrderDAO();
	}

	public TicketOrderVO insertTicketorder(Integer memberNo, Integer ticketOrdStatus, Double ticketOrdTotalPrice,
			Double ticketOrdProCodeAmount, Double ticketOrdActuallyAmount, Integer ticketOrdPayStatus,
			Integer mypromocodeNo, String ticketOrdAddress, Integer sellerNo, String ticketOrdCode) {
//
//		SellerVO sellerVO = new SellerVO(); // FK寫法 要去想怎麼抓值，抓的是PK還是什麼
//		sellerVO.setSelId(2001);
//
//		MyPromoCodeVO mypromocodeVO = new MyPromoCodeVO();
//		mypromocodeVO.setMyProCodeId(1);
//
//		MemberVO membervo = new MemberVO();
//		membervo.setMemId(7001);
//
		TicketOrderVO ticketOrderVO = new TicketOrderVO();

		ticketOrderVO.setMemberNo(memberNo);
		ticketOrderVO.setTicketOrdStatus(ticketOrdStatus);
		ticketOrderVO.setTicketOrdTotalPrice(ticketOrdTotalPrice);
		ticketOrderVO.setTicketOrdProCodeAmount(ticketOrdProCodeAmount);
		ticketOrderVO.setTicketOrdActuallyAmount(ticketOrdActuallyAmount);
		ticketOrderVO.setTicketOrdPayStatus(ticketOrdPayStatus);
		ticketOrderVO.setMypromocodeNo(mypromocodeNo);
		ticketOrderVO.setTicketOrdAddress(ticketOrdAddress);
		ticketOrderVO.setSellerNo(sellerNo);
		ticketOrderVO.setTicketOrdCode(ticketOrdCode);
		dao.insert(ticketOrderVO);

		return ticketOrderVO;
	}

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

	public void deleteTicketorder(Integer ticketOrdId) {
		dao.delete(ticketOrdId);
	}

	public TicketOrderVO getById(Integer ticketOrdId) {
		return dao.getById(ticketOrdId);
	}

	public List<TicketOrderVO> getAll() {
		return dao.getAll();
	}

}
