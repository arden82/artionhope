package com.tha103.artion.promoCode.model;

import java.sql.Date;
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
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.memberLevel.model.MemberLevelVO;
import com.tha103.artion.myPromoCode.model.MyPromoCodeVO;
 


@Entity
@Table(name = "promocode")
public class PromoCodeVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proCode_id", updatable = false)
	private Integer proCodeId;

	@Expose
	@Column(name = "proCode_name")
	private String proCodeName;

	@Expose
	@Column(name = "proCode_code")
	private String proCodeCode;

	@Expose
	@Column(name = "proCode_type")
	private Integer proCodeType;

	@Expose
	@Column(name = "proCode_value")
	private String proCodeValue;
	
	@Expose
	@Column(name = "proCode_startDate")
	private Date proCodeStartDate;

	@Expose
	@Column(name = "proCode_endDate")
	private Date proCodeEndDate;

	@Expose
	@Column(name = "proCode_actType")
	private Integer proCodeActType;
	
	// 優惠碼(fk)>會員等級(pk)
	@ManyToOne
	@JoinColumn(name = "memLev_level", referencedColumnName = "memLev_level")
	private MemberLevelVO memLevLevel;

	@Expose
	@Column(name = "proCode_total")
	private Integer proCodeTotal;

	@Expose
	@Column(name = "proCode_status", columnDefinition = "tinyint")
	private Integer proCodeStatus;

	@Expose
	@Column(name = "proCode_describe")
	private String proCodeDescribe;

	// 優惠碼(fk)>管理者(pk)
	@ManyToOne
	@JoinColumn(name = "adm_id", referencedColumnName = "adm_id")
	private AdministratorVO administrator;

//-----------------------以下為OneToMany-----------------------
	// 優惠碼(pk)>我的優惠碼(fk)
	@Expose
	@OneToMany(mappedBy = "promocode", cascade = CascadeType.ALL)
	private Set<MyPromoCodeVO> myProCodes;
//-------------------------------------------------------------
	public PromoCodeVO() {
		super();
	}

	public PromoCodeVO(Integer proCodeId, String proCodeName, String proCodeCode, Integer proCodeType,
			String proCodeValue, Date proCodeStartDate, Date proCodeEndDate, Integer proCodeActType,
			MemberLevelVO memLevLevel, Integer proCodeTotal, Integer proCodeStatus, String proCodeDescribe,
			AdministratorVO administrator, Set<MyPromoCodeVO> myProCodes) {
		super();
		this.proCodeId = proCodeId;
		this.proCodeName = proCodeName;
		this.proCodeCode = proCodeCode;
		this.proCodeType = proCodeType;
		this.proCodeValue = proCodeValue;
		this.proCodeStartDate = proCodeStartDate;
		this.proCodeEndDate = proCodeEndDate;
		this.proCodeActType = proCodeActType;
		this.memLevLevel = memLevLevel;
		this.proCodeTotal = proCodeTotal;
		this.proCodeStatus = proCodeStatus;
		this.proCodeDescribe = proCodeDescribe;
		this.administrator = administrator;
		this.myProCodes = myProCodes;
	}

	public Integer getProCodeId() {
		return proCodeId;
	}

	public void setProCodeId(Integer proCodeId) {
		this.proCodeId = proCodeId;
	}

	public String getProCodeName() {
		return proCodeName;
	}

	public void setProCodeName(String proCodeName) {
		this.proCodeName = proCodeName;
	}

	public String getProCodeCode() {
		return proCodeCode;
	}

	public void setProCodeCode(String proCodeCode) {
		this.proCodeCode = proCodeCode;
	}

	public Integer getProCodeType() {
		return proCodeType;
	}

	public void setProCodeType(Integer proCodeType) {
		this.proCodeType = proCodeType;
	}

	public String getProCodeValue() {
		return proCodeValue;
	}

	public void setProCodeValue(String proCodeValue) {
		this.proCodeValue = proCodeValue;
	}

	public Date getProCodeStartDate() {
		return proCodeStartDate;
	}

	public void setProCodeStartDate(Date proCodeStartDate) {
		this.proCodeStartDate = proCodeStartDate;
	}

	public Date getProCodeEndDate() {
		return proCodeEndDate;
	}

	public void setProCodeEndDate(Date proCodeEndDate) {
		this.proCodeEndDate = proCodeEndDate;
	}

	public Integer getProCodeActType() {
		return proCodeActType;
	}

	public void setProCodeActType(Integer proCodeActType) {
		this.proCodeActType = proCodeActType;
	}

	public MemberLevelVO getMemLevLevel() {
		return memLevLevel;
	}

	public void setMemLevLevel(MemberLevelVO memLevLevel) {
		this.memLevLevel = memLevLevel;
	}

	public Integer getProCodeTotal() {
		return proCodeTotal;
	}

	public void setProCodeTotal(Integer proCodeTotal) {
		this.proCodeTotal = proCodeTotal;
	}

	public Integer getProCodeStatus() {
		return proCodeStatus;
	}

	public void setProCodeStatus(Integer proCodeStatus) {
		this.proCodeStatus = proCodeStatus;
	}

	public String getProCodeDescribe() {
		return proCodeDescribe;
	}

	public void setProCodeDescribe(String proCodeDescribe) {
		this.proCodeDescribe = proCodeDescribe;
	}

	public AdministratorVO getAdministrator() {
		return administrator;
	}

	public void setAdministrator(AdministratorVO administrator) {
		this.administrator = administrator;
	}

	public Set<MyPromoCodeVO> getMyProCodes() {
		return myProCodes;
	}

	public void setMyProCodes(Set<MyPromoCodeVO> myProCodes) {
		this.myProCodes = myProCodes;
	}

	@Override
	public String toString() {
		return "PromoCodeVO [proCodeId=" + proCodeId + ", proCodeName=" + proCodeName + ", proCodeCode=" + proCodeCode
				+ ", proCodeType=" + proCodeType + ", proCodeValue=" + proCodeValue + ", proCodeStartDate="
				+ proCodeStartDate + ", proCodeEndDate=" + proCodeEndDate + ", proCodeActType=" + proCodeActType
				+ ", proCodeTotal=" + proCodeTotal + ", proCodeStatus=" + proCodeStatus + ", proCodeDescribe="
				+ proCodeDescribe + "]";
	}
}
