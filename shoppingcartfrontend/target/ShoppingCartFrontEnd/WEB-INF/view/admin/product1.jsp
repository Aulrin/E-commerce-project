<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="AddProduct" method="post" modelAttribute="prdt" enctype="multipart/form-data">
		<table>	
			<tr><td>	
			Product ID</td></tr>
			<tr><td><form:input path="id"/></td></tr>
			<tr><td>
			Product Name</td></tr> 
			<tr><td><form:input path="name"/></td></tr>
			<tr><td>
			Image</td></tr>
			<tr><td><form:input type="file" path="pimage"/></td></tr>
			<tr><td>Description</td>

				<td><form:input type="text" path="description"/></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><form:input type="text" path="price"/>
			</tr>
			<tr>
				<td>Select Category</td>
				<td><select name="categoryID">
						<c:forEach var="category" items="${categories}">
							<option value="${category.id}" >${category.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
			<td>
			Product Image :</td> <td><input type="file" name ="file"></td>
			
			</tr>
<tr>
				<td>Select Supplier</td>
				<td><select name="supplierID">
						<c:forEach var="supplier" items="${suppliers}">
							<option value="${supplier.id}" >${supplier.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr><td>
			<input type="submit" value="SUBMIT"/></td></tr>
		</table>
		</form:form>
</body></html>