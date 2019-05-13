package com.MarcosEscalona.InTime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MarcosEscalona.InTime.model.Fichaje;

@Repository
public interface FichajeRepository extends JpaRepository<Fichaje, Integer> {

	List<Fichaje> findByIdEmpleado(int idEmpleado);


}
