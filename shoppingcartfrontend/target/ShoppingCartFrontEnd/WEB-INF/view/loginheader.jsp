<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>


	<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<ul class="nav navbar-nav navbar-left">
			<li><img src="resources/images/logo.png" alt="website logo"
				style="width: 40px;"><a href="" style="color: White;">
				<font face="georgia"> Cart 360</font> </a></li>
			
		</ul>

		<ul class="nav navbar-nav navbar-right">
		<c:choose><c:when test="${isLoggedIn==true}">
				<li><a href="mycart"><span
						class="glyphicon glyphicon-shopping-cart"></span>
						MyCart(${cartSize})</a></li>

				<li><a href="logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</c:when><c:otherwise>
			<li><a href="registration"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li></c:otherwise></c:choose>
			
		</ul>


	</div>
	</nav>
	${welcomeMessage}
</body>
</html>