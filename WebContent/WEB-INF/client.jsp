<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/header.jspf" />
</head>
<body>

	<jsp:include page="/WEB-INF/navbar.jspf" />
	<div class="container">
		<div class="page-header">
			<h2>Klient</h2>
		</div>

		<!-- Form for searching client in database -->
		<form action="ClientSearch" method="post">

			<p>
				Podaj nazwisko: <br> <input type="text" name="lastName">
			</p>

			<div>
				<input class="btn btn-primary" type="submit" value="Wyszukaj">
			</div>
		</form>
	</div>

	<!-- List of clients cars -->
	<c:forEach var="client" items="${clients}">
		<p>
			Klient:
			<c:out value="${client.lastName}" />
			Samochód:
			<c:out value="${car.car_registrationNo}" />
		</p>
	</c:forEach>

	<jsp:include page="/WEB-INF/footer.jspf" />
</body>
</html>