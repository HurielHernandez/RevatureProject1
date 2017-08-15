package com.revature.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import com.revature.dao.ReimbursementDAOImp;
import com.revature.dao.UserDAOImp;
import com.revature.models.Reimbursement;
import com.revature.models.User;


public class Main
{
	public static void main(String[] args)
	{
		
		
		createReimbursement();
		
		
	}

	private static void userDao()
	{
//		User bob = new User();
//		bob.setUsername("xkcd");
//		bob.setPassword("blackhat");
//		bob.setFirstName("Eric");
//		bob.setLastName("Hontz");
//		bob.setEmail("lawyermail@sharklazers.com");
////		bob.setUserRole(1);
//		
		UserDAOImp userdatabase = new UserDAOImp();
		User user = userdatabase.readUser("alpha2c");
		System.out.println(user);
//		
//		tab.createUser(bob);
		
	}
	
	@SuppressWarnings("deprecation")
	private static void createReimbursement()
	{
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setAmount(9.99);
		reimbursement.setDescription("Java test");
		reimbursement.setSubmitted(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		reimbursement.setAuthorId(41);
		
		ReimbursementDAOImp reimbursementDatabase = new ReimbursementDAOImp();
		boolean created = reimbursementDatabase.createReimbursment(reimbursement);
		
		System.out.println(reimbursement + " " + created);
	}
}
