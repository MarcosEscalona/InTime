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
<title>Gestión de usuarios</title>
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
				<span class="label label-default">GESTIÓN DE USUARIOS</span>
			</h2>
		</div>

		<c:if test="${mensaje!=null }">

			<div class='alert alert-success' role="alert">${ mensaje}</div>

		</c:if>

		<hr class="featurette-divider">


		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">GESTIÓN DE USUARIOS</h3>
			</div>
			<div class="panel-body">

				<div class="table-responsive">
					<table class="table table-hover table-striped table-bordered">
						<tr>
							<th>Id</th>
							<th>Rol</th>
							<th>Correo</th>
							<th>NIF</th>
							<th>Nombre</th>
							<th>Apellido 1</th>
							<th>Apellido 2</th>
							<th>Fecha Alta</th>
							<th>Fecha Baja</th>
							<th>Acciones</th>
						</tr>

						<c:forEach var="empleado" items="${empleados}">
							<tr>
							
								<td>${empleado.id}</td>
								
								<c:choose>
									<c:when test="${empleado.rol eq 1}">
										<td><span class="label label-info">Usuario</span></td>
									</c:when>
									<c:when test="${empleado.rol eq 2}">
										<td><span class="label label-info">Gestor</span></td>
									</c:when>
									<c:when test="${empleado.rol eq 3}">
										<td><span class="label label-info">Administrador</span></td>
									</c:when>

									<c:otherwise>
										<td><span class="label label-danger">Sin datos</span></td>
									</c:otherwise>
								</c:choose>

								<td>${empleado.correo}</td>
								<td>${empleado.NIF}</td>
								<td>${empleado.nombre}</td>
								<td>${empleado.apellido1}</td>
								<td>${empleado.apellido2}</td>
								<td>${empleado.fechaAltaEmpresa}</td>
								<td width="5%">${empleado.fechaBajaEmpresa}</td>
								
								<c:choose>
								<c:when test="${empleado.fechaBajaEmpresa != '0'}">
								<td><a href=modificarUsuario?idEmpleado=${empleado.id } class="btn btn-success btn-sm"
									role="button" title="Edit"><span
										class="glyphicon glyphicon-pencil"></span></a> 
								<a href="borrarEmpleado/${empleado.id }" onclick=' return confirm("¿Seguro que desea eliminar?") '	class="btn btn-danger btn-sm" role="button" title="Eliminar"><span
										class="glyphicon glyphicon-trash"></span></a></td>
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