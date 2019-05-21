package com.MarcosEscalona.InTime.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.repository.FichajeRepository;
import com.MarcosEscalona.InTime.service.IEmpleadoService;
import com.MarcosEscalona.InTime.util.Util;

@Controller
@RequestMapping("/fichajes")
public class FichajeController {
	
	@Autowired
	private IEmpleadoService serviceEmpleado;
	
	@Autowired
	private FichajeRepository fichajeRepo;
	
	Util u;
	
	@RequestMapping(value="/historicoFichaje", method=RequestMethod.GET)
	public String historicoFichaje(Model model, @RequestParam("idEmpleado") int idEmpleado) {
		
		//Aquí la búsqueda de los datos del empleado en la BBDD, esta sería la consulta de los fichajes realizados
		model.addAttribute("empleado", serviceEmpleado.buscarPorID(idEmpleado));
		
		//Se recuperan los fichajes que ha realizado
		List<Fichaje> listaFichajes = new ArrayList<Fichaje>();
		listaFichajes = serviceEmpleado.buscarFichajesPorIdEmpleado(idEmpleado);
		
		//Se ordenan por fecha para su presentación
		listaFichajes.sort(Comparator.comparing(Fichaje::getTimestamp));
		
		model.addAttribute("fichajes", listaFichajes);
		
		return "fichajes/formHistoricoFichaje";
	}
	
	@RequestMapping(value="/entradaFichaje", method=RequestMethod.GET)
	public String entradaFichaje(Model model, @RequestParam("idEmpleado") int idEmpleado, RedirectAttributes rAttributes) throws ParseException {
					
			Fichaje fichaje = new Fichaje();
			fichaje.setIdEmpleado(idEmpleado);
			fichaje.setTipo(5);
			fichaje.setFechaString(Util.calendarToStringDiaMesAnioHoraMinuto(fichaje.getTimestamp()));
			
			//Comprobar que el empleado está de alta a la fecha del fichaje
			int estaDeAlta = serviceEmpleado.comprobarEmpleadoEstaDeAlta(fichaje, idEmpleado);
			
			if(estaDeAlta == 0) {
				rAttributes.addFlashAttribute("mensaje", "No estás activo en el sistema en la fecha actual");
				return "redirect:/usuarios/formUsuario";
			}
			
			//Comprobar que no ha fichado ya antes
			if(serviceEmpleado.comprobarNoFichajeEntradaMismoDia(fichaje)==1)
			{
				rAttributes.addFlashAttribute("mensaje", "Ya tienes registrado un fichaje de entrada con fecha de hoy o estás exento");
				return "redirect:/usuarios/formUsuario";
			}
			else {

				fichajeRepo.save(fichaje);
				rAttributes.addFlashAttribute("mensaje", "Fichaje de entrada registrado correctamente");
			
			return "redirect:/usuarios/formUsuario";}
	}
	
	
	@RequestMapping(value="/salidaFichaje", method=RequestMethod.GET)
	public String salidaFichaje(Model model, @RequestParam("idEmpleado") int idEmpleado, RedirectAttributes rAttributes) throws ParseException {
		
			Fichaje fichaje = new Fichaje();
			fichaje.setIdEmpleado(idEmpleado);
			fichaje.setTipo(6);
			fichaje.setFechaString(Util.calendarToStringDiaMesAnioHoraMinuto(fichaje.getTimestamp()));
			
			//Comprobar que el empleado está de alta a la fecha del fichaje
			int estaDeAlta = serviceEmpleado.comprobarEmpleadoEstaDeAlta(fichaje, idEmpleado);
			
			if(estaDeAlta == 0) {
				rAttributes.addFlashAttribute("mensaje", "No estás activo en el sistema en la fecha actual");
				return "redirect:/usuarios/formUsuario";
			}
			
			
		
			// Comprobar que ha fichado de entrada en el mismo día
			if(serviceEmpleado.comprobarNoFichajeEntradaMismoDia(fichaje)==0)
			{
				rAttributes.addFlashAttribute("mensaje", "No has realizado fichaje de entrada en el dia de hoy");
				return "redirect:/usuarios/formUsuario";
			}
		
			// Comprobar que no ha fichado de salida antes en el mismo día
			if(serviceEmpleado.comprobarFichajesNoEntradaMismoDia(fichaje)==1)
			{
				rAttributes.addFlashAttribute("mensaje", "Ya has realizado fichaje de salida o estás exento hoy");
				return "redirect:/usuarios/formUsuario";
			}

			
		

			fichajeRepo.save(fichaje);
			rAttributes.addFlashAttribute("mensaje", "Fichaje de salida registrado correctamente");
			
			return "redirect:/usuarios/formUsuario";
	}
	
	
	
	
}
