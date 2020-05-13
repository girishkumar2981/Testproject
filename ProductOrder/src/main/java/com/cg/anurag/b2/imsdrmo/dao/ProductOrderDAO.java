package com.cg.anurag.b2.imsdrmo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.anurag.b2.imsdrmo.dto.ProductOrder;

public interface ProductOrderDAO extends JpaRepository<ProductOrder,Integer> {
	public List<ProductOrder> findAllOrdersByDistributorId(String distributorId);
}
