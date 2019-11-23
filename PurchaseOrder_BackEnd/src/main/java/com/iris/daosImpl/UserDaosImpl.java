package com.iris.daosImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

	public User validateUser(String email, String userPassword) {
		try {
			Session session = sessionFactory.getCurrentSession();
			
			
			Query query=session.createQuery("from com.iris.models.User where email=:email and userpassword=:password");
			query.setParameter("email", email);
			query.setParameter("password", userPassword);
			List<User> userList=query.list();
			if (userList!=null ) {
					return userList.get(0);
				}
			
			else {
				System.out.println("Invalid id or password");
				session.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
