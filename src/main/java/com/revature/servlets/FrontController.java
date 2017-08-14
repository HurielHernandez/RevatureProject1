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

public class FrontController extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8722323755383333155L;
	
	
	UserController userController = new UserController();
	LoginController loginController = new LoginController();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		doDispatch(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		doDispatch(request, response);
	}
	
	private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		String[] url = request.getPathInfo().split("/");
		
		for(String u : url)
			System.out.println("I" + u);
		
		System.out.println(url[1]);
		
		{
			switch(url[1])
			{
				case"login":
					loginController.index(request, response);
					break;
				
				case"users":
					if (url.length > 2)
					{
						System.out.println("users-" + url[1]);
						switch (url[2])
						{
							case "create":
								System.out.println("creaet User");
								userController.create(request, response);
								break;
		
							default:
								userController.show(url[2], request, response);
								break;
						}
					} else
						userController.index(request, response);
					break;
				default:
						response.sendRedirect("/RevatureReimbursement/static/index.html");
				}
		}
		
	}
	
}
