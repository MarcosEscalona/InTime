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

		lista = new LinkedList<>();

		Empleado empleado1 = new Empleado();
		empleado1.setId(1);
		empleado1.setNIF("54098765F");
		empleado1.setNombre("Manuel");
		empleado1.setApellido1("Fernandez");
		empleado1.setApellido2("Cano");
		empleado1.setFechaAltaEmpresa("02-05-2017");
		empleado1.setFechaBajaEmpresa("31-12-9999");

		// Agregamos Empleado
		lista.add(empleado1);
	}
	
	
	@Override
	public List<Empleado> buscarEmpleado() {

		return lista;
	}


	@Override
	public Empleado buscarPorID(int idEmpleado) {
		for(Empleado e: lista) {
			if (e.getId() == idEmpleado) {
				return e;
			}
		}
		return null;
	}


	@Override
	public void fichajeEntrada(int idEmpleado) {
		// Aquí la lógica para registrar el fichaje de entrada de un empleado
		System.out.println("Fichaje de entrada registrado correctamente");
		
	}


	@Override
	public void fichajeSalida(int idEmpleado) {
		// Aquí la lógica para registrar el fichaje de salida de un empleado
		System.out.println("Fichaje de salida registrado correctamente");
	}

}
