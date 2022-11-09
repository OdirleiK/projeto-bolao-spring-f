package com.odirlei.bolao.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odirlei.bolao.dto.PalpiteDTO;
import com.odirlei.bolao.entities.Palpite;
import com.odirlei.bolao.repositories.PalpiteRepository;
import com.odirlei.bolao.services.exceptions.ResourceNotFoundException;

@Service
public class PalpiteService {
	
	@Autowired
	private PalpiteRepository palpiteRepository;
	
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

}
