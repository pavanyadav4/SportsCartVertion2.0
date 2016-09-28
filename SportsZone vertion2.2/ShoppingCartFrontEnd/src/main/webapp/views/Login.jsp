<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>



	${LoginMsg}
	<form:form action="login" commandName="userDetails" method="post">
		<div class=form-group>


			<form:label path="Id">
				<spring:message text="USER ID" />
			</form:label>

			<form:input path="id" class="form-control requried"
				placeholder="Userid" />


		</div>
		<div class=form-group>

			<form:label path="password">
				<spring:message text="PASSWORD" />
			</form:label>

			<form:password path="password" class="form-control requried"
				placeholder="Enter password" />

		</div>
		<div class="form-group">

			<div class="checkbox">
				<form:label path="">
					<input type="checkbox"> Remember me</form:label>
			</div>
		</div>
		<div>
			<input type="submit" class="btn btn-success" value="Login" />
		</div>
	</form:form>
</body>
</html>