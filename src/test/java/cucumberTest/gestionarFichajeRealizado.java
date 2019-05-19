package cucumberTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.util.*;
import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.service.IEmpleadoService;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class gestionarFichajeRealizado {

	@Autowired
	private IEmpleadoService serviceEmpleado;
	
	@Autowired
	private Util u;
	
	Empleado empleado;
	Fichaje fichaje;

	
	
	
	@Given("^un usuario registrado en la bbdd$")
	public void un_usuario_registrado_en_la_bbdd() throws Throwable {
		
		empleado = serviceEmpleado.buscarEmpleado("usuario@usuario");
	    throw new PendingException();
	
	}
	
	@Given("^el usuario esta de alta en la fecha$")
	public void el_usuario_esta_de_alta_en_la_fecha() throws Throwable {
		
		Fichaje fichaje = null;
		Empleado empleado = serviceEmpleado.buscarPorID(5);		
		
		
		int estaActivo = 1;
		
		String fechaAltaEmpleado = empleado.getFechaAltaEmpresa();
		long fechaAltaEmpleadoMilis = Util.fechaStringConvertirMilisegundos(fechaAltaEmpleado);

		String fechaBajaEmpleado = empleado.getFechaAltaEmpresa();
		long fechaBajaEmpleadoMilis = Util.fechaStringConvertirMilisegundos(fechaAltaEmpleado);
		
		if(fichaje.getTimestamp() > fechaBajaEmpleadoMilis || fichaje.getTimestamp() < fechaAltaEmpleadoMilis) estaActivo = 0;
		
		
	    throw new PendingException();
	
	}

	@When("^recibimos una petici?n de fichaje de entrada para este usuario$")
	public void recibimos_una_petici_n_de_fichaje_de_entrada_para_este_usuario() throws Throwable {
		
	    fichaje.setIdEmpleado(empleado.getId());
	    fichaje.setTipo(5);
	    throw new PendingException();
	
	}
	

	@Then("^comprobar que no existe otro fichaje de entrada para ese dia$")
	public void comprobar_que_no_existe_otro_fichaje_de_entrada_para_ese_dia() throws Throwable {
		
		int coincidencia = 0;
		
		String fecha = u.calendarToStringDiaMesAnio(fichaje.getTimestamp());
		System.out.println(fecha);
		
		//Se recuperan los fichajes que ha realizado
		List<Fichaje> listaFichajes = new ArrayList<Fichaje>();
		listaFichajes = serviceEmpleado.buscarFichajesPorIdEmpleado(6);
		
		//Se recorre la lista buscando coincidencias con la fecha del fichaje actual
		for(Fichaje f : listaFichajes)
		{
			String fecha2 = u.calendarToStringDiaMesAnio(f.getTimestamp());
			if (fecha.equals(fecha2)) coincidencia = 1;

		}
				
		throw new PendingException();
	}

	@Then("^registrar fichaje$")
	public void registrar_fichaje() throws Throwable {
		
	    fichaje.setTimestamp(System.currentTimeMillis());
	    throw new PendingException();
	    
	}

	@When("^recibimos una petici?n de fichaje de salida para este usuario$")
	public void recibimos_una_petici_n_de_fichaje_de_salida_para_este_usuario() throws Throwable {
		
	    fichaje.setIdEmpleado(empleado.getId());
	    fichaje.setTipo(6);
	    
		throw new PendingException();
	}

	@Then("^comprobar que no existe otro fichaje de salida para ese dia$")
	public void comprobar_que_no_existe_otro_fichaje_de_salida_para_ese_dia() throws Throwable {
		
		int coincidencia = 0;
		
		String fecha = u.calendarToStringDiaMesAnio(fichaje.getTimestamp());
		System.out.println(fecha);
		
		//Se recuperan los fichajes que ha realizado
		List<Fichaje> listaFichajes = new ArrayList<Fichaje>();
		listaFichajes = serviceEmpleado.buscarFichajesPorIdEmpleado(6);
		
		//Se recorre la lista buscando coincidencias con la fecha del fichaje actual
		for(Fichaje f : listaFichajes)
		{
			String fecha2 = u.calendarToStringDiaMesAnio(f.getTimestamp());
			//Con la comprobación de tipo descartamos la posibilidad válida de un fichaje de salida tras uno de entrada
			if (fecha.equals(fecha2) && f.getTipo()!=5) coincidencia = 1;

		}
		
		
	    
		throw new PendingException();
	}

	@Then("^comprobar que existe un fichaje de entrada anterior para ese dia$")
	public void comprobar_que_existe_un_fichaje_de_entrada_anterior_para_ese_dia() throws Throwable {
		
	    // Este caso es similar al de comprobar que no existe un caso de fichaje de entrada para ese día, si ya existe debe ser
		// necesariamente anterior a la fecha actual. Por lo tanto, no se modelará.
	    
		throw new PendingException();
	}
	
}
