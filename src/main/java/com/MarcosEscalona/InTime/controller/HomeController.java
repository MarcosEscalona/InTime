package com.MarcosEscalona.InTime.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.service.IEmpleadoService;

@Controller
public class HomeController {
	
	@Autowired
	private IEmpleadoService serviceEmpleado;
	
	private	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<Empleado> empleados = serviceEmpleado.buscarEmpleado();
		
		model.addAttribute("empleados", empleados);
		model.addAttribute("fechaActual", dateFormat.format(new Date()));
		
		
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
		
		return "home";
	}
	
		
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String InTime() {

		return "frontal";
	}
	

	

	
}