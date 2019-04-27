package com.MarcosEscalona.InTime.model;

public class Incidencia {

	private int id;
	private Empleado empleado;
	public Empleado gestor;
	//Fechas de inicio y final sobre la que se comunica la incidencia
	private String fechaComienzo;
	private String fechaFin;
	// 1 vacaciones, 2 enfermedad, 3 otras ausencias, 4 exento por errores en el marcaje
	private int tipo;
	// Estado de la incidencia: 0 en espera, 1 aceptada, 2 denegada
	private int estado;
	private String comentario;
	
	
	
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
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Empleado getGestor() {
		return gestor;
	}
	public void setGestor(Empleado gestor) {
		this.gestor = gestor;
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
		return "Incidencia [id=" + id + ", empleado=" + empleado + ", gestor=" + gestor + ", fechaComienzo="
				+ fechaComienzo + ", fechaFin=" + fechaFin + ", tipo=" + tipo + ", estado=" + estado + ", comentario="
				+ comentario + "]";
	}
	


	

}
