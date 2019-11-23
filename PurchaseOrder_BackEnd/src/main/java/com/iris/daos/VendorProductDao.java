package com.iris.daos;

import java.util.List;

import com.iris.models.Products;
import com.iris.models.VendorProducts;

public interface VendorProductDao {
	//public Products getProductById(int pId) ;
	public List<VendorProducts> viewAllProducts(int id);
	public boolean add(VendorProducts vendorProductObj);
	public VendorProducts checkProductForVendor(int vendorId,int vendorProductId);
}
