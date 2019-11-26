package com.iris.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.models.User;
import com.iris.serviceDao.UserServiceDao;

@Controller
public class UserControllers {
//	public boolean checkSession(ModelMap map) {
//
//		if (session.getAttribute("userObj") == null) {
//			map.addAttribute("msg", "Please login again");
//
//			return true;
//		}
//		return false;
//	}

	@Autowired
	UserServiceDao userService;

	// Welcome Page

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getWelcomePage(ModelMap map) {
		

		return "index";
	}

	// Get Registration Form
	@RequestMapping(value = "/RegisterForm", method = RequestMethod.GET)
	public String getRegistrationForm(ModelMap map) {
//		if (checkSession(map)) {
//
//			return "index";
//		}
		System.out.println("gsdrfsg");
		map.addAttribute("userObj", new User());
		return "RegisterForm";
	}

	// Logic for registering user

	@RequestMapping(value = "/regUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("userObj") User userObj, BindingResult result) {
			
		if(result.hasErrors())
		{

			ModelAndView mav = new ModelAndView("RegisterForm");
			return mav;
		}
		else
		{
		userService.registerUser(userObj);
		ModelAndView mav = new ModelAndView("Login");
		
		mav.addObject("msg", "Registration done ");
		return mav;
	}
	}
	// Get Login form
	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public String getLoginForm(ModelMap map) {
//		if (checkSession(map)) {
//
//			return "index";
//		}

		return "Login";
	}

	@Autowired
	HttpSession session;

	// Susscefully logged in
	@RequestMapping(value = "/only", method = RequestMethod.POST)
	public String loginform(@RequestParam String email, @RequestParam String userPassword, ModelMap map) {
//		if (checkSession(map)) {
//
//			return "index";
//		}
		System.out.println(email + " " + userPassword);

		User userObj = userService.validateUser(email, userPassword);

		System.out.println("User Obj in login " + userObj);
		session.setAttribute("userObj", userObj);

		if (userObj != null) {
			System.out.println("User Obj is not null : " + userObj);

			if (userObj.getRole().equals("buyer")) {
				return "BuyerPage";
			} else if (userObj.getRole().equals("Seller")) {
				return "SellerWelcome";
			}

			//
			else if (userObj.getRole().equals("vendor")) {
				return "VendorWelcome";
			}
		} else {
			System.out.println("User Obj is  null");

		}
		System.out.println("I m in here..");
		return null;

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(User userObj, ModelMap map) {
//		if (checkSession(map)) {
//
//			return "index";
//		}
		session.removeAttribute("userObj");
		session.invalidate();
		return "index";
	}
}
