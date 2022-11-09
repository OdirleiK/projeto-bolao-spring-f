package com.odirlei.bolao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odirlei.bolao.dto.PalpiteDTO;
import com.odirlei.bolao.services.PalpiteService;

@RestController
@RequestMapping(value = "/palpites")
public class PalpiteResource {

	@Autowired
	PalpiteService palpiteService;
	
	@GetMapping
	public ResponseEntity<List<PalpiteDTO>> findAll() {
		List<PalpiteDTO> list = palpiteService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PalpiteDTO> findById(@PathVariable Long id) {
		PalpiteDTO dto = palpiteService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
