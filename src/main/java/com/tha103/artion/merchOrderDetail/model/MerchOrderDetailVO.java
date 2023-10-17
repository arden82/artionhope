package com.tha103.artion.merchOrderDetail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.tha103.artion.merch.model.MerchVO;
import com.tha103.artion.merchOrder.model.MerchOrderVO;

@Entity
@Table(name = "merchorderdetail")
// 配合 TestHQLWithParameter.java


public class MerchOrderDetailVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "merchOrdDetail_id", updatable = false)
	private Integer merchOrdDetailId;

	//周邊商品訂單明細(fk)>周邊商品(pk)
	@ManyToOne
	@JoinColumn(name = "merOrder_id", referencedColumnName = "merOrder_id")
	private MerchOrderVO merchorder;

	//周邊商品訂單明細(fk)>周邊商品(pk)
	@ManyToOne
	@JoinColumn(name = "merch_id", referencedColumnName = "merch_id")
	private MerchVO merch;

	@Expose
	@Column(name = "merOrderDetail_quantity")
	private Integer merOrderDetailQuantity;

	@Expose
	@Column(name = "merOrderDetail_price")
	private Integer merOrderDetailPrice;

//-------------------------------------------------------------
	public MerchOrderDetailVO() {
		super();
	}

	public MerchOrderDetailVO(Integer merchOrdDetailId, MerchOrderVO merchorder, MerchVO merch,
			Integer merOrderDetailQuantity, Integer merOrderDetailPrice) {
		super();
		this.merchOrdDetailId = merchOrdDetailId;
		this.merchorder = merchorder;
		this.merch = merch;
		this.merOrderDetailQuantity = merOrderDetailQuantity;
		this.merOrderDetailPrice = merOrderDetailPrice;
	}

	public Integer getMerchOrdDetailId() {
		return merchOrdDetailId;
	}

	public void setMerchOrdDetailId(Integer merchOrdDetailId) {
		this.merchOrdDetailId = merchOrdDetailId;
	}

	public MerchOrderVO getMerchorder() {
		return merchorder;
	}

	public void setMerchorder(MerchOrderVO merchorder) {
		this.merchorder = merchorder;
	}

	public MerchVO getMerch() {
		return merch;
	}

	public void setMerch(MerchVO merch) {
		this.merch = merch;
	}

	public Integer getMerOrderDetailQuantity() {
		return merOrderDetailQuantity;
	}

	public void setMerOrderDetailQuantity(Integer merOrderDetailQuantity) {
		this.merOrderDetailQuantity = merOrderDetailQuantity;
	}

	public Integer getMerOrderDetailPrice() {
		return merOrderDetailPrice;
	}

	public void setMerOrderDetailPrice(Integer merOrderDetailPrice) {
		this.merOrderDetailPrice = merOrderDetailPrice;
	}

	@Override
	public String toString() {
		return "MerchOrderDetailVO [merchOrdDetailId=" + merchOrdDetailId + ", merOrderDetailQuantity="
				+ merOrderDetailQuantity + ", merOrderDetailPrice=" + merOrderDetailPrice + "]";
	}


}
