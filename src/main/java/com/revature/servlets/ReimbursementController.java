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
	
	protected void userIndex(int userId, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
	
		ReimbursementDAOImp reimbursementDatabase = new ReimbursementDAOImp();
		
		ArrayList<Reimbursement> reimbursements  = reimbursementDatabase.readAllReimbursement(userId);
		
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
		
		System.out.println(session.getAttribute("userId") + " EMAIL");
			
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setAmount(Double.parseDouble(request.getParameter("amount").toString()));
		reimbursement.setDescription(request.getParameter("purpose"));
		reimbursement.setSubmitted(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		reimbursement.setAuthorId(Integer.parseInt(session.getAttribute("userId").toString()));
		
		ReimbursementDAOImp reimbursementDatabase = new ReimbursementDAOImp();
		boolean created = reimbursementDatabase.createReimbursment(reimbursement);
		
		System.out.println("reimbursement -"  + reimbursement + " " + created);
		Gson gson = new Gson();
		String rJson = gson.toJson(reimbursement);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(rJson);
		
	}
	
	protected void update(int reimbursementId, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//get User that is logged in
		HttpSession session = request.getSession(true);
				
		System.out.println(session.getAttribute("userId") + " USERID");
		
		ReimbursementDAOImp reimbursementDatabase = new ReimbursementDAOImp();
		
		Reimbursement reimbursement =  reimbursementDatabase.readReimbursement(reimbursementId);
		
		reimbursement.setResolved( new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		reimbursement.setResolverId( Integer.parseInt(session.getAttribute("userId").toString()) );
		reimbursement.setStatus(2);
		
		
		boolean updated = reimbursementDatabase.updateReimbursment(reimbursement);
		
		System.out.println("reimbursement -"  + reimbursement + " " + updated);

		Gson gson = new Gson();
		String rJson = gson.toJson(reimbursement);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(rJson);
		
	}


}
