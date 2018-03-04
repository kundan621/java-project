<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Using Department</title>

</head>
<body bgcolor="blanchedAlmond"> <!-- bgcolor="blanchedAlmond" -->

<center>
<br><br><br><br><br><br><br>

<h1 style="font-family: Raleway">Search Using Department</h1>
<br><br><br> 

<div id="design">

<c:form action="mdepartment" modelAttribute="multidept" method="post">

<table >			

<tr>
<td><c:checkboxes items="${deptcbox}" path="dept_Name"  ></c:checkboxes><br></td></tr>
<tr><td><span style="color: red"><c:errors path="dept_Name"></c:errors></span></td></tr>

<tr><td colspan=6 align="center"><input type="submit" value="Submit"></td></tr>
</table>

</c:form>
</div>

</body>
</html>