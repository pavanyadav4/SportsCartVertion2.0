<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ZoneRegester</title>
</head>
<body>

	<div align="center">
		<form:form action="Registration" method="post" commandName="userDetails">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>SportsZone Registration</h2></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" id="name" class="form-Control"/></td>
				</tr>


				<tr>
					<td>Contact:</td>
					<td><form:input path="contact" id="contact" class="form-Control"/></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" id="address" class="form-Control"/></td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><form:input type="email" path="email" id="email" class="form-Control"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" id="password" class="form-Control"/></td>
				</tr>
				<tr>
					<td>Role:</td>
					<td><form:input path="role" /></td>
				</tr>
				<tr>
					<td  colspan="2" align="center"><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>


</body>
</html>