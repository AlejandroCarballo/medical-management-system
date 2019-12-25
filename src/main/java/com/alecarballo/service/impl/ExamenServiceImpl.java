package com.alecarballo.service.impl;

import java.util.List;
import java.util.Optional;

import com.alecarballo.dao.IExamenDAO;
import com.alecarballo.model.Examen;
import com.alecarballo.service.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenServiceImpl implements IExamenService {

	@Autowired	
	private IExamenDAO dao;

	@Override
	public void registrar(Examen examen) {
		dao.save(examen);
	}

	@Override
	public void modificar(Examen examen) {
		dao.save(examen);
	}

	@Override
	public void eliminar(int idExamen) {
		//INI-CAMBIO PARA SPRING BOOT 2
		dao.deleteById(idExamen);
	}

	@Override
	public Examen listarId(int idExamen) {
		//INI-CAMBIO PARA SPRING BOOT 2
		Optional<Examen> opt = dao.findById(idExamen);
		return opt.isPresent() ? opt.get() : new Examen();		
	}

	@Override
	public List<Examen> listar() {
		return dao.findAll();
	}

}
