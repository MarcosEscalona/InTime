package com.MarcosEscalona.InTime.service;

import java.util.List;

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
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		//IncidenciaRepository rep = context.getBean("IncidenciaRepository", IncidenciaRepository.class);
		
		//creating session. This you can create in your own way.
		Configuration cfg = new Configuration();
		cfg.configure("root-context.xml");
		cfg.addAnnotatedClass(Incidencia.class);

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		//**creating CriteriaBuilder**
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Incidencia> criteria = builder.createQuery(Incidencia.class);
		Root<Incidencia> IncidenciaRoot=criteria.from(Incidencia.class);
		criteria.select(IncidenciaRoot);

		//**Adding where clause**
		criteria.where(builder.equal(IncidenciaRoot.get("idEmpleadoGenera"), idEmpleado));
		List<Incidencia> incidenciaList=session.createQuery(criteria).getResultList();
			

		return incidenciaList;
	}


}
