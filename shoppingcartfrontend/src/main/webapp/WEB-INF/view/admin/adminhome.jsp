<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h4>	<a href="managecategories"> Manage Categories</a> &emsp;&emsp;
	<a href="managesuppliers"> Manage Suppliers</a>&emsp;&emsp;
	<a href="manageproducts"> Manage Products</a>
	</h4></center>

<br>
	<c:if test="${isAdminClickedManageCategories==true }">
		<jsp:include page="category.jsp"></jsp:include>
	</c:if>
	<c:if test="${isAdminClickedManageSuppliers==true }">
		<jsp:include page="supplier.jsp"></jsp:include>
	</c:if>
	<c:if test="${isAdminClickedManageProducts==true }">
		<jsp:include page="product.jsp"></jsp:include>
	</c:if>


</body>
</html>