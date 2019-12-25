package com.alecarballo.service;

import com.alecarballo.model.Archivo;

public interface IArchivoService {

	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);
}
