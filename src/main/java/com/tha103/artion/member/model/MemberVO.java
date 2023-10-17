package com.tha103.artion.member.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.*;

import com.google.gson.annotations.Expose;
import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.activityCommentLike.model.ActivityCommentLikeVO;
import com.tha103.artion.activityLike.model.ActivityLikeVO;
import com.tha103.artion.commentReport.model.CommentReportVO;
import com.tha103.artion.memberCollection.model.MemberCollectionVO;
import com.tha103.artion.memberLevel.model.MemberLevelVO;
import com.tha103.artion.memberNotify.model.MemberNotifyVO;
import com.tha103.artion.merchOrder.model.MerchOrderVO;
import com.tha103.artion.myPromoCode.model.MyPromoCodeVO;
import com.tha103.artion.ticketOrder.model.TicketOrderVO;

import javax.persistence.CascadeType;

@Entity
@Table(name = "member")
public class MemberVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mem_id")
	private Integer memId;
	
	@Expose
	@Column(name = "mem_name")
	private String memName;
	
	@Expose
	@Column(name = "mem_nickname")
	private String memNickname;
	
	@Expose 
	@Column(name = "mem_account")
	private String memAccount;
	
	@Expose
	@Column(name = "mem_password")
	private String memPassword;
	
	@Expose
	@Column(name = "mem_gender")
	private String memGender;
	
	@Expose
	@Column(name = "mem_birthday")
	private Date memBirthday;
	
	@Expose
	@Column(name = "mem_mobile")
	private String memMobile;
	
	@Expose
	@Column(name = "mem_address")
	private String memAddress;
	
	@Expose
	@Column(name = "mem_registerdTime", updatable = false)
	private Timestamp memRegisterdTime;
	
	@Expose
	@Column(name = "mem_lastModifiedTime", insertable = false, updatable = false)
	private Timestamp memLastModifiedTime;

	//會員(fk)>會員等級(pk)
	@ManyToOne
	@JoinColumn(name = "memLev_level", referencedColumnName = "memLev_level")
	private MemberLevelVO memLevLevel;

	@Expose
	@Column(name = "mem_profilePhoto", columnDefinition = "longblob")
	private byte[] memProfilePhoto;
	
	@Expose
	@Column(name = "mem_totalCost")
	private Integer memTotalCost;
	
//-----------------------以下為OneToMany-----------------------
	//會員(pk)>我的折扣碼(fk)
	@Expose
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private Set<MyPromoCodeVO> mypromocodes;
	
	//會員(pk)>會員通知(fk)
	@Expose
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private Set<MemberNotifyVO> membnots;
	
	//會員(pk)>周邊商品訂單(fk)
	@Expose
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private Set<MerchOrderVO> merOrders;
	
	//會員(pk)>票卷訂單(fk)
	@Expose
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private Set<TicketOrderVO> ticOrders;
	
	//會員(pk)>活動留言(fk)
	@Expose
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private Set<ActivityCommentVO> actComs;
	
	//會員(pk)>留言按讚(fk)
	@Expose
	@OneToMany(mappedBy ="member",cascade = CascadeType.ALL )
	private Set<ActivityLikeVO> actLikes;
	
	//會員(pk)>會員收藏(fk)
	@Expose
	@OneToMany(mappedBy ="member", cascade = CascadeType.ALL)
	private Set<MemberCollectionVO> memCols;
	
	//會員(pk)>會員收藏(fk)
	@Expose
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private Set<ActivityCommentLikeVO>actComLikes;

	//會員(pk)>會員檢舉(fk)
		@Expose
		@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
		private Set<CommentReportVO>ComReps;
	
//-------------------------------------------------------------
		public MemberVO() {
			super();
			// TODO Auto-generated constructor stub
		}

	

	public MemberVO(Integer memId, String memName, String memNickname, String memAccount, String memPassword,
		String memGender, Date memBirthday, String memMobile, String memAddress, Timestamp memRegisterdTime,
		Timestamp memLastModifiedTime, MemberLevelVO memLevLevel, byte[] memProfilePhoto, Integer memTotalCost,
		Set<MyPromoCodeVO> mypromocodes, Set<MemberNotifyVO> membnots, Set<MerchOrderVO> merOrders,
		Set<TicketOrderVO> ticOrders, Set<ActivityCommentVO> actComs, Set<ActivityLikeVO> actLikes,
		Set<MemberCollectionVO> memCols, Set<ActivityCommentLikeVO> actComLikes, Set<CommentReportVO> comReps) {
	super();
	this.memId = memId;
	this.memName = memName;
	this.memNickname = memNickname;
	this.memAccount = memAccount;
	this.memPassword = memPassword;
	this.memGender = memGender;
	this.memBirthday = memBirthday;
	this.memMobile = memMobile;
	this.memAddress = memAddress;
	this.memRegisterdTime = memRegisterdTime;
	this.memLastModifiedTime = memLastModifiedTime;
	this.memLevLevel = memLevLevel;
	this.memProfilePhoto = memProfilePhoto;
	this.memTotalCost = memTotalCost;
	this.mypromocodes = mypromocodes;
	this.membnots = membnots;
	this.merOrders = merOrders;
	this.ticOrders = ticOrders;
	this.actComs = actComs;
	this.actLikes = actLikes;
	this.memCols = memCols;
	this.actComLikes = actComLikes;
	ComReps = comReps;
}



	public Integer getMemId() {
		return memId;
	}



	public void setMemId(Integer memId) {
		this.memId = memId;
	}



	public String getMemName() {
		return memName;
	}



	public void setMemName(String memName) {
		this.memName = memName;
	}



	public String getMemNickname() {
		return memNickname;
	}



	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}



	public String getMemAccount() {
		return memAccount;
	}



	public void setMemAccount(String memAccount) {
		this.memAccount = memAccount;
	}



	public String getMemPassword() {
		return memPassword;
	}



	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}



	public String getMemGender() {
		return memGender;
	}



	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}



	public Date getMemBirthday() {
		return memBirthday;
	}



	public void setMemBirthday(Date memBirthday) {
		this.memBirthday = memBirthday;
	}



	public String getMemMobile() {
		return memMobile;
	}



	public void setMemMobile(String memMobile) {
		this.memMobile = memMobile;
	}



	public String getMemAddress() {
		return memAddress;
	}



	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}



	public Timestamp getMemRegisterdTime() {
		return memRegisterdTime;
	}



	public void setMemRegisterdTime(Timestamp memRegisterdTime) {
		this.memRegisterdTime = memRegisterdTime;
	}



	public Timestamp getMemLastModifiedTime() {
		return memLastModifiedTime;
	}



	public void setMemLastModifiedTime(Timestamp memLastModifiedTime) {
		this.memLastModifiedTime = memLastModifiedTime;
	}



	public MemberLevelVO getMemLevLevel() {
		return memLevLevel;
	}



	public void setMemLevLevel(MemberLevelVO memLevLevel) {
		this.memLevLevel = memLevLevel;
	}



	public byte[] getMemProfilePhoto() {
		return memProfilePhoto;
	}



	public void setMemProfilePhoto(byte[] memProfilePhoto) {
		this.memProfilePhoto = memProfilePhoto;
	}



	public Integer getMemTotalCost() {
		return memTotalCost;
	}



	public void setMemTotalCost(Integer memTotalCost) {
		this.memTotalCost = memTotalCost;
	}



	public Set<MyPromoCodeVO> getMypromocodes() {
		return mypromocodes;
	}



	public void setMypromocodes(Set<MyPromoCodeVO> mypromocodes) {
		this.mypromocodes = mypromocodes;
	}



	public Set<MemberNotifyVO> getMembnots() {
		return membnots;
	}



	public void setMembnots(Set<MemberNotifyVO> membnots) {
		this.membnots = membnots;
	}



	public Set<MerchOrderVO> getMerOrders() {
		return merOrders;
	}



	public void setMerOrders(Set<MerchOrderVO> merOrders) {
		this.merOrders = merOrders;
	}



	public Set<TicketOrderVO> getTicOrders() {
		return ticOrders;
	}



	public void setTicOrders(Set<TicketOrderVO> ticOrders) {
		this.ticOrders = ticOrders;
	}



	public Set<ActivityCommentVO> getActComs() {
		return actComs;
	}



	public void setActComs(Set<ActivityCommentVO> actComs) {
		this.actComs = actComs;
	}



	public Set<ActivityLikeVO> getActLikes() {
		return actLikes;
	}



	public void setActLikes(Set<ActivityLikeVO> actLikes) {
		this.actLikes = actLikes;
	}



	public Set<MemberCollectionVO> getMemCols() {
		return memCols;
	}



	public void setMemCols(Set<MemberCollectionVO> memCols) {
		this.memCols = memCols;
	}



	public Set<ActivityCommentLikeVO> getActComLikes() {
		return actComLikes;
	}



	public void setActComLikes(Set<ActivityCommentLikeVO> actComLikes) {
		this.actComLikes = actComLikes;
	}



	public Set<CommentReportVO> getComReps() {
		return ComReps;
	}



	public void setComReps(Set<CommentReportVO> comReps) {
		ComReps = comReps;
	}



	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memName=" + memName + ", memNickname=" + memNickname + ", memAccount="
				+ memAccount + ", memPassword=" + memPassword + ", memGender=" + memGender + ", memBirthday="
				+ memBirthday + ", memMobile=" + memMobile + ", memAddress=" + memAddress + ", memRegisterdTime="
				+ memRegisterdTime + ", memLastModifiedTime=" + memLastModifiedTime + ", memProfilePhoto="
				+ Arrays.toString(memProfilePhoto) + ", memTotalCost=" + memTotalCost + "]";
	}


	
}
