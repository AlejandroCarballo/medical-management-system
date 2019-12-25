package com.alecarballo.service;

import java.util.List;

import com.alecarballo.model.ConsultaExamen;

public interface IConsultaExamenService {
	
	List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta);

}
