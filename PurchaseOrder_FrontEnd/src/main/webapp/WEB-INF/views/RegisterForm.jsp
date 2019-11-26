<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="${css}/register.css" rel="stylesheet">
<title>Insert title here</title>
<style>
.error {
	color: red;
	font-size: 20px;
}
</style>

</head>
<body>


	<f:errors path="*" />
	<div class="container table-responsive-md" style="width: 500px;">
		<div class="jumbotron" align="center">
			<h1>Registration</h1>
		</div>
		<f:form action="regUser" method="post" modelAttribute="userObj"
			class="form-group">
			<table align="center"
				class=" table-responsive table table-hover table-borderless">
				<tr>
				<tr>
					<td>User Name</td>
					<td>:</td>
					<td><f:input path="userName" class="form-control" /></td>
					<td><f:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td>:</td>
					<td><f:input path="email" class="form-control" /></td>
					<td><f:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td>:</td>
					<td><f:password path="userPassword" class="form-control" /></td>
					<td><f:errors path="userPassword" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td>:</td>
					<td><f:input path="address" class="form-control" /></td>
					<td><f:errors path="address" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Mobile_no</td>
					<td>:</td>
					<td><f:input path="mobileNumber" class="form-control" /></td>
					<td><f:errors path="mobileNumber" cssClass="error" /></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" value="Submit"
						class="btn btn-success" /></td>
				</tr>
			</table>
		</f:form>
	</div>

</body>
</html>