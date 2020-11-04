<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/error_page_style.css"/>">
	<title>ERROR</title>
</head>

<body>

<div class="info">
	<div class="container">
	
		<div class="info-title">
			<h1>403</h1>
			<h1>Forbidden</h1>
		</div>
		<div class="info-text">
			<p>We are sorry, but you do not have access to this page or resource for some reason.</p>
			<p>It is possible that you are not authenticated. <a href="<c:url value="signin"/>">To do this, follow this link.</a></p>
		</div>
	</div>
</div>












<tag:footer/>