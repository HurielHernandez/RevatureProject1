package com.revature.dao;

import java.util.ArrayList;
import java.sql.Connection;
import com.revature.util.ConnectionUtility;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.models.User;

public class UserDAOImp implements UserDAO
{

	public User readUser(String username)
	{
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		User returnUser = new User();

		try (Connection connection = ConnectionUtility.getConnectionFromProperties())
		{
			final String SQL = "SELECT * FROM ERS_USERS WHERE U_USERNAME = ?";
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1, username);
			resultSet = pstmt.executeQuery();

			while (resultSet.next())
			{
				returnUser.setId(resultSet.getInt("U_ID"));
				returnUser.setUsername(resultSet.getString("U_USERNAME"));
				returnUser.setEmail(resultSet.getString("U_EMAIL"));
				returnUser.setFirstName(resultSet.getString("U_FIRSTNAME"));
				returnUser.setLastName(resultSet.getString("U_LASTNAME"));
				returnUser.setPassword(resultSet.getString("U_PASSWORD"));
				
				//add userrole

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}

		return returnUser;

	}
	
	@Override
	public ArrayList<User> readAllUsers()
	{
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		ArrayList<User> users = new ArrayList<User>();

		try (Connection connection = ConnectionUtility.getConnectionFromProperties())
		{
			final String SQL = "SELECT * FROM ERS_USERS";
			pstmt = connection.prepareStatement(SQL);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()  )
			{
				User user = new User();
				user.setId(resultSet.getInt("U_ID"));
				user.setUsername(resultSet.getString("U_USERNAME"));
				user.setEmail(resultSet.getString("U_EMAIL"));
				user.setFirstName(resultSet.getString("U_FIRSTNAME"));
				user.setLastName(resultSet.getString("U_LASTNAME"));
				user.setPassword(resultSet.getString("U_PASSWORD"));				
				//add userrole
				
				users.add(user);

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}

		return users;
	}

	public boolean createUser(User user)
	{
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		boolean created = false;
		
		try (Connection connection = ConnectionUtility.getConnectionFromProperties())
		{
			final String SQL = "INSERT INTO ERS_USERS ( U_USERNAME, U_EMAIL, U_FIRSTNAME, U_LASTNAME, U_PASSWORD ) "
								+ "VALUES ( ?, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getPassword());
			
			resultSet = pstmt.executeQuery();
			//get user role
			if (resultSet.next())
			{
				created = true;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		return created;
	}

	@Override
	public boolean updateUser(User user)
	{
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		boolean updated = false;
		
		try (Connection connection = ConnectionUtility.getConnectionFromProperties())
		{
			final String SQL = "UPDATE ERS_USERS SET U_USERNAME=?, U_EMAIL=?, U_FIRSTNAME=?, U_LASTNAME=?, U_PASSWORD=? WHERE U_ID =?";

			pstmt = connection.prepareStatement(SQL);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getPassword());
			pstmt.setInt(6, user.getId());
			
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



}
