package com.tha103.artion.merch.model;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.tha103.artion.merchOrderDetail.model.MerchOrderDetailVO;


@Entity
@Table(name = "merch")
public class MerchVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "merch_id", updatable = false)
	private Integer merchId;
	
	@Expose
	@Column(name = "merch_picture1", columnDefinition = "longblob")
	private Byte[] merchPicture1;
	
	@Expose
	@Column(name = "merch_picture2", columnDefinition = "longblob")
	private Byte[] merchPicture2;
	
	@Expose
	@Column(name = "merch_picture3", columnDefinition = "longblob")
	private Byte[] merchPicture3;
	
	@Expose
	@Column(name = "merch_picture4", columnDefinition = "longblob")
	private Byte[] merchPicture4;
	
	@Expose
	@Column(name = "merch_name")
	private String merchName;
	
	@Expose
	@Column(name = "merch_total")
	private Integer merchTotal;
	
	@Expose
	@Column(name = "merch_price")
	private Integer merchPrice;
	
	@Expose
	@Column(name = "merch_sort")
	private Integer merchSort;
	
	@Expose
	@Column(name = "merch_startTime")
	private Timestamp merchStartTime;
	
	@Expose
	@Column(name = "merch_endTime")
	private Timestamp merchEndTime;
	
	@Expose
	@Column(name = "merch_introduction")
	private String merchIntroduction;
	
	@Expose
	@Column(name = "merch_sellAmount")
	private Integer merchSellAmount;
	
	@Expose
	@Column(name = "merch_status")
	private Integer merchStatus;
	
//-----------------------以下為OneToMany-----------------------
	//周邊商品(pk)>周邊商品訂單明細(fk)
	@Expose
	@OneToMany(mappedBy = "merch", cascade = CascadeType.ALL)
	private Set<MerchOrderDetailVO> metOrdDets;
//-------------------------------------------------------------
	public MerchVO() {
		super();
	}

	public MerchVO(Integer merchId, Byte[] merchPicture1, Byte[] merchPicture2, Byte[] merchPicture3,
			Byte[] merchPicture4, String merchName, Integer merchTotal, Integer merchPrice, Integer merchSort,
			Timestamp merchStartTime, Timestamp merchEndTime, String merchIntroduction, Integer merchSellAmount,
			Integer merchStatus, Set<MerchOrderDetailVO> metOrdDets) {
		super();
		this.merchId = merchId;
		this.merchPicture1 = merchPicture1;
		this.merchPicture2 = merchPicture2;
		this.merchPicture3 = merchPicture3;
		this.merchPicture4 = merchPicture4;
		this.merchName = merchName;
		this.merchTotal = merchTotal;
		this.merchPrice = merchPrice;
		this.merchSort = merchSort;
		this.merchStartTime = merchStartTime;
		this.merchEndTime = merchEndTime;
		this.merchIntroduction = merchIntroduction;
		this.merchSellAmount = merchSellAmount;
		this.merchStatus = merchStatus;
		this.metOrdDets = metOrdDets;
	}

	public Integer getMerchId() {
		return merchId;
	}

	public void setMerchId(Integer merchId) {
		this.merchId = merchId;
	}

	public Byte[] getMerchPicture1() {
		return merchPicture1;
	}

	public void setMerchPicture1(Byte[] merchPicture1) {
		this.merchPicture1 = merchPicture1;
	}

	public Byte[] getMerchPicture2() {
		return merchPicture2;
	}

	public void setMerchPicture2(Byte[] merchPicture2) {
		this.merchPicture2 = merchPicture2;
	}

	public Byte[] getMerchPicture3() {
		return merchPicture3;
	}

	public void setMerchPicture3(Byte[] merchPicture3) {
		this.merchPicture3 = merchPicture3;
	}

	public Byte[] getMerchPicture4() {
		return merchPicture4;
	}

	public void setMerchPicture4(Byte[] merchPicture4) {
		this.merchPicture4 = merchPicture4;
	}

	public String getMerchName() {
		return merchName;
	}

	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}

	public Integer getMerchTotal() {
		return merchTotal;
	}

	public void setMerchTotal(Integer merchTotal) {
		this.merchTotal = merchTotal;
	}

	public Integer getMerchPrice() {
		return merchPrice;
	}

	public void setMerchPrice(Integer merchPrice) {
		this.merchPrice = merchPrice;
	}

	public Integer getMerchSort() {
		return merchSort;
	}

	public void setMerchSort(Integer merchSort) {
		this.merchSort = merchSort;
	}

	public Timestamp getMerchStartTime() {
		return merchStartTime;
	}

	public void setMerchStartTime(Timestamp merchStartTime) {
		this.merchStartTime = merchStartTime;
	}

	public Timestamp getMerchEndTime() {
		return merchEndTime;
	}

	public void setMerchEndTime(Timestamp merchEndTime) {
		this.merchEndTime = merchEndTime;
	}

	public String getMerchIntroduction() {
		return merchIntroduction;
	}

	public void setMerchIntroduction(String merchIntroduction) {
		this.merchIntroduction = merchIntroduction;
	}

	public Integer getMerchSellAmount() {
		return merchSellAmount;
	}

	public void setMerchSellAmount(Integer merchSellAmount) {
		this.merchSellAmount = merchSellAmount;
	}

	public Integer getMerchStatus() {
		return merchStatus;
	}

	public void setMerchStatus(Integer merchStatus) {
		this.merchStatus = merchStatus;
	}

	public Set<MerchOrderDetailVO> getMetOrdDets() {
		return metOrdDets;
	}

	public void setMetOrdDets(Set<MerchOrderDetailVO> metOrdDets) {
		this.metOrdDets = metOrdDets;
	}

	@Override
	public String toString() {
		return "MerchVO [merchId=" + merchId + ", merchPicture1=" + Arrays.toString(merchPicture1) + ", merchPicture2="
				+ Arrays.toString(merchPicture2) + ", merchPicture3=" + Arrays.toString(merchPicture3)
				+ ", merchPicture4=" + Arrays.toString(merchPicture4) + ", merchName=" + merchName + ", merchTotal="
				+ merchTotal + ", merchPrice=" + merchPrice + ", merchSort=" + merchSort + ", merchStartTime="
				+ merchStartTime + ", merchEndTime=" + merchEndTime + ", merchIntroduction=" + merchIntroduction
				+ ", merchSellAmount=" + merchSellAmount + ", merchStatus=" + merchStatus + "]";
	}
	
}
