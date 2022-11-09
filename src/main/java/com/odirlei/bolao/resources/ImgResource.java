package com.odirlei.bolao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.odirlei.bolao.dto.UriFileDTO;
import com.odirlei.bolao.services.ImgService;

@RestController
@RequestMapping(value = "/aws-bucket")
public class ImgResource {

	@Autowired
	private ImgService imgService;
	
	@PostMapping(value= "/img")
	public ResponseEntity<UriFileDTO> uploadImage(@RequestParam("file") MultipartFile file) {
		UriFileDTO dto = imgService.uploadFile(file);
		return ResponseEntity.ok().body(dto);
	}
	
}
