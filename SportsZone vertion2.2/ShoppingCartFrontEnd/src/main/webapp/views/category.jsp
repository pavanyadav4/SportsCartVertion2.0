<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>

	${SavedMsg} ${updateMsg} ${ErrorUpdateMsg}
	<h1>Add Category</h1>
	<c:url var="addAction" value="category/add"></c:url>
	<div class="table responsive" align="center">
	<form:form action="${addAction}" commandName="category">
		<table class="table table-hover" style="width: 80%">
			<tr>
				<td><form:label path="categoryid">
						<spring:message text="ID" />
					</form:label></td>
					<c:choose>
				<c:when test="${!empty category.categoryid}">
					<td><form:input path="categoryid"  readonly="true" /></td>
				</c:when>

				<c:otherwise>
					<td><form:input path="categoryid" pattern="{5,10}" required="true"
							title="id should be between 5 to 10 characters" /></td>
				</c:otherwise>
</c:choose>
			</tr>
			<tr>
				<td><form:label path="name">
						<spring:message text="name" />
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>

			<tr>
				<td><form:label path="description">
						<spring:message text="description" />
					</form:label></td>
				<td><form:input path="description" required="true" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty category.name}">
						<input type="submit"
							value="<spring:message text="Edit category"/> ">

					</c:if> <c:if test="${empty category.name}">
						<input type="submit"
							value="<spring:message text="Add category"/> ">
					</c:if></td>

						
			</tr>
		</table>
	</form:form>
	<br>
</div>

	<h3>Category List</h3>
	<c:if test="${!empty categoryList}">
	<div class="table responsive" align="center">
		<table class="table table-hover" style="width: 80%">

			<tr>
				<th width="80">Category Id</th>
				<th width="120">Category Name</th>
				<th width="120">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.categoryid}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="<c:url value="category/Update/${category.categoryid}"/>">Edit</a></td>
						<%-- <jsp:include page="edit.jsp"></jsp:include> --%>
					<td><a href="<c:url value="category/Remove/${category.categoryid}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		
		</table>
</div>	
	</c:if>


</body>
</html>