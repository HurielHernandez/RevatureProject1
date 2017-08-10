package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionUtility;

public class ReimbursementDAOImp implements ReimbursementDAO
{

	@Override
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

}
