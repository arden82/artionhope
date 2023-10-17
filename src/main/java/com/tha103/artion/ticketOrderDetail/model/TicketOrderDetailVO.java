package com.tha103.artion.ticketOrderDetail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;


@Entity
@Table(name = "ticketorderdetail")
// 配合 TestHQLWithParameter.java
public class TicketOrderDetailVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticOrdDetail_id", updatable = false)
	private Integer ticOrdDetId;

	// 票卷訂單明細(fk)>票卷訂單(pk)
	@ManyToOne
	@JoinColumn(name = "ticketOrd_id", referencedColumnName = "ticketOrd_id")
	private TicketOrderVO ticketorder;

	@Expose
	@Column(name = "ticketOrdDetail_quantity")
	private Integer ticOrdDetQuantity;

	@Expose
	@Column(name = "ticOrdDetail_price")
	private Double ticOrdDetPrice;

	// 票卷訂單明細(fk)>活動(pk)
	@ManyToOne
	@JoinColumn(name = "act_id", referencedColumnName = "act_id")
	private ActivityVO activity;

//-------------------------------------------------------------
	public TicketOrderDetailVO() {
		super();
	}

	public TicketOrderDetailVO(Integer ticOrdDetId, TicketOrderVO ticketorder, Integer ticOrdDetQuantity,
			Double ticOrdDetPrice, ActivityVO activity) {
		super();
		this.ticOrdDetId = ticOrdDetId;
		this.ticketorder = ticketorder;
		this.ticOrdDetQuantity = ticOrdDetQuantity;
		this.ticOrdDetPrice = ticOrdDetPrice;
		this.activity = activity;
	}

	public Integer getTicOrdDetId() {
		return ticOrdDetId;
	}

	public void setTicOrdDetId(Integer ticOrdDetId) {
		this.ticOrdDetId = ticOrdDetId;
	}

	public TicketOrderVO getTicketorder() {
		return ticketorder;
	}

	public void setTicketorder(TicketOrderVO ticketorder) {
		this.ticketorder = ticketorder;
	}

	public Integer getTicOrdDetQuantity() {
		return ticOrdDetQuantity;
	}

	public void setTicOrdDetQuantity(Integer ticOrdDetQuantity) {
		this.ticOrdDetQuantity = ticOrdDetQuantity;
	}

	public Double getTicOrdDetPrice() {
		return ticOrdDetPrice;
	}

	public void setTicOrdDetPrice(Double ticOrdDetPrice) {
		this.ticOrdDetPrice = ticOrdDetPrice;
	}

	public ActivityVO getActivity() {
		return activity;
	}

	public void setActivity(ActivityVO activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "TicketOrderDetailVO [ticOrdDetId=" + ticOrdDetId + ", ticOrdDetQuantity=" + ticOrdDetQuantity
				+ ", ticOrdDetPrice=" + ticOrdDetPrice + "]";
	}

}
