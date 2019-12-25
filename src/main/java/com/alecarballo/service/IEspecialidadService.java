package com.alecarballo.service;

import java.util.List;

import com.alecarballo.model.Especialidad;

public interface IEspecialidadService {

	void registrar(Especialidad especialidad);

	void modificar(Especialidad especialidad);

	void eliminar(int idEspecialidad);

	Especialidad listarId(int idEspecialidad);

	List<Especialidad> listar();

}
