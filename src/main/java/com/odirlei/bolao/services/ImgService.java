package com.odirlei.bolao.services;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.odirlei.bolao.dto.UriFileDTO;

@Service
public class ImgService {

	@Autowired
	private S3Service s3Service;
	
	public UriFileDTO uploadFile(MultipartFile file) {
		URL url = s3Service.uploadFile(file);
		return new UriFileDTO(url.toString());
	}

}
