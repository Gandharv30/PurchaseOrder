package com.iris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.ProductDao;
import com.iris.models.Products;

@Controller
public class POController {
	@Autowired
	ProductDao productdao;

	//vendor-can add products
//	@RequestMapping(value="/addProductForm",method=RequestMethod.GET)
//	public ModelAndView getProductForm(){
//		ModelAndView mv=new ModelAndView("AddProduct");
//		mv.addObject("productObj",new Products());
//		return mv;
//	}
//	
//	
//	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
//	public ModelAndView addProduct(@ModelAttribute("productObj")Products productObj){
//		productdao.addProduct(productObj);
//		
//		ModelAndView mv=new ModelAndView("ViewProducts");
//		mv.addObject("productDetails",productdao.viewAllProducts());
//		return mv;
//	}
	
	@RequestMapping(value = "/RaisePo", method = RequestMethod.GET)
	public String homeController(ModelMap map) {
		
		map.addAttribute("productDetails", productdao.viewAllProducts());
		return "RaisePo";

	}
	
	/*@RequestMapping(value="/viewAllProducts",method=RequestMethod.GET)
	public ModelAndView getAllProducts(){
		ModelAndView mv=new ModelAndView("ViewAllProducts");
		mv.addObject("productDetails",productdao.viewAllProducts());
		return mv;
	}*/
	

	

//	@RequestMapping(value="/addProductNew",method=RequestMethod.POST)
//	public boolean addProductBy(@RequestBody Products proObj){
//		boolean res=productdao.addProduct(proObj);
//		return res;
//	}

}
