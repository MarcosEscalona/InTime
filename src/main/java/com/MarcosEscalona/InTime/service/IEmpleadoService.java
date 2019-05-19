package com.MarcosEscalona.InTime.service;

import java.text.ParseException;
import java.util.List;
import com.MarcosEscalona.InTime.model.Empleado;
import com.MarcosEscalona.InTime.model.Fichaje;

public interface IEmpleadoService {
	Empleado buscarEmpleado(String correo);
	Empleado buscarPorID(int id);
	void fichajeSalida(int idEmpleado);
	List<Fichaje> buscarFichajesPorIdEmpleado(int idEmpleado);
	Iterable<Empleado> recuperarTodosEmpleados();
	void borrarEmpleado(int idEmpleado);
	void guardar(Empleado empleado);
	void fichajeEntrada(int idEmpleado);
	int comprobarNoFichajeEntradaMismoDia(Fichaje fichaje);
	int comprobarFichajesNoEntradaMismoDia(Fichaje fichaje);
	int comprobarEmpleadoEstaDeAlta(Fichaje fichaje, int idEmpleado) throws ParseException;
}
