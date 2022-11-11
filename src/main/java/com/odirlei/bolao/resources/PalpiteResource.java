package com.odirlei.bolao.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.odirlei.bolao.dto.PalpiteDTO;
import com.odirlei.bolao.entities.Palpite;
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
	
	@PostMapping(value = "/palpitar")
	public ResponseEntity<Palpite> insert(@RequestBody PalpiteDTO dto) {
		Palpite palpite = palpiteService.insert(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/id")
				.buildAndExpand(palpite.getId())
				.toUri();
		return ResponseEntity.created(uri).body(palpite);
	}
}
