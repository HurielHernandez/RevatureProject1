package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.dao.ReimbursementDAOImp;
import com.revature.dao.UserDAOImp;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ReimbursementController extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
	
		ReimbursementDAOImp reimbursementDatabase = new ReimbursementDAOImp();
		
		ArrayList<Reimbursement> reimbursements  = reimbursementDatabase.readAllReimbursement();
		
		System.out.println(reimbursements);
		
		Gson gson = new Gson();
		String rJson = gson.toJson(reimbursements);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(rJson);
		
	}
	
	protected void show(int reimbursementId, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println(reimbursementId + "REIMBURSEMENTid");
		ReimbursementDAOImp reimbursementDatabase = new ReimbursementDAOImp();
		
		Reimbursement reimbursement  = reimbursementDatabase.readReimbursement(reimbursementId);

		System.out.println(reimbursement);
		
		Gson gson = new Gson();
		String rJson = gson.toJson(reimbursement);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(rJson);
		
	}
	
	protected void create( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		//get User that is logged in
		HttpSession session = request.getSession(true);
		
		User user = (User) session.getAttribute("User");
		
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setAmount(9.99);
		reimbursement.setDescription(request.getParameter("purpose"));
		reimbursement.setSubmitted(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		reimbursement.setAuthorId(41);
		
		ReimbursementDAOImp reimbursementDatabase = new ReimbursementDAOImp();
		boolean created = reimbursementDatabase.createReimbursment(reimbursement);
		
		
//		user.setUsername((String)request.getParameter("username"));
//		user.setFirstName((String)request.getParameter("firstName"));
//		user.setLastName((String)request.getParameter("lastName"));
//		user.setPassword("temporary password");
//		user.setEmail((String)request.getParameter("email"));
//		
//		int role = 0;
//		user.setUserRole(role);
//		
//		UserDAOImp userdatabase = new UserDAOImp();
//		
//		boolean created = userdatabase.createUser(user);
//		
//		System.out.println("user -"  + user + " " + false);
//
//		Gson gson = new Gson();
//		String rJson = gson.toJson(user);
//		
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		out.write(rJson);
		
	}
	
	protected void update(String username, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
//		UserDAOImp userdatabase = new UserDAOImp();
//		
//		User user = userdatabase.readUser(username);
//		System.out.println(user);
//		
//		user.setUsername((String)request.getParameter("username"));
//		user.setFirstName((String)request.getParameter("firstName"));
//		user.setLastName((String)request.getParameter("lastName"));
//		user.setPassword("temporary password");
//		user.setEmail((String)request.getParameter("email"));		
//		
//		boolean updated = userdatabase.updateUser(user);
//		
//		System.out.println("user -"  + user + " " + updated);
//
//		Gson gson = new Gson();
//		String rJson = gson.toJson(user);
//		
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		out.write(rJson);
		
	}


}
