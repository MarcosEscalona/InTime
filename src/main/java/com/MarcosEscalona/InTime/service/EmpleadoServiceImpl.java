package com.MarcosEscalona.InTime.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.repository.EmpleadoRepository;
import com.MarcosEscalona.InTime.repository.FichajeRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	
	@Autowired
	private FichajeRepository fichajeRepo;
	
	@Autowired
	private EmpleadoRepository empleadoRepo;

	
	public EmpleadoServiceImpl() {

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


	@Override
	public Empleado buscarPorID(int idEmpleado) {

		Empleado empleado = empleadoRepo.findByid(idEmpleado);
		
		return empleado;
	}
	
	@Override
	public void guardar(Empleado empleado) {
		

		empleadoRepo.save(empleado);
		
		System.out.println("Guadando el objeto " + empleado + " en la base de datos.");
		
		
		return;
	}

}
