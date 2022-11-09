package com.odirlei.bolao.dto;

import java.io.Serializable;

public class UriFileDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private String uri;
	
	public UriFileDTO() {}

	public UriFileDTO(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
