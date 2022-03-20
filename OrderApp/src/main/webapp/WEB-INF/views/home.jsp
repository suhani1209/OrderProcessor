<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
 <%@include file="navbar.jsp" %>
 <%@include file="header.jsp" %>
<%--         
Welcome ${user.username } !!   <a href="/logout">logout</a>
<br>
<a href="/addorder/${user.id}">add order</a><br>
<a href="/orders/${user.id }">view order</a><br>
<a href="/orders/${user.id }">update</a><br>
<a href="/orders/${user.id }">delete</a><br> --%>
	<div class="section-header text-center">
		<h2>Our Featured products</h2>
    </div>
	<div class="food">
            <div class="container">
                <div class="row align-items-center">
                <c:forEach items="${products}" var="product">
                    <div class="col-md-4">
                        <div class="food-item">
                            <h2>${product.productName}</h2>
                            <p>
                               ${product.productCategory}
                            </p>
                            <a href="/addorder/${user.id}">Shop</a>
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>
        </div>
<%-- <table>
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
</table> --%>
<%@include file="footer.jsp" %>
</body>
</html>