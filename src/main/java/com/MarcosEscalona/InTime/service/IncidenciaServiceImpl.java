package com.MarcosEscalona.InTime.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.model.Incidencia;
import com.MarcosEscalona.InTime.repository.IncidenciaRepository;
import com.MarcosEscalona.InTime.util.Util;

@Service
public class IncidenciaServiceImpl implements IIncidenciaService {

	@Autowired
	private IncidenciaRepository incidenciaRepo;
	
	// Constructor vacio. Unicamente para imprimir un mensaje al crearse una instancia
	public IncidenciaServiceImpl() {
		System.out.println("Creando una instancia de la clase IncidenciaServiceImpl");
	}

	@Override
	public void guardar(Incidencia incidencia) {
		

		incidenciaRepo.save(incidencia);
		
		System.out.println("Guadando el objeto " + incidencia + " en la base de datos.");
		
		
		return;
	}

	@Override
	public List<Incidencia> buscarIncidenciasPorIdEmpleado(int idEmpleado) {
		
		List<Incidencia> incidenciaList = incidenciaRepo.findByIdEmpleadoGenera(idEmpleado);
		
		return incidenciaList;
	}
	
	@Override
	public Optional<Incidencia> buscarIncidencia(int idIncidencia) {
			
		Optional <Incidencia> incidencia = incidenciaRepo.findById(idIncidencia);

		return incidencia;
	}
	
	@Override
	public void borrarIncidencia(int idIncidencia) {
		
		incidenciaRepo.deleteById(idIncidencia);
			
		return;
	}

	@Override
	public Iterable<Incidencia> recuperarTodasIncidencias() {
		
		//Todos los registros
		
		Iterable<Incidencia> listaIncidencias = incidenciaRepo.findAll();
		
		return listaIncidencias;
	}
	
	@Override
	public int comprobarCoherenciaFechas(Incidencia incidencia) throws ParseException {
		
		int fechasCorrectas = 1;
		
		
		String fechaInicioIncidencia = incidencia.getFechaComienzo();
		long fechaInicioMilis = Util.fechaStringConvertirMilisegundos(fechaInicioIncidencia);

		String fechaFinIncidencia = incidencia.getFechaFin();
		long fechaFinMilis = Util.fechaStringConvertirMilisegundos(fechaFinIncidencia);
		

		if(fechaInicioMilis < fechaFinMilis) fechasCorrectas = 0;
	
		return fechasCorrectas;
	}

}
