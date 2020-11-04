<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src="<c:url value="js/ball.js"/>"></script>
	<link rel="stylesheet" href="<c:url value="css/football.css"/>">
	<title>Football</title>
</head>
<body>
	<div class="block">
		<img src="images/ball.png" alt="" id="ball" width="75" height="75" style="position: relative; left: 75px;">
	</div>
	<p style="padding-top: 0px; text-align: center;">
		<button type="button" id="button">KICK</button>
	</p>
</body>
</html>