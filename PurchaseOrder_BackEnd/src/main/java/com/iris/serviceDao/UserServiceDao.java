package com.iris.serviceDao;

import java.util.List;

import com.iris.models.User;

public interface UserServiceDao {
	public boolean registerUser(User userObj);
	public boolean deleteUser(User userObj);
	public User validateUser(String email,String password);
	public List<User> getAllUsers();
}
