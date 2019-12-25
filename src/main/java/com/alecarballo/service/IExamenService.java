package com.alecarballo.service;

import java.util.List;

import com.alecarballo.model.Examen;

public interface IExamenService {

	void registrar(Examen examen);

	void modificar(Examen examen);

	void eliminar(int idExamen);

	Examen listarId(int idExamen);

	List<Examen> listar();
}
