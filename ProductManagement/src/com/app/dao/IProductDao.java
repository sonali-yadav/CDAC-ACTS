package com.app.dao;

import com.app.pojos.Product;

public interface IProductDao {

	Product getById(int pid);
	String createNewProduct(Product p); 	//p is a transient pojo ref
	String updateProductDetails(Product p);	//p is a detached pojo ref
	String deleteProductDetails(int pid);
}
