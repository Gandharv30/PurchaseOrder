<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SellerPOs</title>
	<style>
	body {background: rgb(2,0,36);
	background: linear-gradient(40deg, rgba(2,0,36,1) 0%, rgba(159,100,51,0.7203256302521008) 0%, rgba(194,128,70,0.9948354341736695) 100%);
	}
	</style>
</head>
<body>

<div align="center" style="margin-top: 250px">
<table border=1px>
<h2 >Purchase Orders</h2>
<tr>
<!-- <th>Purchase Order Id</th> -->
<th>Purchase Order Id</th>
<th>Seller Id</th>
<th>Buyer Id</th>
<th>Status</th>
</tr>

<f:forEach items="${ poList}" var="obj">
<tr>
               <td>${obj.poId}</td>
				<td>${obj.buyerObj.userId}</td>
				<td>${obj.sellerObj.userId}</td>
				<td>${obj.status }</td>
</tr>
</f:forEach>

</table>
</div>
</body>
</html>