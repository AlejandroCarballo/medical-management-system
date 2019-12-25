package com.alecarballo.service.impl;

import java.util.List;
import java.util.Optional;

import com.alecarballo.model.Medico;
import com.alecarballo.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alecarballo.dao.IMedicoDAO;

@Service
public class MedicoServiceImpl implements IMedicoService {

	@Autowired
	private IMedicoDAO dao;

	@Override
	public Medico registrar(Medico medico) {
		return dao.save(medico);
	}

	@Override
	public Medico modificar(Medico medico) {
		return dao.save(medico);
	}

	@Override
	public void eliminar(int idMedico) {
		//INI-CAMBIO PARA SPRING BOOT 2
		dao.deleteById(idMedico);
	}

	@Override
	public Medico listarId(int idMedico) {
		//INI-CAMBIO PARA SPRING BOOT 2
		Optional<Medico> opt = dao.findById(idMedico);
		return opt.isPresent() ? opt.get() : new Medico();
	}

	@Override
	public List<Medico> listar() {
		return dao.findAll();
	}

}
