package com.devcamp.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name= "countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name= "country_code", unique = true)
	private String countryCode;
	
	@Column(name ="country_name")
	private String countryName;
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Region> regions;
	
	public Country() {
		super();
	}

	public Country(int id, String countryCode, String countryName, Set<Region> regions) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.regions = regions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Set<Region> getRegions() {
		return regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}
	
	
	
}
