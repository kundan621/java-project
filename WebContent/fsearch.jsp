<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %> 
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="resources/homepage.css" rel="stylesheet" type="text/css"> 
    <%@ include file="navbar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	
	#design
	{
		border-radius : 5px; 
		border-color:red;
		background-color: lightblue; /*  #fefbd8; lightsalmon; */
		width: 450px;
		height:200px;			
	}
	h1
	{
		font-family: Raleway;
	}
	table
	{
		border-radius : 5px; 
		background-color : lightred;
		width: 450px;
		height:200px;
		color: red;
	}
	#searchList
	{
		border-radius : 5px;
		width: 200px;
	}
	#box
	{
		border-radius : 5px;
		width: 200px;
	}
	#sub
	{
		border-radius : 5px; 
		background-color: lightorange;
		width: 100px;
		height:25px;
	}

</style>
</head>
<body bgcolor="blanchedAlmond">
<br><br><br>
<br><br><br><br>
<center>
<h1>** Hi... <span style="color: green"><c:forEach items="${user}" var="ser" >${ser.userName}</c:forEach></span> ! Please select the search criteria **</h1>
<br><br><br>
<div id="design">
<f:form action="searchby" method="post" modelAttribute="my">
<table border="1" cellspacing="10" cellpadding="10">

<tr><td>Search using</td><td><select name="FieldSearch" id="searchList">
				<c:forEach items="${fieldsearch}" var="search" >
					<option>${search}</option>
				</c:forEach>
			</select>
			</td></tr>

<tr><td>Type Keyword</td><td><input type="text" id="box" name="search" required pattern="[A-Za-z0-9]{1,20}" title="Alphanumeric inputs are only allowed" 
placeholder="133057 or Kundan "/></td></tr>

<tr><td colspan=2 align="center"><input type="submit" id="sub" value="Search"/></td></tr>

</table>

</f:form>
</div>
</body>
</html>