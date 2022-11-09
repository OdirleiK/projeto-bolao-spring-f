package com.odirlei.bolao.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odirlei.bolao.dto.JogoDTO;
import com.odirlei.bolao.entities.Jogo;
import com.odirlei.bolao.repositories.JogoRepository;
import com.odirlei.bolao.services.exceptions.ResourceNotFoundException;

@Service
public class JogoService {

	@Autowired
	private JogoRepository jogoRepository;

	@Transactional(readOnly = true)
	public List<JogoDTO> findAll() {
		 List<Jogo> list = jogoRepository.findAll();
		 return list.stream().map(x -> new JogoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public JogoDTO findById(Long id) {
		Optional<Jogo> obj = jogoRepository.findById(id);
		Jogo entity = obj.orElseThrow(() -> new ResourceNotFoundException("Jogo nao encontrado"));
		return new JogoDTO(entity);
	}
}
