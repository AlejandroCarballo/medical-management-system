package com.alecarballo.service.impl;

import java.util.List;
import java.util.Optional;

import com.alecarballo.dao.IEspecialidadDAO;
import com.alecarballo.model.Especialidad;
import com.alecarballo.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	@Autowired
	private IEspecialidadDAO dao;

	@Override
	public void registrar(Especialidad especialidad) {
		dao.save(especialidad);
	}

	@Override
	public void modificar(Especialidad especialidad) {
		dao.save(especialidad);
	}

	@Override
	public void eliminar(int idEspecialidad) {
		//INI-CAMBIO PARA SPRING BOOT 2
		dao.deleteById(idEspecialidad);
	}

	@Override
	public Especialidad listarId(int idEspecialidad) {
		//INI-CAMBIO PARA SPRING BOOT 2
		Optional<Especialidad> opt = dao.findById(idEspecialidad);
		return opt.isPresent() ? opt.get() : new Especialidad();
	}

	@Override
	public List<Especialidad> listar() {
		return dao.findAll();
	}
}
