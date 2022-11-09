package com.odirlei.bolao.dto;

import java.util.Date;

import com.odirlei.bolao.entities.User;

public class PasswordResetTokenDTO {

	private Long id;
	private String token;
	private UserDTO userDTO;
	private Date expiryDate;
	    
	public PasswordResetTokenDTO() {}

	public PasswordResetTokenDTO(Long id, String token, User user, Date expiryDate, UserDTO userDTO) {
		super();
		this.id = id;
		this.token = token;
		this.userDTO = userDTO;
		this.expiryDate = expiryDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDTO getUser() {
		return userDTO;
	}

	public void setUser(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
}
