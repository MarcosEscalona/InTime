package com.MarcosEscalona.InTime.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fichaje")
public class Fichaje {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int idEmpleado;
	
	private long timestamp = (System.currentTimeMillis()); 
	
	String fechaString;
	
	//1 vacaciones, 2 enfermedad, 3 otras ausencias, 4 exento por errores en el marcaje, 5 entrada, 6 salida
	private int tipo;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
	public String getFechaString() {
		return fechaString;
	}
	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}
	@Override
	public String toString() {
		return "Fichaje [id=" + id + ", idEmpleado=" + idEmpleado + ", timestamp=" + timestamp + ", fechaString="
				+ fechaString + ", tipo=" + tipo + "]";
	}
	
	


	

		
}
