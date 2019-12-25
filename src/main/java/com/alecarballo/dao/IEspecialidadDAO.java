package com.alecarballo.dao;

import com.alecarballo.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialidadDAO extends JpaRepository<Especialidad, Integer> {

}
