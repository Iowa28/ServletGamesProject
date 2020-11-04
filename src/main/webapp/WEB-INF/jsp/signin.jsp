<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/reg_style.css"/>">
	<style>
		a {
		text-decoration: none;
		}
		a:hover {
		text-decoration: underline;
		}
	</style>
	<title>Sign In</title>
</head>
<body>
	<form action="<c:url value="signin"/>" method="POST" class="reg">
	<p class="field">email:</p>
  	<input name="email" type="email" placeholder="Email"<c:if test="${not empty email}"> value="<c:out value="${email}"/>"</c:if>><br>
  	
  	<p class="field">Password:</p>
  	<input name="password" type="password" placeholder="Password"><br><br>
  	
  	<input type="submit" value="Sing In" class="btn btn-success"><br><br>
  	
  	Don't have an account yet? <a href="<c:url value="reg"/>">Register now</a>
	</form>
	
</body>
</html>