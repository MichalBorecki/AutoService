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
				<c:out value="${message}" default="Lista klientów" />
			</h2>
		</div>
		<table class="table table-bordered">
			<tr>
				<th style="width: 150px"></th>
				<th>Imię</th>
				<th>Nazwisko</th>
				<th>Samochody</th>
				<th>E-mail</th>
				<th>Data urodzenia</th>
			</tr>
			<!-- List of customers vehicles -->
			<c:forEach var="customer" items="${customers }">
				<tr>
					<td><form class="form-buttons" action="CustomerDelete" method="post">
							<button class="btn btn-info btn-sm" type="submit" name="id" value="${customer.id}">Usuń</button>
						</form>
						<form class="form-buttons" action="CustomerUpdate" method="get">
							<button class="btn btn-info btn-sm" type="submit" name="id" value="${customer.id}">Edytuj</button>
						</form></td>
					<td>${customer.firstName }</td>
					<td>${customer.lastName }</td>
					<td><a href=/Auto_Service/CustomerVehicle?id=${customer.id}>Lista samochodów</a></td>
					<td>${customer.email }</td>
					<td>${customer.dateOfBirth }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<jsp:include page="/WEB-INF/footer.jspf" />

</body>
</html>