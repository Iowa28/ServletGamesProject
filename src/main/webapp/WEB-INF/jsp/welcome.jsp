<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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


<tag:header/>


<c:if test="${not empty name}">
	<br>
	<div class="container">
	<tag:name/>
	</div>
</c:if>


<div class="intro">
	<div class="container">

		<div class="intro-header">
			<h2>About Site</h2>
		</div>

		<div class="intro-text">
			<p>This site is a set of simple browser games written in java script. It was made for a semester computer science work and homework assignment. This is my first experience in developing a site like this and similar games, so there is nothing special about them, but I still hope that you get at least a little pleasure from them. Enjoy it!</p>
		</div>

	</div>
</div>

<div class="categories">
	<div class="container">
		
		<div class="categories-header">
			<h2>Search By Category</h2>
		</div>

		<form action="<c:url value="welcome"/>" method="post">
		
			<c:forEach items="${categories}" var="category">
				<input type="submit" value="${category.getName()}" name="${category.getId()}" class="btn btn-info btn-lg">
			</c:forEach>
		
			<input type="submit" value="All" name="all" class="btn btn-info btn-lg">
			
		</form>
	</div>
</div>



<c:forEach items="${games}" var="game">
    
     <tag:item name="${game.getName()}" raiting="${game.getRaiting()}" info="${game.getAnnotation()}"></tag:item>
     	
</c:forEach>
    


<tag:footer/>