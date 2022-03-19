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
	<a href="/home">Home</a>

	<form action="/orders/${userid}/view" method="post">
		<table>
			<tr>
				<td><input type="text" name="searchId" id="searchId" placeholder="Enter order id"/></td>
				<td><input type="submit"/></td>
			</tr>
		</table>
	</form>


	<table>
		<thead>
			<tr>
				<th>Order Id</th>
				<th>Order Status</th>
				<th>Order Date</th>
				<th>Order Time</th>
				<th>Update</th>
				<th>Delete</th>
				<th>View order details</th>
				<th>Shipping address</th>
				<th>Phone number</th>
			</tr>
		</thead>


		<c:forEach items="${orders}" var="order">
			<c:if test="${order.status != 'DELETED' }">
				<tr>
					<td>${order.orderId}</td>
					<td>${order.status}</td>
					<td>${order.getDate()}</td>
					<td>${order.getTime()}</td>
					<td><a href="/orders/${userid }/update/${order.orderId}">Update</a></td>
					<td><a href="/orders/${userid }/delete/${order.orderId}">Delete</a></td>
					<td><a href="/orders/${userid }/view/${order.orderId}">view
							order</a></td>
					<td>${order.user.shippingAddress}</td>
					<td>${order.user.phoneNumber}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>


</body>
</html>