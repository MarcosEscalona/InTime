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
<title>Gestión de incidencias (empleado)</title>
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
				<span class="label label-default">GESTIÓN GLOBAL DE INCIDENCIAS</span>
			</h2>
		</div>
		
		<c:if test="${mensaje!=null }">
      	
      		<div class='alert alert-success' role="alert">${ mensaje}</div>
      	
      	</c:if>

		<hr class="featurette-divider">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">GESTION GLOBAL DE INCIDENCIAS</h3>
			</div>
			<div class="panel-body">

				<div class="table-responsive">
					<table class="table table-hover table-striped table-bordered">
						<tr>
							<th>Id</th>
							<th>Fecha inicio</th>
							<th>Fecha fin</th>
							<th>Motivo</th>
							<th>Estado</th>
							<th>Id Empleado</th>
							<th>Id Gestor</th>
							<th>Comentario</th>
							<th>Acciones</th>
						</tr>

						<c:forEach var="incidencia" items="${incidencias}">
							<tr>
								<td>${incidencia.id}</td>
								<td>${incidencia.fechaComienzo}</td>
								<td>${incidencia.fechaFin}</td>

								<c:choose>
									<c:when test="${incidencia.tipo eq '1'}">
										<td><span class="label label-warning">Vacaciones</span></td>
									</c:when>
									<c:when test="${incidencia.estado eq '2'}">
										<td><span class="label label-warning">Enfermedad</span></td>
									</c:when>
									<c:when test="${incidencia.estado eq '3'}">
										<td><span class="label label-warning">Otras ausencias</span></td>
									</c:when>
									<c:when test="${incidencia.estado eq '4'}">
										<td><span class="label label-warning">Exento por errores</span></td>
									</c:when>
									<c:otherwise>
										<td><span class="label label-danger">Sin datos</span></td>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${incidencia.estado eq '0'}">
										<td><span class="label label-warning">En espera</span></td>
									</c:when>
									<c:when test="${incidencia.estado eq '1'}">
										<td><span class="label label-success">Aceptada</span></td>
									</c:when>
									<c:when test="${incidencia.estado eq '2'}">
										<td><span class="label label-danger">Denegada</span></td>
									</c:when>
									<c:otherwise>
										<td><span class="label label-danger">Sin datos</span></td>
									</c:otherwise>
								</c:choose>
								
								<td>${incidencia.idEmpleadoGenera}</td>
								<td>${incidencia.idEmpleadoGestor}</td>
								<td contenteditable='true'>${incidencia.comentario}</td>
								
								<c:choose>
								<c:when test="${incidencia.estado eq '0'}">
								<td><a href="incidencias/aceptarIncidencia?idIncidencia=${incidencia.id }" class="btn btn-success btn-sm"
									role="button" title="Aceptar"><span
										class="glyphicon glyphicon-thumbs-up"></span></a>
										<a href="incidencias/rechazarIncidencia?idIncidencia=${incidencia.id }" class="btn btn-danger btn-sm"
									role="button" title="Rechazar"><span
										class="glyphicon glyphicon-thumbs-down"></span></a>  
								</c:when>	
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