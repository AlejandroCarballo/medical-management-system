package com.alecarballo.dao;

import com.alecarballo.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExamenDAO extends JpaRepository<Examen, Integer> {

}
