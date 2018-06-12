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
			<h2>Samochód</h2>
		</div>
		<p class="lead">Wypełnij formularz i zapisz dane</p>

		<form action="VehicleUpdate" method="post">

			<div class="form-group col-md-3">
				<label for="manufacturer">Marka:</label> <input class="form-control" id="manufacturer" type="text"
					value="${manufacturer }" name="manufacturer" required>
			</div>

			<div class="form-group col-md-3">
				<label for="model">Model:</label> <input class="form-control" id="model" type="text" value="${model }" name="model"
					required>
			</div>

			<div class="form-group col-md-3">
				<label for="year">Rok produkcji:</label> <input class="form-control" id="year" type="number" value="${year }"
					min="1930" max="2050" step="1" value="2018" name="year" required>
			</div>

			<div class="form-group col-md-3">
				<label for="nextServicingDate">Data kolejnego przeglądu technicznego:</label> <input class="form-control"
					id="nextServicingDate" type="date" value="${next_servicing_date }" name="next_servicing_date" required>
			</div>

			<div class="form-group col-md-3">
				<label for="registrationNo">Numer rejestracyjny:</label> <input class="form-control" id="registrationNo" type="text"
					value="${registration_no }" name="registration_no" required>
			</div>

			<div class="form-group col-md-6">
				<label for="customerId">Dane właściciela:</label> <select class="form-control" id="customerId" name="customer_id"
					required>
					<c:forEach var="customer" items="${customers }">
						<option value="${customer_id}" ${customer.id == customer_id ? 'selected' : '' }><c:out
								value='${customer.firstName } ${customer.lastName } - ${customer.email }'></c:out></option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group col-md-12">
				<button type="submit" class="btn btn-primary btn-submit">Zapisz dane</button>
			</div>
		</form>
	</div>

	<jsp:include page="/WEB-INF/footer.jspf" />
</body>
</html>