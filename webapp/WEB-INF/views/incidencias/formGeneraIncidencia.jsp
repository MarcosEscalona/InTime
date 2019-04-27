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
				<span class="label label-default">GENERACIÓN DE INCIDENCIA</span>
			</h2>
		</div>

		<hr class="featurette-divider">

		<spring:url value="/incidencias/guardarIncidencia" var="urlForm"></spring:url>
		<form action="${urlForm }" method="post">
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="titulo">Fecha de comienzo de la incidencia</label> <input
							type="date" id="fechaComienzo" name="fechaComienzo" required="required" />

					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<div class="form-group">
							<label for="titulo">Fecha de fin de la incidencia</label> <input
								type="date" id="fechaFin" name="fechaFin" required="required" />

						</div>
					</div>
					<div class="col-sm-5">
						<div class="form-group">
							<label for="tipo">Tipo</label> <select id="tipo" name="tipo"
								class="form-control">
								<option value="Vacaciones">Vacaciones</option>
								<option value="Baja">Baja medica</option>
								<option value="Otras">Otras ausencias</option>
								<option value="Errores">Errores en el marcaje</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-10">
						<div class="form-group">
							<label for="detalle">Comentario</label>
							<textarea class="form-control" name="comentario" id="comentario"
								rows="10"></textarea>
						</div>
					</div>
				</div>

				<button type="submit" class="btn btn-danger">Guardar</button>
		</form>

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