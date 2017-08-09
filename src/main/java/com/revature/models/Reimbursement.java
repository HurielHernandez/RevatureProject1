package com.revature.models;

import java.util.Date;

public class Reimbursement
{
	private int id;
	private double amount;
	private String description;
	private Date submitted;
	private Date resolved;
	private User author;
	private User resolver;
	private String type;
	private String status;
	
	public Reimbursement(int id, double amount, String description, Date submitted, Date resolved, User author,
			User resolver, String type, String status)
	{
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Date getSubmitted()
	{
		return submitted;
	}

	public void setSubmitted(Date submitted)
	{
		this.submitted = submitted;
	}

	public Date getResolved()
	{
		return resolved;
	}

	public void setResolved(Date resolved)
	{
		this.resolved = resolved;
	}

	public User getAuthor()
	{
		return author;
	}

	public void setAuthor(User author)
	{
		this.author = author;
	}

	public User getResolver()
	{
		return resolver;
	}

	public void setResolver(User resolver)
	{
		this.resolver = resolver;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", submitted="
				+ submitted + ", resolved=" + resolved + ", author=" + author + ", resolver=" + resolver + ", type="
				+ type + ", status=" + status + "]";
	}
	
	
	
	
}
