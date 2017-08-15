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
	ReimbursementController reimbursementController = new ReimbursementController();
	
	
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

//		System.out.println(url[1]);
		if(url.length > 1)
		{
			//www.url/RevautreReimbursement/static/api/{url[1]}/
			switch (url[1])
			{
				case "login":
					loginController.index(request, response);
					break;
				case "users":
					sendToUserController(request, response, url);
					break;
				case "reimbursements":
					sendToReimbursementController(request, response, url);
					break;
				default:
					response.sendRedirect("/RevatureReimbursement/static/index.html");
			}
		}
		
	}

	private void sendToUserController(HttpServletRequest request, HttpServletResponse response, String[] url)
			throws IOException, ServletException
	{
		if (url.length > 2)
		{
			switch (url[2])
			{
				// www.url/RevautreReimbursement/static/api/users/{create}
				case "create":
					System.out.println("CREATE");
					userController.create(request, response);
					break;
				default:
					// www.url/RevautreReimbursement/static/api/users/{username}/create
					if (url.length > 3 && url[3].equals("update"))
						userController.update(url[2], request, response);
					else
						// www.url/RevautreReimbursement/static/api/users/{username}/
						userController.show(url[2], request, response);
				break;
			}
		} else
			// www.url/RevautreReimbursement/static/api/users/
			userController.index(request, response);
	}
	
	private void sendToReimbursementController(HttpServletRequest request, HttpServletResponse response, String[] url)
			throws IOException, ServletException
	{
		if (url.length > 2)
		{
			switch (url[2])
			{
//				// www.url/RevautreReimbursement/static/api/reimbursement/{create}
				case "create":
					System.out.println("CREATE");
					reimbursementController.create(request, response);
					break;
				default:
//					// www.url/RevautreReimbursement/static/api/reimbursement/{username}/update
//					if (url.length > 3 && url[3].equals("update"))
//						userController.update(url[2], request, response);
//					else
//						// www.url/RevautreReimbursement/static/api/reimbursements/{reimbursementId}/
						reimbursementController.show(Integer.parseInt(url[2]), request, response);
//				break;
			}
		} else
			// www.url/RevautreReimbursement/static/api/users/
			reimbursementController.index(request, response);
	}
	
}
