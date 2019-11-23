<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>enter registration details</h1>

<div align="center">


	<form action="regUser"  method="post">
		<table>


		<tr>
		<td>
		Name: <input type="text" id="userName" name="userName" >
		</td>
		</tr>

<tr>

<td>
Email: <input type="text" id="email" name="email" >

</td>
</tr>

<tr>

<td>
password: <input type="password" id="userPassword" name="userPassword" >

</td>
</tr>

<tr>

<td>
Address: <input type="text" id="addressLine" name="addressLine" >

</td>
</tr>
<tr>

<td>
Mobile Number: <input type="text" id="mobileNumber" name="mobileNumber" >

</td>
</tr>

<tr>
<td> 
<input type="submit" value="register">
</td>

</tr>

</table>

</form>
</div>

</body>
</html>