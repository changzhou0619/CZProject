package com.mercury.CZProject.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressid;
	
	@OneToOne
	@JoinColumn(name="propertyid")
	@JsonIgnore
	private Property property;
	
	@Column
	private String country;
	
	@Column
	private String state_province;
	
	@Column
	private String street;
	
	@Column
	private String zipcode;

	public Address() {
		super();
	}

	public Address(int addressid, Property property, String country, String state_province, String street,
			String zipcode) {
		super();
		this.addressid = addressid;
		this.property = property;
		this.country = country;
		this.state_province = state_province;
		this.street = street;
		this.zipcode = zipcode;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	@JsonIgnore
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState_province() {
		return state_province;
	}

	public void setState_province(String state_province) {
		this.state_province = state_province;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", property=" + property + ", country=" + country
				+ ", state_province=" + state_province + ", street=" + street + ", zipcode=" + zipcode + "]";
	}
	
	
}
