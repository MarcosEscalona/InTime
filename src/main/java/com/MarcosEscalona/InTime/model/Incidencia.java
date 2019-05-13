package com.MarcosEscalona.InTime.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="incidencia")
public class Incidencia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int idEmpleadoGenera;
	

	public int idEmpleadoGestor;
	
	//Fechas de inicio y final sobre la que se comunica la incidencia
	private String fechaComienzo;
	private String fechaFin;
	// 1 vacaciones, 2 enfermedad, 3 otras ausencias, 4 exento por errores en el marcaje
	private int tipo;
	// Estado de la incidencia: 0 en espera, 1 aceptada, 2 denegada
	private int estado;
	private String comentario = "Incidencia aun sin comentario del Gestor";
		
	
	public Incidencia() {
		super();
	}
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdEmpleadoGenera() {
		return idEmpleadoGenera;
	}
	public void setIdEmpleadoGenera(int idEmpleadoGenera) {
		this.idEmpleadoGenera = idEmpleadoGenera;
	}
	public int getIdEmpleadoGestor() {
		return idEmpleadoGestor;
	}
	public void setIdEmpleadoGestor(int idEmpleadoGestor) {
		this.idEmpleadoGestor = idEmpleadoGestor;
	}
	public String getFechaComienzo() {
		return fechaComienzo;
	}
	public void setFechaComienzo(String fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Incidencia [id=" + id + ", idEmpleadoGenera=" + idEmpleadoGenera + ", idEmpleadoGestor="
				+ idEmpleadoGestor + ", fechaComienzo=" + fechaComienzo + ", fechaFin=" + fechaFin + ", tipo=" + tipo
				+ ", estado=" + estado + ", comentario=" + comentario + "]";
	}
	

	

	

	


	

}
