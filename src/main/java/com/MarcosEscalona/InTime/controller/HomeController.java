package com.MarcosEscalona.InTime.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MarcosEscalona.InTime.model.Empleado;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<Empleado> empleados = getLista();
		model.addAttribute("empleados", empleados);
		return "home";
	}
	
	@RequestMapping(value="/detail")
	public String mostrarDetalle(Model model) {
		String tituloPelicula = "Rapidos y veloces";
		int duracion = 135;
		double precioEntrada = 9.80;
		
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
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
			empleado1.setFechaAltaEmpresa(formatter.parse("02-05-2017"));
			empleado1.setFechaBajaEmpresa(formatter.parse("31-12-9999"));
			empleado1.setImagen("cara.jpg");

			Empleado empleado2 = new Empleado();
			empleado2.setId(2);
			empleado2.setNIF("54098865F");
			empleado2.setNombre("Manuel");
			empleado2.setApellido1("Fernandez");
			empleado2.setFechaAltaEmpresa(formatter.parse("02-05-2017"));
			empleado2.setFechaBajaEmpresa(formatter.parse("10-01-2019"));
			empleado2.setImagen("cara.jpg");

			Empleado empleado3 = new Empleado();
			empleado3.setId(3);
			empleado3.setNIF("54091765F");
			empleado3.setNombre("Manuel");
			empleado3.setApellido1("Fernandez");
			empleado3.setFechaAltaEmpresa(formatter.parse("02-05-2017"));
			empleado3.setFechaBajaEmpresa(formatter.parse("31-12-9999"));
			empleado3.setImagen("cara.jpg");
		
			// Agregamos los objetos Empleado a la lista
			lista.add(empleado1);
			lista.add(empleado2);
			lista.add(empleado3);

			return lista;
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	
}