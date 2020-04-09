package com.sd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sd.hib.User;
import com.sd.util.SDUtils;

public class RegistrationController extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public RegistrationController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	 /**
	  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	  */
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.sendRedirect("userenrollment.jsp");
	 }

	 /**
	  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	  */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String msg = "Password and Conform Passwords must be same";
	  String page = "userenrollment.jsp";
	  if(request.getParameter("password").equals(request.getParameter("confPassword")))
	  {
		   User user = new User();
		   user.setUsername(request.getParameter("userId"));
		   user.setPassword(request.getParameter("password"));
		   user.setFirst_name(request.getParameter("firstName"));
		   user.setLast_name(request.getParameter("lastName"));
		   user.setDob("26/09/1983");
		   user.setEmail_id(request.getParameter("email"));
		   
		   user.setId(SDUtils.generateUniqueKey());
		   
		   System.out.println(user.toString());
		   SmartDocDao baseDao = new SmartDocDaoImpl();
		   boolean result = baseDao.register(user);
		   if(result)
			   page = "loginpage.jsp";
		   else
			   page = "enrollfailed.jsp";
	   
		   msg = baseDao.getResponseMessage();
	  } 
	  request.setAttribute("msg2", msg);
	  request.getRequestDispatcher(page).include(request, response);
	 }

	}