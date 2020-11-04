<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value="/css/reg_style.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
	<style>
		a {
		text-decoration: none;
		}
		a:hover {
		text-decoration: underline;
		}
	</style>
	<title>Registration</title>
</head>
<body>
	<form action="reg" method="post" class="reg">
		<p class="field">Name:</p>
		<input type="text" name="name"><br>
		<p class="field">email:</p>
		<input type="email" name="mail"><br>
		<p class="field">Password:</p>
		<input type="password" name="password1"><br>
		<p class="field">Password confirmation:</p>
		<input type="password" name="password2"><br>
		<p class="field">Consent to the processing of personal data:</p>
		<input type="checkbox" name="checkbox"><br>
		<input type="submit" value="Register" class="btn btn-success">
		<br>
		<br>
		Already have an account? <a href="<c:url value="signin"/>">Sign in</a>
	</form>
	
</body>
</html>