package com.odirlei.bolao.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odirlei.bolao.dto.PalpiteDTO;
import com.odirlei.bolao.entities.Jogo;
import com.odirlei.bolao.entities.Palpite;
import com.odirlei.bolao.entities.User;
import com.odirlei.bolao.repositories.JogoRepository;
import com.odirlei.bolao.repositories.PalpiteRepository;
import com.odirlei.bolao.repositories.UserRepository;
import com.odirlei.bolao.services.exceptions.ResourceNotFoundException;

@Service
public class PalpiteService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PalpiteRepository palpiteRepository;
	
	@Autowired
	private JogoRepository jogoRepository;
	
	@Transactional(readOnly = true)
	public List<PalpiteDTO> findAll() {
		List<Palpite> list = palpiteRepository.findAll();
		return list.stream().map(x -> new PalpiteDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public PalpiteDTO findById(Long id) {
		Optional<Palpite> obj = palpiteRepository.findById(id);
		Palpite entity = obj.orElseThrow(() -> new ResourceNotFoundException("Palpite nao encontrado"));
		return new PalpiteDTO(entity);
	}
	
	public Palpite insert(PalpiteDTO dto) {
		User user = userRepository.findById(dto.getUsuario_id()).get();
		Jogo jogo = jogoRepository.findById(dto.getJogo_id()).get();
		Palpite entity = new Palpite(dto, user, jogo);
		entity = palpiteRepository.save(entity);
		return entity;
	}

}
