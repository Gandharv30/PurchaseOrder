package com.iris.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.ProductDao;
import com.iris.daos.PuchaseOrderDao;
import com.iris.daos.UserDao;
import com.iris.models.POItems;
import com.iris.models.Products;
import com.iris.models.PurchaseOrder;
import com.iris.models.User;
import com.iris.serviceDao.ProductServiceDao;

@Controller
public class POController {
	public boolean checkSession(ModelMap map) {

        if(session.getAttribute("rObj")==null)
        {
               map.addAttribute("msg", "Please login again");
                                                        

        return true;
        }
        return false;
        }


	
	@Autowired
	ProductServiceDao productService;
	
	@RequestMapping(value = "/raisepo", method = RequestMethod.GET)
	public ModelAndView viewAllProducts(ModelMap map) {
//		if(checkSession(map)) {
//            
//            return new ModelAndView("index");
// }

		
		
		System.out.println("Product Details : "+productService.viewAllProducts());
		
		ModelAndView mv=new ModelAndView("raisePO1");
		mv.addObject("productDetails", productService.viewAllProducts());
		return mv;
    }
	

	@Autowired
	HttpSession session;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	PuchaseOrderDao poDao;
	
	@RequestMapping(value="/raisePO",method=RequestMethod.POST)
	public String raisePurchaseOrder(@RequestBody List<POItems> poItemsList,ModelMap map) {
		if(checkSession(map)) {
            
            return "index";
 }

		
		System.out.println("I m raising purchasing order");
		
		User userObj=(User)session.getAttribute("userObj");
		
		System.out.println("I am in raise Purchase Order "+userObj);
		System.out.println("i m in");
		
		PurchaseOrder poObj=new PurchaseOrder();
		poObj.setBuyerObj(userObj);
		poObj.setSellerObj(userDao.gettingSeller());
		poObj.setStatus("sent to seller");
		poObj.setCreatedDate(LocalDate.now());
		
		System.out.println(userDao.gettingSeller());
		
	
	
		
		
		for(POItems obj:poItemsList) {
			obj.setProductObj(productDao.getProductById(obj.getProductId()));
			obj.setPurchaseOrderObj(poObj);
		}
		
		poObj.setPoItemsObj(poItemsList);
		System.out.println("hello there"+poObj);
				
		System.out.println("Purchase Order : "+poObj);
		
		
		poDao.addPO(poObj);
		
		map.addAttribute("msg","Purchase Order has been raised succesfully...");
		return "SuccessLog";
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="/getProductNameById",method=RequestMethod.GET)
	public Products getProductById(@RequestParam int productId) {
		
		Products pObj=productDao.getProductById(productId);
		return pObj;
	}
	
	@RequestMapping(value="/viewPOs",method=RequestMethod.GET)
	public String  viewPOs(ModelMap map,@RequestParam(required=false)String message) {
//		if(checkSession(map)) {
//            
//            return "index";
// }

		
		
		List<PurchaseOrder> poList=poDao.viewAllPo();
		System.out.println(poList);
		map.addAttribute("poList",poList);
		session.setAttribute("poList", poList);
		return "SellerPOs";
	}
	
	}



