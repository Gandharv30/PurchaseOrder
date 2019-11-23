package com.iris.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iris.daos.ProductDao;
import com.iris.daos.VendorProductDao;

@Controller
public class VendorProductController {



	@Autowired
	VendorProductDao vendorDaoObj;
	
	@Autowired
	HttpSession session;
	
	
	@Autowired
	ProductDao productDaoObj;
	
}
