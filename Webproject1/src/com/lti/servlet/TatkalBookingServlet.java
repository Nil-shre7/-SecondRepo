package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/TatkalBookingServlet")
public class TatkalBookingServlet extends HttpServlet {
	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
	//	java.util.Date currentTime = new java.util.Date(Date.getTime());
		
		Calendar cal=Calendar.getInstance();
		int currentHour=cal.get(Calendar.HOUR_OF_DAY);
		
		ServletConfig sconfg=getServletConfig();
		System.out.println(sconfg.getServletName());
		
		int startTime=Integer.parseInt(sconfg.getInitParameter("startTime"));
		int endTime=Integer.parseInt(sconfg.getInitParameter("endTime"));
		
	    if( currentHour>=startTime && currentHour<=endTime )
			  out.print("<h1>Welcome to Railway Booking</h1>");
		  else
			  out.print("<h1>Sorry you are late</h1>");
	}

	
}
