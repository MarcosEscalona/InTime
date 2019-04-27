package com.MarcosEscalona.InTime.controller;

import com.MarcosEscalona.InTime.model.Incidencia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/incidencias")
public class IncidenciaController {

		
		@RequestMapping(value="/generarIncidencia", method=RequestMethod.GET)
		public String generaIncidencia(Model model, @RequestParam("idEmpleado") int idEmpleado) {
				return "incidencias/formGeneraIncidencia";
		}
		
		@PostMapping(value="/guardarIncidencia")
		
		// Fechas en YYYY-MM-DD
		public String guardarIncidencia(@RequestParam("fechaComienzo") String fechaComienzo, @RequestParam("fechaFin") String fechaFin, @RequestParam("tipo") String tipo, @RequestParam("comentario") String comentario ) {
				
				Incidencia incidencia = new Incidencia();
				
				incidencia.setFechaComienzo(fechaComienzo);
				incidencia.setFechaFin(fechaFin);
				incidencia.setEstado(0);
				incidencia.setComentario(comentario);
				
				switch(tipo) {
					case "Vacaciones": incidencia.setTipo(1);
					case "Baja medica": incidencia.setTipo(2);
					case "Otras ausencias": incidencia.setTipo(3);
					case "Errores en el marcaje": incidencia.setTipo(4);
					default: incidencia.setTipo(-1);
				}
				
				// Guardar objeto en BD, tras definir id y empleado que genera y empleado gestor (inicialmente por defecto)
			

				return "incidencias/formGeneraIncidencia";
		}
		
}