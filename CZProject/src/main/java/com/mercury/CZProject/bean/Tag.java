package com.mercury.CZProject.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tag")
public class Tag {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tagid;
	
	@Column
	private String tagname;

	public Tag() {
		super();
	}

	public Tag(int tagid, String tagname) {
		super();
		this.tagid = tagid;
		this.tagname = tagname;
	}

	public int getTagid() {
		return tagid;
	}

	public void setTagid(int tagid) {
		this.tagid = tagid;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	@Override
	public String toString() {
		return "Tag [tagid=" + tagid + ", tagname=" + tagname + "]";
	}
	
	
}
