<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<fmt:setLocale value='en' />
<fmt:setBundle basename='page_properties/messages' var="language" />
<fmt:setLocale value='en' />
<fmt:setBundle basename='page_properties/shoppingCart'
	var="shoppingCartLanguage" />
<title><fmt:message key="title" bundle="${language}" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/shoppingCart.js"></script>
</head>
<body>
	<h1>
		<fmt:message key="shopping-cart" bundle="${shoppingCartLanguage}" />
	</h1>
	<table>
		<tr>
			<th><fmt:message key="table-column_2" bundle="${language}" /></th>
			<th><fmt:message key="table-column_3" bundle="${language}" /></th>
			<th><fmt:message key="table-column_4" bundle="${language}" /></th>
			<th><fmt:message key="table-column_5"
					bundle="${shoppingCartLanguage}" /></th>
			<td></td>
		</tr>
		<c:forEach var="product" items="${cartProducts}" varStatus="loop">
			<tr>
				<td value="${product.type}">${product.type}</td>
				<td value="${product.genre}">${product.genre}</td>
				<td value="${product.name}">${product.name}</td>
				<td value="${product.quantity}">${product.quantity}</td>
				<td><form>
						<button id="removeButton" value="${loop.index}"
							onclick="removeProduct(this.value)" type="button">
							<fmt:message key="remove-product"
								bundle="${shoppingCartLanguage}" />
						</button>
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

