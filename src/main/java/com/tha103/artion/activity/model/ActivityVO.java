package com.tha103.artion.activity.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
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

import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailVO;
import com.google.gson.annotations.Expose;
import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.activityLike.model.ActivityLikeVO;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.memberCollection.model.MemberCollectionVO;

@Entity
@Table(name = "activity")

public class ActivityVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "act_id")
	private Integer actId;

	@Expose
	@Column(name = "act_name")
	private String actName;

	@Expose
	@Column(name = "act_ticketID")
	private Integer actTicketID;

	@Expose
	@Column(name = "act_ticketPrice")
	private Integer actTicketPrice; //0元=免費

	@Expose
	@Column(name = "act_ticketStartTime") //廠商自訂
	private Timestamp actTicketStartTime; 

	@Expose
	@Column(name = "act_ticketEndTime") //廠商自訂
	private Timestamp actTicketEndTime;  

	@Expose
	@Column(name = "act_type")
	private Integer actType;

	@Expose
	@Column(name = "act_startDate") //廠商自訂
	private Date actStartDate;

	@Expose
	@Column(name = "act_endDate") //廠商自訂
	private Date actEndDate;

	@Expose
	@Column(name = "act_startTime") //廠商自訂
	private Time actStartTime;

	@Expose
	@Column(name = "act_endTime") //廠商自訂
	private Time actEndTime;

	@Expose
	@Column(name = "act_city")
	private String actCity;

	@Expose
	@Column(name = "act_zone")
	private String actZone;

	@Expose
	@Column(name = "act_address")
	private String actAddress;

	@Expose
	@Column(name = "act_organization")
	private String actOrganization;

	@Expose
	@Column(name = "act_email")
	private String actEmail;

	@Expose
	@Column(name = "act_phone")
	private String actPhone;

	@Expose
	@Column(name = "act_ticketTotal")
	private Integer actTicketTotal;

	@Expose
	@Column(name = "act_content")
	private String actContent;

	@Expose
	@Column(name = "act_coverPicture", columnDefinition = "longblob")
	private byte[] actCoverPicture;

	@Expose
	@Column(name = "act_picture1", columnDefinition = "longblob")
	private byte[] actPicture1;

	@Expose
	@Column(name = "act_picture2", columnDefinition = "longblob")
	private byte[] actPicture2;

	@Expose
	@Column(name = "act_picture3", columnDefinition = "longblob")
	private byte[] actPicture3;

	@Expose
	@Column(name = "act_likeTimes")
	private Integer actLikeTimes;

	@Expose
	@Column(name = "act_views")
	private Integer actViews;

	@Expose
	@Column(name = "act_approalStatus")
	private Integer actApproalStatus;

	@Expose
	@Column(name = "act_status")
	private Integer actStatus;

	// 活動(fk)>廠商(pk)
	@ManyToOne
	@JoinColumn(name = "sel_id", referencedColumnName = "sel_id")
	private SellerVO seller;

	@Expose
	@Column(name = "act_longitude")
	private BigDecimal actLongitude;

	@Expose
	@Column(name = "act_latitude")
	private BigDecimal actLatitude;

	@Expose
	@Column(name = "act_ticketTotalSell")
	private Integer actTicketTotalSell;
	
	//活動(FK)>管理者(PK)
	@ManyToOne
	@JoinColumn(name = "adm_id", referencedColumnName = "adm_id" )
	private AdministratorVO admId;

	@Expose
	@Column(name = "act_lastModifiedTime", insertable = false, updatable = false)
	private Timestamp actLastModifiedTime;

	@Expose
	@Column(name = "act_ResultContent")
	private String actResultContent;

//-----------------------以下為OneToMany-----------------------
	// 活動(pk)>活動收藏(fk)
	@Expose
	@OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
	private Set<MemberCollectionVO> memCols;
	
	// 活動(pk)>活動按讚(fk)
	@Expose
	@OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
	private Set<ActivityLikeVO> actLikes;
	
	// 活動(pk)>活動留言(fk)
	@Expose
	@OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
	private Set<ActivityCommentVO> actComs;
	
	//活動(pk)>票卷訂單明細(fk)
	@Expose
	@OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
	private Set<TicketOrderDetailVO> ticOrdDets;

//-------------------------------------------------------------
	public ActivityVO() {
		super();
	}

	public ActivityVO(Integer actId, String actName, Integer actTicketID, Integer actTicketPrice,
			Timestamp actTicketStartTime, Timestamp actTicketEndTime, Integer actType, Date actStartDate,
			Date actEndDate, Time actStartTime, Time actEndTime, String actCity, String actZone, String actAddress,
			String actOrganization, String actEmail, String actPhone, Integer actTicketTotal, String actContent,
			byte[] actCoverPicture, byte[] actPicture1, byte[] actPicture2, byte[] actPicture3, Integer actLikeTimes,
			Integer actViews, Integer actApproalStatus, Integer actStatus, SellerVO seller, BigDecimal actLongitude,
			BigDecimal actLatitude, Integer actTicketTotalSell, AdministratorVO admId, Timestamp actLastModifiedTime,
			String actResultContent, Set<MemberCollectionVO> memCols, Set<ActivityLikeVO> actLikes,
			Set<ActivityCommentVO> actComs, Set<TicketOrderDetailVO> ticOrdDets) {
		super();
		this.actId = actId;
		this.actName = actName;
		this.actTicketID = actTicketID;
		this.actTicketPrice = actTicketPrice;
		this.actTicketStartTime = actTicketStartTime;
		this.actTicketEndTime = actTicketEndTime;
		this.actType = actType;
		this.actStartDate = actStartDate;
		this.actEndDate = actEndDate;
		this.actStartTime = actStartTime;
		this.actEndTime = actEndTime;
		this.actCity = actCity;
		this.actZone = actZone;
		this.actAddress = actAddress;
		this.actOrganization = actOrganization;
		this.actEmail = actEmail;
		this.actPhone = actPhone;
		this.actTicketTotal = actTicketTotal;
		this.actContent = actContent;
		this.actCoverPicture = actCoverPicture;
		this.actPicture1 = actPicture1;
		this.actPicture2 = actPicture2;
		this.actPicture3 = actPicture3;
		this.actLikeTimes = actLikeTimes;
		this.actViews = actViews;
		this.actApproalStatus = actApproalStatus;
		this.actStatus = actStatus;
		this.seller = seller;
		this.actLongitude = actLongitude;
		this.actLatitude = actLatitude;
		this.actTicketTotalSell = actTicketTotalSell;
		this.admId = admId;
		this.actLastModifiedTime = actLastModifiedTime;
		this.actResultContent = actResultContent;
		this.memCols = memCols;
		this.actLikes = actLikes;
		this.actComs = actComs;
		this.ticOrdDets = ticOrdDets;
	}

	public Integer getActId() {
		return actId;
	}

	public void setActId(Integer actId) {
		this.actId = actId;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public Integer getActTicketID() {
		return actTicketID;
	}

	public void setActTicketID(Integer actTicketID) {
		this.actTicketID = actTicketID;
	}

	public Integer getActTicketPrice() {
		return actTicketPrice;
	}

	public void setActTicketPrice(Integer actTicketPrice) {
		this.actTicketPrice = actTicketPrice;
	}

	public Timestamp getActTicketStartTime() {
		return actTicketStartTime;
	}

	public void setActTicketStartTime(Timestamp actTicketStartTime) {
		this.actTicketStartTime = actTicketStartTime;
	}

	public Timestamp getActTicketEndTime() {
		return actTicketEndTime;
	}

	public void setActTicketEndTime(Timestamp actTicketEndTime) {
		this.actTicketEndTime = actTicketEndTime;
	}

	public Integer getActType() {
		return actType;
	}

	public void setActType(Integer actType) {
		this.actType = actType;
	}

	public Date getActStartDate() {
		return actStartDate;
	}

	public void setActStartDate(Date actStartDate) {
		this.actStartDate = actStartDate;
	}

	public Date getActEndDate() {
		return actEndDate;
	}

	public void setActEndDate(Date actEndDate) {
		this.actEndDate = actEndDate;
	}

	public Time getActStartTime() {
		return actStartTime;
	}

	public void setActStartTime(Time actStartTime) {
		this.actStartTime = actStartTime;
	}

	public Time getActEndTime() {
		return actEndTime;
	}

	public void setActEndTime(Time actEndTime) {
		this.actEndTime = actEndTime;
	}

	public String getActCity() {
		return actCity;
	}

	public void setActCity(String actCity) {
		this.actCity = actCity;
	}

	public String getActZone() {
		return actZone;
	}

	public void setActZone(String actZone) {
		this.actZone = actZone;
	}

	public String getActAddress() {
		return actAddress;
	}

	public void setActAddress(String actAddress) {
		this.actAddress = actAddress;
	}

	public String getActOrganization() {
		return actOrganization;
	}

	public void setActOrganization(String actOrganization) {
		this.actOrganization = actOrganization;
	}

	public String getActEmail() {
		return actEmail;
	}

	public void setActEmail(String actEmail) {
		this.actEmail = actEmail;
	}

	public String getActPhone() {
		return actPhone;
	}

	public void setActPhone(String actPhone) {
		this.actPhone = actPhone;
	}

	public Integer getActTicketTotal() {
		return actTicketTotal;
	}

	public void setActTicketTotal(Integer actTicketTotal) {
		this.actTicketTotal = actTicketTotal;
	}

	public String getActContent() {
		return actContent;
	}

	public void setActContent(String actContent) {
		this.actContent = actContent;
	}

	public byte[] getActCoverPicture() {
		return actCoverPicture;
	}

	public void setActCoverPicture(byte[] actCoverPicture) {
		this.actCoverPicture = actCoverPicture;
	}

	public byte[] getActPicture1() {
		return actPicture1;
	}

	public void setActPicture1(byte[] actPicture1) {
		this.actPicture1 = actPicture1;
	}

	public byte[] getActPicture2() {
		return actPicture2;
	}

	public void setActPicture2(byte[] actPicture2) {
		this.actPicture2 = actPicture2;
	}

	public byte[] getActPicture3() {
		return actPicture3;
	}

	public void setActPicture3(byte[] actPicture3) {
		this.actPicture3 = actPicture3;
	}

	public Integer getActLikeTimes() {
		return actLikeTimes;
	}

	public void setActLikeTimes(Integer actLikeTimes) {
		this.actLikeTimes = actLikeTimes;
	}

	public Integer getActViews() {
		return actViews;
	}

	public void setActViews(Integer actViews) {
		this.actViews = actViews;
	}

	public Integer getActApproalStatus() {
		return actApproalStatus;
	}

	public void setActApproalStatus(Integer actApproalStatus) {
		this.actApproalStatus = actApproalStatus;
	}

	public Integer getActStatus() {
		return actStatus;
	}

	public void setActStatus(Integer actStatus) {
		this.actStatus = actStatus;
	}

	public SellerVO getSeller() {
		return seller;
	}

	public void setSeller(SellerVO seller) {
		this.seller = seller;
	}

	public BigDecimal getActLongitude() {
		return actLongitude;
	}

	public void setActLongitude(BigDecimal actLongitude) {
		this.actLongitude = actLongitude;
	}

	public BigDecimal getActLatitude() {
		return actLatitude;
	}

	public void setActLatitude(BigDecimal actLatitude) {
		this.actLatitude = actLatitude;
	}

	public Integer getActTicketTotalSell() {
		return actTicketTotalSell;
	}

	public void setActTicketTotalSell(Integer actTicketTotalSell) {
		this.actTicketTotalSell = actTicketTotalSell;
	}

	public AdministratorVO getAdmId() {
		return admId;
	}

	public void setAdmId(AdministratorVO admId) {
		this.admId = admId;
	}

	public Timestamp getActLastModifiedTime() {
		return actLastModifiedTime;
	}

	public void setActLastModifiedTime(Timestamp actLastModifiedTime) {
		this.actLastModifiedTime = actLastModifiedTime;
	}

	public String getActResultContent() {
		return actResultContent;
	}

	public void setActResultContent(String actResultContent) {
		this.actResultContent = actResultContent;
	}

	public Set<MemberCollectionVO> getMemCols() {
		return memCols;
	}

	public void setMemCols(Set<MemberCollectionVO> memCols) {
		this.memCols = memCols;
	}

	public Set<ActivityLikeVO> getActLikes() {
		return actLikes;
	}

	public void setActLikes(Set<ActivityLikeVO> actLikes) {
		this.actLikes = actLikes;
	}

	public Set<ActivityCommentVO> getActComs() {
		return actComs;
	}

	public void setActComs(Set<ActivityCommentVO> actComs) {
		this.actComs = actComs;
	}

	public Set<TicketOrderDetailVO> getTicOrdDets() {
		return ticOrdDets;
	}

	public void setTicOrdDets(Set<TicketOrderDetailVO> ticOrdDets) {
		this.ticOrdDets = ticOrdDets;
	}

	@Override
	public String toString() {
		return "ActivityVO [actId=" + actId + ", actName=" + actName + ", actTicketID=" + actTicketID
				+ ", actTicketPrice=" + actTicketPrice + ", actTicketStartTime=" + actTicketStartTime
				+ ", actTicketEndTime=" + actTicketEndTime + ", actType=" + actType + ", actStartDate=" + actStartDate
				+ ", actEndDate=" + actEndDate + ", actStartTime=" + actStartTime + ", actEndTime=" + actEndTime
				+ ", actCity=" + actCity + ", actZone=" + actZone + ", actAddress=" + actAddress + ", actOrganization="
				+ actOrganization + ", actEmail=" + actEmail + ", actPhone=" + actPhone + ", actTicketTotal="
				+ actTicketTotal + ", actContent=" + actContent + ", actCoverPicture="
				+ Arrays.toString(actCoverPicture) + ", actPicture1=" + Arrays.toString(actPicture1) + ", actPicture2="
				+ Arrays.toString(actPicture2) + ", actPicture3=" + Arrays.toString(actPicture3) + ", actLikeTimes="
				+ actLikeTimes + ", actViews=" + actViews + ", actApproalStatus=" + actApproalStatus + ", actStatus="
				+ actStatus + ", actLongitude=" + actLongitude + ", actLatitude=" + actLatitude
				+ ", actTicketTotalSell=" + actTicketTotalSell + ", admId=" + admId + ", actLastModifiedTime="
				+ actLastModifiedTime + ", actResultContent=" + actResultContent + "]";
	}
	
}
