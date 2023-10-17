package com.tha103.artion.activityCommentLike.model;


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
import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.member.model.MemberVO;

@Entity
@Table(name = "activitycommentlike")
public class ActivityCommentLikeVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "actComLike_id")
	private Integer actComLikeId;
	
	//留言按讚(fk)>會員(pk)
	@ManyToOne
	@JoinColumn(name = "mem_id", referencedColumnName = "mem_id")
	private MemberVO member;
	
	//留言按讚(fk)>活動留言(pk)
	@ManyToOne
	@JoinColumn(name = "actCom_id", referencedColumnName = "actCom_id")
	private ActivityCommentVO actCom;
	
	@Expose
	@Column(name="actComLike_status", columnDefinition = "tinyint")
	private Integer actComLikeStatus;
	
	@Expose
	@Column(name="actComLike_time")
	private Timestamp actComLikeTime;

//-------------------------------------------------------------
	public ActivityCommentLikeVO() {
		super();
	}

	public ActivityCommentLikeVO(Integer actComLikeId, MemberVO member, ActivityCommentVO actCom,
			Integer actComLikeStatus, Timestamp actComLikeTime) {
		super();
		this.actComLikeId = actComLikeId;
		this.member = member;
		this.actCom = actCom;
		this.actComLikeStatus = actComLikeStatus;
		this.actComLikeTime = actComLikeTime;
	}

	public Integer getActComLikeId() {
		return actComLikeId;
	}

	public void setActComLikeId(Integer actComLikeId) {
		this.actComLikeId = actComLikeId;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public ActivityCommentVO getActCom() {
		return actCom;
	}

	public void setActCom(ActivityCommentVO actCom) {
		this.actCom = actCom;
	}

	public Integer getActComLikeStatus() {
		return actComLikeStatus;
	}

	public void setActComLikeStatus(Integer actComLikeStatus) {
		this.actComLikeStatus = actComLikeStatus;
	}

	public Timestamp getActComLikeTime() {
		return actComLikeTime;
	}

	public void setActComLikeTime(Timestamp actComLikeTime) {
		this.actComLikeTime = actComLikeTime;
	}

	@Override
	public String toString() {
		return "ActivityCommentLikeVO [actComLikeId=" + actComLikeId + ", actComLikeStatus=" + actComLikeStatus
				+ ", actComLikeTime=" + actComLikeTime + "]";
	}
	
}
