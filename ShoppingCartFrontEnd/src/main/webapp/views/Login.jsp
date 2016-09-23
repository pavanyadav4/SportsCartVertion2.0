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
	
				
					<form:form action="login"  commandName= "userDetails" method="post"  >
					
						<div class="form-group">
						<form:label path="Id">
								<spring:message text="ID"/>
						</form:label>
							<form:input path="id"  /><br>
					
						<form:label path="password">
								 <spring:message text="password"/>
								</form:label>
							<form:password  path="password"   />
						</div>
						
						
						<input type="submit" class="btn btn-success btn-block"
							value="Login"/>
						

					</form:form>

				
			

</body>
</html>