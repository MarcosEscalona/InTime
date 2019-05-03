package com.MarcosEscalona.InTime.service;

import java.util.List;

import com.MarcosEscalona.InTime.model.Incidencia;

public interface IIncidenciaService {

	Incidencia buscarIncidenciaporId();

	void guardar(Incidencia incidencia);
	
	List<String> buscarTipoIncidencia();

}
