package com.MarcosEscalona.InTime.model;

public class Incidencia {

	private int id;
	private int idEmpleadoGenera;
	public int idEmpleadoGestor;
	//Fechas de inicio y final sobre la que se comunica la incidencia
	private long fechaComienzo;
	private long fechaFin;
	// 1 vacaciones, 2 enfermedad, 3 otras ausencias, 4 exento por errores en el marcaje
	private int tipo;
	// Estado de la incidencia: 0 en espera, 1 aceptada, 2 denegada
	private int estado;
	private String comentario;
		
	
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
	public long getFechaComienzo() {
		return fechaComienzo;
	}
	public void setFechaComienzo(long fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}
	public long getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(long fechaFin) {
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
