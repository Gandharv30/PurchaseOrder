package com.iris.PurchaseOrder_BackEnd;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iris.daos.UserDao;
import com.iris.models.User;
import com.iris.serviceDao.UserServiceDao;
import com.iris.utility.DBConfig;





public class AppTest { 
	
	
	private static UserServiceDao userServiceObj;
	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
		userServiceObj=context.getBean("userService",UserServiceDao.class);
	}
	
    @Test
    public void registerUser() {
    	System.out.println("I am in register user");
	User userObj=new User();
	userObj.setUserId(10);
	userObj.setUserName("Gandharv");
	userObj.setAddressLine("BA 336 TAGORE GARDEN NEW DELHI");
	userObj.setEmail("pathakgandharv@gmail.com");
	userObj.setUserPassword("abcd");
	userObj.setMobileNumber(99999);
	userObj.setCreatedDate(LocalDate.now());
	userObj.setCreatedBy("system");
	userObj.setRoleId(1);
	userObj.setIdActiveFlag("Y");
	
	System.out.println(userObj);
	
	System.out.println("I am in register user2");
	boolean r;
	r=userServiceObj.registerUser(userObj);
	

Assert.assertTrue("Problem in registering user", r);
}	
    
}
