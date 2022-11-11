package com.odirlei.bolao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odirlei.bolao.dto.TimeDTO;
import com.odirlei.bolao.services.TimeService;

@RestController
@RequestMapping(value = "/times")
public class TimeResource {
	
	@Autowired
	private TimeService service;
	
	@GetMapping
	public ResponseEntity<List<TimeDTO>> findAll() {
		List<TimeDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/grupo/{grupo}")
	public ResponseEntity<List<TimeDTO>> findGroup(@PathVariable String grupo) {
		System.out.println(grupo);
		List<TimeDTO> list = service.findGroup(grupo);
		return ResponseEntity.ok().body(list);
	}

}
