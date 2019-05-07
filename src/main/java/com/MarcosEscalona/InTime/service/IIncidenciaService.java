package com.MarcosEscalona.InTime.service;

import java.util.List;

import com.MarcosEscalona.InTime.model.Incidencia;

public interface IIncidenciaService {

	void guardar(Incidencia incidencia);

	List<Incidencia> buscarIncidenciasPorIdEmpleado(int idEmpleado);
	

}
