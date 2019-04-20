<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Bienvenido a InTime</title>
	<spring:url value="/resources" var ="urlPublic"/>
	<link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">

  </head>

  <body>

    <jsp:include page="includes/menu.jsp"></jsp:include>
    
    <div class="container theme-showcase" role="main">


      <div class="row page-header">          
        <div class="col-lg-12">         
          <h2 class="text text-center"><span class="label label-success">FICHAS DE EMPLEADOS</span></h2>          
          <form class="form-inline" action="#" method="post">
            <div class="form-group">
              <label for="fecha">Fecha: </label>
              <select id="fecha" name="fecha" class="form-control">
                <option value="01-05-2017">01-05-2017</option>
                <option value="02-05-2017">02-05-2017</option>
                <option value="03-05-2017">03-05-2017</option>
                <option value="04-05-2017">04-05-2017</option>                
              </select>
            </div>            
            <button type="submit" class="btn btn-primary">Filtrar</button>
          </form>
        </div>
      </div>

      <!-- Marketing messaging -->
      <div class="container marketing">

        <div class="row">

		<c:forEach items="${empleados }" var="empleado">
          <div class="col-xs-12 col-sm-6 col-md-3">
            <img class="img-rounded" src="${urlPublic}/images/${empleado.imagen}" alt="Generic placeholder image" width="150" height="200">
            <h4>${empleado.nombre }</h4>
            <h4>
              <span class="label label-default">${empleado.apellido1 }</span>
              <span class="label label-default">${empleado.NIF }</span>
            </h4>         
          </div>
		</c:forEach>
        </div>

   
        </div>


    <jsp:include page="includes/footer.jsp"></jsp:include>


    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic}/bootstrap/bootstrap/js/bootstrap.min.js"></script> 
  </body>
</html>
