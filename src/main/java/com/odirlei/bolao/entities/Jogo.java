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
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "dd-MM-yyyy HH:mm")
	private LocalDateTime data;
	
	@ManyToOne(targetEntity = Time.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "time1")
	private Time time1;
	
	@ManyToOne(targetEntity = Time.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "time2")
	private Time time2;
	
	@Enumerated(EnumType.STRING)
	private Resultado resultado;

	public Jogo() {}

	public Jogo(Long id, LocalDateTime data, Time time1, Time time2, Resultado resultado) {
		super();
		this.id = id;
		this.data = data;
		this.time1 = time1;
		this.time2 = time2;
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

	public Time getTime1() {
		return time1;
	}

	public void setTime1(Time time1) {
		this.time1 = time1;
	}

	public Time getTime2() {
		return time2;
	}

	public void setTime2(Time time2) {
		this.time2 = time2;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	
	

	


}
