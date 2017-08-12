package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionUtility;

public class ReimbursementDAOImp implements ReimbursementDAO
{

	public ArrayList<Reimbursement> readAllReimbursement()
	{
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try (Connection connection = ConnectionUtility.getConnectionFromProperties())
		{
			final String SQL = "SELECT * FROM ERS_REIMBURSMENTS";
			pstmt = connection.prepareStatement(SQL);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()  )
			{
				Reimbursement reimbursement= new Reimbursement();
				reimbursement.setId(resultSet.getInt("R_ID"));
				reimbursement.setAmount(resultSet.getDouble("R_AMOUNT"));
				reimbursement.setDescription(resultSet.getString("R_DESPCRIPTION"));
				reimbursement.setSubmitted(resultSet.getDate("R_SUBMITTED"));
				reimbursement.setResolver(resultSet.getString("R_RESOLVER"));
				reimbursement.setAuthorId(resultSet.getInt("UID_AUTHOR"));
				reimbursement.setResolverId(resultSet.getInt("UID_RESOLVER"));
				//add receipt
				//add type
				//add status
				
				reimbursements.add(reimbursement);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}

		return reimbursements;
	
	}
	
	public ArrayList<Reimbursement> readAllReimbursement(int userId)
	{
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try (Connection connection = ConnectionUtility.getConnectionFromProperties())
		{
			final String SQL = "SELECT * FROM ERS_REIMBURSMENTS WHERE U_ID_AUTHOR =?";
			pstmt = connection.prepareStatement(SQL);
			pstmt.setInt(1, userId);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()  )
			{
				Reimbursement reimbursement= new Reimbursement();
				reimbursement.setId(resultSet.getInt("R_ID"));
				reimbursement.setAmount(resultSet.getDouble("R_AMOUNT"));
				reimbursement.setDescription(resultSet.getString("R_DESPCRIPTION"));
				reimbursement.setSubmitted(resultSet.getDate("R_SUBMITTED"));
				reimbursement.setResolver(resultSet.getString("R_RESOLVER"));
				reimbursement.setAuthorId(resultSet.getInt("UID_AUTHOR"));
				reimbursement.setResolverId(resultSet.getInt("UID_RESOLVER"));
				//add receipt
				//add type
				//add status
				
				reimbursements.add(reimbursement);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}

		return reimbursements;
	
	}

	public boolean updateReimbursment(Reimbursement reimburse) {
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		boolean updated = false;
		
		try (Connection connection = ConnectionUtility.getConnectionFromProperties())
		{
			final String SQL = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT=?, R_DESCRIPTION=?, R_SUBMITTED=?, R_RESOLVED=?,"
					+ " U_ID_AUTHOR=?, U_ID_RESOLVER=?, RT_TYPE=?, RT_STATUS=? WHERE R_ID=?";

			pstmt = connection.prepareStatement(SQL);
			pstmt.setDouble(1, reimburse.getAmount());
			pstmt.setString(2, reimburse.getDescription());
			//pstmt.setBlob(3, reimburse.getReciept);
			pstmt.setDate(3, (Date) reimburse.getSubmitted());
			pstmt.setDate(4, (Date) reimburse.getResolved());
			pstmt.setInt(5, reimburse.getAuthorId());
			pstmt.setInt(6, reimburse.getResolverId());
			pstmt.setInt(7, reimburse.getType());
			pstmt.setInt(8, reimburse.getStatus());
			pstmt.setInt(9, reimburse.getId());
			
			int result = pstmt.executeUpdate();
			//get user role
			if (result  > 0)
			{
				updated = true;
			}
		
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		return updated;
	}

	@Override
	public boolean createReimbursment(Reimbursement reimburse) {
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		boolean created = false;
		
		try (Connection connection = ConnectionUtility.getConnectionFromProperties())
		{
			final String SQL = "INSERT INTO ERS_REIMBURSEMENTS (R_AMOUNT, R_DESCRIPTION, R_SUBMITTED, R_RESOLVED,"
					+ " U_ID_AUTHOR, U_ID_RESOLVER=?, RT_TYPE, RT_STATUS) VALUES(?,?,?,?,?,?,?,?) ";

			pstmt = connection.prepareStatement(SQL);
			pstmt.setDouble(1, reimburse.getAmount());
			pstmt.setString(2, reimburse.getDescription());
			//pstmt.setBlob(3, reimburse.getReciept);
			pstmt.setDate(3, (Date) reimburse.getSubmitted());
			pstmt.setDate(4, (Date) reimburse.getResolved());
			pstmt.setInt(5, reimburse.getAuthorId());
			pstmt.setInt(6, reimburse.getResolverId());
			pstmt.setInt(7, reimburse.getType());
			pstmt.setInt(8, reimburse.getStatus());
			
			int result = pstmt.executeUpdate();
			//get user role
			if (result  > 0)
			{
				created  = true;
			}
		
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		return created ;
	}

}


