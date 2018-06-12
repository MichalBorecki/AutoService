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

		<div class="page-header">
			<h4>
				<c:out value="${message}" default="Lista mechaników" />
			</h4>
		</div>
		<table class="table table-bordered">
			<tr>
				<th style="width: 150px"></th>
				<th>Imię</th>
				<th>Nazwisko</th>
				<th>Adres</th>
				<th>Telefon</th>
				<th>Informacje</th>
				<th>Stawka godzinowa</th>
				<th></th>
			</tr>
			<!-- List of employees -->
			<c:forEach var="employee" items="${employees }">
				<tr>
					<td><form class="form-buttons" action="EmployeeDelete" method="post">
							<button class="btn btn-info btn-sm" type="submit" name="id" value="${employee.id}">Usuń</button>
						</form>
						<form class="form-buttons" action="EmployeeUpdate" method="get">
							<button class="btn btn-info btn-sm" type="submit" name="id" value="${employee.id}">Edytuj</button>
						</form></td>
					<td>${employee.firstName }</td>
					<td>${employee.lastName }</td>
					<td>${employee.address }</td>
					<td>${employee.telephone }</td>
					<td>${employee.note }</td>
					<td>${employee.costOfOneHour }</td>
					<td><form class="form-buttons" action="VehiclesInRepair" method="get">
							<button class="btn btn-info btn-sm" type="submit" name="id" value="${employee.id }">Naprawy w toku</button>
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="/WEB-INF/footer.jspf" />
</body>
</html>