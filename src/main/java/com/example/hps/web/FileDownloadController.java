package com.example.hps.web;

import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hps.entity.DatabaseFile;
import com.example.hps.service.DatabaseFileService;



@RestController
public class FileDownloadController {

    @Autowired
    private DatabaseFileService fileStorageService;

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity < Resource > downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        DatabaseFile databaseFile = fileStorageService.getFile(fileName);

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
            .body(new ByteArrayResource(databaseFile.getData()));
    }
    
    @GetMapping("/getFilesByProject/{id}/{type}")
    public ResponseEntity<List<DatabaseFile>> getAllFiles(@PathVariable long id,@PathVariable Boolean type) {
    	  List<DatabaseFile> files =new ArrayList<>();
    	if(type==false) {
            files = fileStorageService.GetByProject(id);
    	}
    	else {
    		files = fileStorageService.GetAll();
    	}
        return ResponseEntity.ok(files);
    }
    
    @GetMapping()
    public ResponseEntity<List<DatabaseFile>> GetAll(){
    	List<DatabaseFile> databaseFiles=fileStorageService.GetAll();
    	
    	return ResponseEntity.ok(databaseFiles);
    }
    
    @GetMapping("getbyname/{name}")
    public ResponseEntity<DatabaseFile> getdatafilebyname(@PathVariable String name){
    	DatabaseFile databaseFile=fileStorageService.getdatafilebyname(name);
    	return  new ResponseEntity<DatabaseFile>(databaseFile,HttpStatus.ACCEPTED);
    }
    
/*    @GetMapping("getlikename/{name}")
    public ResponseEntity<List<DatabaseFile>> GetLikeName(@PathVariable String name){
    	List<DatabaseFile>  databaseFiles=fileStorageService.GetLikenam(name);
    	return new ResponseEntity<List<DatabaseFile>>(databaseFiles,HttpStatus.ACCEPTED);
    }*/

}