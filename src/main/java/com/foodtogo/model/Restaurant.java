package com.foodtogo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurant_table")
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="restId")
	private int restId;
	@Column(name="restName")
	private String restName;
	@Column(name="restAddress")
	private String address;
	@Column(name="phoneNo")
	private String phoneNo;
	@Column(name="imageUrl")
	private String imageUrl;
	@OneToOne
	@JoinColumn(name="owner",referencedColumnName="ownerId")
	private Owner owner;
	public Restaurant() {
		super();
	}
	public Restaurant(int restId, String restName, String address, String phoneNo, Owner owner,String imageUrl) {
		super();
		this.restId = restId;
		this.restName = restName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.owner = owner;
		this.imageUrl=imageUrl;
	}
	
	public int getRestId() {
		return restId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Restaurant [restId=" + restId + ", restName=" + restName + ", address=" + address + ", phoneNo="
				+ phoneNo + ", owner=" + owner + "]";
	}	
}


