<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>SportsProducts</title>
</head>
<body>
<c:if test="${not empty productList}"></c:if>
	<div class="table responsive" align="center">
		<table class="table table-hover" style="width: 80%">
			<caption>Products</caption>
			<thead>
				<tr id="tr1">
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Product Price</th>
					<th>Category</th>
					<th>Supplier</th>
					<th>Image</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="product">
					<tr id="tr1">
						<td id="td1"><c:out value="${product.id}" />
						<td id="td1"><c:out value="${product.name}" />
						<td id="td1"><c:out value="${product.description}" />
						<td id="td1"><c:out value="${product.price}" />
						<td id="td1"><c:out value="${product.category_id}" />
						<td id="td1"><c:out value="${product.supplier_id}" />
						<td><div class="thumbnail">
								<img height="100px" width="100px" alt="${product.id }"
									src="<c:url value="/resources/images/${product.id }.jpg"></c:url>">
							</div> <%-- <td id="td1"><a href="addeditproduct/${product.id }"><img
								alt="Edit" src="D:\images\edit1.jpg"></a>
						<td id="td1"><a href="adddeleteproduct/${product.id }"><img
								alt="Delete" src="D:\images\del1.jpg"></a> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>