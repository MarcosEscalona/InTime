<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Creacion de Noticias</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">



		<div class="row">
			<h2 class="text text-center">
				<span class="label label-default">FICHAJE DE SALIDA</span>
			</h2>
		</div>

		<hr class="featurette-divider">

		<h1>Nombre del Empleado ${  nombre}</h1>
		<h2>Apellido 1 del Empleado ${apellido1 }</h2>
		<h2>Hoy es ${fechaActual }</h2>

		<a class="btn btn-danger"
			href="/InTime/"
			role="button">Volver</a>




	</div>



	<hr class="featurette-divider">

	<!-- FOOTER -->
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
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${urlPublic}/tinymce/tinymce.min.js"></script>

</body>
</html>