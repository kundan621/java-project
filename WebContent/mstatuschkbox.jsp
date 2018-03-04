<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="navbar.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Using Marital Status</title>
</head>
<body bgcolor="blanchedAlmond">

<center>
<br><br><br><br><br><br><br>
<h1 style="font-family: Raleway">Search Using Marital Status</h1>
<br><br><br> 

<h2><span style="color: green">M - Married | S - Single | s - separated | W - Widowed | D - Divorced</span></h2><br>
<div id="design">

<c:form action="mstatus" modelAttribute="multistatus" method="post">

<table>			

<tr>
	<td><c:checkboxes items="${deptcbox}" path="emp_Marital_Status"></c:checkboxes>
		<c:hidden path="emp_Grade" value="M1" /></td>
</tr>

<tr></tr>

<tr><td><span style="color: red"><c:errors path="emp_Marital_Status"></c:errors></span></td></tr>

<tr><td colspan=5 align="center">
<input type="submit" value="Submit">
</td>
</tr>

</table>

</c:form>
</div>

</body>
</html>