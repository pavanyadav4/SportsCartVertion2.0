<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/table1.css" />">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>
	<h1>Add Product</h1>
	<div class="table responsive" align="center">

		<c:url var="addAction" value="product/add"></c:url>
		<form:form action="${addAction}" commandName="product"
			enctype="multipart/form-data">
			<table class="table table-hover" style="width: 80%">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<c:choose>
						<c:when test="${!empty product.id}">
							<td><form:input path="id" readonly="true" /></td>
						</c:when>
						<c:otherwise>
							<td><form:input path="id" pattern="{5,15}" required="true"
									title="id should be between 5 to 15 characters/" /></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" required="true" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:input path="description" required="true" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input path="price" required="true" /></td>
				</tr>
				<tr>
					<td>Category:</td>
					<td><form:select path="category_id" required="true">
							<c:forEach items="${categoryList}" var="category">
								<form:option class="input1" value="${category.categoryid}">${category.name}</form:option>
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<td>Supplier:</td>
					<td><form:select path="supplier_id" required="true">
							<c:forEach items="${supplierList}" var="supplier">
								<form:option class="input1" value="${supplier.id}">${supplier.name}</form:option>
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<td>Image:</td>
					<td><form:input type="file"
							class=" btn btn-default btn-block form-control" path="image"
							required="true" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" class="btn btn-primary" value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<div class="table responsive" align="center">
		<table class="table table-hover" style="width: 80%">

			<!-- <table class="table1" style="width: 80%"> -->
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
					<th>Edit</th>
					<th>Delete</th>
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
						<td><a href="<c:url value="product/Update/${product.id}"/>">Edit</a></td>
						<td><a href="<c:url value="product/remove/${product.id}"/>">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<!-- 	</div> -->
</body>
</html>