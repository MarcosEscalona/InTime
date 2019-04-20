<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido a InTime</title>
<spring:url value="/resources" var ="urlPublic"/>
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">
</head>

<body>

	<div class="panel panel-default">
		<div class="panel-heading">Lista de Empleados</div>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>NIF</th>
						<th>Nombre</th>
						<th>Apellido 1</th>
						<th>Fecha de Alta</th>
						<th>Fecha de Baja</th>
						<th>Estado</th>
						<th>Imagen</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ empleados }" var="empleado">
						<tr>
							<td>${empleado.id }</td>
							<td>${empleado.NIF }</td>
							<td>${empleado.nombre }</td>
							<td>${empleado.apellido1 }</td>
							<td><fmt:formatDate value="${empleado.fechaAltaEmpresa}"
									pattern="dd-MM-yyyy" /></td>
							<td><fmt:formatDate value="${empleado.fechaBajaEmpresa}"
									pattern="dd-MM-yyyy" /></td>
							<td><c:choose>
									<c:when test="${empleado.fechaBajaEmpresa < '19-04-2019' }">
										<span class="label label-success">ACTIVA</span>
									</c:when>
									<c:otherwise>
										<span class="label label-danger">INACTIVA</span>
									</c:otherwise>
								</c:choose></td>
							<td><img src="${urlPublic}/images/${empleado.imagen}" width="80" height="100"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
