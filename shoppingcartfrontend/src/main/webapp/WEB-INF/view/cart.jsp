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
<br>
<c:forEach var="cart" items="${cartList}">
<img alt="" src="resources/images/${cart.productID}.PNG"><br>
Name  : "${cart.productName}"<br>
Price :${cart.price}" <br>
Quantity  :${cart.quantity}<br><br><br>
  
</c:forEach>
<a href="buy"> BUY</a>
</body>
</html>