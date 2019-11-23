<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
$(document).ready(function(){
    $(".add-row").click(function(){
        var name = $("#name").val();
        var email = $("#email").val();
        var markup = "<tr><td><input type='checkbox' name='record'></td><td>" + name + "</td><td>" + email + "</td></tr>";
        $("table tbody").append(markup);
    });
    
    // Find and remove selected table rows
    $(".delete-row").click(function(){
        $("table tbody").find('input[name="record"]').each(function(){
            if($(this).is(":checked")){
                $(this).parents("tr").remove();
            }
        });
    });
});    
</script>
<title>Insert title here</title>
</head>
<body>                                    
 <div class="container">
		<h1 style="color: green;">Raise Po</h1>
		<table class="table table-borderless  table table-hover table-dark">
			<thead>
				<tr>
					<th>Items</th>
					<th>Quantity</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<select class="form-control">
						<option>Select your products</option>
						<c:forEach items="${productDetails}" var="pObj">
						<option> 
						${pObj.productName} 
						</option>
						</c:forEach>
						</select>
						
						</td>
					<td><input type="number" min="0" pattern="\d*"  class="form-control" placeholder="Quantity" required/></td>

				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" value="submit"	class="btn btn-primary" /></td>
				</tr>

			</tbody>
		</table>
	</div>

</body>
</html>