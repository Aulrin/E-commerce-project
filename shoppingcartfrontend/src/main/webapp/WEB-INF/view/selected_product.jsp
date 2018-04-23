<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.button {
  display: inline-block;
  border-radius: 15px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 15px;
  padding: 10px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
</head>
<body><br><br><br><br>
	<div class="container">
		<div class="row">
			<div class="list-group">
				<div class="media col-md-4">
					<img alt="" src="resources/images/${selectedProduct.id}.PNG">
				</div>
				<div class="col-md-6">
					<table class="table">
						<tr>
							<td style="font-family: sans-serif;font-size: 20px;font: bold;">
							Product Name:</td>
							<td>${selectedProduct.name}</td>
						</tr>
						<tr>
							<td style="font-family: sans-serif;font-size: 20px;font: bold;">
							Price:</td>
							<td>${selectedProduct.price}</td>
						</tr>
						<tr>
							<td style="font-family: sans-serif;font-size: 20px;font: bold;">
							Description</td>
							<td>${selectedProduct.description}</td>

						</tr>
						
						<tr>
						<td></td>
							<td><a href="cart/add/${selectedProduct.id}">
							<button class="button" style="vertical-align:middle">
							<span><span class="glyphicon glyphicon-shopping-cart"></span>
							Add to Cart</span></button></a></td></tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
</body>
</html>