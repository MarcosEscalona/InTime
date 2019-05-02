package com.MarcosEscalona.InTime.service;

import java.util.List;

import com.MarcosEscalona.InTime.model.Empleado;

public interface IEmpleadoService {
	List<Empleado> buscarEmpleado();
	Empleado buscarPorID(int id);
}
