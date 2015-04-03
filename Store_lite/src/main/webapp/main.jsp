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
<fmt:setBundle basename='page_properties/main' var="mainLanguage" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
<link rel="stylesheet" type="text/css" href="css/style.css"
	media="screen"></link>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/json2/20140204/json2.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title><fmt:message key="title" bundle="${language}" /></title>
</head>
<body>
	<script type="text/javascript" src="js/main.js"></script>
	<div class="container" id="container">

		<div class="header" id="header">
			<h1>
				<fmt:message key="main.header" bundle="${mainLanguage}" />
			</h1>
		</div>
		<div class="menu" id="menu">
			<p>
				<input class="button" type="button"
					value="<fmt:message key='main.main'  bundle='${mainLanguage}'/>"
					id="toMainPageButton" onclick="nextPage(this.id);"></input>
			</p>
			<br></br>
			<p>
				<input class="button" type="button" id="toProductListButton"
					value="<fmt:message key='main.catalogue'  bundle='${mainLanguage}'/>"
					onclick="nextPage(this.id);"></input>
			</p>
			<br></br>
			<p>
				<input class="button" type="button" id="toShopCartButton"
					value="<fmt:message key='main.shopping-cart' bundle='${mainLanguage}'/>"
					onclick="nextPage(this.id);"></input>
			</p>
			<select id="changeBackgrnd" onchange="changeBackgrnd(this.id)">
				<option><fmt:message key="main.choose-color"
						bundle="${mainLanguage}" /></option>
				<option
					value="<fmt:message key='main.hex.color-blue'  bundle='${mainLanguage}' />">
					<fmt:message key="main.color-blue" bundle="${mainLanguage}" /></option>
				<option
					value="<fmt:message key='main.hex.color-green'  bundle='${mainLanguage}'/>">
					<fmt:message key="main.color-green" bundle="${mainLanguage}" /></option>
				<option
					value="<fmt:message key='main.hex.color-red'   bundle='${mainLanguage}'/>">
					<fmt:message key="main.color-red" bundle="${mainLanguage}" /></option>
				<option
					value="<fmt:message key='main.hex.color-purple'  bundle='${mainLanguage}'/>">
					<fmt:message key="main.color-purple" bundle="${mainLanguage}" /></option>
				<option
					value="<fmt:message key='main.hex.color-very_light_red'   bundle='${mainLanguage}'/>">
					<fmt:message key="main.color-very_light_red"
						bundle="${mainLanguage}" /></option>
			</select>
		</div>
		<div class="content" id="content">

			<div class="information">
				
			</div>
			<div class="newItems">
				
			</div>
		</div>
		<div class="footer" id="footer">
			<fmt:message key="main.footer" bundle="${mainLanguage}" />
		</div>
	</div>
</body>
</html>