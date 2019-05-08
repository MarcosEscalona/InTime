package com.MarcosEscalona.InTime.service;

import java.util.List;
import java.util.Optional;

import com.MarcosEscalona.InTime.model.Incidencia;

public interface IIncidenciaService {

	void guardar(Incidencia incidencia);

	List<Incidencia> buscarIncidenciasPorIdEmpleado(int idEmpleado);

	Optional<Incidencia> buscarIncidencia(int idIncidencia);

	void borrarIncidencia(int idIncidencia);

	Iterable<Incidencia> recuperarTodasIncidencias();
	
}
