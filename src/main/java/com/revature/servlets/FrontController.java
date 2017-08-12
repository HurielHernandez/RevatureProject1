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
//		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
//		
//		reimbursements.add( new Reimbursement(1, "Bob", "Smith", "travel", "pending"));
//		reimbursements.add( new Reimbursement(2, "Jane", "Doe", "travel", "aprroved"));
//		reimbursements.add( new Reimbursement(3, "Jerry", "Dis", "travel", "denied"));
		
//		Gson gson = new Gson();
//		
//		String rJson = gson.toJson(" {User: Huriel Hernndez }" );
//		
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		out.write(rJson);
//		
		
//		request.getRequestDispatcher("/user.html").forward(request, response);
		
		doDispatch(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		doDispatch(request, response);
	}
	
	private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		System.out.println(request.getPathInfo());
		{
			switch(request.getPathInfo())
			{
			case"/login":
				loginController.index(request, response);
				break;
			
			case"/users":
				userController.index(request, response);
				break;
			default:
					response.sendRedirect("/RevatureReimbursement/static/index.html");
			}
		}
		
	}
	
}
