package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello.php")			//URL pattern,it can be anything i.e. .html,.exe,.php
public class HelloServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String password= request.getParameter("password");
		
	if(name.equals("Heli") && password.equals("1234"))
	{	
				String rememberMe = request.getParameter("rememberMe");
	 			if(rememberMe != null && rememberMe.equals("yes"))
	 			{		 		       
	 			Cookie c1 = new  Cookie("abc", Base64.getEncoder().encodeToString(name.getBytes()));
	 			c1.setMaxAge(60 * 60); // will expire in 1 hour
	 				
	 			Cookie c2 = new  Cookie("xyz", Base64.getEncoder().encodeToString(password.getBytes()));
	 			c2.setMaxAge(60 * 60);
	 				
	 			response.addCookie(c1);
	 			response.addCookie(c2);
	 			}
	response.sendRedirect("Welcome.html");
		
	}
	else
	{
		int attempt=1;int allowed=3;
		String page ="Form.html";
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie: cookies){
				if(cookie.getName().equals("attempt")){
					attempt= Integer.parseInt(cookie.getValue());
					attempt++;
					break;
				}
			}
			
			if(attempt >= allowed)
			{
				page= "logout.html";
			    Cookie cookie = new Cookie("attempt",String.valueOf(attempt));
			    cookie.setMaxAge(60*30);
			}
		}
		Cookie cookie = new Cookie("attempt",String.valueOf(attempt));
		cookie.setMaxAge(60*60);
		response.addCookie( cookie);
		response.sendRedirect(page);
		
	}	
	}
}

		