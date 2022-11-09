package com.odirlei.bolao.dto;

import java.time.LocalDateTime;

import com.odirlei.bolao.entities.Jogo;
import com.odirlei.bolao.enums.Resultado;

public class JogoDTO {
	
	private Long id;
	private LocalDateTime data;
	private Long id_time1;
	private Long id_time2;
	private Resultado resultado;
	
	public JogoDTO() {}
	
	
	public JogoDTO(Long id, LocalDateTime data, Long id_time1, Long id_time2, Resultado resultado) {
		super();
		this.id = id;
		this.data = data;
		this.id_time1 = id_time1;
		this.id_time2 = id_time2;
		this.resultado = resultado;
	}

	public JogoDTO(Jogo entity) {
		this.id = entity.getId();
		this.data = entity.getData();
		this.id_time1 = entity.getId_time1();
		this.id_time2 = entity.getId_time2();
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

	public Long getId_time1() {
		return id_time1;
	}

	public void setId_time1(Long id_time1) {
		this.id_time1 = id_time1;
	}


	public Long getId_time2() {
		return id_time2;
	}


	public void setId_time2(Long id_time2) {
		this.id_time2 = id_time2;
	}


	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

}
