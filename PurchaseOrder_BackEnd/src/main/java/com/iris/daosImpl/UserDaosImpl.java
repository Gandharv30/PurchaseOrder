package com.iris.daosImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.UserDao;
import com.iris.models.User;

@Repository("userDao")
public class UserDaosImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
    

	public boolean registerUser(User userObj) {
		try {
			
			System.out.println("I m in register User method...");
			Session session = sessionFactory.getCurrentSession();
			session.save(userObj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(User userObj) {
		
		return false;
	}

	public List<User> getAllUsers() {
	
		return null;
	}

	public User validateUser(String email, String password) {
		try {
			Session session = sessionFactory.getCurrentSession();
			User userObj = session.get(User.class, email);
			if (userObj != null) {
				if (userObj.getUserPassword().equals(password)) {
					return userObj;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
