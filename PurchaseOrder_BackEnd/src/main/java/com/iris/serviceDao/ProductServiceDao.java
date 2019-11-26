package com.iris.serviceDao;

import java.util.List;

import com.iris.models.Products;

public interface ProductServiceDao {
	public boolean addProduct(Products productObj);
	public List<Products> viewAllProducts();
	public boolean deleteProduct(Products productObj);
	public Products getProductByName(String productName); //commented
	public boolean updateProduct(Products productObj);
}
