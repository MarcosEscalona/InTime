package com.MarcosEscalona.InTime.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import com.MarcosEscalona.InTime.model.Incidencia;
import com.MarcosEscalona.InTime.repository.IncidenciaRepository;

@Service
public class IncidenciaServiceImpl implements IIncidenciaService {

	// Constructor vacio. Unicamente para imprimir un mensaje al crearse una instancia
	public IncidenciaServiceImpl() {
		System.out.println("Creando una instancia de la clase IncidenciaServiceImpl");
	}

	@Override
	public void guardar(Incidencia incidencia) {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		IncidenciaRepository rep = context.getBean("IncidenciaRepository", IncidenciaRepository.class);
		rep.save(incidencia);
		
		System.out.println("Guadando el objeto " + incidencia + " en la base de datos.");
	}

	@Override
	public List<Incidencia> buscarIncidenciasPorIdEmpleado(int idEmpleado) {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		IncidenciaRepository rep = context.getBean("IncidenciaRepository", IncidenciaRepository.class);
		
		List<Incidencia> incidenciaList = rep.findByIdEmpleadoGenera(idEmpleado);
		
		return incidenciaList;
	}
	
	@Override
	public Optional<Incidencia> buscarIncidencia(int idIncidencia) {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		IncidenciaRepository rep = context.getBean("IncidenciaRepository", IncidenciaRepository.class);
		
		Optional <Incidencia> incidencia = rep.findById(idIncidencia);
			

		return incidencia;
	}
	
	@Override
	public void borrarIncidencia(int idIncidencia) {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		IncidenciaRepository rep = context.getBean("IncidenciaRepository", IncidenciaRepository.class);
		
		rep.deleteById(idIncidencia);
			

		return;
	}

	@Override
	public Iterable<Incidencia> recuperarTodasIncidencias() {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		IncidenciaRepository rep = context.getBean("IncidenciaRepository", IncidenciaRepository.class);
		
		//Todos los registros
		
		Iterable<Incidencia> listaIncidencias = rep.findAll();
		
		return listaIncidencias;
	}

}
