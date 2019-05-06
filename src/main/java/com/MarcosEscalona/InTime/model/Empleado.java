package com.MarcosEscalona.InTime.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int rol; //Empleado 1, gestor 2, administrador 3
	private String correo;
	private String clave;
	private String NIF;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String fechaAltaEmpresa;
	private String fechaBajaEmpresa;
	
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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
	public String getFechaAltaEmpresa() {
		return fechaAltaEmpresa;
	}
	public void setFechaAltaEmpresa(String fechaAltaEmpresa) {
		this.fechaAltaEmpresa = fechaAltaEmpresa;
	}
	public String getFechaBajaEmpresa() {
		return fechaBajaEmpresa;
	}
	public void setFechaBajaEmpresa(String fechaBajaEmpresa) {
		this.fechaBajaEmpresa = fechaBajaEmpresa;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", rol=" + rol + ", correo=" + correo + ", clave=" + clave + ", NIF=" + NIF
				+ ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", fechaAltaEmpresa="
				+ fechaAltaEmpresa + ", fechaBajaEmpresa=" + fechaBajaEmpresa + "]";
	}




	

	
}
