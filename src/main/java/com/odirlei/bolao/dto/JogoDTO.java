package com.odirlei.bolao.dto;

import java.time.LocalDateTime;

import com.odirlei.bolao.entities.Jogo;
import com.odirlei.bolao.enums.Resultado;

public class JogoDTO {
	
	private Long id;
	private LocalDateTime data;
	private Resultado resultado;
	
	public JogoDTO() {}
	
	
	public JogoDTO(Long id, LocalDateTime data, Long time1, Long time2, Resultado resultado) {
		super();
		this.id = id;
		this.data = data;
		this.resultado = resultado;
	}

	public JogoDTO(Jogo entity) {
		this.id = entity.getId();
		this.data = entity.getData();
		this.resultado = entity.getResultado();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


	public Resultado getResultado() {
		return resultado;
	}


	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	
	
	

}
