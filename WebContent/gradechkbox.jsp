<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="navbar.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search using grade</title>
</head>
<body bgcolor="blanchedAlmond"><!-- bgcolor="blanchedAlmond" -->

<center>
<br><br><br><br><br><br><br>
<h1 style="font-family: Raleway">Search Using Grade</h1>
<br><br><br> 

<div id="design">

<c:form action="mgrade" modelAttribute="multigrade" method="post">

<table >			

<tr>
<td><c:checkboxes items="${deptcbox}" path="emp_Grade"  ></c:checkboxes><br>
<c:hidden path="emp_Marital_Status" value="M" /></td>
</tr>
<tr><td><span style="color: red"><c:errors path="emp_Grade"></c:errors></span></td></tr>
<tr><td colspan=7 align="center">
<input type="submit" value="Submit">
</td>
</tr>
</table>

</c:form>
</div>

</body>
</html>