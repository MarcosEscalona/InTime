package com.MarcosEscalona.InTime.controller;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.model.Incidencia;
import com.MarcosEscalona.InTime.repository.FichajeRepository;
import com.MarcosEscalona.InTime.service.IEmpleadoService;
import com.MarcosEscalona.InTime.service.IIncidenciaService;
import com.MarcosEscalona.InTime.util.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/incidencias")
public class IncidenciaController {

		@Autowired
		private IIncidenciaService serviceIncidencia;
		
		@Autowired
		private IEmpleadoService serviceEmpleado;
		
		@Autowired
		private FichajeRepository fichajeRepo;
		
		
		@RequestMapping(value="/generarIncidencia", method=RequestMethod.GET)
		public String generaIncidencia(Model model, @RequestParam("idEmpleado") int idEmpleado, @ModelAttribute Incidencia incidencia) {
				
				incidencia.setIdEmpleadoGenera(idEmpleado);
				return "incidencias/formGeneraIncidencia";
		}
		
	
		@PostMapping(value="/guardarIncidencia")
		public String guardarIncidencia(@ModelAttribute Incidencia incidencia, BindingResult erroresBinding, RedirectAttributes rAttributes) throws ParseException {
						
				for (ObjectError error : erroresBinding.getAllErrors()) {
					System.out.println(error.getDefaultMessage());
				}
			
				if (erroresBinding.hasErrors()) {
					return "incidencias/formGeneraIncidencia";
				}
			
				incidencia.setEstado(0);
				
				//Se asigna un gestor genérico en tanto la incidencia es tratada por un gestor auténtico
				incidencia.setIdEmpleadoGestor(-1); 
				
				//Formatear las fechas a dd/mm/yyyy
				String fechaComienzo = Util.formatearFecha(incidencia.getFechaComienzo());
				String fechaFin = Util.formatearFecha(incidencia.getFechaFin());
				
				incidencia.setFechaComienzo(fechaComienzo);
				incidencia.setFechaFin(fechaFin);
				
				
				//Comprobar que la fecha de inicio es menor que la fecha de fin
				if(serviceIncidencia.comprobarCoherenciaFechas(incidencia)==0) {
					rAttributes.addFlashAttribute("mensaje", "Error: fecha de finalización debe ser mayor o igual que fecha de inicio");
					rAttributes.addAttribute("idEmpleado", incidencia.getIdEmpleadoGenera());
					return "redirect:/incidencias/generarIncidencia";
				}
				
				//Comprobar que el empleado está de alta en el rango de vigencia de la incidencia
				int estaDeAlta = serviceIncidencia.comprobarEmpleadoEstaDeAlta(incidencia);
				
				if(estaDeAlta == 0) {
					rAttributes.addFlashAttribute("mensaje", "No estás activo en el sistema en todo el rango de fechas de la incidencia");
					rAttributes.addAttribute("idEmpleado", incidencia.getIdEmpleadoGenera());
					return "redirect:/incidencias/generarIncidencia";
				}
				
			
				// Guardar objeto en BD, id de incidencia autoincremental
				serviceIncidencia.guardar(incidencia);
			
				rAttributes.addFlashAttribute("mensaje", "Incidencia registrada / modificada correctamente");
				rAttributes.addAttribute("idEmpleado", incidencia.getIdEmpleadoGenera());
			
				return "redirect:/incidencias/generarIncidencia";
		}
		
		
		@RequestMapping(value="/gestionaIncidenciaEmpleado", method=RequestMethod.GET)
		public String gestionaIncidenciaEmpleado(Model model, @RequestParam("idEmpleado") int idEmpleado) {
				
				//Se añaden los datos del empleado
				model.addAttribute("empleado", serviceEmpleado.buscarPorID(idEmpleado));
				
				//Se recuperan las incidencias que ha generado
				List<Incidencia> listaIncidencias = new ArrayList<Incidencia>();
				listaIncidencias = serviceIncidencia.buscarIncidenciasPorIdEmpleado(idEmpleado);
				
				model.addAttribute("incidencias", listaIncidencias);
				
				
				return "incidencias/formGestionaIncidenciaEmpleado";
		}
		
		@RequestMapping(value="/gestionaIncidenciaGestor", method=RequestMethod.GET)
		public String gestionaIncidenciaGestor(Model model) {
				
				
				//Se recupera el total de incidencias generadas
				Iterable<Incidencia> listaIncidencias = new ArrayList<Incidencia>();
				listaIncidencias = serviceIncidencia.recuperarTodasIncidencias();
				
				model.addAttribute("incidencias", listaIncidencias);
				
				
				return "incidencias/formGestionaIncidenciaGestor";
		}
		
		
		@RequestMapping(value="/modificarIncidencia", method=RequestMethod.GET)
		public String modificaIncidencia(Model model, @RequestParam("idIncidencia") int idIncidencia, @ModelAttribute Incidencia incidencia) {
				
				model.addAttribute("incidencia", serviceIncidencia.buscarIncidencia(idIncidencia));
				
				return "incidencias/formGeneraIncidencia";
		}
		
		@GetMapping(value="/borrarIncidencia/{idIncidencia}/{idEmpleado}")
		public String borraIncidencia(@PathVariable("idIncidencia") int idIncidencia, @PathVariable("idEmpleado")  int idEmpleado, RedirectAttributes rAttributes) {
				
				serviceIncidencia.borrarIncidencia(idIncidencia);
					
				rAttributes.addFlashAttribute("mensaje", "Incidencia correctamente eliminada");
				rAttributes.addAttribute("idEmpleado", idEmpleado);
				
				return "redirect:/incidencias/gestionaIncidenciaEmpleado";
		}
		
		
		@RequestMapping(value="/denegarIncidencia", method=RequestMethod.GET)
		public String deniegaIncidencia(Model model, @RequestParam("idIncidencia") int idIncidencia, @ModelAttribute Incidencia incidencia) {
				
				model.addAttribute("incidencia", serviceIncidencia.buscarIncidencia(idIncidencia));
			
						
				return "incidencias/formDeniegaIncidencia";
		}
		
		@PostMapping(value="/guardarIncidenciaDenegada")
		public String guardarIncidenciaDenegada(@ModelAttribute Incidencia incidencia, BindingResult erroresBinding, RedirectAttributes rAttributes, Authentication authentication) {
						
				for (ObjectError error : erroresBinding.getAllErrors()) {
					System.out.println(error.getDefaultMessage());
				}
			
				if (erroresBinding.hasErrors()) {
					return "incidencias/formDeniegaIncidencia";
				}
			
				System.out.println(incidencia.toString());
				
				// Asignamos como gestor al empleado que está denegando la incidencia
				Empleado empleado = serviceEmpleado.buscarEmpleado(authentication.getName());
				incidencia.setIdEmpleadoGestor(empleado.getId());
				
				// Marcamos la incidencia como denegada
				incidencia.setEstado(2);
				
				// Update de objeto en BD
				serviceIncidencia.guardar(incidencia);
			
				rAttributes.addFlashAttribute("mensaje", "Incidencia marcada como denegada correctamente");
			
				return "redirect:/incidencias/gestionaIncidenciaGestor";
		}
		
		@RequestMapping(value="/aceptarIncidencia", method=RequestMethod.GET)
		public String aceptaIncidencia(Model model, @RequestParam("idIncidencia") int idIncidencia, @ModelAttribute Incidencia incidencia) {
				
				model.addAttribute("incidencia", serviceIncidencia.buscarIncidencia(idIncidencia));
			
						
				return "incidencias/formAceptaIncidencia";
		}
		
		@PostMapping(value="/guardarIncidenciaAceptada")
		public String guardarIncidenciaAceptada(@ModelAttribute Incidencia incidencia, BindingResult erroresBinding, RedirectAttributes rAttributes, Authentication authentication) throws ParseException {
						
				for (ObjectError error : erroresBinding.getAllErrors()) {
					System.out.println(error.getDefaultMessage());
				}
			
				if (erroresBinding.hasErrors()) {
					return "incidencias/formAceptaIncidencia";
				}
			
				System.out.println(incidencia.toString());
				
				// Asignamos como gestor al empleado que está aceptando la incidencia
				Empleado empleado = serviceEmpleado.buscarEmpleado(authentication.getName());
				incidencia.setIdEmpleadoGestor(empleado.getId());
				
				// Marcamos la incidencia como aceptada
				incidencia.setEstado(1);
				
				//Aquí la logica para marcar los fichajes de los días en que se ha aceptado la incidencia
				long milisegundosInicio = Util.fechaStringConvertirMilisegundos(incidencia.getFechaComienzo());
				long milisegundosFinal = Util.fechaStringConvertirMilisegundos(incidencia.getFechaFin());
				
				long milisegundosIncidencia = milisegundosFinal - milisegundosInicio;
				
				int numDiasInc = ((int) (milisegundosIncidencia / 86400000)) + 1;
				
				System.out.println(numDiasInc);
				
				
				for(int i=0; i<numDiasInc; i++) {
					
					Fichaje fichaje = new Fichaje();
					
					fichaje.setIdEmpleado(incidencia.getIdEmpleadoGenera());
					fichaje.setTipo(incidencia.getTipo());
					fichaje.setTimestamp(milisegundosInicio);
					fichaje.setFechaString(Util.calendarToStringDiaMesAnio(milisegundosInicio));
					
					fichajeRepo.save(fichaje);
					
					milisegundosInicio = milisegundosInicio + 86400000;
					
				}
				
				// Update de objeto en BD
				serviceIncidencia.guardar(incidencia);
			
				rAttributes.addFlashAttribute("mensaje", "Incidencia marcada como aceptada correctamente");
			
				return "redirect:/incidencias/gestionaIncidenciaGestor";
		}
		
	
		
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		}
		
}