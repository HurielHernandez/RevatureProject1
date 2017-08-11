package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO
{
	public ArrayList<Reimbursement> readAllReimbursement();
	
	public ArrayList<Reimbursement> readAllReimbursement(int userID);
	
	public boolean updateReimbursment(Reimbursement reimburse);
	
	public boolean createReimbursment(Reimbursement reimburse);
	
}
