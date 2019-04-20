package com.MarcosEscalona.InTime.model;

public class Incidencia {

	private int id;
	private Empleado empleado;
	public Empleado gestor;
	private int fecha;
	private int tipo;
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
