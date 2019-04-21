package com.MarcosEscalona.InTime.model;

import java.util.Date;

public class Empleado {

	private int id;
	private int rol; //Empleado 1, gestor 2, administrador 3
	private String NIF;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fechaAltaEmpresa;
	private Date fechaBajaEmpresa;
	private String imagen;
	// Matriz para registrar fichajes desde el 01/01/2019 durante 2000 días, columna 1 es el día, columna 2 es hora entrada
	// columna 3 es hora de salida, columna 4 es estado ese día (0 activo, 1 vacaciones, 2 enfermedad, 3 otras ausencias, 4 exento por errores en el marcaje)
	private int[][] calendario = new int[2000][4];
	
	
	
	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public int getCalendarioValor(int fila, int columna) {
		return calendario[fila][columna];
	}
	
	public void setCalendarioValor(int fila, int columna, int valor) {
		this.calendario[fila][columna] = valor;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public Date getFechaAltaEmpresa() {
		return fechaAltaEmpresa;
	}
	public void setFechaAltaEmpresa(Date fechaAltaEmpresa) {
		this.fechaAltaEmpresa = fechaAltaEmpresa;
	}
	public Date getFechaBajaEmpresa() {
		return fechaBajaEmpresa;
	}
	public void setFechaBajaEmpresa(Date fechaBajaEmpresa) {
		this.fechaBajaEmpresa = fechaBajaEmpresa;
	}
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", NIF=" + NIF + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", fechaAltaEmpresa=" + fechaAltaEmpresa + ", fechaBajaEmpresa=" + fechaBajaEmpresa + "]";
	}

	
	
}
