package com.odirlei.bolao.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.odirlei.bolao.enums.Resultado;

@Entity
@Table(name = "tb_jogo")
public class Jogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@DateTimeFormat(style= "dd-MM-yyyy HH:mm")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "dd-MM-yyyy HH:mm")
	private LocalDateTime data;
	
	@ManyToOne(targetEntity = Time.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "id_time1")
	private Long id_time1;
	
	@ManyToOne(targetEntity = Time.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "id_time2")
	private Long id_time2;
	
	@Enumerated(EnumType.STRING)
	private Resultado resultado;

	public Jogo() {}

	public Jogo(Long id, LocalDateTime data, Long id_time1, Long id_time2, Resultado resultado) {
		super();
		this.id = id;
		this.data = data;
		this.id_time1 = id_time1;
		this.id_time2 = id_time2;
		this.resultado = resultado;
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
