<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/header.jspf" />
</head>
<body>

	<jsp:include page="/WEB-INF/navbar.jspf" />

	<div class="container">

		<form action="/Auto_Service/EmployeeHours">
			<h4>Wyznacz okres do obliczenia ilości godzin każdego pracownika:</h4>
			<div class="form-group col-md-6">
				<label for=""startDate"">Początek:</label> <input class="form-control" id="" startDate"" type="date"
					name="startDate">
			</div>
			<div class="form-group col-md-6">
				<label for="endDate">Koniec:</label> <input class="form-control" id="endDate" type="date" name="endDate">
			</div>

			<button type="submit" class="btn btn-primary btn-submit">Sprawdź</button>
		</form>

		<div class="page-header">
			<h4>
				<c:out value="${message}" default="Ilość przepracowanych godzin" />
			</h4>
		</div>
		<table class="table table-bordered">
			<tr>
				<th>Pracownik</th>
				<th>Ilość godzin</th>
			</tr>
			<c:forEach var="order" items="${employeeHours}">
				<tr>
					<td><c:forEach var="employee" items="${employees }">
							<c:if test="${employee.id == order.employeeId }">
								<a href=/Auto_Service/EmployeeRead?id=${employee.id}> <c:out
										value='${employee.firstName } ${employee.lastName }'></c:out></a>
							</c:if>
						</c:forEach></td>
					<td>${order.repairTime}</td>

				</tr>
			</c:forEach>
		</table>
	</div>

	<jsp:include page="/WEB-INF/footer.jspf" />

</body>
</html>