package com.odirlei.bolao.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odirlei.bolao.dto.RoleDTO;
import com.odirlei.bolao.dto.UserDTO;
import com.odirlei.bolao.dto.UserInsertDTO;
import com.odirlei.bolao.dto.UserUpdateDTO;
import com.odirlei.bolao.entities.Email;
import com.odirlei.bolao.entities.PasswordResetToken;
import com.odirlei.bolao.entities.Role;
import com.odirlei.bolao.entities.User;
import com.odirlei.bolao.enums.StatusEmail;
import com.odirlei.bolao.repositories.PasswordTokenRepository;
import com.odirlei.bolao.repositories.RoleRepository;
import com.odirlei.bolao.repositories.UserRepository;
import com.odirlei.bolao.services.exceptions.DatabaseException;
import com.odirlei.bolao.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private JavaMailSender emailSender;	
	
	@Autowired
	private PasswordTokenRepository passwordRepository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list =  repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);
	}

	public UserDTO insert(UserInsertDTO dto) {
		Email email = new Email();
		User entity = new User();
		SimpleMailMessage message = new SimpleMailMessage();
		
		Role role = roleRepository.findById((long) 1).get(); 
		
		
		copyDtoToEntity(dto, entity);
		
		entity.setSenha(passwordEncoder.encode(dto.getSenha()));
		
		email.setSendDateEmail(LocalDateTime.now());
		message.setFrom("odirlei47777@gmail.com");
		message.setTo(entity.getEmail());
		message.setSubject("Bolao Copa do mundo | nao responda");
		message.setText("Ola " + entity.getNome() + " Seja muito bem vindo ao nosso bolão, chame seus amigos e se divirta");
		//emailSender.send(message);
		email.setStatusEmail(StatusEmail.SENT);
		
	
		entity.getRoles().add(role);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	

	
	
	@SuppressWarnings("deprecation")
	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
			User entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);
		} 
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}
	
	@Transactional
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}	
	
	public UserDTO findByEmail(String email) {
		User entity = repository.findByEmail(email);
		return new UserDTO(entity);
	}
	
	public void createPasswordResetTokenForUser(User user, String token) {
	    PasswordResetToken myToken = new PasswordResetToken(token, user);
	    passwordRepository.save(myToken);
	}
	
	@Transactional
	public SimpleMailMessage constructResetTokenEmail(String token, User user) {
		String url = token; //"/users/changePasswor?token="
		Email email = new Email();
		SimpleMailMessage message = new SimpleMailMessage();
		
		email.setSendDateEmail(LocalDateTime.now());
		message.setFrom("odirlei47777@gmail.com");
		message.setTo(user.getEmail());
		message.setSubject("Bolao Copa do mundo | Redefinir Senha");
		message.setText("Ola " + user.getUsername() + " Seu link para redefinir a sua senha: " + url);
		emailSender.send(message);
		email.setStatusEmail(StatusEmail.SENT);
		
		return null;
	}
	
	public void changePassword(String novaSenha, Long id) {
		User user = this.repository.findById(id).get();
		user.setSenha(passwordEncoder.encode(novaSenha));
		repository.save(user);
	}
	
	@SuppressWarnings("deprecation")
	public void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setNome(dto.getNome());
		entity.setSobrenome(dto.getSobrenome());
		entity.setEmail(dto.getEmail());
		entity.getRoles().clear();
		for(RoleDTO roleDto : dto.getRoles()) {
			Role role = roleRepository.getOne(roleDto.getId());
			entity.getRoles().add(role);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByEmail(username);
		if (user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found:" + username);
		return user;
	}


	




	
}
