package com.mercury.CZProject.bean;

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
@Table(name="PROPERTYIMG")
public class PropertyImg {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int propertyimgid;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Property property;
	
	@Column
	private String imgurl;

	public PropertyImg() {
		super();
	}

	public PropertyImg(int propertyimgid, Property property, String imgurl) {
		super();
		this.propertyimgid = propertyimgid;
		this.property = property;
		this.imgurl = imgurl;
	}

	public int getPropertyimgid() {
		return propertyimgid;
	}

	public void setPropertyimgid(int propertyimgid) {
		this.propertyimgid = propertyimgid;
	}

	@JsonIgnore
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Override
	public String toString() {
		return "PropertyImg [propertyimgid=" + propertyimgid + ", property=" + property + ", imgurl=" + imgurl + "]";
	}
	
	
}
