<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>


	<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<ul class="nav navbar-nav navbar-left">
			<li>
				<a class="navbar-brand" href="hom" style="padding: 10px;font-size: 30px;width: 100px;text-align: center;text-decoration: none;margin: 5px 2px;">
				Cart 360</a></li>
				<c:forEach items="${categories}" var="category">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
        <ul class="dropdown-menu">
        						<c:forEach items="${category.products}" var="product">
        
          <li><a href="product/get/${product.id}">${product.name}</a></li>
          </c:forEach>
        </ul>
      </li>
					</c:forEach>
			
		</ul>

		<ul class="nav navbar-nav navbar-right">
		<li><a href="aboutus">About Us</a></li>
		<li><a href="contact">Contact Us</a></li>
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
<b><i>	${welcomeMessage}</i></b>
</body>
</html>