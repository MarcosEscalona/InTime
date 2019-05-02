package com.MarcosEscalona.InTime.service;

import com.MarcosEscalona.InTime.model.Incidencia;

public interface IIncidenciaService {

	Incidencia buscarIncidenciaporId();

	void guardar(Incidencia incidencia);

}
