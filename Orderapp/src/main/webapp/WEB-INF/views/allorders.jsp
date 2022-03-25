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
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">


	<style type="text/css">
		<%@include file ="../../css/style.css" %> 
		<%@include file="../../css/allorders.css" %>
	</style>
	
</head>
<body>
	
	<!-- Nav Bar Start -->
	<div class="navbar navbar-expand-lg bg-light navbar-light">
		<div class="container-fluid">
			<a href="/home" class="navbar-brand">Order <span>Processor</span></a>
			<button type="button" class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-between"
				id="navbarCollapse">
				<div class="navbar-nav ml-auto">
					<a href="/home" class="nav-item nav-link">Home</a>
					<a href="/addorder" class="nav-item nav-link">Shop</a>
					<a href="/orders" class="nav-item nav-link">My Orders</a>
					<div class="nav-item dropdown">
						<a href="/home" class="nav-link dropdown-toggle"
							data-toggle="dropdown">Hi, ${user.username}</a>
						<div class="dropdown-menu">
							<a href="/logout" class="dropdown-item">Logout</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--  Nav Bar End -->

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

	<!----------- SEARCH BY ORDER ID FORM  ----SEARCH BAR------------>
	<%-- <form action="/orders/${user.id}" method="post">
		<input type="text" name="searchId" id="searchId"
			placeholder="Enter order id" /> <input type="submit" class="button"
			value="Search" /> <input type="reset" class="button" value="Reset" />
	</form> --%>
	
	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for Order ID" title="Type in a name"/>
	
	<!---------------- DISMISSIBLE ALERTS  ------------->
	<%
	if (request.getParameter("success") != null) {
	%>

	<div class="alert alert-success alert-dismissible fade show"
		role="alert" style="margin-top: 2rem;width: max-content; margin-inline: auto;">
		<%=request.getParameter("success")%>
		<a type="button" class="message" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</a>
	</div>
	<%
	}
	%>

	<c:choose>
		<c:when test="${message !=null}">
			<div class="section-header text-center">
				<h2 style="margin-top: 30px">${message}</h2>
			</div>
		</c:when>
		
		<c:otherwise>
			<table id="orderTable">
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
				</c:otherwise>
				</c:choose>

				<c:forEach items="${orders}" var="order">
					<c:if test="${order.status != 'DELETED' }">
						<tr>
							<td>${order.orderId}</td>
							<td>${order.status}</td>
							<td>${order.getDate()}</td>
							<td>${order.getTime()}</td>
							<td><a
								href="update?orderid=${order.orderId}"><i
									class="fas fa-edit"></i></a></td>


							<td><a data-bs-toggle="modal"
								href="#myModal-${order.orderId }"><i class="fa fa-trash-o"></i></a></td>
							<div class="modal" id="myModal-${order.orderId}">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title">Delete order</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal"></button>
										</div>
										<div class="modal-body">
											<form action="delete/${order.orderId}">
												<div class="mb-3">
													<p>Are you sure you want to delete this order?</p>
													<p class="text-danger">
														<small>This action cannot be undone.</small>
													</p>
												</div>
												<div class="modal-footer">
													<button type="submit" class="btn btn-danger">Delete</button>
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal" aria-hidden="true"
														onclick="document.getElementById('myModal').style.display='none'">Cancel</button>
												</div>
											</form>
										</div>
									</div>
								</div>
						
							<td><a href="view?orderid=${order.orderId}">Details</a></td>
							<td>${order.user.shippingAddress}</td>
							<td>${order.user.phoneNumber}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
			
			
			<!------------- INCLUDE FOOTER JSP PAGE  ---------->
			<%@include file="footer.jsp"%>
			
			<!--------------INCLUDE SCRIPT FILES  ------------>
			
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
				crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
			<script type="text/javascript" src="../../js/search.js"></script>
</body>
</html>