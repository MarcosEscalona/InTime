@featureTest
Feature: aceptarDenegarIncidencia

Se prueba la historia de usuario que trata de la potestad del gestor de aceptar o rechazar una incidencia

@Scenario1
Scenario: modificar comentario de incidencia
	Given una incidencia registrada en la bbdd
	When cambia el comentario
	Then comentario modificado

@Scenario2
Scenario: denegar incidencia
	Given una incidencia registrada en la bbdd
	When rechazar la incidencia
	Then la incidencia esta en estado 2

@Scenario3
Scenario: aceptar incidencia
	Given una incidencia registrada en la bbdd
	When aceptar la incidencia
	Then la incidencia esta en estado 1

@Scenario4
Scenario: anotar incidencia en tabla fichaje
	Given una incidencia aceptada en la bbdd
	When anotar como exentas de fichaje todas las fechas que abarca la incidencia
	Then las fechas estan marcadas como exentas de fichar

