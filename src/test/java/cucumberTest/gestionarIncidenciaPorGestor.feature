@featureTest
Feature: gestionarIncidenciaPorGestor

Se prueba la historia de usuario que trata de la potestad del gestor de aceptar o rechazar una incidencia

@Scenario1
Scenario: aceptar la incidencia
	Given una incidencia registrada en la bbdd
	And incidencia en estado espera
	When aceptar la incidencia
	Then comentario modificado
	And estado modificado
	And gestor añadido
	And fichaje actualizado



@Scenario2
Scenario: denegar incidencia
	Given una incidencia registrada en la bbdd
	And incidencia en estado espera
	When denegar la incidencia
	Then comentario modificado
	And estado modificado
	And gestor añadido




