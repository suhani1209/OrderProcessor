<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add order</title>
</head>
<body>
<a href="/home">Home</a>
${userid}
<h1>Choose from the products listed below..</h1>
<form:form action="../addorder/${id}" method="post" modelAttribute="orderDto">
		<c:forEach items="${allproducts}" var="product">
				<form:checkbox path="products" value="${product}" />
				${product.productName}
				${product.productCategory}
			<br>
		</c:forEach> 
	<input type ="submit"/>
	</form:form>
</body>
</html>