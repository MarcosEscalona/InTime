<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Bienvenido a InTime</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot" />
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">

</head>

<body>

	<jsp:include page="includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<div class="row">
			<h2 class="text text-center">
				<span class="label label-default">FICHA PERSONAL</span>
			</h2>
		</div>

		<!-- Marketing messaging -->
		<div class="container marketing">

			<div class="row page-header">

				<c:forEach items="${empleados }" var="empleado">

					<div class="col-sm-4">
						<img class="img-rounded"
							src="${urlPublic}/images/${empleado.imagen}"
							alt="Generic placeholder image" width="200" height="250">
					</div>



					<div class="col-sm-4">
						<table class="table">
							<tbody>
								<tr>
									<th scope="col text-right">Id Empleado</th>
									<th scope="col"><span class="label label-default">${empleado.id }</span></th>
								</tr>
								<tr>
									<th scope="row">Rol empleado</th>
									<td><span class="label label-default">${empleado.rol }</span></td>
								</tr>
								<tr>
									<th scope="row">NIF</th>
									<td><span class="label label-default">${empleado.NIF }</span></td>
								</tr>
								<tr>
									<th scope="row">Nombre</th>
									<td><span class="label label-default">${empleado.nombre }</span></td>
								</tr>
								<tr>
									<th scope="row">Apellido 1</th>
									<td><span class="label label-default">${empleado.apellido1 }</span></td>
								</tr>
								<tr>
									<th scope="row">Apellido 2</th>
									<td><span class="label label-default">${empleado.apellido2 }</span></td>
								</tr>
								<tr>
									<th scope="row">Fecha alta sistema</th>
									<td><span class="label label-default"><fmt:formatDate value="${empleado.fechaAltaEmpresa}" pattern="dd-MM-yyyy"/></span></td>
								</tr>
							</tbody>
						</table>

					</div>

					<div class="col-sm-4">

						<table class="table">
							<tbody>
								<tr>
									<th><a class="btn btn-success"
										href="fichajes/entradaFichaje?idEmpleado=${empleado.id }&fecha=${fechaActual}"
										role="button">Fichaje diario de entrada</a></th>
								</tr>
								<tr>
									<th><a class="btn btn-danger"
										href="fichajes/salidaFichaje?idEmpleado=${empleado.id }&fecha=${fechaActual}"
										role="button">Fichaje diario de salida</a></th>

								</tr>
								<tr>
									<th><a class="btn btn-info"
										href="fichajes/historicoFichaje?idEmpleado=${empleado.id }"
										role="button">Consultar histórico de fichajes</a></th>

								</tr>
								<tr>
									<th><a class="btn btn-warning"
										href="incidencias/generarIncidencia?idEmpleado=${empleado.id }"
										role="button">Crear incidencia</a></th>

								</tr>
								<tr>
									<th><a class="btn btn-primary"
										href="gestionaIncidencia?idEmpleado=${empleado.id }&fecha=${fechaActual}"
										role="button">Gestionar mis incidencias</a></th>

								</tr>

							</tbody>
						</table>



					</div>


				</c:forEach>

			</div>

		</div>

		<div class="container marketing">
			<jsp:include page="includes/footer.jsp"></jsp:include>
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
