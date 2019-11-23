<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Products	</title>
</head>
<body>
		<h1>View Products</h1>
		<div >
<h4>Items</h4>
 <h4> Quantity </h4>
 </div>
		<table>
			<tr>
				<th>Product Id</th>
				<th>Product Name</th>
				
				<th>Product Price</th>
			</tr>
			<c:forEach items="${productDetails}" var="pObj">
			<tr>
				<td>${pObj.productId}</td>
				<td>${pObj.productName}</td>
				
				<td>${pObj.productPrice}</td>
			</tr>
			</c:forEach>
		</table>

		 <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
    <c:forEach items="${productDetails}" var="pObj">
     <li><a href="#">${pObj.productName}</a> </li>
     </c:forEach>
    </ul>
  </div>
	</body>
</html>