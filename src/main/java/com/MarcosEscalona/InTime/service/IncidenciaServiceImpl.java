package com.MarcosEscalona.InTime.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

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
		System.out.println("2");
		rep.save(incidencia);
		System.out.println("3");
		
		System.out.println("Guadando el objeto " + incidencia + " en la base de datos.");
	}

	@Override
	public Incidencia buscarIncidenciaporId() {
		// TODO Auto-generated method stub
		return null;
	}


}
