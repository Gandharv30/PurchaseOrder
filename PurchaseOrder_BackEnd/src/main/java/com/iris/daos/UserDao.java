package com.iris.daos;
import java.util.List;

import com.iris.models.User;

public interface UserDao {

	public boolean registerUser(User userObj);
	public boolean deleteUser(User userObj);
	public User validateUser(String email,String password);
	public List<User> getAllUsers();
	public User gettingSeller();
	
}
