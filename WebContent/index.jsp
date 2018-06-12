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

		<form class="col-md-3 form-search" action="VehiclesInRepair">
			<label for="employeeId"></label> <select style="float: left;" class="form-control" id="employeeId" name="id">
				<option disabled selected value required>-- wybierz mechanika --</option>
				<c:forEach var="employee" items="${employees }">
					<option value="${employee.id }"><c:out value='${employee.firstName } ${employee.lastName }'></c:out></option>
				</c:forEach>
			</select> <input class="btn btn-primary btn-main-site" type="submit" value="Wyszukaj zlecenia w naprawie"><br><br>
			<button class="btn btn-primary btn-main-site" type="submit" name="viewAll" value="viewAll">Pokaż wszystkie zlecenia w naprawie</button>

			 
		</form>

		<div class="col-md-12 page-header">
			<h3>
				<c:out value="${message}" default="" />
			</h3>
		</div>

		<table class="table table-bordered">
			${tableHeader }
			<!-- List of orders -->
			<c:forEach var="order" items="${orders }">
				<tr>
					<td><form class="form-buttons" action="OrderDelete" method="post">
							<button class="btn btn-info btn-sm" type="submit" name="id" value="${order.id}">Usuń</button>
						</form>
						<form class="form-buttons" action="OrderUpdate" method="get">
							<button class="btn btn-info btn-sm" type="submit" name="id" value="${order.id}">Edytuj</button>
						</form></td>
					<td>${order.orderDate }</td>
					<td>${order.plannedServiceStart }</td>
					<td>${order.serviceStartDate }</td>
					<td><c:forEach var="employee" items="${employees }">
							<c:if test="${employee.id == order.employeeId}">
								<a href=/Auto_Service/EmployeeRead?id=${employee.id}> <c:out
										value='${employee.firstName } ${employee.lastName }'></c:out></a>
							</c:if>
						</c:forEach></td>
					<td>${order.descriptionOfProblem }</td>
					<td>${order.descriptionOfRepair }</td>
					<td><c:if test="${order.status == 1 }">
							<c:out value="Przyjęty"></c:out>
						</c:if> <c:if test="${order.status == 2 }">
							<c:out value="Zatwierdzone koszty naprawy"></c:out>
						</c:if> <c:if test="${order.status == 3 }">
							<c:out value="W naprawie"></c:out>
						</c:if> <c:if test="${order.status == 4 }">
							<c:out value="Gotowy do obioru"></c:out>
						</c:if> <c:if test="${order.status == 5 }">
							<c:out value="Rezygnacja"></c:out>
						</c:if></td>
					<td><c:forEach var="vehicle" items="${vehicles }">
							<c:if test="${vehicle.id == order.vehicleId}">
								<a href=/Auto_Service/VehicleRead?id=${vehicle.id}> <c:out
										value='${vehicle.manufacturer } "${vehicle.model }"'></c:out> <br> <c:out
										value='${vehicle.registrationNo }'></c:out></a>
							</c:if>
						</c:forEach></td>
					<td>${order.costForCustomer }</td>
					<td>${order.costOfSpareParts }</td>
					<td>${order.costOfOneHour }</td>
					<td>${order.repairTime }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<jsp:include page="/WEB-INF/footer.jspf" />

</body>
</html>
