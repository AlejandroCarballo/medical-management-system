package com.alecarballo.service.impl;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.alecarballo.dao.IConsultaExamenDAO;
import com.alecarballo.dto.FiltroConsultaDTO;
import com.alecarballo.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alecarballo.dao.IConsultaDAO;
import com.alecarballo.dto.ConsultaListaExamenDTO;
import com.alecarballo.dto.ConsultaResumenDTO;
import com.alecarballo.service.IConsultaService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ConsultaServiceImpl implements IConsultaService {

	@Autowired
	private IConsultaDAO dao;

	@Autowired
	private IConsultaExamenDAO ceDAO;

	@Transactional
	@Override
	public Consulta registrar(ConsultaListaExamenDTO consultaDTO) {
		// java 8
		// consultaDTO.getDetalleConsulta().forEach(x -> x.setConsulta(consulta));
		// return dao.save(consultaDTO);
		Consulta cons = new Consulta();
		consultaDTO.getConsulta().getDetalleConsulta().forEach(x -> x.setConsulta(consultaDTO.getConsulta()));
		cons = dao.save(consultaDTO.getConsulta());

		consultaDTO.getLstExamen()
				.forEach(e -> ceDAO.registrar(consultaDTO.getConsulta().getIdConsulta(), e.getIdExamen()));

		return cons;
	}

	@Override
	public void modificar(Consulta consulta) {
		dao.save(consulta);
	}

	@Override
	public void eliminar(int idConsulta) {
		//INI-CAMBIO PARA SPRING BOOT 2
		dao.deleteById(idConsulta);
		//INI-CAMBIO PARA SPRING BOOT 2
	}

	@Override
	public Consulta listarId(int idConsulta) {
		//INI-CAMBIO PARA SPRING BOOT 2
		Optional<Consulta> opt = dao.findById(idConsulta);
		return opt.isPresent() ? opt.get() : new Consulta();
		//FIN-CAMBIO PARA SPRING BOOT 2
	}

	@Override
	public List<Consulta> listar() {
		return dao.findAll();
	}

	@Override
	public List<Consulta> buscar(FiltroConsultaDTO filtro) {
		return dao.buscar(filtro.getDni(), filtro.getNombreCompleto());
	}

	@Override
	public List<Consulta> buscarfecha(FiltroConsultaDTO filtro) {
		LocalDateTime fechaSgte = filtro.getFechaConsulta().plusDays(1);
		return dao.buscarPorFecha(filtro.getFechaConsulta(), fechaSgte);
	}

	@Override
	public List<ConsultaResumenDTO> listarResumen() {
		List<ConsultaResumenDTO> consulta = new ArrayList<>();
		dao.listarResumen().forEach(x -> {
			ConsultaResumenDTO cr = new ConsultaResumenDTO();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			consulta.add(cr);
		});
		return consulta;
	}

	@Override
	public byte[] generarReporte() {		
		byte[] data = null;
		try {
			File file = new ClassPathResource("/reports/consultas.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;	
	}
}
