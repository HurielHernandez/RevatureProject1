package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAO
{
	public User readUser(String userId);
	
	public ArrayList<User> readAllUsers();
	
	public boolean createUser(User user);
	
	public void UpdateUser(User user);
	
	
}
