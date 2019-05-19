<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Edición de usuario</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/usuarios/guardarUsuario" var="urlForm"></spring:url>
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
				<span class="label label-default">MODIFICACIÓN DE USUARIO</span>
			</h2>
		</div>

		<c:if test="${mensaje!=null }">

			<div class='alert alert-success' role="alert">${ mensaje}</div>

		</c:if>

		<spring:hasBindErrors name="empleado">
			<div class='alert alert-danger' role='alert'>
				Existen los siguientes errores a corregir:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<hr class="featurette-divider">

		<form:form action="${urlForm }" method="post"
			modelAttribute="empleado">
			<div class="row">
				<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">ID empleado</label>
						<form:input type="text" path="id" id="id" readonly="true" />
					</div>
				</div>

				<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">Rol</label>
						<form:input type="text" path="rol" id="rol" />
					</div>
				</div>

				<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">Correo</label>
						<form:input type="text" path="correo" id="correo" />
					</div>
				</div>
				
								<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">Activo</label>
						<form:input type="text" path="activo" id="activo" />
					</div>
				</div>
				

						<form:input type="text" path="clave" id="clave" hidden="true" />


				<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">NIF</label>
						<form:input type="text" path="NIF" id="NIF" />
					</div>
				</div>

				<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">nombre</label>
						<form:input type="text" path="nombre" id="nombre" />
					</div>
				</div>

				<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">apellido1</label>
						<form:input type="text" path="apellido1" id="apellido1" />
					</div>
				</div>

				<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">apellido2</label>
						<form:input type="text" path="apellido2" id="apellido2" />
					</div>
				</div>
				
								<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">Fecha Alta Empresa</label>
						<form:input type="text" path="fechaAltaEmpresa" id="fechaAltaEmpresa" />
					</div>
				</div>
				
										<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">Fecha Baja Empresa</label>
						<form:input type="text" path="fechaBajaEmpresa" id="fechaBajaEmpresa" />
					</div>
				</div>
				
				






				<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>

		<a class="btn btn-info" href="/InTime/usuarios/gestionaUsuario" 
			role="button">Volver</a>

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