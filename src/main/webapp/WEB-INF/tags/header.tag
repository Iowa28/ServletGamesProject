<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<header class="header">
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
			
			<form action="<c:url value="welcome"/>" method="post">
				<input list="<game>" name="search" class="form-control ds-input"
	            placeholder="Search Games" style="margin-top: 5px;">
	            <datalist id="<game>">
		 			<c:forEach items="${games}" var="game">
		 							
		 				<option value="${game.getName()}">
	     	
					</c:forEach>
				</datalist>
			</form>
		</div>
	</header>