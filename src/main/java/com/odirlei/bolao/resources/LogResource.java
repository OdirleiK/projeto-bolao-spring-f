package com.odirlei.bolao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odirlei.bolao.dto.LogDTO;
import com.odirlei.bolao.services.LogService;

@RestController
@RequestMapping(value = "/logs")
public class LogResource {

	@Autowired
	LogService logService;
	
	@GetMapping
	public ResponseEntity<List<LogDTO>> findAll() {
		List<LogDTO> list = logService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LogDTO> findById(@PathVariable Long id) {
		LogDTO dto = logService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
