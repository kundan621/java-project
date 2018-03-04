<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="z" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/homepage.css" rel="stylesheet" type="text/css"> 
<%@ include file="navbar.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
	
	#design
	{
		border-radius : 5px; 
		border-color:red;
		background-color: #fefbd8;/* lightsalmon; */
		width: 700px;
		height:250px;			
	}
	h1
	{
		font-family: Raleway;
	}
	table
	{
		border-radius : 5px; 
		background-color: lightred;
		width: 600px;
		height:200px;
	}
	#errorbox
	{
		width: 100px;
	}

</style>
</head>
<body bgcolor="d9ad7c">
<z:if test="${isLoggedIn}">
<jsp:forward page="/employee.jsp"></jsp:forward>
</z:if>
<center>
<br><br><br><br><br><br><br>
<h1>Capgemini Employee Maintenance System</h1>
<br><br><br> 

<div id="design">

<c:form action="validatelogin" modelAttribute="validate">

<table cellspacing="10">
<tr></tr>
<tr></tr>
<tr><td>USER ID </td><td> <c:input path="userId" id="user" placeholder="Enter User ID" pattern="[A-Za-z0-9]{6}"/></td>
<td> <span style="color: red"><c:errors path="userId" id="errorbox"></c:errors>  </span></td>  </tr>   
<tr></tr>
<tr><td>PASSWORD </td><td> 	<c:input type="password" path="userPassword" id="pass" placeholder="Enter Password" pattern="[A-Za-z0-9_@#%$!*&^]{8,20}"/></td>
<td><span style="color: red"><c:errors path="userPassword" id="errorbox"></c:errors> </span> </td></tr>     			
<tr></tr>				
<tr><td>ROLE </td> <td> <c:radiobutton path="userType" value="admin" />Admin&nbsp;&nbsp;
					    <c:radiobutton path="userType" value="employee" />Employee
				</td>
				<td>
					 <span style="color: red">
					 <c:errors path="userType" id="errorbox"></c:errors>  </span> <br></td></tr>
<tr></tr>
<tr></tr>
		<tr><td colspan=2 align="center">&nbsp;<input type="reset" value="Reset" id="res"/>
		&nbsp;<input type="submit" value="Login" id="sub"/></td></tr>
</table>

</c:form>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
<div id="footer"></div>
</body>
</html>