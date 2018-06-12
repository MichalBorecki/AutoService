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
		<!-- Form for searching customer by lastName in database -->
		<form class="form-search" action="CustomerSearch" method="post">

			<h3>Wyszukaj klienta</h3>
			<br> <input type="text" name="last_name" placeholder="wpisz nazwisko"> <input class="btn btn-primary"
				type="submit" value="Wyszukaj">

		</form>
	</div>

	<jsp:include page="/WEB-INF/footer.jspf" />

</body>
</html>