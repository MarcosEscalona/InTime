$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("gestionarFichajeRealizado.feature");
formatter.feature({
  "line": 2,
  "name": "gestionarFichajeRealizado",
  "description": "\r\nGesti�n de las acciones de fichar",
  "id": "gestionarfichajerealizado",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@featureTest"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "empleado ficha para marcar su entrada",
  "description": "",
  "id": "gestionarfichajerealizado;empleado-ficha-para-marcar-su-entrada",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@Scenario1"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "un usuario registrado en la bbdd",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "recibimos una petici�n de fichaje de entrada para este usuario",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "comprobar que no existe otro fichaje de entrada para ese dia",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "registrar fichaje",
  "keyword": "And "
});
formatter.match({
  "location": "gestionarFichajeRealizado.un_usuario_registrado_en_la_bbdd()"
});
formatter.result({
  "duration": 92872200,
  "error_message": "java.lang.NullPointerException\r\n\tat cucumberTest.gestionarFichajeRealizado.un_usuario_registrado_en_la_bbdd(gestionarFichajeRealizado.java:35)\r\n\tat ✽.Given un usuario registrado en la bbdd(gestionarFichajeRealizado.feature:8)\r\n",
  "status": "failed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "gestionarFichajeRealizado.comprobar_que_no_existe_otro_fichaje_de_entrada_para_ese_dia()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "gestionarFichajeRealizado.registrar_fichaje()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 14,
  "name": "empleado ficha para marcar su salida",
  "description": "",
  "id": "gestionarfichajerealizado;empleado-ficha-para-marcar-su-salida",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@Scenario2"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "un usuario registrado en la bbdd",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "recibimos una petici�n de fichaje de salida para este usuario",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "comprobar que no existe otro fichaje de salida para ese dia",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "comprobar que existe un fichaje de entrada anterior para ese dia",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "registrar fichaje",
  "keyword": "And "
});
formatter.match({
  "location": "gestionarFichajeRealizado.un_usuario_registrado_en_la_bbdd()"
});
formatter.result({
  "duration": 138700,
  "error_message": "java.lang.NullPointerException\r\n\tat cucumberTest.gestionarFichajeRealizado.un_usuario_registrado_en_la_bbdd(gestionarFichajeRealizado.java:35)\r\n\tat ✽.Given un usuario registrado en la bbdd(gestionarFichajeRealizado.feature:15)\r\n",
  "status": "failed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "gestionarFichajeRealizado.comprobar_que_no_existe_otro_fichaje_de_salida_para_ese_dia()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "gestionarFichajeRealizado.comprobar_que_existe_un_fichaje_de_entrada_anterior_para_ese_dia()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "gestionarFichajeRealizado.registrar_fichaje()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 23,
  "name": "hay dias de fichaje exento por aceptaci�n de incidencia",
  "description": "",
  "id": "gestionarfichajerealizado;hay-dias-de-fichaje-exento-por-aceptaci�n-de-incidencia",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@Scenario3"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "un usuario registrado en la bbdd",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "se acepta una incidencia",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "todos los dias que abarca la incidencia quedan marcados como exentos de fichaje",
  "keyword": "Then "
});
formatter.match({
  "location": "gestionarFichajeRealizado.un_usuario_registrado_en_la_bbdd()"
});
formatter.result({
  "duration": 205200,
  "error_message": "java.lang.NullPointerException\r\n\tat cucumberTest.gestionarFichajeRealizado.un_usuario_registrado_en_la_bbdd(gestionarFichajeRealizado.java:35)\r\n\tat ✽.Given un usuario registrado en la bbdd(gestionarFichajeRealizado.feature:24)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.se_acepta_una_incidencia()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.todos_los_dias_que_abarca_la_incidencia_quedan_marcados_como_exentos_de_fichaje()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("gestionarIncidenciaPorGestor.feature");
formatter.feature({
  "line": 2,
  "name": "gestionarIncidenciaPorGestor",
  "description": "\r\nSe prueba la historia de usuario que trata de la potestad del gestor de aceptar o rechazar una incidencia",
  "id": "gestionarincidenciaporgestor",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@featureTest"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "aceptar la incidencia",
  "description": "",
  "id": "gestionarincidenciaporgestor;aceptar-la-incidencia",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@Scenario1"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "una incidencia registrada en la bbdd",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "incidencia en estado espera",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "aceptar la incidencia",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "comentario modificado",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "estado modificado",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "gestor a�adido",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "fichaje actualizado",
  "keyword": "And "
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.una_incidencia_registrada_en_la_bbdd()"
});
formatter.result({
  "duration": 1005700,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat cucumberTest.gestionarIncidenciaPorGestor.una_incidencia_registrada_en_la_bbdd(gestionarIncidenciaPorGestor.java:26)\r\n\tat ✽.Given una incidencia registrada en la bbdd(gestionarIncidenciaPorGestor.feature:8)\r\n",
  "status": "pending"
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.incidencia_en_estado_espera()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.aceptar_la_incidencia()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.comentario_modificado()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.estado_modificado()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.fichaje_actualizado()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 19,
  "name": "denegar incidencia",
  "description": "",
  "id": "gestionarincidenciaporgestor;denegar-incidencia",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@Scenario2"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "una incidencia registrada en la bbdd",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "incidencia en estado espera",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "denegar la incidencia",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "comentario modificado",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "estado modificado",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "gestor a�adido",
  "keyword": "And "
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.una_incidencia_registrada_en_la_bbdd()"
});
formatter.result({
  "duration": 142500,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat cucumberTest.gestionarIncidenciaPorGestor.una_incidencia_registrada_en_la_bbdd(gestionarIncidenciaPorGestor.java:26)\r\n\tat ✽.Given una incidencia registrada en la bbdd(gestionarIncidenciaPorGestor.feature:20)\r\n",
  "status": "pending"
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.incidencia_en_estado_espera()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.denegar_la_incidencia()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.comentario_modificado()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "gestionarIncidenciaPorGestor.estado_modificado()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});