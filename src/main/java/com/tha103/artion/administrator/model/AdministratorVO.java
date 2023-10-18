package com.tha103.artion.administrator.model;

import java.sql.Date;
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
import com.tha103.artion.promoCode.model.PromoCodeVO;

@Entity
@Table(name = "administrator")
public class AdministratorVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adm_id", updatable = false)
	private Integer admId;
		
	@Expose
	@Column(name = "adm_name")
	private String admName;
	
	@Expose
	@Column(name = "adm_identity")
	private Integer admIdentity;
	
	@Expose
	@Column(name = "adm_status", columnDefinition = "tinyint")
	private Integer admStatus;
	
	@Expose
	@Column(name = "adm_mail")
	private String admMail;
	
	@Expose
	@Column(name = "adm_password")
	private String admPassword;
	
	@Expose
	@Column(name = "adm_birthday")
	private Date admBirthday;
	
	@Expose
	@Column(name = "adm_mobile")
	private String admMobile;
	
	@Expose
	@Column(name = "adm_addTime", insertable = false , updatable = false)
	private Timestamp admAddTime;
	
	@Expose
	@Column(name = "adm_lastModifiedTime", insertable = false , updatable = false)
	private Timestamp admLastModifiedTime;
	
	@Expose
	@Column(name = "adm_profilePhoto", columnDefinition = "longblob")
	private byte[] admProfilePhoto;
	
	@Expose
	@Column(name = "adm_right")
	private Integer admRight;
	
//-----------------------以下為OneToMany-----------------------
	//管理者(pk)>優惠碼(fk)
	@Expose
	@OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL)
	private Set<PromoCodeVO> proCodes;

//-------------------------------------------------------------
	public AdministratorVO() {
		super();
	}

	public AdministratorVO(Integer admId, String admName, Integer admIdentity, Integer admStatus, String admMail,
			String admPassword, Date admBirthday, String admMobile, Timestamp admAddTime, Timestamp admLastModifiedTime,
			byte[] admProfilePhoto, Integer admRight, Set<PromoCodeVO> proCodes) {
		super();
		this.admId = admId;
		this.admName = admName;
		this.admIdentity = admIdentity;
		this.admStatus = admStatus;
		this.admMail = admMail;
		this.admPassword = admPassword;
		this.admBirthday = admBirthday;
		this.admMobile = admMobile;
		this.admAddTime = admAddTime;
		this.admLastModifiedTime = admLastModifiedTime;
		this.admProfilePhoto = admProfilePhoto;
		this.admRight = admRight;
		this.proCodes = proCodes;
	}

	public Integer getAdmId() {
		return admId;
	}

	public void setAdmId(Integer admId) {
		this.admId = admId;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public Integer getAdmIdentity() {
		return admIdentity;
	}

	public void setAdmIdentity(Integer admIdentity) {
		this.admIdentity = admIdentity;
	}

	public Integer getAdmStatus() {
		return admStatus;
	}

	public void setAdmStatus(Integer admStatus) {
		this.admStatus = admStatus;
	}

	public String getAdmMail() {
		return admMail;
	}

	public void setAdmMail(String admMail) {
		this.admMail = admMail;
	}

	public String getAdmPassword() {
		return admPassword;
	}

	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}

	public Date getAdmBirthday() {
		return admBirthday;
	}

	public void setAdmBirthday(Date admBirthday) {
		this.admBirthday = admBirthday;
	}

	public String getAdmMobile() {
		return admMobile;
	}

	public void setAdmMobile(String admMobile) {
		this.admMobile = admMobile;
	}

	public Timestamp getAdmAddTime() {
		return admAddTime;
	}

	public void setAdmAddTime(Timestamp admAddTime) {
		this.admAddTime = admAddTime;
	}

	public Timestamp getAdmLastModifiedTime() {
		return admLastModifiedTime;
	}

	public void setAdmLastModifiedTime(Timestamp admLastModifiedTime) {
		this.admLastModifiedTime = admLastModifiedTime;
	}

	public byte[] getAdmProfilePhoto() {
		return admProfilePhoto;
	}

	public void setAdmProfilePhoto(byte[] admProfilePhoto) {
		this.admProfilePhoto = admProfilePhoto;
	}

	public Integer getAdmRight() {
		return admRight;
	}

	public void setAdmRight(Integer admRight) {
		this.admRight = admRight;
	}

	public Set<PromoCodeVO> getProCodes() {
		return proCodes;
	}

	public void setProCodes(Set<PromoCodeVO> proCodes) {
		this.proCodes = proCodes;
	}

	@Override
	public String toString() {
		return "AdministratorVO [admId=" + admId + ", admName=" + admName + ", admIdentity=" + admIdentity
				+ ", admStatus=" + admStatus + ", admMail=" + admMail + ", admPassword=" + admPassword
				+ ", admBirthday=" + admBirthday + ", admMobile=" + admMobile + ", admAddTime=" + admAddTime
				+ ", admLastModifiedTime=" + admLastModifiedTime + ", admProfilePhoto="
				+ Arrays.toString(admProfilePhoto) + ", admRight=" + admRight + ", proCodes=" + proCodes + "]";
	}

	
	
	
}
