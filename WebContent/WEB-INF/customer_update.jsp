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

		<p class="lead">Edytuj dane w formularzu i zapisz</p>

		<form action="/Auto_Service/CustomerUpdate" method="post">
			<div class="form-row">
				<div class="form-group col-md-3">
					<label for="firstName">Imię:</label> <input class="form-control" id="firstName" type="text" value="${first_name}"
						name="first_name" required>
				</div>

				<div class="form-group col-md-3">
					<label for="lastName">Nazwisko:</label> <input class="form-control" id="lastName" type="text" value="${last_name}"
						name="last_name" value="${last_name}" required>
				</div>

				<div class="form-group col-md-3">
					<label for="email">E-mail:</label> <input class="form-control" id="email" type="email" value="${email_address}"
						name="email_address" value="${email_address}" required>
				</div>

				<div class="form-group col-md-3">
					<label for="dateOfBirth">Data urodzenia:</label> <input class="form-control" id="dateOfBirth" type="date"
						name="date_of_birth" value="${date_of_birth}">
				</div>
			</div>

			<div class="form-group col-md-12">
				<button type="submit" class="btn btn-primary btn-submit">Zapisz dane</button>
			</div>
		</form>
	</div>

	<jsp:include page="/WEB-INF/footer.jspf" />

</body>
</html>