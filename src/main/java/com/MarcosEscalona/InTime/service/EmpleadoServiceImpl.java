package com.MarcosEscalona.InTime.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.model.Incidencia;
import com.MarcosEscalona.InTime.repository.EmpleadoRepository;
import com.MarcosEscalona.InTime.repository.FichajeRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	
	@Autowired
	private FichajeRepository fichajeRepo;
	
	@Autowired
	private EmpleadoRepository empleadoRepo;

	private List<Empleado> lista = null;
	
	public EmpleadoServiceImpl() {
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
	public Empleado buscarPorID(int idEmpleado) {
		for(Empleado e: lista) {
			if (e.getId() == idEmpleado) {
				return e;
			}
		}
		return null;
	}

	
	
	
	
	
	
	@Override
	public Empleado buscarEmpleado(String correo) {

		Empleado empleado = empleadoRepo.findBycorreo(correo);

		return empleado;
	}

	
	
	
	@Override
	public Iterable<Empleado> recuperarTodosEmpleados() {
		
		//Todos los registros
		
		Iterable<Empleado> listaEmpleados = empleadoRepo.findAll();
		
		return listaEmpleados;
	}
	
	@Override
	public void borrarEmpleado(int idEmpleado) {
		
		empleadoRepo.deleteById(idEmpleado);
		
		return;
	}
	
	@Override
	public List<Fichaje> buscarFichajesPorIdEmpleado(int idEmpleado) {
		
		List<Fichaje> fichajeList = fichajeRepo.findByIdEmpleado(idEmpleado);
		
		return fichajeList;
	}
	
	
	@Override
	public void fichajeEntrada(int idEmpleado) {
		
		Fichaje fichaje = new Fichaje();
		fichaje.setIdEmpleado(idEmpleado);
		fichaje.setTipo(5);
		
		fichajeRepo.save(fichaje);

	}


	@Override
	public void fichajeSalida(int idEmpleado) {
		
		Fichaje fichaje = new Fichaje();
		fichaje.setIdEmpleado(idEmpleado);
		fichaje.setTipo(6);
		
		fichajeRepo.save(fichaje);

	}

}
