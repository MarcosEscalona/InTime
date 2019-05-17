package com.MarcosEscalona.InTime.service;

import java.util.List;
import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.model.Fichaje;

public interface IEmpleadoService {
	Empleado buscarEmpleado(String correo);
	Empleado buscarPorID(int id);
	void fichajeEntrada(int idEmpleado);
	void fichajeSalida(int idEmpleado);
	List<Fichaje> buscarFichajesPorIdEmpleado(int idEmpleado);
	Iterable<Empleado> recuperarTodosEmpleados();
	void borrarEmpleado(int idEmpleado);
	void guardar(Empleado empleado);
}
