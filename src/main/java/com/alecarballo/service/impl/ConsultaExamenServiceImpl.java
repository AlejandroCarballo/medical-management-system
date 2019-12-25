package com.alecarballo.service.impl;

import java.util.List;

import com.alecarballo.dao.IConsultaExamenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alecarballo.model.ConsultaExamen;
import com.alecarballo.service.IConsultaExamenService;

@Service
public class ConsultaExamenServiceImpl implements IConsultaExamenService{
	
	@Autowired
	private IConsultaExamenDAO dao;
	
	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta) {
		return dao.listarExamenesPorConsulta(idconsulta);
	}

}
