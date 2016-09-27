
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<style>
</style>

</head>
<body style="background-color: #f7f7f7;">

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

				<%-- <tr>
					<c:if test="${loggedOut==true}">
					</c:if>
					<td>${logOutMsg}</td>
				</tr> --%>
				<%-- 
				<tr>
					<c:if test="${not empty cartSize}">
						<td align="right"><a href="myCart">My cart</a>(${cartSize})</td>
					</c:if>
				</tr> --%>

			</table>
		</div>

		<%-- <div >
			<ul id=menu>
				<c:if test="${not empty List}">
					<c:forEach items="${category.List}" var="category ">
						<li><a href="${category.name}">${category.name}</a>
						
							
					</c:forEach>
				</c:if>
			</ul>
			<br> <br> <br> --%>
		<%-- --
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
 --%>

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
				<jsp:include page="adminHome.jsp"></jsp:include>
			</c:if>

			<div id="categories">
				<c:if test="${isAdminClickedCategories==true}">
					<%@ include file="/views/adminHome.jsp"%>
					<%@ include file="/views/category.jsp"%>

				</c:if>


			</div>
			<div id="suppliers">
				<c:if test="${isAdminClickedSuppliers==true}">
					<%@ include file="/views/adminHome.jsp"%>
					<%@ include file="/views/supplier.jsp"%>

				</c:if>
			</div>
			
			<div id="products">
				<c:if test="${isAdminClickedProducts==true}">
					<%@ include file="/views/adminHome.jsp"%>
					<%@ include file="/views/Product.jsp"%>

				</c:if>
			</div>
			
		</div>
	</div>




</body>
</html>