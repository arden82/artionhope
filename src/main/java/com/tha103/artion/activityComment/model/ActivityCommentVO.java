package com.tha103.artion.activityComment.model;

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

import com.google.gson.annotations.Expose;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activityCommentLike.model.ActivityCommentLikeVO;
import com.tha103.artion.commentReport.model.CommentReportVO;
import com.tha103.artion.member.model.MemberVO;

@Entity
@Table(name = "activitycomment")
public class ActivityCommentVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actCom_id", updatable = false)
	private Integer actComId;

	// 活動留言(fk)>會員(pk)
	@ManyToOne
	@JoinColumn(name = "mem_id", referencedColumnName = "mem_id")
	private MemberVO member;

	// 活動留言(fk)>活動(pk)
	@ManyToOne
	@JoinColumn(name = "act_id", referencedColumnName = "act_id")
	private ActivityVO activity;

	@Expose
	@Column(name = "actCom_content")
	private String actComContent;

	@Expose
	@Column(name = "actCom_reportTimes")
	private Integer actComReportTimes;

	@Expose
	@Column(name = "actCom_time", insertable = false)
	private Timestamp actComTime;

	@Expose
	@Column(name = "actCom_likeTimes")
	private Integer actComLikeTimes;

	@Expose
	@Column(name = "actCom_coverPicture", columnDefinition = "longblob")
	private byte[] actComCoverPicture;

	@Expose
	@Column(name = "actCom_picture1", columnDefinition = "longblob")
	private byte[] actComPicture1;

	@Expose
	@Column(name = "actCom_picture2", columnDefinition = "longblob")
	private byte[] actComPicture2;

	@Expose
	@Column(name = "actCom_picture3", columnDefinition = "longblob")
	private byte[] actComPicture3;

	@Expose
	@Column(name = "actCom_status", columnDefinition = "tinyint")
	private boolean actComStatus;
	
//-----------------------以下為OneToMany-----------------------
	// 活動留言(pk)>活動留言按讚(fk)
	@Expose
	@OneToMany(mappedBy = "actCom", cascade = CascadeType.ALL)
	private Set<ActivityCommentLikeVO> actComLikes;

	// 活動留言(pk)>活動留言檢舉(fk)
	@Expose
	@OneToMany(mappedBy = "actCom", cascade = CascadeType.ALL)
	private Set<CommentReportVO> comReports;
	
//-------------------------------------------------------------
	public ActivityCommentVO() {
		super();
	}

	public ActivityCommentVO(Integer actComId, MemberVO member, ActivityVO activity, String actComContent,
			Integer actComReportTimes, Timestamp actComTime, Integer actComLikeTimes, byte[] actComCoverPicture,
			byte[] actComPicture1, byte[] actComPicture2, byte[] actComPicture3, boolean actComStatus,
			Set<ActivityCommentLikeVO> actComLikes, Set<CommentReportVO> comReports) {
		super();
		this.actComId = actComId;
		this.member = member;
		this.activity = activity;
		this.actComContent = actComContent;
		this.actComReportTimes = actComReportTimes;
		this.actComTime = actComTime;
		this.actComLikeTimes = actComLikeTimes;
		this.actComCoverPicture = actComCoverPicture;
		this.actComPicture1 = actComPicture1;
		this.actComPicture2 = actComPicture2;
		this.actComPicture3 = actComPicture3;
		this.actComStatus = actComStatus;
		this.actComLikes = actComLikes;
		this.comReports = comReports;
	}

	public Integer getActComId() {
		return actComId;
	}

	public void setActComId(Integer actComId) {
		this.actComId = actComId;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public ActivityVO getActivity() {
		return activity;
	}

	public void setActivity(ActivityVO activity) {
		this.activity = activity;
	}

	public String getActComContent() {
		return actComContent;
	}

	public void setActComContent(String actComContent) {
		this.actComContent = actComContent;
	}

	public Integer getActComReportTimes() {
		return actComReportTimes;
	}

	public void setActComReportTimes(Integer actComReportTimes) {
		this.actComReportTimes = actComReportTimes;
	}

	public Timestamp getActComTime() {
		return actComTime;
	}

	public void setActComTime(Timestamp actComTime) {
		this.actComTime = actComTime;
	}

	public Integer getActComLikeTimes() {
		return actComLikeTimes;
	}

	public void setActComLikeTimes(Integer actComLikeTimes) {
		this.actComLikeTimes = actComLikeTimes;
	}

	public byte[] getActComCoverPicture() {
		return actComCoverPicture;
	}

	public void setActComCoverPicture(byte[] actComCoverPicture) {
		this.actComCoverPicture = actComCoverPicture;
	}

	public byte[] getActComPicture1() {
		return actComPicture1;
	}

	public void setActComPicture1(byte[] actComPicture1) {
		this.actComPicture1 = actComPicture1;
	}

	public byte[] getActComPicture2() {
		return actComPicture2;
	}

	public void setActComPicture2(byte[] actComPicture2) {
		this.actComPicture2 = actComPicture2;
	}

	public byte[] getActComPicture3() {
		return actComPicture3;
	}

	public void setActComPicture3(byte[] actComPicture3) {
		this.actComPicture3 = actComPicture3;
	}

	public boolean getActComStatus() {
		return actComStatus;
	}

	public void setActComStatus(boolean actComStatus) {
		this.actComStatus = actComStatus;
	}

	public Set<ActivityCommentLikeVO> getActComLikes() {
		return actComLikes;
	}

	public void setActComLikes(Set<ActivityCommentLikeVO> actComLikes) {
		this.actComLikes = actComLikes;
	}

	public Set<CommentReportVO> getComReports() {
		return comReports;
	}

	public void setComReports(Set<CommentReportVO> comReports) {
		this.comReports = comReports;
	}

	@Override
	public String toString() {
		return "ActivityCommentVO [actComId=" + actComId + ", actComContent=" + actComContent + ", actComReportTimes="
				+ actComReportTimes + ", actComTime=" + actComTime + ", actComLikeTimes=" + actComLikeTimes
				+ ", actComCoverPicture=" + Arrays.toString(actComCoverPicture) + ", actComPicture1="
				+ Arrays.toString(actComPicture1) + ", actComPicture2=" + Arrays.toString(actComPicture2)
				+ ", actComPicture3=" + Arrays.toString(actComPicture3) + ", actComStatus=" + actComStatus + "]";
	}

}
