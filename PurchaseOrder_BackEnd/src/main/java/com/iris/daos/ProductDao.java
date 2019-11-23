package com.iris.daos;

import java.util.List;

import com.iris.models.Products;

public interface ProductDao {
	public boolean addProduct(Products productObj);
	public List<Products> viewAllProducts();
	public boolean deleteProduct(Products productObj);
	public Products getProductByName(String productName);
	public boolean updateProduct(Products productObj);
}
