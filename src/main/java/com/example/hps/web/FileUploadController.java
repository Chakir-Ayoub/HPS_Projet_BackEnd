package com.example.hps.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.hps.entity.DatabaseFile;
import com.example.hps.response.Response;
import com.example.hps.service.DatabaseFileService;

@RestController
public class FileUploadController {

	@Autowired
	private DatabaseFileService fileStorageService;

	@PostMapping("/uploadFile/{id}/{type}")
	public Response uploadFile(@RequestParam("file") MultipartFile file,@PathVariable long id,@PathVariable Boolean type) throws IOException {
		DatabaseFile fileName = fileStorageService.storeFile(file,id,type);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName.getFileName()).toUriString();

		return new Response(fileName.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> Delete(@PathVariable String id){
		fileStorageService.Delete(id);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
}
