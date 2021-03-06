package com.MarcosEscalona.InTime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MarcosEscalona.InTime.model.Incidencia;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {

	//Buscar las incidencias generadas por un determinado empleado
	List<Incidencia> findByIdEmpleadoGenera(int idEmpleado);
	
	//Buscar las incidencias entre dos rangos de iD
	List<Incidencia> findByIdEmpleadoGeneraBetween(int idEmpleadoInf, int idEmpleadoSup);
	
}
