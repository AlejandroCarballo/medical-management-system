package com.alecarballo.service.impl;

import com.alecarballo.dao.IResetTokenDAO;
import com.alecarballo.model.ResetToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alecarballo.service.IResetTokenService;

@Service
public class ResetTokenServiceImpl implements IResetTokenService {

	@Autowired
	private IResetTokenDAO dao;

	@Override
	public ResetToken findByToken(String token) {
		return dao.findByToken(token);
	}

	@Override
	public void guardar(ResetToken token) {
		dao.save(token);

	}

	@Override
	public void eliminar(ResetToken token) { 
		dao.delete(token);
	}

}
