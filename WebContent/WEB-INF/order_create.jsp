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
			<h2>Zlecenie</h2>
		</div>
		<p class="lead">Wypełnij formularz i zapisz dane</p>

		<form action="OrderCreate" method="post">

			<div class="form-group col-md-6">
				<label for="vehicleId">Wybierz samochód:</label> <select class="form-control" id="vehicleId" name="vehicle_id"
					required>
					<option hidden disabled selected value>-- wybierz samochód --</option>
					<c:forEach var="vehicle" items="${vehicles }">
						<option value="${vehicle.id }"><c:out
								value='${vehicle.manufacturer } "${vehicle.model }" o numerze rejest.: ${vehicle.registrationNo }'></c:out></option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group col-md-3">
				<label for="orderDate">Data przyjęcia do naprawy:</label> <input class="form-control" id="orderDate" type="date"
					name="order_date" required>
			</div>

			<div class="form-group col-md-3">
				<label for="plannedServiceStart">Planowana data rozpoczęcia naprawy:</label> <input class="form-control"
					id="plannedServiceStart" type="date" name="planned_service_start">
			</div>

			<div class="form-group col-md-12">
				<label for="descriptionOfProblem">Opis problemu:</label>
				<textarea class="form-control" id="descriptionOfProblem" rows="4" type="text" name="description_of_problem" required></textarea>
			</div>

			<div style="clear: left" class="form-group col-md-3">
				<label for="serviceStartDate">Data rozpoczęcia naprawy:</label> <input class="form-control" id="serviceStartDate"
					type="date" name="service_start_date">
			</div>

			<div class="form-group col-md-3">
				<label for="employeeId">Wybierz mechanika:</label> <select class="form-control" id="employeeId" name="employee_id">
					<option value="0">-- wybierz mechanika --</option>
					<c:forEach var="employee" items="${employees }">
						<option value="${employee.id }"><c:out value='${employee.firstName } ${employee.lastName }'></c:out></option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group col-md-12">
				<label for="descriptionOfRepair">Opis naprawy:</label>
				<textarea class="form-control" id="descriptionOfRepair" rows="4" type="text" name="description_of_repair"></textarea>
			</div>

			<div class="form-group col-md-3">
				<label for="costForCustomer">Koszt naprawy dla klienta:</label> <input class="form-control" id="costForCustomer"
					type="number" value="0.00" min="0.00" step="0.01" name="cost_for_customer">
			</div>

			<div class="form-group col-md-3">
				<label for="costOfSpareParts">Koszt wykorzystanych części:</label> <input class="form-control" id="costOfSpareParts"
					type="number" value="0.00" min="0.00" step="0.01" name="cost_of_spare_parts">
			</div>

			<div class="form-group col-md-3">
				<label for="repairTime">Ilość roboczogodzin:</label> <input class="form-control" id="repairTime" type="number"
					value="0.00" min="0.00" step="0.25" name="repair_time">
			</div>

			<div class="form-group col-md-3">
				<label for="status">Status:</label> <select class="form-control" id="status" name="status" required>
					<option hidden disabled selected value>-- wybierz status --</option>
					<option value="1">Przyjęty</option>
					<option value="2">Zatwierdzone koszty naprawy</option>
					<option value="3">W naprawie</option>
					<option value="4">Gotowy do odbioru</option>
					<option value="5">Rezygnacja</option>
				</select>
			</div>

			<div class="form-group col-md-3">
				<label for="serviceEndDate">Data zakończenia naprawy:</label> <input class="form-control" id="serviceEndDate"
					type="date" name="service_end_date">
			</div>

			<div style="clear: left" class="form-group col-md-3">
				<button type="submit" class="btn btn-primary btn-submit">Zapisz dane</button>
			</div>
		</form>
	</div>

	<jsp:include page="/WEB-INF/footer.jspf" />

</body>
</html>