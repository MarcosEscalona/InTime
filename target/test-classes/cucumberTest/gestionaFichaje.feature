@featureTest
Feature: gestionaFichaje

Producido un fichaje se traduce de TimeStamp a una fecha legible y se guarda

@Scenario1
Scenario: fichaje de entrada
	Given un fichaje de entrada
	When recibimos el fichaje
	Then se guarda en la bbdd

@Scenario2
Scenario: borrar cuenta
	Given un usuario registrado en la bbdd
	When eliminar cuenta
	Then usuario no existe en la bbdd

