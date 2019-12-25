package com.alecarballo.dao;

import com.alecarballo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
	
	Usuario findOneByUsername(String username);
}