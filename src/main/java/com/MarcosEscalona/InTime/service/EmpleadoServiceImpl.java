package com.MarcosEscalona.InTime.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.MarcosEscalona.InTime.model.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	private List<Empleado> lista = null;
	
	public EmpleadoServiceImpl() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println("Hola");

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

			// Agregamos Empleado
			lista.add(empleado1);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());

		}
	}
	
	
	@Override
	public List<Empleado> buscarEmpleado() {

		return lista;
	}

}
