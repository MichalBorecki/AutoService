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
			<h2>Mechanik</h2>
		</div>
		<p class="lead">Wypełnij formularz i zapisz dane</p>

		<form action="EmployeeCreate" method="post">
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="firstName">Imię:</label> <input class="form-control" id="firstName" type="text" name="first_name"
						required>
				</div>

				<div class="form-group col-md-4">
					<label for="lastName">Nazwisko:</label> <input class="form-control" id="lastName" type="text" name="last_name"
						required>
				</div>

				<div class="form-group col-md-4">
					<label for="telephone">Telefon:</label> <input class="form-control" id="telephone" type="tel" name="telephone"
						required>
				</div>

				<div class="form-group col-md-6">
					<label for="address">Adres:</label>
					<textarea class="form-control" id="address" rows="2" type="text" name="address" required></textarea>
				</div>

				<div class="form-group col-md-6">
					<label for="note"address"">Informacje dodatkowe:</label>
					<textarea class="form-control" id="note" rows="2" type="text" name="note"></textarea>
				</div>

				<div class="form-group col-md-2">
					<label for="costOfOneHour"address"">Koszt roboczogodziny:</label> <input class="form-control" id="costOfOneHour"
						type="number" min="0.01" step="0.01" name="cost_of_one_hour" required>
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