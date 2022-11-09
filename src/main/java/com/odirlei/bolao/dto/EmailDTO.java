package com.odirlei.bolao.dto;

import com.odirlei.bolao.entities.Email;

public class EmailDTO {

	
	private String ownerRef;
	private String emailFrom;
	private String emailTo;
	private String subject;
	private String text;
	
	public EmailDTO() {}

	public EmailDTO(String ownerRef, String emailFrom, String emailTo, String subject, String text) {
		this.ownerRef = ownerRef;
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.subject = subject;
		this.text = text;
	}
	
	public EmailDTO(Email entity) {
		this.ownerRef = entity.getOwnerRef();
		this.emailFrom = entity.getEmailFrom();
		this.emailTo = entity.getEmailTo();
		this.subject = entity.getSubject();
		this.text = entity.getText();
	}

	public String getOwnerRef() {
		return ownerRef;
	}

	public void setOwnerRef(String ownerRef) {
		this.ownerRef = ownerRef;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
}
