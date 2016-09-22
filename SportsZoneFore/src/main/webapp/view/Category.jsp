<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Page</title>
</head>
<body>

	<h1>Add a Category</h1>
	<c:url var="addAction" value="/category/add"></c:url>
	<form:form action="${addAction}" commandName="category">
		<table>
			<tr>
				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<c:choose>
					<c:when test=""${!empty category.id}">
						<td><form:input path="id" disabled="true" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="id" pattern=".{4,7}" required="true"
								title="id shopul contail 4 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name"></spring:message>
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="descreption">
						<spring:message text="Descreption"></spring:message>
					</form:label></td>
				<td><form:input path="descreption" required="true" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty category.name}">
						<input type="submit"
							value="<spring:message text="Edit Category"/>" />
					</c:if> <c:if test="${empty category.name}">
						<input type="submit" value="<spring:message text="Add Category"/>" />
					</c:if></td>
			</tr>
		</table>

	</form:form>
<br>



</body>
</html>