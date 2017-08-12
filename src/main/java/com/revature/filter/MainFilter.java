package com.revature.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainFilter implements Filter
{

	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException
	{
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpServletResponse response = (HttpServletResponse) res;
	
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		
		if(session.getAttribute("email") == null && !req.toString().contains("api"))
			request.getRequestDispatcher("/static/index.html").forward(request, response);
		else {
		        filterChain.doFilter(request, response);
		}


	}

	public void init(FilterConfig arg0) throws ServletException
	{
		// TODO Auto-generated method stub

	}
}
