package com.iris.serviceDaoImpl;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.daos.ProductDao;
import com.iris.models.Products;
import com.iris.serviceDao.ProductServiceDao;

@Service("productService")
@Transactional
public class ProductServiceDaoImpl implements ProductServiceDao {

	
	@Autowired
	ProductDao productDao;
	@Override
	public boolean addProduct(Products productObj) {
		
		return false;
	}

	@Override
	public List<Products> viewAllProducts() {
		
		return productDao.viewAllProducts();
	}

	@Override
	public boolean deleteProduct(Products productObj) {
				return false;
	}

	@Override
	public Products getProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProduct(Products productObj) {
		// TODO Auto-generated method stub
		return false;
	}

}
