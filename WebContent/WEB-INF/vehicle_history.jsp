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
				<c:out value="${message}" default="Historia napraw" />
			</h2>
		</div>
		<table class="table table-bordered">
			<tr>
				<th>Data przyjęcia do naprawy</th>
				<th>Opis naprawy</th>
				<th style="width: 150px"></th>
			</tr>
			<!-- List of orders -->
			<c:forEach var="order" items="${orders }">
				<tr>
					<td>${order.serviceStartDate }</td>
					<td>${order.descriptionOfRepair }</td>
					<td><form class="form-buttons" action="OrderRead" method="get">
							<button class="btn btn-info btn-sm" type="submit" name="id" value="${order.id}">Szczegóły naprawy</button>
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<jsp:include page="/WEB-INF/footer.jspf" />

</body>
</html>