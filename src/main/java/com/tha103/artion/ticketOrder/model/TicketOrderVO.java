package com.tha103.artion.ticketOrder.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.myPromoCode.model.MyPromoCodeVO;
import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailVO;


@Entity
@Table(name = "ticketorder")
// 配合 TestHQLWithParameter.java

public class TicketOrderVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticketOrd_id", updatable = false)
	private Integer ticketOrdId;

	@Expose
	@Column(name = "ticketOrd_time", insertable = false, updatable = false)
	private Timestamp ticketOrdTime;

	//票卷訂單(fk)>會員(pk)
	@ManyToOne
	@JoinColumn(name = "mem_id", referencedColumnName = "mem_id")
	private MemberVO member;

	@Expose
	@Column(name = "ticketOrd_status")
	private Integer ticketOrdStatus;

	@Expose
	@Column(name = "ticketOrd_totalPrice")
	private Double ticketOrdTotalPrice;

	@Expose
	@Column(name = "ticketOrd_proCodeAmount")
	private Double ticketOrdProCodeAmount;

	@Expose
	@Column(name = "ticketOrd_actuallyAmount")
	private Double ticketOrdActuallyAmount;

	@Expose
	@Column(name = "ticketOrd_payStatus")
	private Integer ticketOrdPayStatus;

	//票卷訂單(fk)>我的優惠碼(pk)
	@ManyToOne
	@JoinColumn(name = "myProCode_id", referencedColumnName = "myProCode_id")
	private MyPromoCodeVO mypromocode;

	@Expose
	@Column(name = "ticketOrd_address")
	private String ticketOrdAddress;

	// 票卷訂單(fk)>廠商(pk)
	@ManyToOne
	@JoinColumn(name = "sel_id", referencedColumnName = "sel_id")
	private SellerVO seller;

	@Expose
	@Column(name = "ticketOrd_code")
	private String ticketOrdCode;

//-----------------------以下為OneToMany-----------------------
	//票卷訂單(pk)>票卷訂單明細(fk)
	@Expose
	@OneToMany(mappedBy = "ticketorder", cascade = CascadeType.ALL)
	private Set<TicketOrderDetailVO> ticOrdDets;

//-------------------------------------------------------------
	public TicketOrderVO() {
		super();
	}

	public TicketOrderVO(Integer ticketOrdId, Timestamp ticketOrdTime, MemberVO member, Integer ticketOrdStatus,
			Double ticketOrdTotalPrice, Double ticketOrdProCodeAmount, Double ticketOrdActuallyAmount,
			Integer ticketOrdPayStatus, MyPromoCodeVO myProCodeId, String ticketOrdAddress, SellerVO sel,
			String ticketOrdCode, Set<TicketOrderDetailVO> ticOrdDets) {
		super();
		this.ticketOrdId = ticketOrdId;
		this.ticketOrdTime = ticketOrdTime;
		this.member = member;
		this.ticketOrdStatus = ticketOrdStatus;
		this.ticketOrdTotalPrice = ticketOrdTotalPrice;
		this.ticketOrdProCodeAmount = ticketOrdProCodeAmount;
		this.ticketOrdActuallyAmount = ticketOrdActuallyAmount;
		this.ticketOrdPayStatus = ticketOrdPayStatus;
		this.myProCodeId = myProCodeId;
		this.ticketOrdAddress = ticketOrdAddress;
		this.sel = sel;
		this.ticketOrdCode = ticketOrdCode;
		this.ticOrdDets = ticOrdDets;
	}

	public Integer getTicketOrdId() {
		return ticketOrdId;
	}

	public void setTicketOrdId(Integer ticketOrdId) {
		this.ticketOrdId = ticketOrdId;
	}

	public Timestamp getTicketOrdTime() {
		return ticketOrdTime;
	}

	public void setTicketOrdTime(Timestamp ticketOrdTime) {
		this.ticketOrdTime = ticketOrdTime;
	}

	public MemberVO getMemId() {
		return member;
	}

	public void setMemId(MemberVO member) {
		this.member = member;
	}

	public Integer getTicketOrdStatus() {
		return ticketOrdStatus;
	}

	public void setTicketOrdStatus(Integer ticketOrdStatus) {
		this.ticketOrdStatus = ticketOrdStatus;
	}

	public Double getTicketOrdTotalPrice() {
		return ticketOrdTotalPrice;
	}

	public void setTicketOrdTotalPrice(Double ticketOrdTotalPrice) {
		this.ticketOrdTotalPrice = ticketOrdTotalPrice;
	}

	public Double getTicketOrdProCodeAmount() {
		return ticketOrdProCodeAmount;
	}

	public void setTicketOrdProCodeAmount(Double ticketOrdProCodeAmount) {
		this.ticketOrdProCodeAmount = ticketOrdProCodeAmount;
	}

	public Double getTicketOrdActuallyAmount() {
		return ticketOrdActuallyAmount;
	}

	public void setTicketOrdActuallyAmount(Double ticketOrdActuallyAmount) {
		this.ticketOrdActuallyAmount = ticketOrdActuallyAmount;
	}

	public Integer getTicketOrdPayStatus() {
		return ticketOrdPayStatus;
	}

	public void setTicketOrdPayStatus(Integer ticketOrdPayStatus) {
		this.ticketOrdPayStatus = ticketOrdPayStatus;
	}

	public MyPromoCodeVO getMyProCodeId() {
		return myProCodeId;
	}

	public void setMyProCodeId(MyPromoCodeVO myProCodeId) {
		this.myProCodeId = myProCodeId;
	}

	public String getTicketOrdAddress() {
		return ticketOrdAddress;
	}

	public void setTicketOrdAddress(String ticketOrdAddress) {
		this.ticketOrdAddress = ticketOrdAddress;
	}

	public SellerVO getSel() {
		return sel;
	}

	public void setSel(SellerVO sel) {
		this.sel = sel;
	}

	public String getTicketOrdCode() {
		return ticketOrdCode;
	}

	public void setTicketOrdCode(String ticketOrdCode) {
		this.ticketOrdCode = ticketOrdCode;
	}

	public Set<TicketOrderDetailVO> getTicOrdDets() {
		return ticOrdDets;
	}

	public void setTicOrdDets(Set<TicketOrderDetailVO> ticOrdDets) {
		this.ticOrdDets = ticOrdDets;
	}

	@Override
	public String toString() {
		return "TicketOrderVO [ticketOrdId=" + ticketOrdId + ", ticketOrdTime=" + ticketOrdTime + ", ticketOrdStatus="
				+ ticketOrdStatus + ", ticketOrdTotalPrice=" + ticketOrdTotalPrice + ", ticketOrdProCodeAmount="
				+ ticketOrdProCodeAmount + ", ticketOrdActuallyAmount=" + ticketOrdActuallyAmount
				+ ", ticketOrdPayStatus=" + ticketOrdPayStatus + ", ticketOrdAddress=" + ticketOrdAddress
				+ ", ticketOrdCode=" + ticketOrdCode + "]";
	}

}
