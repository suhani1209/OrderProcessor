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
<!-- Google Font -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Nunito:600,700" rel="stylesheet"> 
        
        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="../../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        
        <style type="text/css">
        	<%@include file="../../css/style.css" %>
        	.page-header{
        		background:linear-gradient(rgba(0, 0, 0, .5), rgba(0, 0, 0, .5)), url(https://media.istockphoto.com/photos/shopping-online-concept-shopping-service-on-the-online-web-with-by-picture-id1133980246?k=20&m=1133980246&s=612x612&w=0&h=bwut2YUV7gtnjrv354523xU_9S-TtKQOqGTdiGMsPfs=);
        		background-repeat: no-repeat;
    			background-size: 100% 150%;
        	}
        	.button{
			        background-color: green;
			        border: none;
			        color: #fff;
			        padding: 15px 30px;
			        margin-top:20px;
			        margin-left:45%;
			        text-decoration: none;
			        cursor: pointer;
			        align:center
			}
        	table {
        	margin-top:-160px;
			  width: 100%;
			}
			th, td {
			  text-align: left;
			  padding: 8px;
			}
			th{
				background-color: #f2f2f2;
			}
			tr:nth-child(even) {background-color: #f2f2f2;}
        </style>
</head>
<body>
	<!-- Nav Bar Start -->
        <div class="navbar navbar-expand-lg bg-light navbar-light">
            <div class="container-fluid">
                <a href="/home" class="navbar-brand">Order <span>Processor</span></a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav ml-auto">
                        <a href="/home" class="nav-item nav-link">Home</a>
                        <a href="/addorder/${user.id}" class="nav-item nav-link">Shop</a>
                        <a href="/orders/${user.id }" class="nav-item nav-link">My Orders</a>
                       <%--  <a href="/orders/${user.id }" class="nav-item nav-link">Update Orders</a>
                        <a href="/orders/${user.id }" class="nav-item nav-link">Delete</a> --%>
                       <div class="nav-item dropdown">
                            <a href="/home" class="nav-link dropdown-toggle" data-toggle="dropdown">Hi, ${user.username}</a>
                            <div class="dropdown-menu">
                                <a href="/logout" class="dropdown-item">Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Nav Bar End -->
        <!-- Page Header Start -->
        <div class="page-header">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h2>Update order</h2>
                    </div>
                    <div class="col-12">
                        <a>Order id : ${orderDto.orderId }</a>
                        <a>Order status :${orderDto.status }</a>
                        <a>Order on : ${orderDto.getDate() }</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Page Header End -->

	
	<form:form action="/orders/${user.id}/update/${id}" method="post" modelAttribute="orderDto">
		<table>
		<div class="section-header text-center">
			<h2>Our Featured products</h2>
   		 </div>
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
		</table>
	<input type ="submit" class="button" value="Update"/>
	</form:form>
	
	<%@include file="footer.jsp" %>

</body>
</html>