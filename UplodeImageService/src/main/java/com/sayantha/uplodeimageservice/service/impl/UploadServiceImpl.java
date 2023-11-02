package com.sayantha.uplodeimageservice.service.impl;


import com.sayantha.uplodeimageservice.service.custom.UploadService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

@Service

public class UploadServiceImpl implements UploadService {
    @Override
    public String handleUploads(MultipartFile imageFile) {
        String fileName = imageFile.getOriginalFilename();

        String destinationDirectory = System.getProperty("user.home") + "/Downloads";
        File directory = new File(destinationDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = destinationDirectory + "/" + fileName;

        try {
            imageFile.transferTo(Paths.get(filePath));
            return filePath;
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while saving the image :" + e.getLocalizedMessage());
        }

    }
    @Override
    public ResponseEntity<Resource> getImage(String imagePath)  {
        File file = new File(imagePath);

        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .contentLength(file.length())
                .body(resource);
    }
}
