package cucumberTest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.model.Incidencia;
import com.MarcosEscalona.InTime.repository.FichajeRepository;
import com.MarcosEscalona.InTime.service.IIncidenciaService;
import com.MarcosEscalona.InTime.util.Util;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class gestionarIncidenciaPorGestor {

	@Autowired
	private IIncidenciaService serviceIncidencia;
	
	@Autowired
	private FichajeRepository fichajeRepo;
	
	Optional<Incidencia> incidencia;
	Incidencia inc;
	Empleado e;
	
	@When("^se acepta una incidencia$")
	public void se_acepta_una_incidencia() throws Throwable {

		inc.setEstado(1);
		
	    throw new PendingException();
	}

	@Then("^todos los dias que abarca la incidencia quedan marcados como exentos de fichaje$")
	public void todos_los_dias_que_abarca_la_incidencia_quedan_marcados_como_exentos_de_fichaje() throws Throwable {
	    
		long milisegundosInicio = Util.fechaStringConvertirMilisegundos(inc.getFechaComienzo());
		long milisegundosFinal = Util.fechaStringConvertirMilisegundos(inc.getFechaFin());
		
		long milisegundosIncidencia = milisegundosFinal - milisegundosInicio;
		
		int numDiasInc = ((int) (milisegundosIncidencia / 86400000)) + 1;
		
		System.out.println(numDiasInc);
		
		
		for(int i=0; i<numDiasInc;i++) {
			
			Fichaje fichaje = new Fichaje();
			
			fichaje.setIdEmpleado(inc.getIdEmpleadoGenera());
			fichaje.setTipo(inc.getTipo());
			fichaje.setTimestamp(milisegundosInicio);
			fichaje.setFechaString(Util.calendarToStringDiaMesAnio(milisegundosInicio));
			
			fichajeRepo.save(fichaje);
			
			milisegundosInicio = milisegundosInicio + 86400000;
			
		
	    throw new PendingException();
	    }
	}

	@Given("^una incidencia registrada en la bbdd$")
	public void una_incidencia_registrada_en_la_bbdd() throws Throwable {

		incidencia = serviceIncidencia.buscarIncidencia(70);
		
	    throw new PendingException();
	}

	@Given("^incidencia en estado espera$")
	public void incidencia_en_estado_espera() throws Throwable {
	    
		inc.setEstado(0);
		
	    throw new PendingException();
	}

	@When("^aceptar la incidencia$")
	public void aceptar_la_incidencia() throws Throwable {

		inc.setEstado(1);
		
		
	    throw new PendingException();
	}

	@Then("^comentario modificado$")
	public void comentario_modificado() throws Throwable {

		inc.setComentario("Aqui el comentario del gestor");
		
	    throw new PendingException();
	}

	@Then("^estado modificado$")
	public void estado_modificado() throws Throwable {

		inc.setEstado(1);
		
	    throw new PendingException();
	}

	@Then("^gestor a?adido$")
	public void gestor_a_adido() throws Throwable {
	    
		inc.setIdEmpleadoGestor(e.getId());
		
	    throw new PendingException();
	}

	@Then("^fichaje actualizado$")
	public void fichaje_actualizado() throws Throwable {
	    
		long milisegundosInicio = Util.fechaStringConvertirMilisegundos(inc.getFechaComienzo());
		long milisegundosFinal = Util.fechaStringConvertirMilisegundos(inc.getFechaFin());
		
		long milisegundosIncidencia = milisegundosFinal - milisegundosInicio;
		
		int numDiasInc = ((int) (milisegundosIncidencia / 86400000)) + 1;
		
		System.out.println(numDiasInc);
		
		
		for(int i=0; i<numDiasInc;i++) {
			
			Fichaje fichaje = new Fichaje();
			
			fichaje.setIdEmpleado(inc.getIdEmpleadoGenera());
			fichaje.setTipo(inc.getTipo());
			fichaje.setTimestamp(milisegundosInicio);
			fichaje.setFechaString(Util.calendarToStringDiaMesAnio(milisegundosInicio));
			
			fichajeRepo.save(fichaje);
			
			milisegundosInicio = milisegundosInicio + 86400000;
		
		
	    throw new PendingException();
		}
	}

	@When("^denegar la incidencia$")
	public void denegar_la_incidencia() throws Throwable {
	    
		inc.setEstado(2);
		
	    throw new PendingException();
	}
	
	
}
