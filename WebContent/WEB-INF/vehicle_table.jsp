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
			<h2>
				<c:out value="${message}" default="Lista samochodów:" />
			</h2>
		</div>
		<table class="table table-bordered">
			<tr>
				<th style="width: 150px"></th>
				<th>Model</th>
				<th>Marka</th>
				<th>Rok produkcji</th>
				<th>Numer rejestracyjny</th>
				<th>Właściciel</th>
				<th>Data następnego przeglądu</th>
			</tr>
			<!-- List of vehicles  -->
			<c:forEach var="vehicle" items="${vehicles }">
				<tr>
					<td><form class="form-buttons" action="VehicleDelete" method="post">
							<button class="btn btn-info btn-sm" type="submit" name="id" value="${vehicle.id}">Usuń</button>
						</form>
						<form class="form-buttons" action="VehicleUpdate" method="get">
							<button class="btn btn-info btn-sm" type="submit" name="id" value="${vehicle.id}">Edytuj</button>
						</form></td>
					<td>${vehicle.model }</td>
					<td>${vehicle.manufacturer }</td>
					<td>${vehicle.year }</td>
					<td>${vehicle.registrationNo }</td>
					<td><c:forEach var="customer" items="${customers }">
							<c:if test="${customer.id == vehicle.customerId}">
								<a href=/Auto_Service/CustomerRead?id=${vehicle.customerId}> <c:out
										value='${customer.firstName } ${customer.lastName }'></c:out></a>
							</c:if>
						</c:forEach></td>
					<td>${vehicle.nextServicingDate }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<jsp:include page="/WEB-INF/footer.jspf" />

</body>
</html>