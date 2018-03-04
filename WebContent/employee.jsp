<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="navbar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee operations</title>
<style type="text/css">

.list
{
	margin-top:300px;
	margin-left: 800px;
    list-style-type: none;
    background-color: lightblue;
    position: fixed;
    width: 270px;
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
<br><br>
<br><br><br><center>
<h1>** Welcome <span style="color: green"><c:forEach items="${user}" var="ser" >${ser.userName}</c:forEach></span> ! Select the type of search you wish to perform **</h1>
 
	<ul class="list">
		<li class="navigate"><a href="populatefsearchpara" >Simple Search</a></li>
		<li class="navigate"><a href="populatewsearchpara" >Wild Card Search</a></li>
		<li class="navigate"><a href="multiplesearch.jsp" >Multiple Choice Search</a></li>
	</ul>

</body>
</html>