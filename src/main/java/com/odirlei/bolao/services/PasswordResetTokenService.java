package com.odirlei.bolao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odirlei.bolao.repositories.PasswordTokenRepository;



@Service
public class PasswordResetTokenService {

	@Autowired
	private PasswordTokenRepository passwordRepository;
	
	public boolean verifyToken(String token, Long id) {
		String tokenInDataBase = passwordRepository.findByUserId(id).getToken();
		if(!token.equals(tokenInDataBase)) {
			return false;
		}
		return true;
	}
}
