<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>SportsZone</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
</style>

</head>
<body style="background-color: #f7f7f7;">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="Home">SportsZone</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="productList">Products</a></li>
				<!-- <li><a href="#">Page 1</a></li>
				<li><a href="#">Page 2</a></li> -->
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><c:choose>
						<c:when test="${empty loggedInUser}">

							<li><a href="Registration"><span
									class="glyphicon glyphicon-user"></span> Sign Up</a></li>
							<li><a href="Login"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>


						</c:when>

						<c:when test="${not empty loggedInUser}">
											${SuccessMessage}
								<a>Welcome ${loggedInUser}</a>
							<li><a href="logout"><span
									class="glyphicon glyphicon-user"></span>Logout</a></li>
						</c:when>
					</c:choose></li>
			</ul>
		</div>



		<div id="Registration">

			<c:if test="${userClickedRegisterHere==true}">
				<%-- 	<jsp:include page="Registration.jsp"></jsp:include> --%>
			</c:if>
		</div>


		${failureMessage}
		<div id="Login">

			<c:if test="${userClickedLoginHere==true}">
				<%-- 	<jsp:include page="Login.jsp"></jsp:include> --%>
			</c:if>
		</div>


		<div id="admin">
			<c:if test="${isAdmin==true}">
				<jsp:include page="adminHome.jsp"></jsp:include>
			</c:if>

			<div id="categories">
				<c:if test="${isAdminClickedCategories==true}">
					<%@ include file="/views/adminHome.jsp"%>
					<%-- <%@ include file="/views/category.jsp"%> --%>

				</c:if>


			</div>
			<div id="suppliers">
				<c:if test="${isAdminClickedSuppliers==true}">
					<%@ include file="/views/adminHome.jsp"%>
					<%-- <%@ include file="/views/supplier.jsp"%> --%>

				</c:if>
			</div>

			<div id="products">
				<c:if test="${isAdminClickedProducts==true}">
					<%@ include file="/views/adminHome.jsp"%>
					<%-- <%@ include file="/views/Product.jsp"%> --%>

				</c:if>
			</div>

		</div>

	</nav>

	<div>

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
		<div id="products">
			<c:if test="${isClickedProductList==true}">
				<%-- <%@ include file="/views/adminHome.jsp"%> --%>
				<%@ include file="/views/productList.jsp"%>

			</c:if>
		</div>

		<div id="admin">
			<c:if test="${isAdmin==true}">
				<%-- <jsp:include page="adminHome.jsp"></jsp:include> --%>
			</c:if>

			<div id="categories">
				<c:if test="${isAdminClickedCategories==true}">
					<%-- 	<%@ include file="/views/adminHome.jsp"%> --%>
					<%@ include file="/views/category.jsp"%>

				</c:if>


			</div>
			<div id="suppliers">
				<c:if test="${isAdminClickedSuppliers==true}">
					<%-- <%@ include file="/views/adminHome.jsp"%> --%>
					<%@ include file="/views/supplier.jsp"%>

				</c:if>
			</div>

			<div id="products">
				<c:if test="${isAdminClickedProducts==true}">
					<%-- <%@ include file="/views/adminHome.jsp"%> --%>
					<%@ include file="/views/Product.jsp"%>

				</c:if>
			</div>
			<div id="about">
				<c:if test="${userClickedAboutHere==true}">
					<%-- <%@ include file="/views/adminHome.jsp"%> --%>
					<%@ include file="/views/About.jsp"%>

				</c:if>
			</div>


		</div>
	</div>

	<footer>
		<p class="pull-right">
			<a href="#">Back to top</a>
		</p>


		<p>
			&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a
				href="#">Terms</a>&middot;<a href="About"><span
				class="glyphicon glyphicon-tag"></span>About</a>
		</p>
	</footer>
</body>
</html>