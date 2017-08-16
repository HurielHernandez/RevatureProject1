package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.revature.dao.UserDAOImp;
import com.revature.models.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

public class LoginController extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{

		String email = (String) request.getParameter("email");
		String password = (String)request.getParameter("password");
		boolean valid = false;
		
		
		UserDAOImp userDatabase = new UserDAOImp();
		
		User user = userDatabase.readUserE(email);
		
		System.out.println(user);
		
		if(password.equals(user.getPassword())) {
			valid = true;
		}
		
		
		if(valid == false) {
			Gson erGson = new Gson();
			String erJson = erGson.toJson("Error: Invalid email or password!");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter erOut = response.getWriter();
			erOut.write(erJson);
			
			return;
		}
		
		
		System.out.println("LOGIN " + email);

		HttpSession session = request.getSession(true);

		if (session.getAttribute("email") == null || email.equals(session.getAttribute("email"))==false)
		{
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			session.setAttribute("userId", user.getId());
			Gson conGson = new Gson();
			String conJson = conGson.toJson("Successful login");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(conJson);
			
		} else
		{

			Gson gson = new Gson();
			String rJson = gson.toJson("Stored Email: " + session.getAttribute("email") + " Stored password: "
					+ session.getAttribute("password"));

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(rJson);
		}

	}
}
