<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Generaci�n de incidencia</title>
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
				<span class="label label-default">GESTI�N DE INCIDENCIAS</span>
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
					${empleado.apellido2 } <br> Fecha Alta Sistema:
					${empleado.fechaAltaEmpresa } <br> Fecha Baja Sistema:
					${empleado.fechaBajaEmpresa }
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
							<th>Fecha</th>
							<th>Hora de entrada</th>
							<th>Hora de salida</th>
							<th>Minutos trabajados</th>
							<th>Estado</th>
							<th>Incidencia</th>
						</tr>

						<c:forEach var="fichaje" items="${fichaje}">
							<tr>
								<td><fmt:formatDate pattern="dd-MM-yyyy"
										value="${fichaje.fecha}" />


									<td>${fichaje.horaEntrada}</td>
				<td>${fichaje.horaSalida}</td>
				<td>${fichaje.minutosTrabajados}</td>
				<c:choose>
					<c:when test="${fichaje.estado eq 'Activa'}">
						<td><span class="label label-success">${fichaje.estado}</span></td>
					</c:when>
					<c:otherwise>
						<td><span class="label label-danger">${fichaje.estado}</span></td>
					</c:otherwise>
					</c:choose>
				<td>
					<a href="#" class="btn btn-success btn-sm" role="button"
									title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
					<a href="#" class="btn btn-danger btn-sm" role="button"
									title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
				</td>
			  </tr>
			</c:forEach>
            
        </table>
      </div>
				
			</div>
		</div>








		<a class="btn btn-danger" href="/InTime/" role="button">Volver</a>




	</div>
	<hr class="featurette-divider"> <!-- FOOTER -->
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