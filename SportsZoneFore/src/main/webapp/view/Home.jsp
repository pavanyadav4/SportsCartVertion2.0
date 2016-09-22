<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="width=device-width, initial-scale=1; charset=ISO-8859-1">

<link type="text/css" rel="stylesheet" href="stylesheet.css" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="<c:url value="resources/menu.css"/>">
<link rel="stylesheet" href="<c:url value="resources/main.css"/>">

<title>Sports cart</title>
</head>
<body>


	<%-- 
	<nav
		class="navbar navbar-default navbar-fixed-top top-nav-collapse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><img src="D:\cart.png"
				width="35px" class="img-circle" alt="logo"></a>
		</div>
		<div class="collapse navbar-collapse text-center"
			id="bs-example-navbar-collapse-1">
			<div class="col-md-8 col-xs-12 nav-wrap">
				<ul class="nav navbar-nav">
					<li class=""><a href="" class="page-scroll">Home</a></li>
					<li class=""><a href="" class="page-scroll">Services</a></li>
					<li class=""><a href="" class="page-scroll">Works</a></li>
					<li class=""><a href="" class="page-scroll">About</a></li>
					<li><a href="#contact" class="page-scroll">Contact</a></li>
					
					<c:if test=""></c:if>
					<li><a style="text-align: right" href="Login">Login</a> <c:if
							test="${userClickLoginHere}==true">
							<jsp:include page="Login.jsp"></jsp:include>
						</c:if></li>
					<li><a href="Registration">Register</a> <c:if
							test="${userClickRegisterHere}==true">
							<jsp:include page="Registration.jsp"></jsp:include>
						</c:if></li>
				</ul>
			</div>
			<div class="col-sm-5 col-md-3">
				<form class="navbar-form" role="search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							name="q">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
			<div class="social-media hidden-sm hidden-xs">
				<ul class="nav navbar-nav">
					<li><a href="#"><i class="fa fa-facebook"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter"></i></a></li>
					<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
				</ul>
			</div>
		</div>
	</div>
	</nav>
<div>

</div>
 --%>

	<%-- <c:choose>
	<c:when test="${empty loggedInUser}">
			<li><a href="Login">Login</a> <c:if
					test="${userClickLoginHere}==true">
					<jsp:include page="Login.jsp"></jsp:include>
				</c:if></li>
			<li><a href="Registration">Register</a> <c:if
					test="${userClickRegisterHere}==true">
					<jsp:include page="Registration.jsp"></jsp:include>
				</c:if></li>
	</c:when>
	<c:when test="${not empty loggedInUser}">
		<h2>Welcome ${loggedInUser}</h2>
		<a href="logout">Logout</a>
		<jsp:include page="LoginSuccess.jsp"></jsp:include>
	</c:when>
	<c:when test="${isAdmin}==true">
		<jsp:include page="AdminHome.jsp"></jsp:include>
	</c:when>

</c:choose> --%>


	<div>
		<div data-role="header" data-position="fixed">
			<h1>Welcome to shopping cart</h1>
			${SuccessMessage}
			<table>
				<tr>
					<c:choose>
						<c:when test="${empty loggedInUser}">
							<td align="left"><a href="Login">Login</a></td>
							<td align="center"><a href="Registration">Register</a></td>
						</c:when>

						<c:when test="${not empty loggedInUser}">
							<td>Welcome ${loggedInUser},</td>
							<td align="right"><a href="logout">Logout</a></td>
						</c:when>
					</c:choose>
				</tr>

				<tr>
					<c:if test="${loggedOut==true}">
					</c:if>
					<td>${logOutMsg}</td>
				</tr>
				<%-- 
				<tr>
					<c:if test="${not empty cartSize}">
						<td align="right"><a href="myCart">My cart</a>(${cartSize})</td>
					</c:if>
				</tr> --%>

			</table>
		</div>

		<div>
			<ul id=menu>
				<c:if test="${not empty List}">
					<c:forEach items="${category.List}" var="category ">
						<li><a href="${category.name}">${category.name}</a>
					</c:forEach>
				</c:if>
			</ul>
			<br> <br> <br> --
			<div>
				<c:if test="${!empty selectedProduct.name}">
					<table>
						<tr>
							<th align="left" width="80">Product ID</th>
							<th align="left" width="120">Product Name</th>
							<th align="left" width="200">Product Description</th>
							<th align="left" width="80">Price</th>
							<th align="left" width="200">Product Category</th>
							<th align="left" width="200">Product Supplier</th>
						</tr>
						<tr>
							<td align="left">${SelectedProduct.id}</td>
							<td align="left">${SelectedProduct.name}</td>
							<td align="left">${SelectedProduct.description}</td>
							<td align="left">${SelectedProduct.price}</td>
							<td align="left">${SelectedProduct.category.name}</td>
							<td align="left">${SelectedProduct.supplier.name}</td>
						</tr>
					</table>
				</c:if>
			</div>


			${message}

			<div id="Registration">

				<c:if test="${userClickedRegisterHere==true}">
					<jsp:include page="Registration.jsp"></jsp:include>
				</c:if>
			</div>


			${failureMessage}
			<div id="Login">

				<c:if test="${userClickedLoginHere==true}">
					<jsp:include page="Login.jsp"></jsp:include>
				</c:if>
			</div>


			<div id="admin">
				<c:if test="${isAdmin==true}">
					<jsp:include page="AdminHome.jsp"></jsp:include>

					<div id="categories">
						<c:if test="${isAdminClickedCategory==true}">
							<%@ include file="AdminHome.jsp"%>
							<%@ include file="Category.jsp"%>
						</c:if>
					</div>

					<div id="products">
						<c:if test="${isAdminClickedProducts==true}">
							<%@ include file="AdminHome.jsp"%>
							<%@ include file="Product.jsp"%>
						</c:if>
					</div>

					<div id="suppliers">
						<c:if test="${isAdminClickedSuppliers==true}">
							<%@ include file="AdminHome.jsp"%>
							<%@ include file="Supplier.jsp"%>
						</c:if>
					</div>

				</c:if>
			</div>
		</div>
</body>
</html>