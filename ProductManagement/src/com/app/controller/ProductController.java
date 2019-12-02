package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dao.IProductDao;
import com.app.pojos.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private IProductDao pdao;
	
	public ProductController() {
		System.out.println("inside ProductController() constructor");	
	}
	
	//REQUEST HANDLING METHOD TO GET A PRODUCT BY ID
	//EXAMPLE OF GET MAPPING 
	
	@GetMapping("/{pid}")
	public ResponseEntity<?> getProductDetails(@PathVariable int pid) {
		System.out.println("inside getProductDetails() of rest controller...");
		Product p=pdao.getById(pid);
		if (p!=null) {
			return new ResponseEntity<Product>(p,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid Product Id...:-(",HttpStatus.NOT_FOUND);
	}
	
	//REQUEST HANDLING METHOD TO CREATE A NEW PRODUCT
	//EXAMPLE OF POST MAPPING
	
	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody Product p) {
		try {
			// SC=201 FOR CREATED
		return new ResponseEntity<String>(pdao.createNewProduct(p),HttpStatus.CREATED);
		} catch (RuntimeException e) {
			// SC=500 FOR INTERNAL_SERVER_ERROR
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//REQUEST HANDLING METHOD TO UPDATE A PRODUCT'S DETAILS
	//EXAMPLE OF PUT MAPPING
	
	
	
	//REQUEST HANDLING METHOD TO DELETE A PRODUCT BY ID
	//EXAMPLE OF DELETE MAPPING 
	
	
	
}