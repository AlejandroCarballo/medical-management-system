package com.alecarballo.service;

import java.util.List;

import com.alecarballo.dto.FiltroConsultaDTO;
import com.alecarballo.model.Consulta;
import com.alecarballo.dto.ConsultaListaExamenDTO;
import com.alecarballo.dto.ConsultaResumenDTO;

public interface IConsultaService {

	Consulta registrar(ConsultaListaExamenDTO consultaDTO);

	void modificar(Consulta consulta);

	void eliminar(int idConsulta);

	Consulta listarId(int idConsulta);

	List<Consulta> listar();
	
	List<Consulta> buscar(FiltroConsultaDTO filtro);

	List<Consulta> buscarfecha(FiltroConsultaDTO filtro);
	
	List<ConsultaResumenDTO> listarResumen();

	byte[] generarReporte();
}
