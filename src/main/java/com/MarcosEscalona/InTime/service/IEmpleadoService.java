package com.MarcosEscalona.InTime.service;

import java.util.List;

import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.model.Incidencia;

public interface IEmpleadoService {
	List<Empleado> buscarEmpleado();
	Empleado buscarPorID(int id);
	void fichajeEntrada(int idEmpleado);
	void fichajeSalida(int idEmpleado);
	List<Fichaje> buscarFichajesPorIdEmpleado(int idEmpleado);
}
