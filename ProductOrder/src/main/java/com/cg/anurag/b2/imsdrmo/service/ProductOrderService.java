package com.cg.anurag.b2.imsdrmo.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.anurag.b2.imsdrmo.dao.ProductOrderDAO;
import com.cg.anurag.b2.imsdrmo.dto.Orders;
import com.cg.anurag.b2.imsdrmo.dto.ProductOrder;
import com.cg.anurag.b2.imsdrmo.dto.ProductSpecs;

@Service
public class ProductOrderService {
@Autowired
ProductOrderDAO pod;
public void setPod(ProductOrderDAO pod) {
	this.pod = pod;
}
@Transactional
public ProductOrder placeorder(ProductOrder ppo,ProductSpecs pspec,double quantityvalue ) {
	double unitprice=pspec.getPriceperunit();
	ppo.setTotalprice(unitprice*quantityvalue);
	ppo.setProductname(pspec.getProductname());
	ppo.setPriceperunit(pspec.getPriceperunit());
	ppo.setQuantityvalue(quantityvalue);
	ppo.setWarehouseId(pspec.getWarehouseId());
	ppo.setDistributorId(pspec.getDistributorId());
	ppo.setManufacturingdate(pspec.getManufacturingdate());
	ppo.setExpirydate(pspec.getExpirydate());
	ppo.setDeliverystatus("processing");
	LocalDate doo = LocalDate.now();
	ppo.setDateoforder(LocalDate.now());
	LocalDate delivery = doo.plusDays(5);
	ppo.setDateofdelivery(delivery);;
	ppo.setProductId(pspec.getProductId());
return pod.save(ppo);
}
@Transactional
public  ProductOrder trackproductorder(int orderId)
{
	return pod.findById(orderId).get();
}
@Transactional
public Orders getProductOrder(String distributorId,String deliverystatus,LocalDate sd,LocalDate ed)
{
	List<ProductOrder> list = pod.findAllOrdersByDistributorId(distributorId);
	List<ProductOrder> slist=new ArrayList<>();
	for(ProductOrder r : list)
	{
	if(r.getDateoforder().isAfter(sd)&& r.getDateoforder().isBefore(ed)&&r.getDeliverystatus().equalsIgnoreCase(deliverystatus))
	{
		slist.add(r);
		
	}
	}
	Orders o=new Orders();
	o.setOrders(slist);
	return o;
	
}
@Transactional
public boolean updateproductorder(int orderId,String deliverystatus)
{
	ProductOrder v=pod.findById(orderId).get();
	if(v!=null)
	{
		if(v!=null)
		{
			v.setDeliverystatus(deliverystatus);
			return true;
		}
		return false;
	}
	return false;
}
	
}

	
	

