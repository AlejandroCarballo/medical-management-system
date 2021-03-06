package com.alecarballo.service.impl;

import java.util.List;
import java.util.Optional;

import com.alecarballo.model.Paciente;
import com.alecarballo.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alecarballo.dao.IPacienteDAO;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteDAO dao;

	@Override
	public Paciente registrar(Paciente paciente) {
		return dao.save(paciente);
	}

	@Override
	public Paciente modificar(Paciente paciente) {
		return dao.save(paciente);
	}

	@Override
	public void eliminar(int idPaciente) {
		//INI-CAMBIO PARA SPRING BOOT 2
		dao.deleteById(idPaciente);
	}

	@Override
	public Paciente listarId(int idPaciente) {
		//INI-CAMBIO PARA SPRING BOOT 2
		Optional<Paciente> opt = dao.findById(idPaciente);
		return opt.isPresent() ? opt.get() : new Paciente();
	}

	@Override
	public List<Paciente> listar() {
		return dao.findAll();
	}

	@Override
	public Page<Paciente> listarPageable(Pageable pageable) {		
		return dao.findAll(pageable);
	}

}
