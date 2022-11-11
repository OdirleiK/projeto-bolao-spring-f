package com.odirlei.bolao.dto;

import java.time.LocalDateTime;

import com.odirlei.bolao.entities.Palpite;
import com.odirlei.bolao.enums.Resultado;

public class PalpiteDTO {

	private Long id;
	private Long jogo_id;
	private Long usuario_id;
	private LocalDateTime data_inclusao;
	private Resultado resultado;

	
	public PalpiteDTO() {}


	public PalpiteDTO(Long id, Long jogo_id, Long usuario_id, LocalDateTime data_inclusao, Resultado resultado) {
		super();
		this.id = id;
		this.jogo_id = jogo_id;
		this.usuario_id = usuario_id;
		this.data_inclusao = data_inclusao;
		this.resultado = resultado;
	}
	
	public PalpiteDTO(Palpite entity) {
		this.id = entity.getId();
		this.data_inclusao = entity.getData_inclusao();
		this.resultado = entity.getResultado();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJogo_id() {
		return jogo_id;
	}

	public void setJogo_id(Long jogo_id) {
		this.jogo_id = jogo_id;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public LocalDateTime getData_inclusao() {
		return data_inclusao;
	}

	public void setData_inclusao(LocalDateTime data_inclusao) {
		this.data_inclusao = data_inclusao;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	
}
