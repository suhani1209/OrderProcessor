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
	
	<!---------------INCLUDE NAVBAR AND HEADER CONTAINING CAROUSEL ------------>
	 <%@include file="navbar.jsp" %>
	 <%@include file="header.jsp" %>
	 
	 <!-----------------DISPLAYING ALL PRODUCTS IN HOME PAGE  ------------>
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

	<!------------INCLUDING FOOTER JSP ------------------->
	<%@include file="footer.jsp" %>
</body>
</html>