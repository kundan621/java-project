<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="navbar.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

.list
{
	margin-top:300px;
	margin-left: 800px;
    list-style-type: none;
    background-color: lightblue;
    position: fixed;
    width: 340px;
}
.navigate
{
    float: center;
}

.navigate a 
{
    display: block;
    color: black;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 25px;
    align: center;
}
.navigate a:hover:not(.active) 
{
    background-color: lightblue;
}
.active 
{
    background-color: yellow;
}
</style>
</head>

<body bgcolor="blanchedAlmond">
<br><br><br>
<br><br><br><br>
<center>
<h1>** Hi... <span style="color: green"><c:forEach items="${user}" var="ser" >${ser.userName}</c:forEach></span> ! Please select type of Multiple search **</h1>
<br><br>
	<ul class="list">
		<li class="navigate"><a href="multidept" >Search using department</a></li>
		<li class="navigate"><a href="multigrade" >Search using grade</a></li>
		<li class="navigate"><a href="multimarital" >Search using Marital Status</a></li>
	</ul>
</body>
</html>