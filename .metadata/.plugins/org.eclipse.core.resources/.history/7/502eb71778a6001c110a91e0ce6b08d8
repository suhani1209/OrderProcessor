<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>
<body>
	
	<table>
		<thead>
			<tr>
				<th>Order Id</th>
				<th>Order Status</th>
				<th>Order Date</th>
				<th>Order time</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>


		<c:forEach items="${orders}" var="order">
			<c:if test="${order.status != 'DELETED' }">
			<tr>
				<td>${order.orderId}</td>
				<td>${order.status}</td>
				<td>${order.orderedOn}</td>
				<td>${order.orderTime}</td>
				<td><a href="/orders/update/${order.orderId}">Update</a></td>
				<td><a href="/orders/delete/${order.orderId}">Delete</a></td>
			</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>