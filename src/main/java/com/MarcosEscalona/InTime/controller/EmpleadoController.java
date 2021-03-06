package com.MarcosEscalona.InTime.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		return "usuarios/formUsuario";
	}

	@RequestMapping(value = "/modificarUsuario", method = RequestMethod.GET)
	public String modificaUsuario(Model model, @RequestParam("idEmpleado") int idEmpleado, @ModelAttribute Empleado empleado) {
		
		model.addAttribute("empleado", serviceEmpleado.buscarPorID(idEmpleado));
		

		return "usuarios/formModificaUsuario";
	}
	
	
	@PostMapping(value="/guardarUsuario")
	public String modificaUsuario(@ModelAttribute Empleado empleado, BindingResult erroresBinding, RedirectAttributes rAttributes) {
					
			for (ObjectError error : erroresBinding.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
		
			if (erroresBinding.hasErrors()) {
				return "usuarios/formModificaUsuario";
			}
			
		
			System.out.println(empleado.toString());
			serviceEmpleado.guardar(empleado);
		
			rAttributes.addFlashAttribute("mensaje", "Empleado modificado correctamente");
		
			return "redirect:/usuarios/gestionaUsuario";
	}
	
	@RequestMapping(value = "/gestionaUsuario", method = RequestMethod.GET)
	public String gestionaUsuario(Model model) {
		
		//Se recupera el total de empleados existentes
		Iterable<Empleado> listaEmpleados = new ArrayList<Empleado>();
		listaEmpleados = serviceEmpleado.recuperarTodosEmpleados();
		
		model.addAttribute("empleados", listaEmpleados);

		return "usuarios/formGestionaUsuarios";
	}
	
	@GetMapping(value="/borrarUsuario/{idEmpleado}")
	public String borraEmpleado(@PathVariable("idEmpleado")  int idEmpleado, RedirectAttributes rAttributes) {
			
			serviceEmpleado.borrarEmpleado(idEmpleado);
				
			rAttributes.addFlashAttribute("mensaje", "Empleado correctamente eliminado");
			
			return "redirect:/usuarios/gestionaUsuario";
	}
	

}
		



