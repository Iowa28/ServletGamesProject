<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/admin_style.css"/>">
	<title>Admin</title>
</head>
	
	
<body>

<header class="header">
	<div class="container">
		<div class="header-inner">

			<h1>ADMIN</h1>
			<div class="header-nav">
				<a href="<c:url value="/welcome"/>">Main</a>
				<a href="<c:url value="/profile"/>">Profile</a>
				<a href="<c:url value="/admin"/>">Admin</a>
				<a href="<c:url value="/signout"/>">Out</a>
			</div>
			
		</div>
	</div>
</header>


<div class="title">
	<div class="container">
		<h1>User list:</h1>
	</div>
</div>

<c:forEach items="${users}" var="user">
	<div class="user">
		<div class="container">
			<div class="user-inner">
			
				<div class="user-fields">
				
					<form action="<c:url value="admin"/>" method="post">
						<div class="user-field">
							<p>Id: </p>
							<input type="text" name="id" value="${user.getId()}" readonly>
						</div>
						<div class="user-field">
							<p>Name: </p>
							<input type="text" name="name" value="${user.getName()}">
						</div>
						
						<div class="user-field">
							<p>Email: </p>
							<input type="email" name="email" value="${user.getEmail()}">
						</div>
						
						<div class="user-field">
							<p>Password: </p>
							<input type="text" name="password" value="${user.getPassword()}">
						</div>
						
						<div class="user-field">
							<p>Country: </p>
							<input type="text" name="country" value="${user.getCountry()}">
						</div>
						
						<div class="user-field">
							<p>City: </p>
							<input type="text" name="city" value="${user.getCity()}">
						</div>
						
						<div class="user-field">
							<p>Date of Birth: </p>
							<input type="date" name="date" value="${user.getDate()}">
						</div>
						<input type="submit" value="Edit" name="edit" class="btn btn-success btn-lg">
						<input type="reset" value="Reset" class="btn btn-primary btn-lg">
						<input type="submit" value="Delete" name="delete" class="btn btn-danger btn-lg">
					</form>
					
				</div>
			
			</div>
		</div>
	</div>
     	
</c:forEach>

<div class="title">
	<div class="container">
		<h1>Add user:</h1>
	</div>
</div>

<div class="user">
		<div class="container">
			<div class="user-inner">
			
				<div class="user-fields">
				
					<form action="<c:url value="admin"/>" method="post">
						<div class="user-field">
							<p>Name: </p>
							<input type="text" name="name">
						</div>
						
						<div class="user-field">
							<p>Email: </p>
							<input type="email" name="email">
						</div>
						
						<div class="user-field">
							<p>Password: </p>
							<input type="text" name="password">
						</div>
						
						<div class="user-field">
							<p>Country: </p>
							<input type="text" name="country">
						</div>
						
						<div class="user-field">
							<p>City: </p>
							<input type="text" name="city">
						</div>
						
						<div class="user-field">
							<p>Date of Birth: </p>
							<input type="date" name="date">
						</div>
						<input type="submit" value="Add" name="add" class="btn btn-success btn-lg">
					</form>
					
				</div>
			
			</div>
		</div>
	</div>


<tag:footer/>