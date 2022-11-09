package com.odirlei.bolao.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odirlei.bolao.dto.LogDTO;
import com.odirlei.bolao.entities.Log;
import com.odirlei.bolao.repositories.LogRepository;
import com.odirlei.bolao.services.exceptions.ResourceNotFoundException;

@Service
public class LogService {

	@Autowired
	private LogRepository logRepository;
	
	@Transactional(readOnly = true)
	public List<LogDTO> findAll() {
		List<Log> list = logRepository.findAll();
		return list.stream().map(x -> new LogDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public LogDTO findById(Long id) {
		Optional<Log> obj = logRepository.findById(id);
		Log entity = obj.orElseThrow(() -> new ResourceNotFoundException("Log nao encontrado"));
		return new LogDTO(entity);
	}
	
}
