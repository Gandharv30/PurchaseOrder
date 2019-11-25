package com.iris.daos;

import java.util.List;

import com.iris.models.Products;
import com.iris.models.VendorProducts;

public interface VendorProductDao {

	public List<Products> viewAllProducts(int id);

	public boolean add(VendorProducts vendorProductObj);

	public Products getProductById(int pId);

	public VendorProducts checkProductForVendor(int vendorId, int productId);

}
