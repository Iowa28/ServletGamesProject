<%@ attribute name="name"%>
<%@ attribute name="info"%>
<%@ attribute name="raiting"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="section">
	<div class="container">

		<div class="section-item">

			<img src="<c:url value="/images/${name}.jpg"/>" width="350" height="250" alt="" class="section-icon">

			<div class="section-info">
				<h3 class="section-title">${name}</h3>
				<div class="section-text">
					<p>${info}</p>
				</div>
				<h5>Raiting: ${raiting}/10</h5>
				<form action="<c:url value="/game"/>" target="_blank">
					<button id="${name}" class="btn btn-success btn-lg" style="margin-top: 38px">Play</button>
				</form>
				
			</div>

		</div>
			
	</div>
</section>