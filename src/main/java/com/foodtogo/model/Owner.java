package com.foodtogo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="owner_table")
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ownerId")
	private int ownerId;
	@Column(name="ownerName")
	private String ownerName;
	@Column(name="address")
	private String address;
	@Column(name="phoneNo")
	private String phoneNo;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="status")
	private String status;
	public Owner() {
		super();
	}
	public Owner(int ownerId, String ownerName, String address, String phoneNo, String email, String password) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", address=" + address + ", phoneNo="
				+ phoneNo + ", email=" + email + ", password=" + password + "]";
	}
	
}


