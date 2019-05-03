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
<title>Login</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot" />
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">

</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<div class="row">
			<h2 class="text text-center">
				<span class="label label-default">LOGIN</span>
			</h2>
		</div>
		<div class="row page-header"></div>

		<c:if test="${mensaje!=null }">

			<div class='alert alert-success' role="alert">${ mensaje}</div>

		</c:if>

		<!-- Marketing messaging -->
		<div class="container marketing">

			<div class="ContentForm col-md-4"></div>

			<div class="ContentForm col-md-4">
				<form action="" method="post" name="FormEntrar">
					<div class="input-group input-group-lg">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-envelope"></i></span> <input type="email"
							class="form-control" name="correo" placeholder="Correo"
							id="Correo" aria-describedby="sizing-addon1" required>
					</div>
					<br>
					<div class="input-group input-group-lg">
						<span class="input-group-addon" id="sizing-addon1"><i
							class="glyphicon glyphicon-lock"></i></span> <input type="password"
							name="contra" class="form-control" placeholder="******"
							aria-describedby="sizing-addon1" required>
					</div>
					<br> <a class="btn btn-lg btn-primary btn-block btn-signin"
						id="IngresoLog" href="${urlRoot }/home" role="button">Acceder</a>

				</form>
			</div>
		</div>

	</div>

	<div class="row page-header"></div>

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
