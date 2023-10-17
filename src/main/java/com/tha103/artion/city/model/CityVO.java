package com.tha103.artion.city.model;

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
import com.tha103.artion.area.model.AreaVO;

@Entity
@Table (name= "city")
public class CityVO {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id", updatable = false)
	private Integer cityId;
	
	@Expose
	@Column(name ="city_name")
	private String cityName;
	
//-----------------------以下為OneToMany-----------------------
	@Expose
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	private Set<AreaVO> areas;
	
//-------------------------------------------------------------
	public CityVO() {
		super();
	}

	public CityVO(Integer cityId, String cityName, Set<AreaVO> areas) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.areas = areas;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Set<AreaVO> getAreas() {
		return areas;
	}

	public void setAreas(Set<AreaVO> areas) {
		this.areas = areas;
	}

	@Override
	public String toString() {
		return "CityVO [cityId=" + cityId + ", cityName=" + cityName + "]";
	}
	
}
