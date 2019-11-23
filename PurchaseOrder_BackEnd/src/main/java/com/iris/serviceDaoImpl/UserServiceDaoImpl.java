package com.iris.serviceDaoImpl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.daos.UserDao;
import com.iris.models.User;
import com.iris.serviceDao.UserServiceDao;

@Service("userService")
@Transactional
public class UserServiceDaoImpl implements UserServiceDao {
	
	@Autowired 
	UserDao userDao;

	public boolean registerUser(User userObj) {
	 
	 userObj.setRole("buyer");
	 userObj.setIsActive("Y");
	 userObj.setCreatedBy("System");
	 userObj.setCreatedDate(LocalDate.now());
	 
	// System.out.println("User Obj : "+userObj);
	
	 
	 boolean b= userDao.registerUser(userObj);
	 
	 if(b!=false) {
		 return true;
	 }
		return false;
	}

	public boolean deleteUser(User userObj) {

		return false;
	}

	public User validateUser(String email, String userPassword) {
		return userDao.validateUser(email, userPassword);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
