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
				<span class="label label-default">GESTIÓN DE INCIDENCIAS PROPIAS</span>
			</h2>
		</div>
		
		<c:if test="${mensaje!=null }">
      	
      		<div class='alert alert-success' role="alert">${ mensaje}</div>
      	
      	</c:if>

		<hr class="featurette-divider">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">DATOS DEL EMPLEADO</h3>
			</div>
			<div class="panel-body">
				<p>
					Id: ${empleado.id } <br> Nombre: ${empleado.nombre } <br>
					Apellido 1 : ${empleado.apellido1 } <br> Apellido 2:
					${empleado.apellido2 } <br> Fecha Alta Sistema:
					${empleado.fechaAltaEmpresa}<br> Fecha Baja Sistema:
					${empleado.fechaBajaEmpresa}
				</p>

			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">INCIDENCIAS REGISTRADAS</h3>
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
							<th>Id Gestor</th>
							<th>Comentario del Gestor</th>
							<th>Acciones</th>
						</tr>

						<c:forEach var="incidencia" items="${incidencias}">
							<tr>
								<td>${incidencia.id}</td>
								<td>${incidencia.fechaComienzo}</td>
								<td>${incidencia.fechaFin}</td>

								<c:choose>
									<c:when test="${incidencia.tipo eq '1'}">
										<td><span class="label label-info">Vacaciones</span></td>
									</c:when>
									<c:when test="${incidencia.tipo eq '2'}">
										<td><span class="label label-info">Enfermedad</span></td>
									</c:when>
									<c:when test="${incidencia.tipo eq '3'}">
										<td><span class="label label-info">Otras ausencias</span></td>
									</c:when>
									<c:when test="${incidencia.tipo eq '4'}">
										<td><span class="label label-info">Exento por errores</span></td>
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
	
								<td>${incidencia.idEmpleadoGestor}</td>
								<td width="5%">${incidencia.comentario}</td>
								
								<c:choose>
								<c:when test="${incidencia.estado eq '0'}">
								<td><a href="modificarIncidencia?idIncidencia=${incidencia.id }" class="btn btn-success btn-sm"
									role="button" title="Edit"><span
										class="glyphicon glyphicon-pencil"></span></a> 
									<a href="borrarIncidencia/${incidencia.id }/${empleado.id }" onclick=' return confirm("¿Seguro que desea eliminar?") '	class="btn btn-danger btn-sm" role="button" title="Eliminar"><span
										class="glyphicon glyphicon-trash"></span></a></td>
								</c:when>
								</c:choose>
							</tr>
						</c:forEach>

					</table>
				</div>

			</div>
		</div>








		<a class="btn btn-danger" href="/InTime/home" role="button">Volver</a>




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