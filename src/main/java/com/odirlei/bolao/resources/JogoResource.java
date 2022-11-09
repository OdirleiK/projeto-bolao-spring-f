package com.odirlei.bolao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odirlei.bolao.dto.JogoDTO;
import com.odirlei.bolao.services.JogoService;

@RestController
@RequestMapping(value = "/jogos")
public class JogoResource {

	@Autowired
	JogoService jogoService;
	
	@GetMapping
	public ResponseEntity<List<JogoDTO>> findAll() {
		List<JogoDTO> list = jogoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<JogoDTO> findById(@PathVariable Long id) {
		JogoDTO dto = jogoService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
}
