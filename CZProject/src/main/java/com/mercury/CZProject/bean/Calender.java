package com.mercury.CZProject.bean;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CALENDER")
public class Calender {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int propertycalenderid;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Property property;
	
	@Column
	private Date date;
	
	@Column
	private double cost;
	
	@Column
	private boolean available;

	public Calender() {
		super();
	}

	public Calender(int propertyCalenderId, Property property, Date date, double cost, boolean available) {
		super();
		this.propertycalenderid = propertyCalenderId;
		this.property = property;
		this.date = date;
		this.cost = cost;
		this.available = available;
	}

	public int getPropertyCalenderId() {
		return propertycalenderid;
	}

	public void setPropertyCalenderId(int propertyCalenderId) {
		this.propertycalenderid = propertyCalenderId;
	}

	@JsonIgnore
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Calender [propertyCalenderId=" + propertycalenderid + ", property=" + property + ", date=" + date
				+ ", cost=" + cost + ", available=" + available + "]";
	}
	
	
	
}
