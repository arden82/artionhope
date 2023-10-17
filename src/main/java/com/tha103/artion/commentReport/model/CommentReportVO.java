package com.tha103.artion.commentReport.model;

import java.sql.Timestamp;
import javax.persistence.*;

import com.google.gson.annotations.Expose;
import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.member.model.MemberVO;


@Entity
@Table(name = "commentreport")
public class CommentReportVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comRep_serialNumber", updatable = false)
	private Integer comRepSerialNumber;


	@ManyToOne
	@JoinColumn(name = "mem_id", referencedColumnName = "mem_id")
	private MemberVO member;

	@Expose
	@Column(name = "comRep_content")
	private String comRepContent;

	@Expose
	@Column(name = "comRep_time")
	private Timestamp comRepTime;

	// 活動留言檢舉(fk)>活動留言(pk)
	@ManyToOne
	@JoinColumn(name = "actCom_id", referencedColumnName = "actCom_id")
	private ActivityCommentVO actCom;


//-------------------------------------------------------------
	
	public CommentReportVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CommentReportVO(Integer comRepSerialNumber, MemberVO member, String comRepContent, Timestamp comRepTime,
			ActivityCommentVO actCom) {
		super();
		this.comRepSerialNumber = comRepSerialNumber;
		this.member = member;
		this.comRepContent = comRepContent;
		this.comRepTime = comRepTime;
		this.actCom = actCom;
	}


	public Integer getComRepSerialNumber() {
		return comRepSerialNumber;
	}


	public void setComRepSerialNumber(Integer comRepSerialNumber) {
		this.comRepSerialNumber = comRepSerialNumber;
	}


	public MemberVO getMemId() {
		return member;
	}


	public void setMemId(MemberVO member) {
		this.member = member;
	}


	public String getComRepContent() {
		return comRepContent;
	}


	public void setComRepContent(String comRepContent) {
		this.comRepContent = comRepContent;
	}


	public Timestamp getComRepTime() {
		return comRepTime;
	}


	public void setComRepTime(Timestamp comRepTime) {
		this.comRepTime = comRepTime;
	}


	public ActivityCommentVO getActCom() {
		return actCom;
	}


	public void setActCom(ActivityCommentVO actCom) {
		this.actCom = actCom;
	}


	@Override
	public String toString() {
		return "CommentReportVO [comRepSerialNumber=" + comRepSerialNumber + ", comRepContent=" + comRepContent
				+ ", comRepTime=" + comRepTime + "]";
	}

}
