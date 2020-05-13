package com.cg.anurag.b2.imsdrmo.dto;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="placingproductorder")
public class ProductOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="orderseq")
	@SequenceGenerator(sequenceName = "orderseq",allocationSize = 1,name = "orderseq")
	@Column(name="orderid")
	private int orderId;
	@Column(name="productname")
	private String productname;
	@Column(name="priceperunit")
	private double priceperunit;
	@Column(name="quantityvalue")
	private double quantityvalue;
	@Column(name="totalprice")
	private double totalprice;
	@Column(name="warehouseid")
	private String warehouseId;
	@Column(name="distributorid")
	private String distributorId;
	@Column(name="dateoforder")
	private LocalDate dateoforder;
	@Column(name="dateofdelivery")
	private LocalDate dateofdelivery;
	@Column(name="manufacturingdate")
	private Date manufacturingdate;
	@Column(name="expirydate")
	private Date expirydate;
	@Column(name="deliverystatus")
	private String deliverystatus;
	@Column(name="productid")
	private String productId;
	public ProductOrder() {}
	public ProductOrder(int orderId, String productname, double priceperunit, double quantityvalue,
			double totalprice, String warehouseId, String distributorId, LocalDate dateoforder, LocalDate dateofdelivery,
			Date manufacturingdate, Date expirydate, String deliverystatus,String productId) {
		this.orderId = orderId;
		this.productname = productname;
		this.priceperunit = priceperunit;
		this.quantityvalue = quantityvalue;
		this.totalprice = totalprice;
		this.warehouseId = warehouseId;
		this.distributorId = distributorId;
		this.dateoforder = dateoforder;
		this.dateofdelivery = dateofdelivery;
		this.manufacturingdate = manufacturingdate;
		this.expirydate = expirydate;
		this.deliverystatus = deliverystatus;
		this.productId=productId;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public double getQuantityvalue() {
		return quantityvalue;
	}
	public void setQuantityvalue(double quantityvalue) {
		this.quantityvalue = quantityvalue;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}
	public LocalDate getDateoforder() {
		return dateoforder;
	}
	public void setDateoforder(LocalDate dateoforder) {
		this.dateoforder = dateoforder;
	}
	public LocalDate getDateofdelivery() {
		return dateofdelivery;
	}
	public void setDateofdelivery(LocalDate dateofdelivery) {
		this.dateofdelivery = dateofdelivery;
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
	public String getDeliverystatus() {
		return deliverystatus;
	}
	public void setDeliverystatus(String deliverystatus) {
		this.deliverystatus = deliverystatus;
	}
	
	
	
}
