package com.tha103.artion.activityLike.model;

import java.sql.Timestamp;
import javax.persistence.*;

import com.google.gson.annotations.Expose;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.member.model.MemberVO;

@Entity
@Table(name = "activitylike")
public class ActivityLikeVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "actLike_id", updatable = false)
	private Integer actLikeId;
	
	//留言按讚(fk)>會員(pk)
	@ManyToOne
	@JoinColumn(name = "mem_id", referencedColumnName = "mem_id")
	private MemberVO member;
	
	//留言按讚(fk)>活動(pk)
	@ManyToOne
	@JoinColumn(name = "act_id", referencedColumnName = "act_id")
	private ActivityVO activity;
	
	@Expose
	@Column(name="actLike_status", columnDefinition = "tinyint")
	private Integer actLikeStatus;
	
	@Expose
	@Column(name="actLike_time",insertable=false)
	private Timestamp actLikeTime;

//-------------------------------------------------------------
	public ActivityLikeVO() {
		super();
	}

	public ActivityLikeVO(Integer actLikeId, MemberVO member, ActivityVO activity, Integer actLikeStatus,
			Timestamp actLikeTime) {
		super();
		this.actLikeId = actLikeId;
		this.member = member;
		this.activity = activity;
		this.actLikeStatus = actLikeStatus;
		this.actLikeTime = actLikeTime;
	}

	public Integer getActLikeId() {
		return actLikeId;
	}

	public void setActLikeId(Integer actLikeId) {
		this.actLikeId = actLikeId;
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

	public Integer getActLikeStatus() {
		return actLikeStatus;
	}

	public void setActLikeStatus(Integer actLikeStatus) {
		this.actLikeStatus = actLikeStatus;
	}

	public Timestamp getActLikeTime() {
		return actLikeTime;
	}

	public void setActLikeTime(Timestamp actLikeTime) {
		this.actLikeTime = actLikeTime;
	}

	@Override
	public String toString() {
		return "ActivityLikeVO [actLikeId=" + actLikeId + ", actLikeStatus=" + actLikeStatus + ", actLikeTime="
				+ actLikeTime + "]";
	}

}