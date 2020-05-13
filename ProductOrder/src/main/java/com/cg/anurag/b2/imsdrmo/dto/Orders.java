package com.cg.anurag.b2.imsdrmo.dto;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement
public class Orders {
private List<ProductOrder> orders;
public Orders( ) {}
public Orders(List<ProductOrder> orders) {
	
	this.orders = orders;
}
public List<ProductOrder> getOrders() {
	return orders;
}
public void setOrders(List<ProductOrder> orders) {
	this.orders = orders;
}


}
