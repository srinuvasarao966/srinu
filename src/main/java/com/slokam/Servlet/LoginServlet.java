package com.slokam.Servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.slokam.StudentDAO.StudentDAO;


public class LoginServlet extends GenericServlet
{


	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		 System.out.println("USer Name :" + username);
		 System.out.println("Password :" + password);
		boolean result=StudentDAO.validateUser(username, password);
		
		if(result)
		{
			RequestDispatcher rd=req.getRequestDispatcher("StudentSignup.jsp");
			rd.forward(req, res);
		}
		else
		{
			req.setAttribute("message", "Please provide correct Username/Password");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}
	}
}
