package com.tha103.artion.memberLevel.model;

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
import com.tha103.artion.member.model.MemberVO;

@Entity
@Table(name = "memberlevel")
public class MemberLevelVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memLev_level")
	private Integer memLevLevel;
	
	@Expose
	@Column(name = "memLev_levelName")
	private String memLevLevelName;
	
	@Expose
	@Column(name = "memLev_minimunOrder")
	private Integer memLevMinimunOrder;

//-----------------------以下為OneToMany-----------------------
	//會員等級(pk)>會員(fk)
	@Expose
	@OneToMany(mappedBy = "memLevLevel", cascade = CascadeType.ALL)
	private Set<MemberVO> members;
//-------------------------------------------------------------
	public MemberLevelVO() {
		super();
	}

	public MemberLevelVO(Integer memLevLevel, String memLevLevelName, Integer memLevMinimunOrder,
			Set<MemberVO> members) {
		super();
		this.memLevLevel = memLevLevel;
		this.memLevLevelName = memLevLevelName;
		this.memLevMinimunOrder = memLevMinimunOrder;
		this.members = members;
	}

	public Integer getMemLevLevel() {
		return memLevLevel;
	}

	public void setMemLevLevel(Integer memLevLevel) {
		this.memLevLevel = memLevLevel;
	}

	public String getMemLevLevelName() {
		return memLevLevelName;
	}

	public void setMemLevLevelName(String memLevLevelName) {
		this.memLevLevelName = memLevLevelName;
	}

	public Integer getMemLevMinimunOrder() {
		return memLevMinimunOrder;
	}

	public void setMemLevMinimunOrder(Integer memLevMinimunOrder) {
		this.memLevMinimunOrder = memLevMinimunOrder;
	}

	public Set<MemberVO> getMembers() {
		return members;
	}

	public void setMembers(Set<MemberVO> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "MemberLevelVO [memLevLevel=" + memLevLevel + ", memLevLevelName=" + memLevLevelName
				+ ", memLevMinimunOrder=" + memLevMinimunOrder + "]";
	}
	

}
