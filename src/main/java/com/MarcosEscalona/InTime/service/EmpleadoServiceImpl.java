package com.MarcosEscalona.InTime.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.repository.EmpleadoRepository;
import com.MarcosEscalona.InTime.repository.FichajeRepository;
import com.MarcosEscalona.InTime.util.Util;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	
	@Autowired
	private FichajeRepository fichajeRepo;
	
	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	@Autowired
	private IEmpleadoService serviceEmpleado;
	
	
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
		fichaje.setTipo(6);
		fichaje.setFechaString(Util.calendarToStringDiaMesAnioHoraMinuto(fichaje.getTimestamp()));
		
		fichajeRepo.save(fichaje);

	}
	
	@Override
	public void fichajeSalida(int idEmpleado) {
		
		Fichaje fichaje = new Fichaje();
		fichaje.setIdEmpleado(idEmpleado);
		fichaje.setTipo(6);
		fichaje.setFechaString(Util.calendarToStringDiaMesAnioHoraMinuto(fichaje.getTimestamp()));
		
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
	
	@Override
	public int comprobarNoFichajeEntradaMismoDia(Fichaje fichaje) {
		
		int coincidencia = 0;
		
		String fecha = Util.calendarToStringDiaMesAnio(fichaje.getTimestamp());

		//Se recuperan los fichajes que ha realizado
		List<Fichaje> listaFichajes = new ArrayList<Fichaje>();
		listaFichajes = serviceEmpleado.buscarFichajesPorIdEmpleado(fichaje.getIdEmpleado());
		
		//Se recorre la lista buscando coincidencias con la fecha del fichaje actual
		for(Fichaje f : listaFichajes)
		{

			String fecha2 = Util.calendarToStringDiaMesAnio(f.getTimestamp());
			if (fecha.equals(fecha2)) coincidencia = 1;

		}
	
		return coincidencia;
	}
	
	@Override
	public int comprobarFichajesNoEntradaMismoDia(Fichaje fichaje) {
		
		int coincidencia = 0;
		
		String fecha = Util.calendarToStringDiaMesAnio(fichaje.getTimestamp());

		//Se recuperan los fichajes que ha realizado
		List<Fichaje> listaFichajes = new ArrayList<Fichaje>();
		listaFichajes = serviceEmpleado.buscarFichajesPorIdEmpleado(fichaje.getIdEmpleado());
		
		//Se recorre la lista buscando coincidencias con la fecha del fichaje actual
		for(Fichaje f : listaFichajes)
		{

			String fecha2 = Util.calendarToStringDiaMesAnio(f.getTimestamp());
			if (fecha.equals(fecha2) && f.getTipo()!=5) coincidencia = 1;

		}
	
		return coincidencia;
	}
	
	@Override
	public int comprobarEmpleadoEstaDeAlta(Fichaje fichaje, int idEmpleado) throws ParseException {
		
		int estaDeAlta = 1;
		
		Empleado empleado = serviceEmpleado.buscarPorID(idEmpleado);
		
		String fechaAltaEmpleado = empleado.getFechaAltaEmpresa();
		long fechaAltaEmpleadoMilis = Util.fechaStringConvertirMilisegundos(fechaAltaEmpleado);

		String fechaBajaEmpleado = empleado.getFechaBajaEmpresa();
		long fechaBajaEmpleadoMilis = Util.fechaStringConvertirMilisegundos(fechaBajaEmpleado);
		

		if(fichaje.getTimestamp() > fechaBajaEmpleadoMilis || fichaje.getTimestamp() < fechaAltaEmpleadoMilis) estaDeAlta = 0;
	
		return estaDeAlta;
	}

}
