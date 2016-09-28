<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${errorMessage}

<h1>Add Supplier</h1>
	<div class="table responsive" align="center">
<c:url var="addAction" value="supplier/add"></c:url>
<form:form action="${addAction}" commandName="supplier">
	<table class="table table-hover" style="width: 80%">
	<tr>
			<td><form:label path="id"> <spring:message text="ID"/></form:label></td>
					<c:choose>
							<c:when test="${!empty supplier.id}">
							<td><form:input path="id"  readonly="true"/> </td>
							</c:when>
									
							 <c:otherwise>
							 <td><form:input path="id" pattern="{5,10}" required="true" title="id should be between 5 to 10 characters"/> </td>
							 </c:otherwise>
					</c:choose>
			</tr>
		<tr>
			<td><form:label path="name"> <spring:message text="name"/></form:label></td>
			<td><form:input path="name" required="true"/> </td>
		</tr>
		
		<tr>
			<td><form:label path="address"> <spring:message text="address"/></form:label></td>
			<td><form:input path="address" required="true"/> </td>
		</tr>
		<tr>
			<td colspan="2">
					
					<c:if test="${!empty supplier.name}" > 
			
						
							
			<input type="submit" value="<spring:message text="Edit supplier"/> "> 
			
			 </c:if> 
			<c:if test="${empty supplier.name}">
			<input type="submit" value="<spring:message text="Add supplier"/> "> 
			</c:if>
			</td>

		</tr>
</table>
</form:form>
</div>
<br>


<h3>Supplier List</h3>
	<div class="table responsive" align="center">
	<c:if test="${!empty supplierList}">
	<table class="table table-hover" style="width: 80%">
		<tr>
				<th width="80">Supplier Id</th>
				<th	width="120">Supplier Name</th>
				<th width="120">Supplier Address</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
		</tr>
		<c:forEach items="${supplierList}" var="supplier">
			<tr>
				<td>${supplier.id}</td>
				<td>${supplier.name}</td>
				<td>${supplier.address}</td>
				<td><a href="<c:url value="supplier/update/${supplier.id}"/>">Edit</a></td>
				<td><a href="<c:url value="supplier/remove/${supplier.id}"/>">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
</div>

</body>
</html>