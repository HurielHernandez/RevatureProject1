package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.dao.UserDAOImp;
import com.revature.models.User;


public class UserController extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	protected void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
	
		UserDAOImp userdatabase = new UserDAOImp();
		
		ArrayList<User> users  = userdatabase.readAllUsers();
		
		System.out.println(users);
		
		Gson gson = new Gson();
		String rJson = gson.toJson(users);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(rJson);
		
	}
	
	protected void show(String username, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println(username + "USRERERES");
		UserDAOImp userdatabase = new UserDAOImp();
		
		User user  = userdatabase.readUser(username);
		
		System.out.println(user);
		
		Gson gson = new Gson();
		String rJson = gson.toJson(user);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(rJson);
		
	}
	
	protected void create( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		User user = new User();
		
		user.setUsername((String)request.getParameter("username"));
		user.setFirstName((String)request.getParameter("firstName"));
		user.setLastName((String)request.getParameter("lastName"));
		user.setPassword("temporary password");
		user.setEmail((String)request.getParameter("email"));
		
		int role = 0;
		user.setUserRole(role);
		
		UserDAOImp userdatabase = new UserDAOImp();
		
		boolean created = userdatabase.createUser(user);
		
		System.out.println("user -"  + user + " " + false);

		Gson gson = new Gson();
		String rJson = gson.toJson(user);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(rJson);
		
	}
	
	protected void update(String username, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		UserDAOImp userdatabase = new UserDAOImp();
		
		User user = userdatabase.readUser(username);
		System.out.println(user);
		
		user.setUsername((String)request.getParameter("username"));
		user.setFirstName((String)request.getParameter("firstName"));
		user.setLastName((String)request.getParameter("lastName"));
		user.setPassword("temporary password");
		user.setEmail((String)request.getParameter("email"));		
		
		boolean updated = userdatabase.updateUser(user);
		
		System.out.println("user -"  + user + " " + updated);

		Gson gson = new Gson();
		String rJson = gson.toJson(user);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(rJson);
		
	}

}
