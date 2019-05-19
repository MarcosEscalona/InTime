package com.MarcosEscalona.InTime.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import com.MarcosEscalona.InTime.model.Incidencia;

public interface IIncidenciaService {

	void guardar(Incidencia incidencia);

	List<Incidencia> buscarIncidenciasPorIdEmpleado(int idEmpleado);

	Optional<Incidencia> buscarIncidencia(int idIncidencia);

	void borrarIncidencia(int idIncidencia);

	Iterable<Incidencia> recuperarTodasIncidencias();

	int comprobarCoherenciaFechas(Incidencia incidencia) throws ParseException;
	
}
