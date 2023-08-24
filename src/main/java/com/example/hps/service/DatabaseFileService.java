package com.example.hps.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.hps.Exceptions.RestException;
import com.example.hps.entity.DatabaseFile;
import com.example.hps.entity.Projet;
import com.example.hps.repository.DatabaseFileRepository;
import com.example.hps.repository.ProjetRepository;


@Service
public class DatabaseFileService {

    @Autowired
    private DatabaseFileRepository dbFileRepository;
    @Autowired
    private ProjetRepository projetRepository;
    public DatabaseFile storeFile(MultipartFile file,long id) throws IOException {
        // Normalize file name
    		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        	Projet projet=projetRepository.findByidprojet(id);
            DatabaseFile dbFile = new DatabaseFile("hhh",fileName, file.getContentType(), file.getBytes(),projet);
            return dbFileRepository.save(dbFile);
    }

    public DatabaseFile getFile(String fileId) {
        return dbFileRepository.findByid(fileId);
    }
    
    public List<DatabaseFile> GetByProject(long idproject){
    	return dbFileRepository.GetPinByProject(idproject);
    }
    
    public void Delete(String id) {
    	
    	DatabaseFile databaseFile=dbFileRepository.findByid(id);
    	if(databaseFile==null) throw new RestException("Cette Data file n'existe Pas");
    	
    	dbFileRepository.delete(databaseFile);
    }
}