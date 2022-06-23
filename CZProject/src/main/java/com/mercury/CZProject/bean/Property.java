package com.mercury.CZProject.bean;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PROPERTY")
public class Property {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int propertyid;
	
	@Column
	@JoinColumn(name="hostid")
	private int userid;
	
	@Column
	private String description;
	
	@Column
	@JoinColumn(name="contact_number")
	private int contactnumber;
	
	@Column
	private Date host_since;
	
	@Column
	private int minimum_time;
	
	@Column
	private int maximum_time;
	
	@Column
	private boolean accssible;
	
	@Column
	private int capacity_max;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(
		name = "PROPERTYTAG",
		joinColumns = {
			@JoinColumn(name = "PROPERTYID", referencedColumnName = "PROPERTYID")
		}, 
		inverseJoinColumns = {
			@JoinColumn(name = "TAGID", referencedColumnName = "TAGID")
		}
	)
	private List<Tag> tags;
	
	@OneToMany(mappedBy = "property")
	private Set<PropertyImg> propertyimgs;

	@Column
	private boolean pet_allowed;
	
	@OneToMany(mappedBy = "property")
	private Set<Calender> calenders;

	public Property() {
		super();
	}

	public Property(int propertyid, int userid, String description, int contactnumber, Date host_since,
			int minimum_time, int maximum_time, boolean accssible, int capacity_max, List<Tag> tags,
			Set<PropertyImg> propertyimgs, boolean pet_allowed, Set<Calender> calenders) {
		super();
		this.propertyid = propertyid;
		this.userid = userid;
		this.description = description;
		this.contactnumber = contactnumber;
		this.host_since = host_since;
		this.minimum_time = minimum_time;
		this.maximum_time = maximum_time;
		this.accssible = accssible;
		this.capacity_max = capacity_max;
		this.tags = tags;
		this.propertyimgs = propertyimgs;
		this.pet_allowed = pet_allowed;
		this.calenders = calenders;
	}

	public int getPropertyid() {
		return propertyid;
	}

	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(int contactnumber) {
		this.contactnumber = contactnumber;
	}

	public Date getHost_since() {
		return host_since;
	}

	public void setHost_since(Date host_since) {
		this.host_since = host_since;
	}

	public int getMinimum_time() {
		return minimum_time;
	}

	public void setMinimum_time(int minimum_time) {
		this.minimum_time = minimum_time;
	}

	public int getMaximum_time() {
		return maximum_time;
	}

	public void setMaximum_time(int maximum_time) {
		this.maximum_time = maximum_time;
	}

	public boolean isAccssible() {
		return accssible;
	}

	public void setAccssible(boolean accssible) {
		this.accssible = accssible;
	}

	public int getCapacity_max() {
		return capacity_max;
	}

	public void setCapacity_max(int capacity_max) {
		this.capacity_max = capacity_max;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Set<PropertyImg> getPropertyimgs() {
		return propertyimgs;
	}

	public void setPropertyimgs(Set<PropertyImg> propertyimgs) {
		this.propertyimgs = propertyimgs;
	}

	public boolean isPet_allowed() {
		return pet_allowed;
	}

	public void setPet_allowed(boolean pet_allowed) {
		this.pet_allowed = pet_allowed;
	}

	public Set<Calender> getCalenders() {
		return calenders;
	}

	public void setCalenders(Set<Calender> calenders) {
		this.calenders = calenders;
	}

	@Override
	public String toString() {
		return "Property [propertyid=" + propertyid + ", userid=" + userid + ", description=" + description
				+ ", contactnumber=" + contactnumber + ", host_since=" + host_since + ", minimum_time=" + minimum_time
				+ ", maximum_time=" + maximum_time + ", accssible=" + accssible + ", capacity_max=" + capacity_max
				+ ", tags=" + tags + ", propertyimgs=" + propertyimgs + ", pet_allowed=" + pet_allowed + ", calenders="
				+ calenders + "]";
	}
	
	
	
}
