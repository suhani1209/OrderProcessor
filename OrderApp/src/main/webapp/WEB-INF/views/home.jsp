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
Welcome ${user.username } !!
<br>
<a href="/addorder/${user.id}">add order</a><br>
<a href="/orders/${user.id }">view order</a><br>
<a href="/orders/${user.id }">update</a><br>
<a href="/orders/${user.id }">delete</a><br>
<table>
	<thead>
	<tr>
	<th> Product Id </th>
	<th> Product Name </th>
	<th> Product Category </th>
	</tr>
	</thead>
	
	<c:forEach items="${products}" var="product">
	<tr>
	<td> ${product.productId} </td>
	<td> ${product.productName} </td>
	<td> ${product.productCategory} </td>
	
	</tr>
	</c:forEach>
</table>
</body>
</html>