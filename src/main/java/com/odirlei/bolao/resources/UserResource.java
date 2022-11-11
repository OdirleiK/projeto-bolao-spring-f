package com.odirlei.bolao.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.odirlei.bolao.dto.EmailRequestDTO;
import com.odirlei.bolao.dto.NovaSenhaDTO;
import com.odirlei.bolao.dto.UserDTO;
import com.odirlei.bolao.dto.UserInsertDTO;
import com.odirlei.bolao.dto.UserUpdateDTO;
import com.odirlei.bolao.entities.PasswordResetToken;
import com.odirlei.bolao.entities.User;
import com.odirlei.bolao.repositories.PasswordTokenRepository;
import com.odirlei.bolao.repositories.UserRepository;
import com.odirlei.bolao.services.PasswordResetTokenService;
import com.odirlei.bolao.services.UserService;
import com.odirlei.bolao.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordTokenRepository passwordRepository;
	
	@Autowired
	private PasswordResetTokenService passwordService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		UserDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	
	@PostMapping(value = "/register")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto) {
		UserDTO NewDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(NewDto.getId())
					.toUri();
		return ResponseEntity.created(uri).body(NewDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO dto) {
		UserDTO newDto = service.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//@GetMapping(value = "/{email}")
	public ResponseEntity<UserDTO> findById(@PathVariable("email")String email) {
		UserDTO dto = service.findByEmail(email);
		return ResponseEntity.ok().body(dto);
	}
	
	
	
	@PostMapping(value= "/user/resetPassword")
	public PasswordResetToken recoveryPassword(@RequestBody EmailRequestDTO email){
		User user = repository.findByEmail(email.getEmail());
		if (user == null) {
			throw new ResourceNotFoundException("Usuário com o email " + email.getEmail() + "não encontrado");
		}
		String generateToken = UUID.randomUUID().toString();
		PasswordResetToken token = new PasswordResetToken(generateToken, user);
		service.constructResetTokenEmail(generateToken, user);
		return passwordRepository.save(token);
	}
	
	@PutMapping(value= "/{id}/new-password")
	public ResponseEntity<User> changePassword(@RequestBody NovaSenhaDTO novaSenha, @PathVariable("id") Long id ){
		if (passwordService.verifyToken(novaSenha.getToken(), id)) {
			service.changePassword(novaSenha.getNovaSenha(), id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}

	
	
	
	

	
	
}
