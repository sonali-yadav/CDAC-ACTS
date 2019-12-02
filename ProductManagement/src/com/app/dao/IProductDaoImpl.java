package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Product;

@Repository
@Transactional
public class IProductDaoImpl implements IProductDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Product getById(int pid) {
		System.out.println("inside getById() method");
		return sf.getCurrentSession().get(Product.class, pid);
	}

	@Override
	public String createNewProduct(Product p) {
		System.out.println("inside createNewProduct() method");
		sf.getCurrentSession().save(p);
		return "Product added with ID:"+p.getId();
	}

	@Override
	public String updateProductDetails(Product p) {
		//p is a detached pojo with updated details, we just have to call the update on it.
		sf.getCurrentSession().update(p);
		return "Product updated with ID:"+p.getId();
	}

	@Override
	public String deleteProductDetails(int pid) {
		Session hs=sf.getCurrentSession();
		Product p=hs.get(Product.class, pid);
		if(p!=null) {
			hs.delete(p);
			return "Product deleted successfully!";
		}
		return "Product not found...:-(";
	}

}
