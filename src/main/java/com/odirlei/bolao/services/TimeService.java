package com.odirlei.bolao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odirlei.bolao.dto.TimeDTO;
import com.odirlei.bolao.entities.Time;
import com.odirlei.bolao.repositories.TimeRepository;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository repository;
	
	@Transactional(readOnly = true)
	public List<TimeDTO> findAll() {
		List<Time> list = repository.findAll();
		return list.stream().map(x -> new TimeDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<TimeDTO> findGroup(String grupo) {
		List<Time> list = repository.findGrupo(grupo);
		return list.stream().map(x -> new TimeDTO(x)).collect(Collectors.toList());
	} 
}
