package com.MarcosEscalona.InTime.controller;

import com.MarcosEscalona.InTime.model.Incidencia;
import com.MarcosEscalona.InTime.repository.IncidenciaRepository;
import com.MarcosEscalona.InTime.service.IEmpleadoService;
import com.MarcosEscalona.InTime.service.IIncidenciaService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		
		@RequestMapping(value="/generarIncidencia", method=RequestMethod.GET)
		public String generaIncidencia(Model model, @RequestParam("idEmpleado") int idEmpleado, @ModelAttribute Incidencia incidencia) {
				
				incidencia.setIdEmpleadoGenera(idEmpleado);
				return "incidencias/formGeneraIncidencia";
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
		
	
		@PostMapping(value="/guardarIncidencia")
		// Fechas en YYYY-MM-DD
		public String guardarIncidencia(@ModelAttribute Incidencia incidencia, BindingResult erroresBinding, RedirectAttributes rAttributes) {
						
				for (ObjectError error : erroresBinding.getAllErrors()) {
					System.out.println(error.getDefaultMessage());
				}
			
				if (erroresBinding.hasErrors()) {
					return "incidencias/formGeneraIncidencia";
				}
			
				incidencia.setEstado(0);
				incidencia.setIdEmpleadoGestor(-1); 
			
				// Guardar objeto en BD, id de incidencia autoincremental
				serviceIncidencia.guardar(incidencia);
			
				rAttributes.addFlashAttribute("mensaje", "Incidencia registrada correctamente");
				rAttributes.addAttribute("idEmpleado", incidencia.getIdEmpleadoGenera());
			
				return "redirect:/incidencias/generarIncidencia";
		}
		
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		}
		
}