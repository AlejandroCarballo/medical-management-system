package com.alecarballo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alecarballo.model.Archivo;

public interface IArchivoDAO extends JpaRepository<Archivo, Integer>{

}
