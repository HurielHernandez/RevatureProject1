package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAO
{
	public User readUser(String userId);
	
	public User readUserE(String userEmail);
	
	public ArrayList<User> readAllUsers();
	
	public boolean createUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
	
}
