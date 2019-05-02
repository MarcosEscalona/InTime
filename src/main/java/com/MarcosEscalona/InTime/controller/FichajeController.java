package com.MarcosEscalona.InTime.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MarcosEscalona.InTime.service.IEmpleadoService;

@Controller
@RequestMapping("/fichajes")
public class FichajeController {
	
	@Autowired
	private IEmpleadoService serviceEmpleado;

	@RequestMapping(value="/historicoFichaje", method=RequestMethod.GET)
	public String historicoFichaje(Model model, @RequestParam("idEmpleado") int idEmpleado) {
		
		//Aquí la búsqueda de los datos del empleado en la BBDD, esta sería la consulta de los fichajes realizados
		// Siguiente línea es provisional
		model.addAttribute("empleado", serviceEmpleado.buscarPorID(idEmpleado));
		
		return "fichajes/formHistoricoFichaje";
	}
	
	@RequestMapping(value="/entradaFichaje", method=RequestMethod.GET)
	public String entradaFichaje(Model model, @RequestParam("idEmpleado") int idEmpleado, @RequestParam("fecha") String fecha) {
		
		//Aquí se procesa el fichaje de entrada
			
		return "fichajes/formEntradaFichaje";
	}
	
	@RequestMapping(value="/salidaFichaje", method=RequestMethod.GET)
	public String salidaFichaje(Model model, @RequestParam("idEmpleado") int idEmpleado, @RequestParam("fecha") String fecha) {
		
		//Aquí se procesa el fichaje de salida
	
			
		return "fichajes/formSalidaFichaje";
	}
	
	
	
	
}
