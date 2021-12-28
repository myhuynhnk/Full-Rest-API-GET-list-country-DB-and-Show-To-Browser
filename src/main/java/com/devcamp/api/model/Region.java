package com.devcamp.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "regions")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "region_code", unique = true)
	private String regionCode;
	
	@Column(name = "region_name")
	private String regionName;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	@JsonIgnore
	private Country country;
	
	public Region() {
		super();
	}


	public Region(int id, String regionCode, String regionName, Country country) {
		super();
		this.id = id;
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.country = country;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRegionCode() {
		return regionCode;
	}


	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}


	public String getRegionName() {
		return regionName;
	}


	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
}
