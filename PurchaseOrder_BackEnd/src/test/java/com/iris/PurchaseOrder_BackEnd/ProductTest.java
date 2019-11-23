package com.iris.PurchaseOrder_BackEnd;
import static java.lang.System.out;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iris.daos.ProductDao;
import com.iris.models.Products;
import com.iris.utility.DBConfig;

public class ProductTest {
	private static ProductDao productDaoObj;

	@BeforeClass
	public static void init(){
		out.println("I m in init - start");
		//Created the object of Spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		//Passing the object of Configuration to the Spring container and refershing it
   	 	//context.register(DBConfig.class);
   	 	//context.refresh();
   	 	
   	 	//Asking the object of ProductDao from the spring container so that we can 
   	 	//test its methods.
   	 	productDaoObj=context.getBean(ProductDao.class,"productDao");
   	 	out.println("I m in init - end");
	}
	
	@Test
	public void addProductTest(){
		Products p=new Products();
		p.setProductName("Realme X2 Pro");
		p.setProductDes("Realme Flagship phones");
		p.setProductPrice(30000);		
	
		boolean r=productDaoObj.addProduct(p);
		assertTrue("Problem in Adding User", r);
	}
	
	@Test
	@Ignore
	public void getProductByIdTest(){
		Products productObj=productDaoObj.getProductByName("Realme X2 Pro");
		assertNotNull("Product with given id doesnt exist", productObj);
	}
	
	
	
	@Test
	@Ignore
	public void getAllProductsTest(){
		List<Products> uList=productDaoObj.viewAllProducts();
		Assert.assertNotEquals("Not Users Found...", uList.size(), 0);
	}
	@Test
	@Ignore
	public void deleteProducts(){
		boolean uObj=productDaoObj.deleteProduct(productDaoObj.getProductByName("Realme X2 Pro"));
		assertNotNull("User with given id doesnt exist", uObj);
	}
}
