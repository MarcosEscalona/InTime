<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>InTime</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot" />
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">

</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3 class="panel-title">Error 400</h3>
			</div>
			<div class="panel-body">
				<img src="${urlPublic}/images/error.png" width="48" height="48" class="center">
				<h4> El requerimiento enviado por el cliente es sintácticamente incorrecto!</h4>				
				<br>
				<a class="btn btn-danger" href="/InTime/usuarios/formUsuario" role="button">Volver</a>
			</div>
		</div>

		<div class="container marketing">
			<jsp:include page="../includes/footer.jsp"></jsp:include>
		</div>

	</div>



	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
