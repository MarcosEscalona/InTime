package com.MarcosEscalona.InTime.model;

public class Incidencia {

	private int id;
	private Empleado empleado;
	public Empleado gestor;
	//Fecha sobre la que se comunica la incidencia
	private int fecha;
	// 1 vacaciones, 2 enfermedad, 3 otras ausencias, 4 exento por errores en el marcaje
	private int tipo;
	// Estado de la incidencia: 0 en espera, 1 aceptada, 2 denegada
	private int estado;
	
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
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
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

	

}
