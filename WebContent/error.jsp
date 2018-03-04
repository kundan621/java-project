<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="navbar.jsp"%>
<%@page
isErrorPage="true"
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=lightblue>
<center>
<br><br><br><br><br>
<span style="color: red">
<h2>User ID doesn't exist..!</h2><br>
<h3>Redirecting you to Login Page in 2 seconds.......</h3></span>
<%response.setHeader("Refresh","3;url=index.jsp"); %>
</body>
</html>