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
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Nunito:600,700"
	rel="stylesheet">

<!-- CSS Libraries -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link href="../../lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<style type="text/css">
<%@include file ="../../css/style.css" %> 

#searchId {
	width: 60%;
	margin-left: 10%;
	padding: 10px 10px;
}

.button {
	background-color: green;
	border: none;
	color: #fff;
	padding: 15px 15px;
	text-decoration: none;
	cursor: pointer;
	align: center
}

table {
	width: 100%;
	margin-top: 20px;
}

th, td {
	text-align: left;
	padding: 8px;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Float cancel and delete buttons and add an equal width */
.cancelbtn, .deletebtn {
  float: left;
  width: 50%;
}

/* Add a color to the cancel button */
.cancelbtn {
  background-color: #ccc;
  color: black;
}

/* Add a color to the delete button */
.deletebtn {
  background-color: #f44336;
}

/* Add padding and center-align text to the container */
.container {
  padding: 16px;
  text-align: center;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: #474e5d;
  padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
  background-color: white;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
 
/* The Modal Close Button (x) */
.close {
  position: absolute;
  right: 35px;
  top: 15px;
  font-size: 40px;
  font-weight: bold;
  color: #f1f1f1;
}

.close:hover,
.close:focus {
  color: #f44336;
  cursor: pointer;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and delete button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .deletebtn {
     width: 100%;
  }
}
form {
	display: flex;
}

input.button {
	margin-right: 20px;
	margin-left: 20px;
}
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
					<a href="/home" class="nav-item nav-link">Home</a> <a
						href="/addorder/${user.id}" class="nav-item nav-link">Shop</a> <a
						href="/orders/${user.id}" class="nav-item nav-link">My Orders</a>
					<%-- <a href="/orders/${user.id}" class="nav-item nav-link">Update Orders</a>
                        <a href="/orders/${user.id}" class="nav-item nav-link">Delete</a> --%>
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

	<form action="/orders/${user.id}" method="post">
		<input type="text" name="searchId" id="searchId"
			placeholder="Enter order id" /> <input type="submit" class="button"
			value="Search" /> <input type="reset" class="button" value="Reset" />
	</form>


	<c:choose>
		<c:when test="${message !=null}">
			<div class="section-header text-center">
				<h2 style="margin-top:30px">${message}</h2>
			</div>
		</c:when>

		<c:otherwise>
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
								href="/orders/${order.user.id}/update/${order.orderId}"><i class="fas fa-edit"></i></a></td>

							<td><a class="btn btn-sm del "
						onclick="document.getElementById('id01-${order.orderId}').style.display='block'">
							<i class="fas fa-trash"></i>
					</a></td>

					<div id="id01-${order.orderId}" class="modal">

						<span onclick="document.getElementById('id01-${order.orderId}').style.display='none'"
							class="close" title="Close Modal">x</span>

						<form class="modal-content" action="/orders/${user.id}/delete/${order.orderId}">
							<div class="container">
								<h1>Delete Order</h1>
								<p>Are you sure you want to delete ths order?</p>
								<div class="clearfix">
									<button type="button" onclick="document.getElementById('id01-${order.orderId}').style.display='none'"
										class="cancelbtn">Cancel</button>
									<button class="deletebtn">Delete</button>
								</div>
							</div>
						</form>
					</div> 


							<%-- <td><a onclick="document.getElementById('id01-${order.orderId}').style.display='block'">Delete</a></td>
							<div id="id01-${order.orderId}" class="modal">
								<span onclick="document.getElementById('id01-${order.orderId}').style.display='none'"
									class="close" title="Close Modal">×</span>
								<form class="modal-content" action="/orders/${user.id}/delete/${order.orderId}">
									<div class="container">
										<h1>Delete Order</h1>
										<p>Are you sure you want to delete this order?</p>
										<div class="clearfix">
											<button type="button"
												onclick="document.getElementById('id01-${order.orderId}').style.display='none'"
												class="cancelbtn">Cancel</button>
											<button type="button"
												onclick="document.getElementById('id01-${order.orderId}').style.display='none'"
												class="deletebtn">Delete</button>
										</div>
									</div>
								</form>
							</div> --%>

							<td><a href="/orders/${order.user.id}/view/${order.orderId}">Details</a></td>
							<td>${order.user.shippingAddress}</td>
							<td>${order.user.phoneNumber}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>

			<%@include file="footer.jsp"%>
</body>
</html>