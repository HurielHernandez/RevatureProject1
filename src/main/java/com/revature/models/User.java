package com.revature.models;

public class User
{
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int userRole;
	
	public User()
	{
		this.id = 0;
		this.username  = null;
		this.password = null;
		this.firstName = null;
		this.lastName = null;
		this.email = null;
		this.userRole = 0;
	}
	
	public User(int id, String username, String password, String firstName, String lastName, String email,
			int userRole)
	{

		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getUserRole()
	{
		return userRole;
	}

	public void setUserRole(int userRole)
	{
		this.userRole = userRole;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", userRole=" + userRole + "]";
	}
	
	
	
}
