package com.odirlei.bolao.dto;

import java.io.Serializable;

import com.odirlei.bolao.entities.Time;

public class TimeDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private Integer id;
	private String time;
	
	public TimeDTO() {}

	public TimeDTO(Integer id, String time) {
		this.id = id;
		this.time = time;
	}
	
	public TimeDTO(Time entity) {
		this.id = entity.getId();
		this.time = entity.getTime();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
