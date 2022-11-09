package com.odirlei.bolao.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.odirlei.bolao.entities.Email;
import com.odirlei.bolao.enums.StatusEmail;
import com.odirlei.bolao.repositories.EmailRespository;

@Service
public class EmailService {

	@Autowired
	private EmailRespository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;
	

	
	@SuppressWarnings("finally")
	public Email sendEmail(Email email) {
		email.setSendDateEmail(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			emailSender.send(message);
			
			email.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			email.setStatusEmail(StatusEmail.ERROR);
		} finally {
			return emailRepository.save(email);
		}
		
	}
	
	@SuppressWarnings("finally")
	public Email welcomeUser(Email email) {
		email.setSendDateEmail(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject("Bolão copa do mundo!");
			message.setText("Seja bem vindo ao bolão da copa do mundo!");
			email.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			email.setStatusEmail(StatusEmail.ERROR);
		} finally {
			return emailRepository.save(email);
		}
	}
	
	public Email RecoveryPassoword() {
		return null;
	}
}
