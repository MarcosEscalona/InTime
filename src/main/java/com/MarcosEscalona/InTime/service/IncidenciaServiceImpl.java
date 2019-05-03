package com.MarcosEscalona.InTime.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.MarcosEscalona.InTime.model.Incidencia;

@Service
public class IncidenciaServiceImpl implements IIncidenciaService {

	// Constructor vacio. Unicamente para imprimir un mensaje al crearse una instancia
	public IncidenciaServiceImpl() {
		System.out.println("Creando una instancia de la clase IncidenciaServiceImpl");
	}
	
	@Override
	public void guardar(Incidencia incidencia) {
		System.out.println("Guadando el objeto " + incidencia + " en la base de datos.");
		//Si fuese en una lista como la de empleado: lista.add(incidencia);
	}

	@Override
	public Incidencia buscarIncidenciaporId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarTipoIncidencia() {
		
		List<String> tipoIncidencias = new LinkedList<>();
		tipoIncidencias.add("Vacaciones");
		tipoIncidencias.add("Baja medica");
		tipoIncidencias.add("Otras ausencias");
		tipoIncidencias.add("Errores en el marcaje");
		
		return tipoIncidencias;
	}



}
