<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
<!-- Google Font -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Nunito:600,700" rel="stylesheet"> 
        
        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="../../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        
        <style type="text/css">
        	<%@include file="../../css/style.css" %>
        	#searchId{
        		width:75%;
        		margin-left:25%;
        	}
        	.button{
			        background-color: green;
			        border: none;
			        color: #fff;
			        padding: 15px 15px;
			        margin-right:25%;
			        text-decoration: none;
			        cursor: pointer;
			        align:center
			}
        	table {
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
                        <a href="/addorder/${userid}" class="nav-item nav-link">Shop</a>
                        <a href="/orders/${userid }" class="nav-item nav-link">My Orders</a>
                        <a href="/orders/${userid }" class="nav-item nav-link">Update Orders</a>
                        <a href="/orders/${userid }" class="nav-item nav-link">Delete</a>
                        <a href="/logout" class="nav-item nav-link">Logout</a>
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
                        <h2>Your Order history</h2>
                    </div>
                    <div class="col-12">
                        <a href="/home">Home</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Page Header End -->

	<form action="/orders/${userid}/view" method="post">
		<table>
			<tr>
				<td><input type="text" name="searchId" id="searchId" placeholder="Enter order id"/></td>
				<td><input type="submit" class="button"/></td>
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
				<th>View Details</th>
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
					<td><a href="/orders/${userid }/view/${order.orderId}">Details</a></td>
					<td>${order.user.shippingAddress}</td>
					<td>${order.user.phoneNumber}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	
	<%@include file="footer.jsp" %>

</body>
</html>