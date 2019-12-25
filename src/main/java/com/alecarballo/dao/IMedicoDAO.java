package com.alecarballo.dao;

import com.alecarballo.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoDAO extends JpaRepository<Medico, Integer> {

}
