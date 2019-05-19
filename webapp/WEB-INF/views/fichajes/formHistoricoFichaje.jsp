<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Histórico de fichajes</title>
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
				<span class="label label-default">HISTÓRICO DE FICHAJES</span>
			</h2>
		</div>

		<hr class="featurette-divider">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">DATOS DEL EMPLEADO</h3>
			</div>
			<div class="panel-body">
				<p>
					Id: ${empleado.id } <br> Nombre: ${empleado.nombre } <br>
					Apellido 1 : ${empleado.apellido1 } <br> Apellido 2:
					${empleado.apellido2 } <br> Fecha Alta
					Sistema:${empleado.fechaAltaEmpresa} <br> Fecha Baja
					Sistema:${empleado.fechaBajaEmpresa}
				</p>

			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">FICHAJES REGISTRADOS</h3>
			</div>
			<div class="panel-body">

				<div class="table-responsive">
					<table class="table table-hover table-striped table-bordered">
						<tr>
							<th>Id</th>
							<th>Fecha/Hora</th>
							<th>Tipo</th>

						</tr>

						<c:forEach var="fichaje" items="${fichajes}">
							<tr>
								<td>${fichaje.id}</td>
								<td>${fichaje.fechaString}</td>
								<c:choose>
									<c:when test="${fichaje.tipo eq '1'}">
										<td><span class="label label-info">Vacaciones</span></td>
									</c:when>
									<c:when test="${fichaje.tipo eq '2'}">
										<td><span class="label label-info">Enfermedad</span></td>
									</c:when>
									<c:when test="${fichaje.tipo eq '3'}">
										<td><span class="label label-info">Otras ausencias</span></td>
									</c:when>
									<c:when test="${fichaje.tipo eq '4'}">
										<td><span class="label label-info">Exento por
												errores</span></td>
									</c:when>
									<c:when test="${fichaje.tipo eq '5'}">
										<td><span class="label label-info">Entrada</span></td>
									</c:when>
									<c:when test="${fichaje.tipo eq '6'}">
										<td><span class="label label-info">Salida</span></td>
									</c:when>
									<c:otherwise>
										<td><span class="label label-danger">Sin datos</span></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>

					</table>
				</div>

			</div>
		</div>


		<a class="btn btn-danger" href="/InTime/usuarios/formUsuario" role="button">Volver</a>

	</div>



	<hr class="featurette-divider">

	<!-- FOOTER -->
	<div class="container marketing">
		<jsp:include page="../includes/footer.jsp"></jsp:include>
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