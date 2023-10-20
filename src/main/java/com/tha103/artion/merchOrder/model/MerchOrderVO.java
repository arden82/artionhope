package com.tha103.artion.merchOrder.model;

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
import com.tha103.artion.merchOrderDetail.model.MerchOrderDetailVO;

@Entity
@Table(name = "merchorder")
// 配合 TestHQLWithParameter.java

public class MerchOrderVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "merOrder_id", updatable = false)
	private Integer merOrderId;

	// 周邊商品訂單(fk)>會員(pk)
	@ManyToOne
	@JoinColumn(name = "mem_id", referencedColumnName = "mem_id")
	private MemberVO member;

	@Expose
	@Column(name = "merOrder_actuallyAmount")
	private Integer merOrderActuallyAmount;

	@Expose
	@Column(name = "merOrder_time", insertable = false, updatable = false)
	private Timestamp merOrderTime;

	@Expose
	@Column(name = "merOrder_payStatus")
	private Integer merOrderPayStatus;

	@Expose
	@Column(name = "merOrder_status")
	private Integer merOrderStatus;

	@Expose
	@Column(name = "merOrder_address")
	private String merOrderAddress;

	@Expose
	@Column(name = "merOrder_code")
	private String merOrderCode;

//-----------------------以下為OneToMany-----------------------
	// 周邊商品(pk)>周邊商品訂單明細(fk)
	@Expose
	@OneToMany(mappedBy = "merchorder", cascade = CascadeType.ALL)
	private Set<MerchOrderDetailVO> MerOrdDets;

	public MerchOrderVO(Integer merOrderId, MemberVO member, Integer merOrderActuallyAmount, Timestamp merOrderTime,
			Integer merOrderPayStatus, Integer merOrderStatus, String merOrderAddress, String merOrderCode,
			Set<MerchOrderDetailVO> merOrdDets) {
		super();
		this.merOrderId = merOrderId;
		this.member = member;
		this.merOrderActuallyAmount = merOrderActuallyAmount;
		this.merOrderTime = merOrderTime;
		this.merOrderPayStatus = merOrderPayStatus;
		this.merOrderStatus = merOrderStatus;
		this.merOrderAddress = merOrderAddress;
		this.merOrderCode = merOrderCode;
		MerOrdDets = merOrdDets;
	}

	public Integer getMerOrderId() {
		return merOrderId;
	}

	public void setMerOrderId(Integer merOrderId) {
		this.merOrderId = merOrderId;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public Integer getMerOrderActuallyAmount() {
		return merOrderActuallyAmount;
	}

	public void setMerOrderActuallyAmount(Integer merOrderActuallyAmount) {
		this.merOrderActuallyAmount = merOrderActuallyAmount;
	}

	public Timestamp getMerOrderTime() {
		return merOrderTime;
	}

	public void setMerOrderTime(Timestamp merOrderTime) {
		this.merOrderTime = merOrderTime;
	}

	public Integer getMerOrderPayStatus() {
		return merOrderPayStatus;
	}

	public void setMerOrderPayStatus(Integer merOrderPayStatus) {
		this.merOrderPayStatus = merOrderPayStatus;
	}

	public Integer getMerOrderStatus() {
		return merOrderStatus;
	}

	public void setMerOrderStatus(Integer merOrderStatus) {
		this.merOrderStatus = merOrderStatus;
	}

	public String getMerOrderAddress() {
		return merOrderAddress;
	}

	public void setMerOrderAddress(String merOrderAddress) {
		this.merOrderAddress = merOrderAddress;
	}

	public String getMerOrderCode() {
		return merOrderCode;
	}

	public void setMerOrderCode(String merOrderCode) {
		this.merOrderCode = merOrderCode;
	}

	public Set<MerchOrderDetailVO> getMerOrdDets() {
		return MerOrdDets;
	}

	public void setMerOrdDets(Set<MerchOrderDetailVO> merOrdDets) {
		MerOrdDets = merOrdDets;
	}

	@Override
	public String toString() {
		return "MerchOrderVO [merOrderId=" + merOrderId + ", member=" + member + ", merOrderActuallyAmount="
				+ merOrderActuallyAmount + ", merOrderTime=" + merOrderTime + ", merOrderPayStatus=" + merOrderPayStatus
				+ ", merOrderStatus=" + merOrderStatus + ", merOrderAddress=" + merOrderAddress + ", merOrderCode="
				+ merOrderCode + ", MerOrdDets=" + MerOrdDets + "]";
	}

}
