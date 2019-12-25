package com.alecarballo.service;

import java.util.List;

import com.alecarballo.model.Menu;

public interface IMenuService {

	void registrar(Menu menu);

	void modificar(Menu menu);

	void eliminar(int idMenu);

	Menu listarId(int idMenu);

	List<Menu> listar();
	
	List<Menu> listarMenuPorUsuario(String nombre);
}
