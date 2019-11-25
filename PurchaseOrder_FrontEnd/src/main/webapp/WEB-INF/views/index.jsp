<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="css" value="${pageContext.request.contextPath}/resources/css" scope="application"/>
<c:set var="js" value="${pageContext.request.contextPath}/resources/js" scope="application"/>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Home</title>
	
		<script type="text/javascript" src="${js}/home.js"></script>
	
		<link href="${css}/home.css" rel="stylesheet">
	<!-- <link href="${js}/home.js" rel=""> -->
<body id="page-top">

      	
		<div class="container">
		<div class="centerImg" ></div>
		<div id="typewriter"></div>
		</div>
		<a href="RegisterForm">
		<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
		  Register
		</button></a>
		<a href="loginUser">
		<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" >
		  Log In
		</button></a>
		
		
		<link rel="stylesheet" href="https://storage.googleapis.com/code.getmdl.io/1.0.6/material.indigo-pink.min.css">
		<script src="https://storage.googleapis.com/code.getmdl.io/1.0.6/material.min.js"></script>
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
		<script src="${js}/home.js"></script>
		
</body>

</html>