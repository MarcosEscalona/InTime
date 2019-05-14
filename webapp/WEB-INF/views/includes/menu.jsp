<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<spring:url value="/" var="urlRoot" />
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">

		<sec:authorize access="isAnonymous()">

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





		<sec:authorize access="hasAnyAuthority('usuario')">

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
					<li><a href="${urlRoot}login/logout">Salir</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</sec:authorize>

		<sec:authorize access="hasAnyAuthority('gestor')">

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
					<li><a href="${urlRoot}login/loginInTime">Gestión de
							incidencias globales</a></li>
					<li><a href="${urlRoot}login/logout">Salir</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</sec:authorize>




		<sec:authorize access="hasAnyAuthority('administrador')">

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
					<li><a href="${urlRoot}login/loginInTime">Gestión de
							incidencias globales</a></li>
					<li><a href="${urlRoot}login/loginInTime">Administración
							de usuarios</a></li>
					<li><a href="${urlRoot}login/logout">Salir</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</sec:authorize>






	</div>
</nav>