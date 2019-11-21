package com.iris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iris.models.User;
import com.iris.serviceDao.UserServiceDao;
@Controller
public class UserControllers {
	@Autowired 
	UserServiceDao userService;
	
//	@RequestMapping(value="/",method=RequestMethod.POST)
//	public String getWelcomePage(ModelMap map) {
//
//	//	map.addAttribute
//		
//		return "welcome";
//	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getRegistrationForm(ModelMap map) {
		
		map.addAttribute("userObj",new User());
		return "RegisterForm";
	}
	
	
	
	
	 @RequestMapping("/regUser")
	public ModelAndView registerUser(@ModelAttribute("userObj") User userObj,  BindingResult result) {
		 userService.registerUser(userObj);
		 ModelAndView mav= new ModelAndView("Login1");
		mav.addObject("msg","welcome: ");
			return mav;
		}
		
	
	}
	 

