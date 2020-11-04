<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value="css/minesweeper.css"/>"> 
	<script type="text/javascript" src="<c:url value="js/minesweeper.js"/>"></script>
	<title>Minesweeper</title>
</head>
<body>
	<h1>Minesweeper</h1>
	<table id="grid"></table>
	<button id="button">Reset Grid</button>
</body>
</html>