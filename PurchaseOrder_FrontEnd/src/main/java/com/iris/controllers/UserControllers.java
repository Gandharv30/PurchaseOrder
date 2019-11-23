package com.iris.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.models.User;
import com.iris.serviceDao.UserServiceDao;

@Controller
public class UserControllers {
	@Autowired
	UserServiceDao userService;

	// Welcome Page

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getWelcomePage() {

		return "welcome";
	}

	// Get Registration Form
	@RequestMapping(value = "RegisterForm", method = RequestMethod.GET)
	public String getRegistrationForm(ModelMap map) {
	System.out.println("gsdrfsg");
		map.addAttribute("userObj", new User());
		return "RegisterForm";
	}

	// Logic for registering user

	@RequestMapping(value = "/regUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userObj") User userObj) {

		userService.registerUser(userObj);
		ModelAndView mav = new ModelAndView("Login1");
		mav.addObject("msg", "welcome: ");
		return mav;
	}

	// Get Login form
	@RequestMapping(value="loginUser", method = RequestMethod.GET)
	public String getLoginForm() {

		return "Login";
	}
	
	@Autowired
	HttpSession session;
	
	// Susscefully logged in
	@RequestMapping(value = "/only", method = RequestMethod.POST)
	public String loginform(@RequestParam String email, @RequestParam String userPassword) {
		System.out.println(email+ " "+userPassword);
		System.out.println("yo runnin");
		User userObj = userService.validateUser(email, userPassword);
		session.setAttribute("userObj",userObj);
		
		
		if (userObj != null)
		{
			System.out.println("User Obj is not null : "+userObj);
//			if (userObj.getRole().equals("buyer")) {
//				return "BuyerPage";
//				
//			}
//			else if (userObj.getRole().equals("seller")) {
//				return "SellerWelcome";
//			}
			//Add Else
			 if (userObj.getRole().equals("buyer")) {
				return "VendorWelcome";
			}
		}
		else {
			System.out.println("User Obj is  null");
			
		}
		System.out.println("I m in here..");
	return null;

	}
}
