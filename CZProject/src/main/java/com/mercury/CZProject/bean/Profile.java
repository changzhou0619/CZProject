package com.mercury.CZProject.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name ="PROFILE")
public class Profile implements GrantedAuthority{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int profileid;
	
	@Column
	private String type;

	public Profile() {
		super();
	}
	public Profile(int profileid) {
		super();
		this.profileid = profileid;
	}

	public Profile(int profileid, String type) {
		super();
		this.profileid = profileid;
		this.type = type;
	}

	public int getProfileid() {
		return profileid;
	}

	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Profile [profileid=" + profileid + ", type=" + type + "]";
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return type;
	}
	
	
}
