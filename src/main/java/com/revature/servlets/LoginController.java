package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		String password = request.getParameter("password");
		
		System.out.println("LOGIN " + email);

		HttpSession session = request.getSession(true);

		if (session.getAttribute("email") == null)
		{
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			
		} else
		{

			Gson gson = new Gson();
			String rJson = gson.toJson("Stored Email: " + session.getAttribute("email") + "Stored password: "
					+ session.getAttribute("password"));

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(rJson);
		}

	}
}
