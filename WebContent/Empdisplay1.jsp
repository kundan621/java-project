<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ include file="navbar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="blanchedAlmond">
<br><br><br><br>
<center>
<h1>Employee Records as follows :</h1><br><br><br>
	<table border="1">
			<tr>
				<th>Employee ID</th><th>First Name</th><th>Last Name</th><th>Date of Birth</th><th>Date of Joining</th><th>Department ID</th>
				<th>Grade</th><th>Designation</th><th>Basic Salary</th><th>Gender</th><th>Marital Status</th><th>Home Address</th>
				<th>Contact Number</th>			
			</tr>
			
		<c:forEach items="${emplist}" var="ser" >
			<tr>				
					<td>${ser.emp_Id}</td>
					<td>${ser.emp_First_Name}</td>
					<td>${ser.emp_Last_Name}</td>
					<td>${ser.emp_Date_Of_Birth}</td>
					<td>${ser.emp_Date_Of_Joining}</td>
					<td>${ser.emp_Dept_Id}</td>
					<td>${ser.emp_Grade}</td>
					<td>${ser.emp_Designation}</td>
					<td>${ser.emp_Basic}</td>
					<td>${ser.emp_Gender}</td>
					<td>${ser.emp_Marital_Status}</td>
					<td>${ser.emp_Home_Address}</td>
					<td>${ser.emp_Contact_Num}</td>							
			</tr>	
		</c:forEach>
		
		</table>
				<br>
		<br>
	<h1>${myq}	</h1>	
</body>
</html>