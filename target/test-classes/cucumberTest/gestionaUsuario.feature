@featureTest
Feature: gestionaUsuario

Se prueba la historia de usuario que corresponde a la posibilidad de modificar o eliminar un usuario de la BBDD

@Scenario1
Scenario: modificar un usuario existente
	Given un usuario registrado en la bbdd
	When cambian los datos de usuario
	Then usuario modificado

@Scenario2
Scenario: borrar cuenta
	Given un usuario registrado en la bbdd
	When eliminar cuenta
	Then usuario no existe en la bbdd

