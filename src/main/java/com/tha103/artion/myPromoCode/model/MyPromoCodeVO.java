package com.tha103.artion.myPromoCode.model;

import java.util.Set;

import javax.persistence.*;

import com.google.gson.annotations.Expose;
import com.tha103.artion.member.model.MemberVO;
import com.tha103.artion.promoCode.model.PromoCodeVO;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;

@Entity
@Table(name = "mypromocode")
public class MyPromoCodeVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "myProCode_id")	
	private Integer myProCodeId;
	
	@Expose
	@Column(name="myProCode_status", columnDefinition = "tinyint")
	private Integer myProCodeStatus;
	
	//我的優惠碼(fb)>優惠碼(pk)
	@ManyToOne
	@JoinColumn(name="proCode_id",referencedColumnName = "proCode_id")
	private PromoCodeVO promocode;
	
	//我的優惠碼(fk)>會員(pk)
	@ManyToOne
	@JoinColumn(name="mem_id",referencedColumnName = "mem_id")
	private MemberVO member;
	
//-----------------------以下為OneToMany-----------------------
	//我的優惠碼(pk)>票卷訂單(fk)
	@Expose
	@OneToMany(mappedBy = "mypromocode", cascade = CascadeType.ALL)
	private Set<TicketOrderVO> ticOrds;
	
//-------------------------------------------------------------
	public MyPromoCodeVO() {
		super();
	}

	public MyPromoCodeVO(Integer myProCodeId, Integer myProCodeStatus, PromoCodeVO promocode, MemberVO member,
			Set<TicketOrderVO> ticOrds) {
		super();
		this.myProCodeId = myProCodeId;
		this.myProCodeStatus = myProCodeStatus;
		this.promocode = promocode;
		this.member = member;
		this.ticOrds = ticOrds;
	}

	public Integer getMyProCodeId() {
		return myProCodeId;
	}

	public void setMyProCodeId(Integer myProCodeId) {
		this.myProCodeId = myProCodeId;
	}

	public Integer getMyProCodeStatus() {
		return myProCodeStatus;
	}

	public void setMyProCodeStatus(Integer myProCodeStatus) {
		this.myProCodeStatus = myProCodeStatus;
	}

	public PromoCodeVO getPromocode() {
		return promocode;
	}

	public void setPromocode(PromoCodeVO promocode) {
		this.promocode = promocode;
	}

	public MemberVO getMemId() {
		return member;
	}

	public void setMemId(MemberVO member) {
		this.member = member;
	}

	public Set<TicketOrderVO> getTicOrds() {
		return ticOrds;
	}

	public void setTicOrds(Set<TicketOrderVO> ticOrds) {
		this.ticOrds = ticOrds;
	}

	@Override
	public String toString() {
		return "MyPromoCodeVO [myProCodeId=" + myProCodeId + ", myProCodeStatus=" + myProCodeStatus + "]";
	}
	
}
