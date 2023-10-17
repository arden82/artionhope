package com.tha103.artion.seller.model;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.*;

import com.google.gson.annotations.Expose;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.sellerNotification.model.SellerNotificationVO;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;

@Entity
@Table(name = "seller")

public class SellerVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sel_id")
	private Integer selId;

	@Expose
	@Column(name = "sel_account")
	private String selAccount;

	@Expose
	@Column(name = "sel_password")
	private String selPassword;

	@Expose
	@Column(name = "sel_name")
	private String selName;

	@Expose
	@Column(name = "sel_phone")
	private String selPhone;

	@Expose
	@Column(name = "sel_address")
	private String selAddress;

	@Expose
	@Column(name = "sel_url")
	private String selUrl;

	@Expose
	@Column(name = "sel_facebook")
	private String selFacebook;

	@Expose
	@Column(name = "sel_contactPerson")
	private String selContactPerson;

	@Expose
	@Column(name = "sel_introduction")
	private String selIntroduction;

	@Expose
	@Column(name = "sel_bankCode")
	private String selBankCode;

	@Expose
	@Column(name = "sel_bankNumber")
	private String selBankNumber;

	@Expose
	@Column(name = "sel_bankName")
	private String selBankName;

	@Expose
	@Column(name = "sel_remark")
	private String selRemark;

	@Expose
	@Column(name = "sel_title")
	private String selTitle;

	@Expose
	@Column(name = "sel_principal")
	private String selPrincipal;

	@Expose
	@Column(name = "sel_uniformNumbers")
	private String selUniformNumbers;

	@Expose
	@Column(name = "sel_registeredAddress")
	private String selRegisteredAddress;

	@Expose
	@Column(name = "sel_profilePicture", columnDefinition = "longblob")
	private byte[] selProfilePicture;

	@Expose
	@Column(name = "sel_registerdTime", insertable = false, updatable = false)
	private Timestamp selRegisterdTime;

	@Expose
	@Column(name = "sel_lastModifiedTime", insertable = false, updatable = false)
	private Timestamp selLastModifiedTime;

	@Expose
	@Column(name = "sel_status")
	private Integer selStatus;

//-----------------------以下為OneToMany-----------------------
	// 廠商(pk)>活動(fk)
	@Expose
	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
	private Set<ActivityVO> activitys;

	// 廠商(pk)>廠商通知(fk)
	@Expose
	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
	private Set<SellerNotificationVO> selNots;

	// 廠商(pk)>票卷訂單(fk)
	@Expose
	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
	private Set<TicketOrderVO> ticOrds;

//-------------------------------------------------------------
	public SellerVO() {
		super();
	}

	public SellerVO(Integer selId, String selAccount, String selPassword, String selName, String selPhone,
			String selAddress, String selUrl, String selFacebook, String selContactPerson, String selIntroduction,
			String selBankCode, String selBankNumber, String selBankName, String selRemark, String selTitle,
			String selPrincipal, String selUniformNumbers, String selRegisteredAddress, byte[] selProfilePicture,
			Timestamp selRegisterdTime, Timestamp selLastModifiedTime, Integer selStatus, Set<ActivityVO> activitys,
			Set<SellerNotificationVO> selNots, Set<TicketOrderVO> ticOrds) {
		super();
		this.selId = selId;
		this.selAccount = selAccount;
		this.selPassword = selPassword;
		this.selName = selName;
		this.selPhone = selPhone;
		this.selAddress = selAddress;
		this.selUrl = selUrl;
		this.selFacebook = selFacebook;
		this.selContactPerson = selContactPerson;
		this.selIntroduction = selIntroduction;
		this.selBankCode = selBankCode;
		this.selBankNumber = selBankNumber;
		this.selBankName = selBankName;
		this.selRemark = selRemark;
		this.selTitle = selTitle;
		this.selPrincipal = selPrincipal;
		this.selUniformNumbers = selUniformNumbers;
		this.selRegisteredAddress = selRegisteredAddress;
		this.selProfilePicture = selProfilePicture;
		this.selRegisterdTime = selRegisterdTime;
		this.selLastModifiedTime = selLastModifiedTime;
		this.selStatus = selStatus;
		this.activitys = activitys;
		this.selNots = selNots;
		this.ticOrds = ticOrds;
	}

	public Integer getSelId() {
		return selId;
	}

	public void setSelId(Integer selId) {
		this.selId = selId;
	}

	public String getSelAccount() {
		return selAccount;
	}

	public void setSelAccount(String selAccount) {
		this.selAccount = selAccount;
	}

	public String getSelPassword() {
		return selPassword;
	}

	public void setSelPassword(String selPassword) {
		this.selPassword = selPassword;
	}

	public String getSelName() {
		return selName;
	}

	public void setSelName(String selName) {
		this.selName = selName;
	}

	public String getSelPhone() {
		return selPhone;
	}

	public void setSelPhone(String selPhone) {
		this.selPhone = selPhone;
	}

	public String getSelAddress() {
		return selAddress;
	}

	public void setSelAddress(String selAddress) {
		this.selAddress = selAddress;
	}

	public String getSelUrl() {
		return selUrl;
	}

	public void setSelUrl(String selUrl) {
		this.selUrl = selUrl;
	}

	public String getSelFacebook() {
		return selFacebook;
	}

	public void setSelFacebook(String selFacebook) {
		this.selFacebook = selFacebook;
	}

	public String getSelContactPerson() {
		return selContactPerson;
	}

	public void setSelContactPerson(String selContactPerson) {
		this.selContactPerson = selContactPerson;
	}

	public String getSelIntroduction() {
		return selIntroduction;
	}

	public void setSelIntroduction(String selIntroduction) {
		this.selIntroduction = selIntroduction;
	}

	public String getSelBankCode() {
		return selBankCode;
	}

	public void setSelBankCode(String selBankCode) {
		this.selBankCode = selBankCode;
	}

	public String getSelBankNumber() {
		return selBankNumber;
	}

	public void setSelBankNumber(String selBankNumber) {
		this.selBankNumber = selBankNumber;
	}

	public String getSelBankName() {
		return selBankName;
	}

	public void setSelBankName(String selBankName) {
		this.selBankName = selBankName;
	}

	public String getSelRemark() {
		return selRemark;
	}

	public void setSelRemark(String selRemark) {
		this.selRemark = selRemark;
	}

	public String getSelTitle() {
		return selTitle;
	}

	public void setSelTitle(String selTitle) {
		this.selTitle = selTitle;
	}

	public String getSelPrincipal() {
		return selPrincipal;
	}

	public void setSelPrincipal(String selPrincipal) {
		this.selPrincipal = selPrincipal;
	}

	public String getSelUniformNumbers() {
		return selUniformNumbers;
	}

	public void setSelUniformNumbers(String selUniformNumbers) {
		this.selUniformNumbers = selUniformNumbers;
	}

	public String getSelRegisteredAddress() {
		return selRegisteredAddress;
	}

	public void setSelRegisteredAddress(String selRegisteredAddress) {
		this.selRegisteredAddress = selRegisteredAddress;
	}

	public byte[] getSelProfilePicture() {
		return selProfilePicture;
	}

	public void setSelProfilePicture(byte[] selProfilePicture) {
		this.selProfilePicture = selProfilePicture;
	}

	public Timestamp getSelRegisterdTime() {
		return selRegisterdTime;
	}

	public void setSelRegisterdTime(Timestamp selRegisterdTime) {
		this.selRegisterdTime = selRegisterdTime;
	}

	public Timestamp getSelLastModifiedTime() {
		return selLastModifiedTime;
	}

	public void setSelLastModifiedTime(Timestamp selLastModifiedTime) {
		this.selLastModifiedTime = selLastModifiedTime;
	}

	public Integer getSelStatus() {
		return selStatus;
	}

	public void setSelStatus(Integer selStatus) {
		this.selStatus = selStatus;
	}

	public Set<ActivityVO> getActivitys() {
		return activitys;
	}

	public void setActivitys(Set<ActivityVO> activitys) {
		this.activitys = activitys;
	}

	public Set<SellerNotificationVO> getSelNots() {
		return selNots;
	}

	public void setSelNots(Set<SellerNotificationVO> selNots) {
		this.selNots = selNots;
	}

	public Set<TicketOrderVO> getTicOrds() {
		return ticOrds;
	}

	public void setTicOrds(Set<TicketOrderVO> ticOrds) {
		this.ticOrds = ticOrds;
	}

	@Override
	public String toString() {
		return "SellerVO [selId=" + selId + ", selAccount=" + selAccount + ", selPassword=" + selPassword + ", selName="
				+ selName + ", selPhone=" + selPhone + ", selAddress=" + selAddress + ", selUrl=" + selUrl
				+ ", selFacebook=" + selFacebook + ", selContactPerson=" + selContactPerson + ", selIntroduction="
				+ selIntroduction + ", selBankCode=" + selBankCode + ", selBankNumber=" + selBankNumber
				+ ", selBankName=" + selBankName + ", selRemark=" + selRemark + ", selTitle=" + selTitle
				+ ", selPrincipal=" + selPrincipal + ", selUniformNumbers=" + selUniformNumbers
				+ ", selRegisteredAddress=" + selRegisteredAddress + ", selProfilePicture="
				+ Arrays.toString(selProfilePicture) + ", selRegisterdTime=" + selRegisterdTime
				+ ", selLastModifiedTime=" + selLastModifiedTime + ", selStatus=" + selStatus + "]";
	}

}
