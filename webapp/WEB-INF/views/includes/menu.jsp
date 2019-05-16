<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<spring:url value="/" var="urlRoot" />
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">

		<sec:authorize access="!isAuthenticated()">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="color: #FF0000">Avengers Life -
					In Time</a>
			</div>


			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${urlRoot}login/loginInTime">Login</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</sec:authorize>



		<sec:authorize access="hasAnyAuthority('1')">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="color: #FF0000">Avengers Life -
					In Time</a>
				<a class="navbar-brand" style="color: #00AACC">Usuario: <sec:authentication property="principal.username"/></a>
				<a class="navbar-brand" style="color: #00AACC">Rol: Usuario</a>
			</div>

			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${urlRoot}login/logout">Salir</a></li>
				</ul>
				
			</div>
			<!--/.nav-collapse -->
		</sec:authorize>

		<sec:authorize access="hasAnyAuthority('2')">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="color: #FF0000">Avengers Life -
					In Time</a>
					<a class="navbar-brand" style="color: #00AACC">Usuario: <sec:authentication property="principal.username"/></a>
					<a class="navbar-brand" style="color: #00AACC">Rol: Gestor</a>
			</div>


			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${urlRoot}incidencias/gestionaIncidenciaGestor">Gestión de
							incidencias</a></li>
					<li><a href="${urlRoot}login/logout">Salir</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</sec:authorize>




		<sec:authorize access="hasAnyAuthority('3')">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="color: #FF0000">Avengers Life -
					In Time</a>
					<a class="navbar-brand" style="color: #00AACC">Usuario: <sec:authentication property="principal.username"/></a>
					<a class="navbar-brand" style="color: #00AACC">Rol: Administrador</a>
			</div>


			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${urlRoot}incidencias/gestionaIncidenciaGestor">Gestión de
							incidencias</a></li>
					<li><a href="${urlRoot}usuarios/gestionaUsuario">Administración
							de usuarios</a></li>
					<li><a href="${urlRoot}login/logout">Salir</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</sec:authorize>






	</div>
</nav>