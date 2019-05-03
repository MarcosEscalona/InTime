<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/" var="urlRoot" />
<!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">Avengers Life - In Time</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">    
            <li><a href="${urlRoot}login/loginInTime">Login</a></li>        
            <li><a href="${urlRoot}">Salir</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>