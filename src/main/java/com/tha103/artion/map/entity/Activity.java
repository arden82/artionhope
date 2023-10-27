package com.tha103.artion.map.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "act_id")
	private Integer actId;
	@Column(name = "act_type")
	private Integer actType;
	@Column(name = "act_latitude")
	private Double actLatitude;
	@Column(name = "act_longitude")
    private Double actLongitude;
	@Column(name = "act_coverPicture")
	private byte[] actCoverPicture;
    @Column(name = "act_name")
    private String actName;
    @Column(name = "act_startDate")
    private Date actStartDate;
    @Column(name = "act_endDate")
    private Date actEndDate;
    @Column(name = "act_startTime")
    private Time actStartTime;
    @Column(name = "act_endTime")
    private Time actEndTime;
    @Column(name = "act_city")
    private String actCity;
    @Column(name = "act_zone")
    private String actZone;
    @Column(name = "act_address")
    private String actAddress;
    @Column(name = "act_views")
    private Integer actViews;
    @Column(name = "act_likeTimes")
    private Integer actLikeTimes;
    
    public Activity() {
	}

	public Activity(Integer actId, Integer actType, Double actLatitude, Double actLongitude, byte[] actCoverPicture,
			String actName, Date actStartDate, Date actEndDate, Time actStartTime, Time actEndTime, String actCity,
			String actZone, String actAddress, Integer actViews, Integer actLikeTimes) {
		this.actId = actId;
		this.actType = actType;
		this.actLatitude = actLatitude;
		this.actLongitude = actLongitude;
		this.actCoverPicture = actCoverPicture;
		this.actName = actName;
		this.actStartDate = actStartDate;
		this.actEndDate = actEndDate;
		this.actStartTime = actStartTime;
		this.actEndTime = actEndTime;
		this.actCity = actCity;
		this.actZone = actZone;
		this.actAddress = actAddress;
		this.actViews = actViews;
		this.actLikeTimes = actLikeTimes;
	}

	public Integer getActId() {
		return actId;
	}

	public void setActId(Integer actId) {
		this.actId = actId;
	}

	public Integer getActType() {
		return actType;
	}

	public void setActType(Integer actType) {
		this.actType = actType;
	}

	public Double getActLatitude() {
		return actLatitude;
	}

	public void setActLatitude(Double actLatitude) {
		this.actLatitude = actLatitude;
	}

	public Double getActLongitude() {
		return actLongitude;
	}

	public void setActLongitude(Double actLongitude) {
		this.actLongitude = actLongitude;
	}

	public byte[] getActCoverPicture() {
		return actCoverPicture;
	}

	public void setActCoverPicture(byte[] actCoverPicture) {
		this.actCoverPicture = actCoverPicture;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
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

	public Integer getActViews() {
		return actViews;
	}

	public void setActViews(Integer actViews) {
		this.actViews = actViews;
	}

	public Integer getActLikeTimes() {
		return actLikeTimes;
	}

	public void setActLikeTimes(Integer actLikeTimes) {
		this.actLikeTimes = actLikeTimes;
	}
}
