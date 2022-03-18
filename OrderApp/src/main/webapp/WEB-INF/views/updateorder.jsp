<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update order</title>
</head>
<body>
	<table>
		<tr><td><h3>Order id :</h3> </td>
			<td>${orderDto.orderId } </td>
		</tr>
		<tr><td><h3>Order status :</h3></td>
			<td> ${orderDto.status }</td>
		</tr>
		<tr><td><h3>Order date :</h3></td>
			<td> ${orderDto.orderedOn }</td>
		</tr>
		<tr><td><h3>Order time :</h3></td>
			<td> ${orderDto.orderTime }</td>
		</tr>
	</table>
	
	<form:form action="/orders/${userid}/update/${id}" method="post" modelAttribute="orderDto">
		<c:forEach items="${products}" var="product">

			<tr>
				<td>
				<c:set var="contains" value="false" />
				<c:forEach items="${orderDto.products }" var="prod" >
					<c:if test="${product } == prod">
						<c:set var="contains" value="true" />
					</c:if>
				</c:forEach>
				<c:choose>
				<c:when test="${contains } == 'true'">
						print(product.productName)
						<form:checkbox path="products" value="${ product}" checked="checked"/>
				</c:when>
				<c:otherwise>
					<form:checkbox path="products" value="${ product}" />
				</c:otherwise>
				</c:choose>
				</td>
				<td>${product.productName}</td>
				<td>${product.productCategory}</td>
			</tr>
			<br>
		</c:forEach> 
	<input type ="submit"/>
	</form:form>



</body>
</html>