package com.alecarballo.service.impl;

import java.util.Optional;

import com.alecarballo.dao.IArchivoDAO;
import com.alecarballo.model.Archivo;
import com.alecarballo.service.IArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchivoServiceImpl implements IArchivoService {

	@Autowired
	private IArchivoDAO dao;

	@Override
	public int guardar(Archivo archivo) {
		Archivo ar = dao.save(archivo);
		return ar.getIdArchivo() > 0 ? 1 : 0;
	}

	@Override
	public byte[] leerArchivo(Integer idArchivo) {				
		//INI-CAMBIO PARA SPRING BOOT 2
		Optional<Archivo> opt = dao.findById(idArchivo);
		return opt.isPresent() ? opt.get().getValue() : new byte[0];
	}

}
