package com.odirlei.bolao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odirlei.bolao.entities.Jogo;
import com.odirlei.bolao.repositories.JogoRepository;
import com.odirlei.bolao.services.JogoService;

@RestController
@RequestMapping(value = "/jogos")
public class JogoResource {

	@Autowired
	JogoService jogoService;
	
	@Autowired
	JogoRepository jogoRepository;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Jogo> findById(@PathVariable("id") Long id){
		return jogoRepository.findById(id)
				.map(jogo -> ResponseEntity.ok().body(jogo))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = "")
	public Iterable<Jogo> findAll(){
		return jogoRepository.findAll();
	}
	
}
