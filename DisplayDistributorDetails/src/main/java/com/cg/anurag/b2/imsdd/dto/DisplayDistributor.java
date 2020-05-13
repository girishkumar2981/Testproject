package com.cg.anurag.b2.imsdd.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="displaydistributor")
public class DisplayDistributor {
	
	@Id
	@Column(name="distributorid")
	String distributorId;
	@Column(name="name")
	String name;
	@Column(name="address")
	String address;
	@Column(name="phoneno")
	String phoneno;
	public DisplayDistributor() {}
	public DisplayDistributor(String distributorId, String name, String address, String phoneno) {
		this.distributorId = distributorId;
		this.name = name;
		this.address = address;
		this.phoneno = phoneno;
	}
	public String getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
}
