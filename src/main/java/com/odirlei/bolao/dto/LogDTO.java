package com.odirlei.bolao.dto;

import java.time.LocalDateTime;

import com.odirlei.bolao.entities.Log;
import com.odirlei.bolao.entities.User;

public class LogDTO {

	private Long id;
	private String descricao;
	private LocalDateTime data_evento;
	private User usuario_id;
	
	public LogDTO() {}

	public LogDTO(Long id, String descricao, LocalDateTime data_evento, User usuario_id) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data_evento = data_evento;
		this.usuario_id = usuario_id;
	}
	
	public LogDTO(Log entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.data_evento = entity.getData_evento();
		this.usuario_id = entity.getUsuario_id();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData_evento() {
		return data_evento;
	}

	public void setData_evento(LocalDateTime data_evento) {
		this.data_evento = data_evento;
	}

	public User getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(User usuario_id) {
		this.usuario_id = usuario_id;
	}
	
	
	
	
}
