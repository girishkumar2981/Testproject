package com.cg.anurag.b2.imsdrs.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productspecifications")
public class ProductSpecs {
@Id
@Column(name="productid")
private String productId;
@Column(name="productname")
private String productname;
@Column(name="priceperunit")
private double priceperunit;
@Column(name="manufacturingdate")
private Date manufacturingdate;
@Column(name="expirydate")
private Date expirydate;
@Column(name="distributorid")
private String distributorId;
@Column(name="warehouseid")
private String warehouseId;
public ProductSpecs() {}
public ProductSpecs(String productId, String productname, double priceperunit, Date manufacturingdate,
		Date expirydate, String distributorId, String warehouseId) {
	this.productId = productId;
	this.productname = productname;
	this.priceperunit = priceperunit;
	this.manufacturingdate = manufacturingdate;
	this.expirydate = expirydate;
	this.distributorId = distributorId;
	this.warehouseId = warehouseId;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public double getPriceperunit() {
	return priceperunit;
}
public void setPriceperunit(double priceperunit) {
	this.priceperunit = priceperunit;
}
public Date getManufacturingdate() {
	return manufacturingdate;
}
public void setManufacturingdate(Date manufacturingdate) {
	this.manufacturingdate = manufacturingdate;
}
public Date getExpirydate() {
	return expirydate;
}
public void setExpirydate(Date expirydate) {
	this.expirydate = expirydate;
}
public String getDistributorId() {
	return distributorId;
}
public void setDistributorrId(String distributorId) {
	this.distributorId = distributorId;
}
public String getWarehouseId() {
	return warehouseId;
}
public void setWarehouseId(String warehouseId) {
	this.warehouseId = warehouseId;
}


	}


