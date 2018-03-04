<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="z" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {margin:0;}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
    position: fixed;
    top: 0;
    bottom-margin:70;
    width: 100%;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 20px;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #4CAF50;
}

</style>
</head>
<body>
<br>
<ul>
  <z:choose>
 
  
   <z:when test="${isLoggedIn}">
   <li style="float:right"><a href="logout">Logout [ <z:forEach items="${user}" var="ser" >${ser.userName}</z:forEach> ]</a></li>

	   <li><a href="populatefsearchpara">Simple Search</a></li>
	   <li><a href="populatewsearchpara">Wild Card Search</a></li>
	   <li><a href="multiplesearch.jsp">Multiple Search</a></li>
  
  </z:when>
  <z:otherwise>
   <li><a href="login">Login</a></li>
   </z:otherwise>
  </z:choose>
</ul>


</body>
</html>
