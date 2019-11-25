package com.iris.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.ProductDao;
import com.iris.daos.VendorProductDao;
import com.iris.models.User;
import com.iris.models.VendorProducts;

@Controller
public class VendorProductController {



	@Autowired
	VendorProductDao vendorDaoObj;
	
	@Autowired
	HttpSession session;
	
	
	@Autowired
	ProductDao productDaoObj;
	//////////////////////View All Available Products/////////////////////////
	
	@RequestMapping(value = "/viewAllAvailableProducts", method = RequestMethod.GET)
	public String viewAllAvailableProducts(ModelMap map) {
		
		User userObj=(User)session.getAttribute("userObj");     
		int vendorId=userObj.getUserId();                      //fetch id through session 
		
		map.addAttribute("productDetails", vendorDaoObj.viewAllProducts(vendorId));    //view products added by vendor getallProducts method in vendouproductdao
				
		return "viewAvailableProducts";      //return view product

	}
	
	
	/////////////////////////View All Products///////////////////////
	@RequestMapping(value="viewAllProducts",method=RequestMethod.GET)
	public String viewAllProducts(ModelMap map) {

	map.addAttribute("productDetails", productDaoObj.viewAllProducts());
		return "ViewAllProducts";
	}
	/////////////////////////////getting update quantinty form///////////////////////////////
	@RequestMapping(value="updateProductQuantity",method=RequestMethod.GET)
	public String getUpdateForm(ModelMap map) {
		
		map.addAttribute("productDetails", productDaoObj.viewAllProducts());
		return "updateProductsForm";
	}
	
	/////////////Logic for updating the form///////////////////////////////////
	@RequestMapping(value="updateProductQuantity",method=RequestMethod.POST)
	public ModelAndView updateProducts(@RequestParam int pId  , @RequestParam int quantity) {
		User userObj=(User)session.getAttribute("userObj");		 //get id from session
		System.out.println("I am in update products  "+userObj+" ");
		VendorProducts r=vendorDaoObj.checkProductForVendor(userObj.getUserId(), pId);  //check for product already added if already present then update the quantity else add the quantity
		if(r!=null) {
			System.out.println("the value of r is "+r);
			r.setQuantity(r.getQuantity()+quantity);      //already present then add quantity to existing value
		}
		else {
			r = new VendorProducts();				//else create new object and set values 
			r.setVendorId(userObj.getUserId());
			r.setVendorProductId(pId);
			r.setQuantity(quantity);
		}
		
		vendorDaoObj.add(r);                    //call add method from dao
		
		ModelAndView mv=new ModelAndView("updateProductsForm");
		mv.addObject("msg","Product Quantity Added Succesfully");
		return mv;
		
	}
	
}
