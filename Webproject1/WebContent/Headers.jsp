<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String agent=request.getHeader("user-agent");
%>
<h1><%=agent %></h1>


<h2><%= LocalDateTime.now() %></h2>
<%
//response.setHeader("Refresh","2");

//response.setHeader("Refresh","5;URL=http://www.google.com");
%>



</body>
</html>