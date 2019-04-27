package com.MarcosEscalona.InTime.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.service.IEmpleadoService;

@Controller
public class HomeController {
	
	@Autowired
	private IEmpleadoService serviceEmpleado;
	
	private	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<Empleado> empleados = serviceEmpleado.buscarEmpleado();
		
		model.addAttribute("empleados", empleados);
		model.addAttribute("fechaActual", dateFormat.format(new Date()));
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model){
		
		List<Empleado> empleados = serviceEmpleado.buscarEmpleado();

		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("empleados", empleados);
		
		return "home";
	}
	

	
}