package com.odirlei.bolao.dto;

public class NovaSenhaDTO {
	
	private String novaSenha;
	
	private String token;


	
	public NovaSenhaDTO() {};
	
	public NovaSenhaDTO(String novaSenha, String token) {
		this.novaSenha = novaSenha;
		this.token = token;
	}
	
	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
	
	public String getNovaSenha() {
		return novaSenha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
