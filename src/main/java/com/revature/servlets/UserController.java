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
		
		Gson gson = new Gson();
		String rJson = gson.toJson(users);

		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(rJson);
		
	}

}
