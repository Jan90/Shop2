<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setLocale value='en' />
<fmt:setBundle basename='page_properties/messages' var="language" />
<fmt:setLocale value='en' />
<fmt:setBundle basename='page_properties/main' var="mainLanguage" />
<title><fmt:message key="title" bundle="${language}" /></title>
</head>
<body>
	<h2>
		<fmt:message key="main.information" bundle="${mainLanguage}" />
	</h2>
	<h1>
		<fmt:message key="main.table-header" bundle="${mainLanguage}" />
	</h1>
	<table>
		<tr>
			<th><fmt:message key="table-column_2" bundle="${language}" /></th>
			<th><fmt:message key="table-column_3" bundle="${language}" /></th>
			<th><fmt:message key="table-column_4" bundle="${language}" /></th>
		</tr>
		<c:forEach var="product" items="${newProducts}">
			<tr>
				<td>${product.type}</td>
				<td>${product.genre}</td>
				<td>${product.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>