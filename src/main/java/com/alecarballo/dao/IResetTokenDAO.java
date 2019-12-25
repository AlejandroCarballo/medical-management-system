package com.alecarballo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alecarballo.model.ResetToken;

@Repository
public interface IResetTokenDAO extends JpaRepository<ResetToken, Long>{
	
	//from token where token = :? 
	ResetToken findByToken(String token);

}
