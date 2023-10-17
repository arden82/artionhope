package com.tha103.artion.memberCollection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.member.model.MemberVO;

@Entity
@Table(name = "membercollection")
public class MemberCollectionVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memCol_serialNumber")	
	private Integer memColSerialNumber;
	
	//會員收藏(fk)>會員(pk)
	@ManyToOne
	@JoinColumn(name = "mem_id",referencedColumnName = "mem_id")
	private MemberVO member;
	
	//會員收藏(fk)>活動(pk)
	@ManyToOne
	@JoinColumn(name = "act_id",referencedColumnName = "act_id")
	private ActivityVO activity;
	
	@Expose
	@Column(name = "memCol_status", columnDefinition = "tinyint")
	private Integer memColStatus;

//-------------------------------------------------------------
	public MemberCollectionVO() {
		super();
	}

	public MemberCollectionVO(Integer memColSerialNumber, MemberVO member, ActivityVO activity, Integer memColStatus) {
		super();
		this.memColSerialNumber = memColSerialNumber;
		this.member = member;
		this.activity = activity;
		this.memColStatus = memColStatus;
	}

	public Integer getMemColSerialNumber() {
		return memColSerialNumber;
	}

	public void setMemColSerialNumber(Integer memColSerialNumber) {
		this.memColSerialNumber = memColSerialNumber;
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

	public Integer getMemColStatus() {
		return memColStatus;
	}

	public void setMemColStatus(Integer memColStatus) {
		this.memColStatus = memColStatus;
	}

	@Override
	public String toString() {
		return "MemberCollectionVO [memColSerialNumber=" + memColSerialNumber + ", memColStatus=" + memColStatus + "]";
	}
	
}
