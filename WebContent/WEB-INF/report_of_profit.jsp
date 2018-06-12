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

		<form action="/Auto_Service/ReportOfProfit">
			<h4>Wyznacz okres do obliczenia raportu zysków:</h4>
			<div class="form-group col-md-6">
				<label for=""startDate"">Początek:</label> <input class="form-control" id="" startDate"" type="date"
					name="startDate" value="${startDate }">
			</div>
			<div class="form-group col-md-6">
				<label for="endDate">Koniec:</label> <input class="form-control" id="endDate" type="date" name="endDate"
					value="${endDate }">
			</div>

			<button type="submit" class="btn btn-primary btn-submit">Sprawdź</button>
		</form>

		<div class="page-header">
			<h4>
				<c:out value="${profit}" />
			</h4>
		</div>
	</div>

	<jsp:include page="/WEB-INF/footer.jspf" />

</body>
</html>