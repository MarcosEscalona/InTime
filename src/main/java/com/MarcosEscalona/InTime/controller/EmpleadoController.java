package com.MarcosEscalona.InTime.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.service.IEmpleadoService;

@Controller
@RequestMapping("/usuarios")
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService serviceEmpleado;
	
	
	@RequestMapping(value="/formUsuario", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model, Authentication authentication) {
		
		
		Empleado empleado = serviceEmpleado.buscarEmpleado(authentication.getName());
		
		model.addAttribute("empleado", empleado);
		
		
		/*
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());		
		System.out.println(timestamp.getTime());
		System.out.println(timestamp);
		
		  public static int[] decodificar(long timestamp) {
    	int[] partes = new int[6];
    	partes[SECOND] = (int)(numero % 60);     numero /= 60;
    	partes[MINUTE] = (int)(numero % 60);     numero /= 60;
    	partes[HOUR]   = (int)(numero % 24);     numero /= 24;
    	partes[DAY]    = (int)(numero % 31 + 1); numero /= 31;
    	partes[MONTH]  = (int)(numero % 12 + 1); numero /= 12;
    	partes[YEAR]   = (int)(numero);
    	return partes;
  		}
		 */
		
		return "usuarios/formUsuario";
	}

	@RequestMapping(value = "/gestionaUsuario", method = RequestMethod.GET)
	public String gestionaUsuario(Model model) {
		
		//Se recupera el total de incidencias generadas
		Iterable<Empleado> listaEmpleados = new ArrayList<Empleado>();
		listaEmpleados = serviceEmpleado.recuperarTodosEmpleados();
		
		model.addAttribute("empleados", listaEmpleados);

		return "usuarios/formGestionaUsuarios";
	}
	
	@GetMapping(value="/borrarEmpleado/{idEmpleado}")
	public String borraEmpleado(@PathVariable("idEmpleado")  int idEmpleado, RedirectAttributes rAttributes) {
			
			serviceEmpleado.borrarEmpleado(idEmpleado);
				
			rAttributes.addFlashAttribute("mensaje", "Empleado correctamente eliminado");
			
			return "redirect:/usuarios/gestionaUsuario";
	}
	
	
	


}
