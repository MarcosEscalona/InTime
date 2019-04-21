package com.MarcosEscalona.InTime.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.util.Util;

@Controller
public class HomeController {
	
	private	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> listaFechas = Util.getNextDays(4);
		
		List<Empleado> empleados = getLista();
		model.addAttribute("empleados", empleados);
		model.addAttribute("fechaActual", dateFormat.format(new Date()));
		model.addAttribute("fechas", listaFechas);
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model){
		
		List<String> listaFechas = Util.getNextDays(4);
		
		List<Empleado> empleados = getLista();

		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("empleados", empleados);
		
		System.out.println("Buscando empleados: " + fecha);
		return "home";
	}
	

	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String mostrarDetalle(Model model,@RequestParam("idEmpleado") int idEmpleado, @RequestParam("fecha")String fechaActual) {
		
		
		//Aquí la búsqueda de los datos del empleado en la BBDD, esta sería la consulta para fichajes

		return "detalle";
	}
	
	private List<Empleado> getLista() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Empleado> lista = null;
		try {
			lista = new LinkedList<>();

			Empleado empleado1 = new Empleado();
			empleado1.setId(1);
			empleado1.setNIF("54098765F");
			empleado1.setNombre("Manuel");
			empleado1.setApellido1("Fernandez");
			empleado1.setApellido2("Cano");
			empleado1.setFechaAltaEmpresa(formatter.parse("02-05-2017"));
			empleado1.setFechaBajaEmpresa(formatter.parse("31-12-9999"));
			empleado1.setImagen("cara.jpg");

			// Agregamos los objetos Empleado a la lista
			lista.add(empleado1);

			return lista;
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	
}