package com.revature.models;

import java.sql.Date;

public class Reimbursement
{
	private int id;
	private double amount;
	private String description;
	private Date submitted;
	private Date resolved;
	private String author;
	private int authorId;
	private int resolverId;
	private String resolver;
	private int type;
	private int status;
	
	public Reimbursement(int id, double amount, String description, Date submitted, Date resolved, String author,
			String resolver, int authorId, int resolverId, int type, int status)
	{
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.type = type;
		this.status = status;
		
	}

	public Reimbursement()
	{
		this.id = 0;
		this.amount = 0;
		this.description = null;
		this.submitted = null;
		this.resolved = null;
		this.author = null;
		this.resolver = null;
		this.authorId = 0;
		this.resolverId = 0;
		this.type = 0;
		this.status = 0;
		
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

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public int getAuthorId()
	{
		return authorId;
	}

	public void setAuthorId(int authorId)
	{
		this.authorId = authorId;
	}

	public int getResolverId()
	{
		return resolverId;
	}

	public void setResolverId(int resolverId)
	{
		this.resolverId = resolverId;
	}

	public String getResolver()
	{
		return resolver;
	}

	public void setResolver(String resolver)
	{
		this.resolver = resolver;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "Reimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", submitted="
				+ submitted + ", resolved=" + resolved + ", author=" + author + ", authorId=" + authorId
				+ ", resolverId=" + resolverId + ", resolver=" + resolver + ", type=" + type + ", status=" + status
				+ "]";
	}
	
	
	
	
}
