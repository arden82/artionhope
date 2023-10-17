package com.tha103.artion.sellerNotification.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.tha103.artion.seller.model.SellerVO;

@Entity
@Table(name = "sellernotification")

public class SellerNotificationVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "selNot_serialNumber")
	private Integer selNotSerialNumber;

	// 廠商通知(fk)>廠商(pk)
	@ManyToOne
	@JoinColumn(name = "sel_id", referencedColumnName = "sel_id")
	private SellerVO seller;

	@Expose
	@Column(name = "selNot_readStatus", columnDefinition = "tinyint")
	private boolean selNotReadStatus;

	@Expose
	@Column(name = "selNot_existStatus", columnDefinition = "tinyint")
	private boolean selNotExistStatus;

	@Expose
	@Column(name = "selNot_content")
	private String selNotContent;

	@Expose
	@Column(name = "selNot_receiveDateTime", insertable = false, updatable = false)
	private Timestamp selNotReceiveDateTime;
	
//-------------------------------------------------------------
	public SellerNotificationVO() {
		super();
	}

	public SellerNotificationVO(Integer selNotSerialNumber, SellerVO seller, boolean selNotReadStatus,
			boolean selNotExistStatus, String selNotContent, Timestamp selNotReceiveDateTime) {
		super();
		this.selNotSerialNumber = selNotSerialNumber;
		this.seller = seller;
		this.selNotReadStatus = selNotReadStatus;
		this.selNotExistStatus = selNotExistStatus;
		this.selNotContent = selNotContent;
		this.selNotReceiveDateTime = selNotReceiveDateTime;
	}

	public Integer getSelNotSerialNumber() {
		return selNotSerialNumber;
	}

	public void setSelNotSerialNumber(Integer selNotSerialNumber) {
		this.selNotSerialNumber = selNotSerialNumber;
	}

	public SellerVO getSeller() {
		return seller;
	}

	public void setSeller(SellerVO seller) {
		this.seller = seller;
	}

	public boolean isSelNotReadStatus() {
		return selNotReadStatus;
	}

	public void setSelNotReadStatus(boolean selNotReadStatus) {
		this.selNotReadStatus = selNotReadStatus;
	}

	public boolean isSelNotExistStatus() {
		return selNotExistStatus;
	}

	public void setSelNotExistStatus(boolean selNotExistStatus) {
		this.selNotExistStatus = selNotExistStatus;
	}

	public String getSelNotContent() {
		return selNotContent;
	}

	public void setSelNotContent(String selNotContent) {
		this.selNotContent = selNotContent;
	}

	public Timestamp getSelNotReceiveDateTime() {
		return selNotReceiveDateTime;
	}

	public void setSelNotReceiveDateTime(Timestamp selNotReceiveDateTime) {
		this.selNotReceiveDateTime = selNotReceiveDateTime;
	}

	@Override
	public String toString() {
		return "SellerNotificationVO [selNotSerialNumber=" + selNotSerialNumber + ", selNotReadStatus="
				+ selNotReadStatus + ", selNotExistStatus=" + selNotExistStatus + ", selNotContent=" + selNotContent
				+ ", selNotReceiveDateTime=" + selNotReceiveDateTime + "]";
	}
	
}
