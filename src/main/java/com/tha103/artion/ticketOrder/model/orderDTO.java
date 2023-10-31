package com.tha103.artion.ticketOrder.model;

import java.sql.Timestamp;

import com.tha103.artion.member.model.MemberVO;

public class orderDTO {
	
	
	private Integer ticketOrdId;
	private String memName;
	private Timestamp ticketOrdTime;
	private String selName;
	
	private String actName;
	private Integer actTicPrice;
	private Integer ticOrdDetQuantity;
	private Double ticOrdDetPrice;
	public orderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderDTO(MemberVO memberVO) {
		super();
		this.ticketOrdId = memberVO.getTicOrders();
		this.memName = memName;
		this.ticketOrdTime = ticketOrdTime;
		this.selName = selName;
		this.actName = actName;
		this.actTicPrice = actTicPrice;
		this.ticOrdDetQuantity = ticOrdDetQuantity;
		this.ticOrdDetPrice = ticOrdDetPrice;
	}
	
	

}
