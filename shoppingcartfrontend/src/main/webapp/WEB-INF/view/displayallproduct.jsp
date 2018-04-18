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
<!--  <style> 
.col {
    -webkit-column-count: 3; /* Chrome, Safari, Opera */
    -moz-column-count: 3; /* Firefox */
    column-count: 3;

    -webkit-column-gap: 40px; /* Chrome, Safari, Opera */
    -moz-column-gap: 40px; /* Firefox */
    column-gap: 40px;
}
</style> -->
</head>
<body>

	<div class="container">

		<c:forEach items="${products}" var="product">
			<div class="col-sm-6 col-md-3">
			<div class="well">

				<div class="row">

					<div class="thumbnail">
						<img src="resources/images/${product.id}.PNG" alt="product"
							style="height: 170px; width: 170px; padding: 10px;">
					</div>


						<h4>${product.name}</h4>
						<p><span>Rs. </span>${product.price}</p>
						<p align="right">
							<a href="product/get/${product.id}"><button>View</button></a>
						</p>

	
				</div></div>
			</div>
		</c:forEach>
	</div>
</body>
</html>