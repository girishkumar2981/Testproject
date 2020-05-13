package com.cg.anurag.b2.imsdrmo.controller;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cg.anurag.b2.imsdrmo.dto.Orders;
import com.cg.anurag.b2.imsdrmo.dto.ProductOrder;
import com.cg.anurag.b2.imsdrmo.dto.ProductSpecs;

import com.cg.anurag.b2.imsdrmo.exception.IdNotFoundException;
import com.cg.anurag.b2.imsdrmo.exception.UnsuccessfullOrder;
import com.cg.anurag.b2.imsdrmo.service.ProductOrderService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductOrderController {
@Autowired
ProductOrderService pos;
public void setRmos(ProductOrderService pos) {
	this.pos = pos;
}
@Autowired
RestTemplate restTemplate;
public void setRestTemplate( RestTemplate  restTemplate)
{
	this.restTemplate= restTemplate;
}

@Bean
public  RestTemplate restTemplate()
{
	return new RestTemplate();
}
@GetMapping(value="/getproductorder/distributorid/{distributorId}/deliverystatus/{deliverystatus}/startDate/{startDate}/endDate/{endDate}",produces= {"application/json","application/xml"})
public ResponseEntity<Orders> getProductOrder(@PathVariable String distributorId,@PathVariable String deliverystatus,@PathVariable String startDate,@PathVariable String endDate)throws ParseException
{
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate sd = LocalDate.parse(startDate, formatter);
	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate ed=LocalDate.parse(endDate,formatter1);
	Orders oo=pos.getProductOrder(distributorId,deliverystatus, sd, ed);
	if(oo!=null)
		return new ResponseEntity<>(oo,HttpStatus.OK);
	else
		return new ResponseEntity("Not successful",HttpStatus.NOT_FOUND);
}
@PostMapping("/placeorder/{quantityvalue}")
public ResponseEntity<ProductOrder> placeorder(@RequestBody ProductSpecs pspec,@PathVariable double quantityvalue)
{
	ProductOrder ppo=new ProductOrder();
	ProductOrder t =pos.placeorder(ppo,pspec,quantityvalue);
	if(t==null) {
		throw new IdNotFoundException("Cannot place order");
	} else {
		return new ResponseEntity<ProductOrder>(t, new HttpHeaders(), HttpStatus.OK);
	}
	}

@GetMapping("/trackorder/{orderId}")
private ResponseEntity<ProductOrder> getorder(@PathVariable int orderId) {
	ProductOrder d = pos.trackproductorder(orderId);
	if (d == null) {
		throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
	} else {
		return new ResponseEntity<ProductOrder>(d, new HttpHeaders(), HttpStatus.OK);
	}
}
@PutMapping("/Updatedeliverystatus/{orderId}/{deliverystatus}")

public ResponseEntity<String> updateorder(@PathVariable int orderId,@PathVariable String deliverystatus)
{
		try
		{
		boolean e = pos.updateproductorder(orderId,deliverystatus);
		if (e==false) {
			return new ResponseEntity<String>("Update details Unsuccessful,Provided Id does not exist",HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>("delivery status updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Update details Unsuccessful,Provided Id does not exist",HttpStatus.NOT_FOUND);
		}
	}
}