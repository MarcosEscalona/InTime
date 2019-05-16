<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Generación de incidencia</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/incidencias/guardarIncidencia" var="urlForm"></spring:url>
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
				<span class="label label-default">GENERACIÓN / MODIFICACION DE INCIDENCIA</span>
			</h2>
		</div>
		
      <c:if test="${mensaje!=null }">
      	
      	<div class='alert alert-success' role="alert">${ mensaje}</div>
      	
      </c:if>

		<spring:hasBindErrors name="incidencia">
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

		<form:form action="${urlForm }" method="post" modelAttribute="incidencia">
			<div class="row">
				<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">ID incidencia</label> 
						<form:input type="text" path="id" id="id" readonly="true"  />
					</div>
				</div>
			
				<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">ID Empleado</label> 
						<form:input type="text" path="idEmpleadoGenera" id="idEmpleadoGenera" readonly="true"  />
					</div>
				</div>
				
				<div class="col-sm-2">
					<div class="form-group">
						<label for="titulo">Fecha de comienzo</label> <form:input
							type="date" id="fechaComienzo" path="fechaComienzo" required="required" min="2019-05-01" max="2019-12-31" />

					</div>
				</div>
				<div class="row">
					<div class="col-sm-2">
						<div class="form-group">
							<label for="titulo">Fecha de finalización</label> <form:input
								type="date" id="fechaFin" path="fechaFin" required="required" min="2019-05-01" max="2019-12-31" />

						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="tipo">Tipo</label>
							 <form:select id="tipo" path="tipo"	class="form-control">
								<option value="1">Vacaciones</option>
								<option value="2">Baja medica</option>
								<option value="3">Otras ausencias</option>
								<option value="4">Errores en el marcaje</option>
							</form:select>
						</div>
					</div>
				</div>
			

				<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>

		<a class="btn btn-info" href="/InTime/usuarios/formUsuario" role="button">Volver</a>

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