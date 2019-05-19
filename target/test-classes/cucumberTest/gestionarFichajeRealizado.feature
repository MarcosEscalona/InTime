@featureTest
Feature: gestionarFichajeRealizado

Gestión de las acciones de fichar

@Scenario1
Scenario: empleado ficha para marcar su entrada
	Given un usuario registrado en la bbdd
	And el usuario esta de alta en la fecha
	When recibimos una petición de fichaje de entrada para este usuario
	Then comprobar que no existe otro fichaje de entrada para ese dia
	And registrar fichaje
	
@Scenario2
Scenario: empleado ficha para marcar su salida
	Given un usuario registrado en la bbdd
	And el usuario esta de alta en la fecha
	When recibimos una petición de fichaje de salida para este usuario
	Then comprobar que no existe otro fichaje de salida para ese dia
	And comprobar que existe un fichaje de entrada anterior para ese dia
	And registrar fichaje


@Scenario3
Scenario: hay dias de fichaje exento por aceptación de incidencia
	Given un usuario registrado en la bbdd
	And el usuario está de alta en la fecha
	When se acepta una incidencia
	Then todos los dias que abarca la incidencia quedan marcados como exentos de fichaje