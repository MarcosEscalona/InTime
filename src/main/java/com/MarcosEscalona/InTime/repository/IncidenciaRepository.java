package com.MarcosEscalona.InTime.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MarcosEscalona.InTime.model.Incidencia;

@Repository
public interface IncidenciaRepository extends CrudRepository<Incidencia, Integer> {

}
