package com.MarcosEscalona.InTime.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.service.IEmpleadoService;

@Controller
@RequestMapping("/fichajes")
public class FichajeController {
	
	@Autowired
	private IEmpleadoService serviceEmpleado;
	
	@RequestMapping(value="/historicoFichaje", method=RequestMethod.GET)
	public String historicoFichaje(Model model, @RequestParam("idEmpleado") int idEmpleado) {
		
		//Aquí la búsqueda de los datos del empleado en la BBDD, esta sería la consulta de los fichajes realizados
		model.addAttribute("empleado", serviceEmpleado.buscarPorID(idEmpleado));
		
		//Se recuperan los fichajes que ha realizado
		List<Fichaje> listaFichajes = new ArrayList<Fichaje>();
		listaFichajes = serviceEmpleado.buscarFichajesPorIdEmpleado(idEmpleado);
		
		model.addAttribute("fichajes", listaFichajes);
		
		return "fichajes/formHistoricoFichaje";
	}
	
	@RequestMapping(value="/entradaFichaje", method=RequestMethod.GET)
	public String entradaFichaje(Model model, @RequestParam("idEmpleado") int idEmpleado, RedirectAttributes rAttributes) {
					
			// Método para registrar el fichaje de entrada del empleado	
			serviceEmpleado.fichajeEntrada(idEmpleado);
			
			rAttributes.addFlashAttribute("mensaje", "Fichaje de entrada registrado correctamente");
			
			return "redirect:/home";
	}
	
	
	@RequestMapping(value="/salidaFichaje", method=RequestMethod.GET)
	public String salidaFichaje(Model model, @RequestParam("idEmpleado") int idEmpleado, RedirectAttributes rAttributes) {
					
			// Método para registrar el fichaje de entrada del empleado	
			serviceEmpleado.fichajeSalida(idEmpleado);
			
			rAttributes.addFlashAttribute("mensaje", "Fichaje de salida registrado correctamente");
			
			return "redirect:/home";
	}
	
	
	
	
}
