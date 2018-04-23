<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
  padding: 5px 15px;
  font-size: 15px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 4px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style></head>
<body>
	${supplierSuccessMessage} ${supplierErrorMessage}
	<!-- create 3 text fields -->
	<div class="container">
		<form action="supplier/save/" method="post">
			<table class="table table-bordered" style="background-color: ghostwhite;">
				<tr>
					<td>ID</td>
					<td><input type="text" name='id'
						value="${selectedSupplier.id}"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name='name'
						value="${selectedSupplier.name}"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name='address'
						value="${selectedSupplier.address}"></td>
			</table>
			<div class="container">
				<input type="submit" value='Create Supplier' class="button">
			</div>
		</form>
	</div>
	<br>
	<br>
	<div class="container">
		<table class="table table-bordered">
			<tr style="background-color: black;color: white;">
				<td>Supplier ID</td>
				<td>Supplier Name</td>
				<td>Supplier Address</td>
				<td>Action</td>
			</tr>
			<c:forEach var="supplier" items="${suppliers}">
				<tr style="background-color: ghostwhite;">
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.address}</td>
					<td><a href="supplier/delete/?id=${supplier.id}"><button
								type="button" class="button">Delete</button></a> 
								&emsp;<a href="supplier/edit/?id=${supplier.id}">
								<button type="button" class="button">Edit</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>