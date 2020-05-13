package com.cg.anurag.b2.imsdrs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.anurag.b2.imsdrs.dao.ProductSpecsDAO;
import com.cg.anurag.b2.imsdrs.dto.ProductSpecs;

@Service
public class ProductSpecsService {
	@Autowired
	ProductSpecsDAO psd;
	public void setPsd(ProductSpecsDAO psd) {
		this.psd = psd;
	}
	@Transactional
	public List<ProductSpecs> getAllProductSpecs() {
		return psd.findAll();
		
	}

}
