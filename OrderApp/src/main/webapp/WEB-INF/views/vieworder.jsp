<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Order</title>
</head>
<body>
	<a href="/home">Home</a>
	<table>
		<thead>
			<tr>
				<th>Order Id</th>
				<th>Order Status</th>
				<th>Order Date</th>
				<th>Order Time</th>
			</tr>
		</thead>
		<tr>
			<td>${order.orderId}</td>
			<td>${order.status}</td>
			<td>${order.getDate()}</td>
			<td>${order.getTime()}</td>
		</tr>
	</table>
	<h2>Products you ordered </h2>
	<table>
		<thead>
		<tr>
			<th>Product id</th>
			<th>Product category</th>
			<th>Product name</th>
			</tr>
		</thead>
		<c:forEach items="${order.products}" var="product">
		<tr>
			<td>${product.productId}</td>
			<td>${product.productCategory}</td>
			<td>${product.productName}</td>
		</tr>
		<br>
	</c:forEach>
	
	</table>
</body>
</html>