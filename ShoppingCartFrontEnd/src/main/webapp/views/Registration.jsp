<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Registration</title>
</head>
<body >



${RegisterMsg}
	<form:form action="register"  method="post" commandName="userDetails" >
					
					
						<form:label path="Id">
								<spring:message text="ID"/>
						</form:label>
							<form:input path="id"  /><br>
							
								<form:label path="name">
								 <spring:message text="name"/>
								</form:label>
							<form:input  path="name"   /><br>
					
						<form:label path="password">
								 <spring:message text="password"/>
								</form:label>
							<form:password  path="password" /><br>
						
						
								<form:label path="mail">
								 <spring:message text="mail"/>
								</form:label>
							<form:input  path="mail"   /><br>
							
							<form:label path="contact">
								 <spring:message text="contact"/>
								</form:label>
							<form:input  path="contact"   /><br>
							
							<form:label path="address">
								 <spring:message text="address"/>
								</form:label>
							<form:input path="address"   /><br>
					
						
						<input type="submit" class="btn btn-success btn-block"
							value="Register"/>
</form:form>

	
</body>
</html>