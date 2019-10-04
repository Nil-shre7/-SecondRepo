package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



		@WebServlet(urlPatterns="/HelloServlet",loadOnStartup=1)
		public class HelloServlet extends HttpServlet{
		       
		    
		@Override
		public void init() throws ServletException {
			System.out.println("init is called..");
		}
			
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				System.out.println("doGet of HelloServlet called..");
			}

			@Override
				public void destroy() {
				System.out.println("destroy of HelloServlet called..");
				}
		

	}



