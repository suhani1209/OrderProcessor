<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>trying frontend</title>
 <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Nunito:600,700" rel="stylesheet"> 
        
        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="../../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        
        <style type="text/css">
        	<%@include file="../../css/style.css" %>
        </style>
</head>
<body>
  <!-- Carousel Start -->
        <div class="carousel">
            <div class="container-fluid">
                <div class="owl-carousel">
                    <div class="carousel-item">
                        <div class="carousel-img">
                            <img src="../../images/cart.png" alt="Image">
                        </div>
                        <div class="carousel-text">
                            <h1>Best <span>Quality</span> Products</h1>
                            <p>
                                Special savings on weekends
                            </p>
                            <div class="carousel-btn">
                                <a class="btn custom-btn" href="/orders/${user.id }" >My Orders</a>
                                <a class="btn custom-btn" href="/addorder/${user.id}">Place Order</a>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="carousel-img">
                            <img src="../../images/variety.png" alt="Image">
                        </div>
                        <div class="carousel-text">
                            <h1>One <span>stop shop</span> for <span>coolest tech</span></h1>
                            <p>
                                Choose from a wide range of brands 
                            </p>
                            <div class="carousel-btn">
                                <a class="btn custom-btn" href="/orders/${user.id }" >My Orders</a>
                                <a class="btn custom-btn" href="/addorder/${user.id}">Place Order</a>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="carousel-img">
                            <img src="../../images/fashion.jpg" alt="Image">
                        </div>
                        <div class="carousel-text">
                            <h1>Fastest Order <span>Delivery</span></h1>
                            <p>
                                Your shopping partner with the hottest deals of the week
                            </p>
                            <div class="carousel-btn">
                                <a class="btn custom-btn" href="/orders/${user.id }" >My Orders</a>
                                <a class="btn custom-btn" href="/addorder/${user.id}">Place Order</a>
                            </div>
                        </div>
                    </div> 
                </div>
            </div>
        </div>
        <!-- Carousel End -->

</body>
</html>