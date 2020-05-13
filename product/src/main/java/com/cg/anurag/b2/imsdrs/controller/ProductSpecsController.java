package com.cg.anurag.b2.imsdrs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.anurag.b2.imsdrs.dto.ProductSpecs;
import com.cg.anurag.b2.imsdrs.service.ProductSpecsService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductSpecsController {
@Autowired
ProductSpecsService pss;
@GetMapping("/GetAllProductSpecs")
private ResponseEntity<List<ProductSpecs>> getAllSpecs() 
    {
	List<ProductSpecs> specslist = pss.getAllProductSpecs();
	return new ResponseEntity<List<ProductSpecs>>(specslist, new HttpHeaders(), HttpStatus.OK);
    }
}
