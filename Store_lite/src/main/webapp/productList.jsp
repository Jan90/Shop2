<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<fmt:setLocale value='en' />
<fmt:setBundle basename='page_properties/messages' var="language" />
<fmt:setLocale value='enl' />
<fmt:setBundle basename='page_properties/productList'
	var="productListLanguage" />
<title><fmt:message key="title" bundle="${language}" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script src="js/productList.js" type="text/javascript"></script>
</head>
<body>
	<div class="container" id="container">
		<div class="searchBy" id="searchBy">
			<form name="dropDown" id="dropDown">
			<p id="dropDown_name">
					<fmt:message key="productList.type" bundle="${productListLanguage}" />
				</p>
				<select id="prodType" class="prodType"
					onchange="getGenres(this.value)">
					<option
						value="<fmt:message key='productList.select'  bundle='${productListLanguage}'/>">
						<fmt:message key="productList.select"
							bundle="${productListLanguage}" /></option>
					<option
						value="<fmt:message key='productList.video'  bundle='${productListLanguage}'/>">
						<fmt:message key="productList.video"
							bundle="${productListLanguage}" /></option>
					<option
						value="<fmt:message key='productList.audio'  bundle='${productListLanguage}'/>">
						<fmt:message key="productList.audio"
							bundle="${productListLanguage}" /></option>
				</select>
				<p id="dropDown_name">
					<fmt:message key="productList.genre"
						bundle="${productListLanguage}" />
				</p>
				<select id="genre" class="genre" onchange="showSelectedProductList()">
					<option><fmt:message key="productList.select"
							bundle="${productListLanguage}" /></option>
				</select>
			</form>
			<div class="search" id="search">
				<div>
					<input class="text" id="text" type="text" size="20"
						onchange="showProductList(this.value)" /> <input class="text"
						id="text_search" type="submit"
						value="<fmt:message key='productList.search'  bundle='${productListLanguage}'/>" />
				</div>
			</div>
		</div>
		<div class="content" id="content">
			<form name="productList" action=""
				onsubmit="addToShoppingCart();return false;">
				<div class="productList" id="productList">
					<h1>
						<fmt:message key="header" bundle="${language}" />
					</h1>
					<table>
						<tr>
							<th></th>
							<th><fmt:message key="table-column_2" bundle="${language}" /></th>
							<th><fmt:message key="table-column_3" bundle="${language}" /></th>
							<th><fmt:message key="table-column_4" bundle="${language}" /></th>
						</tr>
						<c:forEach var="product" items="${productList}">
							<tr>
								<td><input type="checkbox" id="product" name="product" />
								</td>
								<td><input type="hidden" id="product" name="product"
									value="${product.type}" /> ${product.type}</td>
								<td><input type="hidden" id="product" name="product"
									value="${product.genre}" />${product.genre}</td>
								<td><input type="hidden" id="product" name="product"
									value="${product.name}" />${product.name}</td>
							</tr>
						</c:forEach>
					</table>
					<div id="addToCart">
						<input class="button" id="addToCartButton" type="submit"
							value="<fmt:message key='productList.shoppingCart'  bundle='${productListLanguage}'/>"></input>
					</div>
					<div class="pagination" id="pagination">
						<c:if test="${currentPage>1}">
							<a href="#" onclick="showProductListPage(1);">first</a>&nbsp;</c:if>
						<c:if test="${currentPage!=1}">
							<a href="#" onclick="showProductListPage('${currentPage-1}');">
								previous </a> &nbsp;  </c:if>
						<c:if test="${currentPage < pageCount}">
							<c:forEach var="pageNumber" begin="${currentPage+1}"
								end="${pageCount}">
								<a href="#" onclick="showProductListPage('${pageNumber}');">
									<c:out value="${pageNumber}" />
								</a> &nbsp; </c:forEach>
						</c:if>
						<c:if test="${currentPage< pageCount}">
							<a href="#" onclick="showProductListPage('${currentPage+1}');">
								next </a> &nbsp;</c:if>
						<c:if test="${currentPage < pageCount}">
							<a href="#" onclick="showProductListPage('${pageCount}');">
								last </a> &nbsp;</c:if>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

