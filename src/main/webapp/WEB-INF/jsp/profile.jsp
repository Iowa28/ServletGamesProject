<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/profile_style.css"/>">
	<title>Profile</title>
</head>
<body>
	<header class="header">
		<div class="container">
			<div class="header-inner">

				<h1>PROFILE</h1>
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
	
	<div class="info">
		<div class="container">
			<div class="info-inner">
			
				<div class="info-avatar">
					<div class="info-image">
						<img alt="" src="images/gandalf.jpg" width="400" height="200">
					</div>
					<p>Upload a photo:</p>
					<input type="file" accept="image/*,image/jpeg">
				</div>
				<div class="info-fields">
				
					<form action="<c:url value="profile"/>" method="post">
						<div class="info-field">
							<p>Name: </p>
							<input type="text" name="name" value="${name}">
						</div>
						
						<div class="info-field">
							<p>Email: </p>
							<input type="email" name="email" value="${email}">
						</div>
						
						<div class="info-field">
							<p>Country: </p>
							<input type="text" name="country" value="${country}">
						</div>
						
						<div class="info-field">
							<p>City: </p>
							<input type="text" name="city" value="${city}">
						</div>
						
						<div class="info-field">
							<p>Date of Birth: </p>
							<input type="date" name="date" value="${date}">
						</div>
						<div class="info-field">
							<p>Favorite Game: </p>
							<input list="<game>" name="game" value="${favoriteGame}">
							<datalist id="<game>">
	 							<c:forEach items="${games}" var="game">
	 							
	 								<option value="${game.getName()}">
     	
								</c:forEach>
							</datalist>
						</div>
						<input type="submit" value="Edit" class="btn btn-success btn-lg">
					</form>
					
				</div>
				
			</div>
			
		</div>
	</div>
	
	<div class="advertising">
	  <div class="container">
	  
	  	<div class="adv-title">
	  		<h2>Реклама</h2>
	  	</div>
	  
	  	<div class="adv-items">
	  		<div class="adv-item">
	  			<img alt="" src="images/Arslanov.jpg" width="160" height="175" class="adv-image">
	  			<a href="#" style="position: absolute; left: 175px; width: 70%">
	  			  Весь мехмат вздрогул, когда стало известно, кто станет преемником М.М. Арсланова...
	  			</a>
	  		</div>
	  		
	  		<div class="adv-item">
	  			<img alt="" src="images/tatarstan.jpg" width="160" height="175" class="adv-image">
	  			<a href="#" style="position: absolute; left: 180px; width: 80%">
	  			  После этого момента во всем Татарстане начался сущий кошмар...
	  			  </a>
	  		</div>
	  	</div>
	  
	  </div>
	</div>
	
</body>
</html>