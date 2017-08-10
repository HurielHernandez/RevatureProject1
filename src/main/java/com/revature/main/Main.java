package com.revature.main;

import java.awt.List;
import java.util.ArrayList;

import com.revature.dao.UserDAOImp;
import com.revature.models.User;
import com.revature.util.ConnectionUtility;

public class Main
{
	public static void main(String[] args)
	{
		
		
		userDao();
		
		
	}

	private static void userDao()
	{
		UserDAOImp database = new UserDAOImp();
		ArrayList<User> users = database.readAllUsers();
		
		User user = database.readUser("alpha2c");
		
		user.setEmail("femail@email.com");
		
		boolean updated = database.updateUser(user);
		
		System.out.println("user updated " + updated);
		
		System.out.println(users);
		
		System.out.println(user);
	}
}
