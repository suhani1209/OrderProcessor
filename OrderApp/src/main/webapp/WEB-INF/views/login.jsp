<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
    <style>
    	<%@include file="../../css/login.css" %>
    </style>   
</head>

<body>
	
	<!------------ ERROR MESSAGE WHEN USER ENTERS WRONG LOGIN DETAILS ---------->
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
	<font color="red">
		<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message }"></c:out>
	</font>
	</c:if> 
	
	<!---------------LOGIN FORM WITH USER AVATAR  ------------------------------>
	<div class="wrapper fadeInDown">
	  	<div id="formContent">
		    <!-- Tabs Titles -->
		    <h2 class="active"> Sign In </h2>
		
		    <!-- Icon -->
		    <div class="fadeIn first">
		      <img src="https://www.kindpng.com/picc/m/285-2856724_user-avatar-enter-free-photo-user-avatar-green.png" id="icon" alt="User Icon" />
		    </div>
		
		    <!-- Login Form -->
		    <form action='login' method='POST'>
		      <input type="text" id="login" class="fadeIn second" name="cName" placeholder="Username" required>
		      <input type="password" id="password" class="fadeIn third" name="cPass" placeholder="Password" required>
		      <input type="submit" name="submit" class="fadeIn fourth" value="Log In" />
		    </form>
	
	  </div>
	</div>
	


</body>
</html>