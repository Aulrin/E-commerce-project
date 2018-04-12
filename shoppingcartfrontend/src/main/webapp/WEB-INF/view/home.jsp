<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>


	<jsp:include page="loginheader.jsp"></jsp:include>

	<jsp:include page="product_menu.jsp"></jsp:include>


	<c:if test="${isAdmin==true}">
		<jsp:include page="admin/adminhome.jsp"></jsp:include>
	</c:if>


	${errorMessage} ${successMessage}



	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedRegister==true}">
		<jsp:include page="registration.jsp"></jsp:include>
	</c:if>

	<c:choose>
		<c:when test="${isUserSelectedProduct==true}">
			<jsp:include page="selected_product.jsp"></jsp:include></c:when>
		<c:when test="${isUserClickedMyCart==true}">
			<jsp:include page="cart.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="displayallproduct.jsp"></jsp:include></c:otherwise>
	</c:choose>
</body>
</html>