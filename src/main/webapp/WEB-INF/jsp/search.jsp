<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/welcome_style.css"/>">
	<script type="text/javascript" src="<c:url value="/js/cookie.js"/>"></script>
	<title>Welcome</title>
</head>
<body>


	<header class="header" style="height: 85px;">
		<div class="container">
			<div class="header-inner">

				<h1>MAIN</h1>
				<div class="header-nav">
					<a href="<c:url value="/welcome"/>">Main</a>
					<a href="<c:url value="/profile"/>">Profile</a>
					<c:if test="${admin == 1}">
					<a href="<c:url value="/admin"/>">Admin</a>
					</c:if>
					<a href="<c:url value="/signout"/>">Out</a>
				</div>
			
			</div>
		</div>
	</header>
	
	
	<tag:item name="${search.getName()}" raiting="${search.getRaiting()}" info="${search.getAnnotation()}"></tag:item>



<tag:footer/>